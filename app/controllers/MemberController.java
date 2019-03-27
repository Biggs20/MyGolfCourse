package controllers;

import models.Member;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
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

    //routes to receive member sign up page
    @Transactional
    public Result getMemberAdd()
    {
        return ok(views.html.memberadd.render());
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
}
