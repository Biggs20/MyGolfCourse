package controllers;

import models.Member;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

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

    @Transactional(readOnly = true)
    public Result getMember(int memberId)
    {
        TypedQuery<Member> query = db.em().createQuery("SELECT m FROM Member m WHERE memberId = :memberId", Member.class);
        query.setParameter("memberId", memberId);
        Member member = query.getSingleResult();

        return ok(views.html.members.render(member));
    }
}
