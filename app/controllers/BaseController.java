package controllers;

import models.Member;
import play.mvc.Controller;

public class BaseController extends Controller
{
    private final String LOGGED_IN_MEMBER = "LoggedInMemberId";

    public void login(Member member)
    {
        session().put(LOGGED_IN_MEMBER, "" + member.getMemberId());
    }

    public void logout()
    {
        session().remove(LOGGED_IN_MEMBER);
    }

    public boolean isLoggedIn()
    {
        return session().containsKey(LOGGED_IN_MEMBER);
    }

    public Integer getLoggedInEmployeeId()
    {
        String memberIdText = session().get(LOGGED_IN_MEMBER);

        Integer memberId = null;

        if (memberIdText != null)
        {
            memberId = Integer.parseInt(memberIdText);
        }

        return memberId;
    }
}