package controllers;

import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class CourseController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;

    @Inject
    public CourseController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }

    @Transactional
    public Result getCourse()
    {
        return ok(views.html.course.render());
    }

}
