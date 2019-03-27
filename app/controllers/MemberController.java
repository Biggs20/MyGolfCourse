package controllers;

import models.Member;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

public class MemberController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;

    @Inject
    public MemberController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }

    //routes to memberlist.html
    @Transactional(readOnly = true)
    public Result getMember()
    {
        TypedQuery<Member> query = db.em().createQuery("SELECT m FROM Member m ORDER BY memberId", Member.class);
        List<Member> members = query.getResultList();

        return ok(views.html.memberlist.render(members));
    }
}
