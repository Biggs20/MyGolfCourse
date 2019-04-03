package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Weather.WeatherResult;
import play.Logger;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.net.HttpURLConnection;
import java.net.URL;

public class HomeController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;


    @Inject
    public HomeController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }


    @Transactional(readOnly = true)
    public Result getHome()
    {
        WeatherResult weatherResult = null;

        //to get weather results
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

        double temp = weatherResult.getMain().getTemp();
        String realTemp = "" + temp;
        String normalTemp = realTemp.substring(0, 2);

        double wind = weatherResult.getWind().getSpeed();
        String realSpeed = "" + wind;
        String normalSpeed = realSpeed.substring(0, 2);

        if (realSpeed.length() < 5)
        {
            normalSpeed = realSpeed.substring(0, 1);
        }

        return ok(views.html.home.render(normalTemp, normalSpeed));
    }

    @Transactional(readOnly = true)
    public Result getContactInfo()
    {
        return ok(views.html.contactinfo.render());
    }

}
