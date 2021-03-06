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
import java.time.LocalDate;
import java.util.List;

public class MemberController extends BaseController
{
    private JPAApi db;
    private FormFactory formFactory;


    @Inject
    public MemberController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }


    //routes to member list
    @Transactional(readOnly = true)
    public Result getMember()
    {
        TypedQuery<Member> query = db.em().createQuery("SELECT m FROM Member m ORDER BY memberId", Member.class);
        List<Member> members = query.getResultList();

        Result result = redirect("/login");

        if (isLoggedIn())
        {
            result = ok(views.html.memberlist.render(members));
        }

        return result;
    }


    //routes to receive member sign up page
    @Transactional(readOnly = true)
    public Result getMemberAdd()
    {
        Result result = redirect("/login");

        if (isLoggedIn())
        {
            result = ok(views.html.memberadd.render());
        }

        return result;
    }


    //creates/ adds the new member to the database
    @Transactional
    public Result postMemberAdd()
    {
        Member member = new Member();

        DynamicForm form = formFactory.form().bindFromRequest();
        String lastName = form.get("lastName");
        String firstName = form.get("firstName");
        String address = form.get("address");
        String city = form.get("city");
        String stateId = form.get("stateId");
        String phoneNumber = form.get("phoneNumber");
        LocalDate dateJoined = LocalDate.parse(form.get("dateJoined"));
        int membershipId = Integer.parseInt(form.get("membershipId"));
        int handicap = Integer.parseInt(form.get("handicap"));

        Logger.debug(lastName);
        Logger.debug(firstName);
        Logger.debug(address);
        Logger.debug(city);
        Logger.debug(stateId);
        Logger.debug(phoneNumber);
        Logger.debug(String.valueOf(membershipId));
        Logger.debug(String.valueOf(handicap));

        member.setLastName(lastName);
        member.setFirstName(firstName);
        member.setAddress(address);
        member.setCity(city);
        member.setStateId(stateId);
        member.setPhoneNumber(phoneNumber);
        member.setDateJoined(dateJoined);
        member.setMembershipId(membershipId);
        member.setHandicap(handicap);

        db.em().persist(member);

        return ok("Saved");
    }

    @Transactional(readOnly = true)
    public Result getRemoveMember()
    {
        Result result = redirect("/login");

        if (isLoggedIn())
        {
            result = ok(views.html.removemember.render());
        }

        return result;
    }


    @Transactional
    public Result postRemoveMember(int memberId)
    {
        TypedQuery<Member> query = db.em().createQuery("SELECT m FROM Member m WHERE memberId = :memberId", Member.class);
        query.setParameter("memberId", memberId);
        Member member = query.getSingleResult();
        db.em().remove(member);

        return ok("DELETED");
    }


    @Transactional(readOnly = true)
    public Result getMemberEdit(int memberId)
    {
        TypedQuery<Member> query = db.em().createQuery("SELECT m FROM Member m WHERE memberId = :memberId", Member.class);
        query.setParameter("memberId", memberId);
        Member member = query.getSingleResult();

        Result result = redirect("/login");

        if (isLoggedIn())
        {
            result = ok(views.html.memberedit.render(member));
        }

        return result;
    }

    @Transactional
    public Result postMemberEdit(int memberId)
    {
        TypedQuery<Member> query = db.em().createQuery("SELECT m FROM Member m WHERE memberId = :memberId", Member.class);
        query.setParameter("memberId", memberId);
        Member member = query.getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();

        String lastName = form.get("lastName");
        String firstName = form.get("firstName");
        String address = form.get("address");
        String city = form.get("city");
        String stateId = form.get("stateId");
        String phoneNumber = form.get("phoneNumber");
        LocalDate dateJoined = LocalDate.parse(form.get("dateJoined"));
        int membershipId = Integer.parseInt(form.get("membershipId"));
        int handicap = Integer.parseInt(form.get("handicap"));

        member.setLastName(lastName);
        member.setFirstName(firstName);
        member.setAddress(address);
        member.setCity(city);
        member.setStateId(stateId);
        member.setPhoneNumber(phoneNumber);
        member.setDateJoined(dateJoined);
        member.setMembershipId(membershipId);
        member.setHandicap(handicap);

        db.em().persist(member);

        return ok("saved");
    }

}