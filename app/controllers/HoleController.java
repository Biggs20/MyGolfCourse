package controllers;

import models.Hole;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

public class HoleController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;

    @Inject
    public HoleController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }

    @Transactional (readOnly = true)
    public Result getCourse()
    {
        TypedQuery<Hole> query = db.em().createQuery("SELECT h FROM Hole h ORDER BY holeNumber", Hole.class);
        List<Hole> holes = query.getResultList();

        return ok(views.html.course.render(holes));
    }
}
