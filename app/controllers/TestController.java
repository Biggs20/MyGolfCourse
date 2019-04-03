package controllers;

//import Services.Email;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Test;
import models.Weather.WeatherResult;
import play.Logger;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class TestController extends Controller
{
    private FormFactory formFactory;
    private JPAApi db;

    @Inject
    public TestController(FormFactory formFactory, JPAApi db)
    {
        this.formFactory = formFactory;
        this.db = db;
    }

    public Result getTest()
    {
        return ok(views.html.test.render("Test Text"));
    }

    public Result postTest()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String test = form.get("test");
        return ok(views.html.test.render(test));
    }

    @Transactional(readOnly = true)
    public Result getTestDb()
    {
        String sql = "SELECT t FROM Test t";
        TypedQuery query = db.em().createQuery(sql, Test.class);
        List<Test> test = query.getResultList();

        return ok(views.html.test.render("Rows: " + test.size()));
    }

    @Transactional
    public Result postTestDb()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String testName = form.get("test");
        Test test = new Test();
        test.setTestName(testName);
        db.em().persist(test);

        return redirect("/testdb");
    }

    @Transactional
    public Result getMap()
    {
        return ok(views.html.map.render());
    }

    public Result getCurrentWeather()
    {
        WeatherResult weatherResult = null;

        try
        {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=35&lon=-92&appid=3b58c83e16da201f3aec2c01b8535402&units=Imperial");
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            Logger.debug("weather api status: " + request.getResponseCode());

            ObjectMapper objectMapper = new ObjectMapper();
            weatherResult = objectMapper.readValue(url, WeatherResult.class);
        } catch (Exception e)
        {
            e.printStackTrace();
            Logger.error(e.getMessage());
        }

        return ok("" + weatherResult.getMain().getTemp());

    }

    /*public Result getLogin()
    {
        return ok(views.html.login.render());
    }*/


    //send email for testing
    /*public Result getSendEmail()
    {
        String result = "no go";

        boolean sentIt = Email.sendEmail("Bring it!");

        if(sentIt)
        {
            result = "sent it";
        }

        return ok(result);
    }*/


}
