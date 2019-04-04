package controllers;

import models.Member;
import play.Logger;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

public class SessionController extends BaseController
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
        String userName = form.get("userName");

        String sql = "SELECT m FROM Member m WHERE userName = :userName";

        Logger.debug(sql);

        TypedQuery<Member> query = db.em().createQuery(sql, Member.class);
        query.setParameter("userName", userName);

        List<Member> members = query.getResultList();

        Result result;

        if (members.size() == 1)
        {
            Member member = members.get(0);
            result = redirect("/admin");
            login(member);

        }
        else
        {
            logout();
            String message = "Incorrect username or password. Please try again.";
            result = ok(views.html.login.render(message));
        }

        return result;
    }

    @Transactional(readOnly = true)
    public Result getAdmin()
    {
        Result result = redirect("/login");

        if (isLoggedIn())
        {
            result = ok(views.html.admin.render());
        }

        return result;
    }
}