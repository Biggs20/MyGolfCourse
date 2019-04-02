package controllers;

import models.Member;
import play.Logger;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

public class SessionController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;

    @Inject
    public SessionController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }

    public Result getLogin()
    {
        return ok(views.html.login.render(""));
    }


    @Transactional(readOnly = true)
    public Result postLogin()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String username = form.get("username");

        String sql = "SELECT m FROM Member m WHERE lastName = :username";

        Logger.debug(sql);

        TypedQuery<Member> query = db.em().createQuery(sql, Member.class);
        query.setParameter("username", username);

        List<Member> members = query.getResultList();

        Result result;

        if (members.size() == 1)
        {
            Member member = members.get(0);
            result = redirect("/member/" + member.getMemberId());
        }
        else
        {
            String message = "Incorrect username or password. Please try again.";
            result = ok(views.html.login.render(message));
        }

        return result;
    }

}