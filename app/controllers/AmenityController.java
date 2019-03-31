package controllers;

import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class AmenityController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;

    @Inject
    public AmenityController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }

    @Transactional
    public Result getAmenity()
    {
        return ok(views.html.amenity.render());
    }

}