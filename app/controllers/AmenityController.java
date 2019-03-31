package controllers;

import models.Amenity;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Transactional (readOnly = true)
    public Result getAmenity()
    {
        TypedQuery<Amenity> query = db.em().createQuery("SELECT a FROM Amenity a ORDER BY amenityId", Amenity.class);
        List<Amenity> amenities = query.getResultList();

        return ok(views.html.amenity.render(amenities));
    }

    @Transactional
    public Result getRestaurant()
    {
        return ok(views.html.restaurant.render());
    }

    @Transactional
    public Result getFitnessCenter()
    {
        return ok(views.html.fitnesscenter.render());
    }

    @Transactional
    public Result getPool()
    {
        return ok(views.html.pool.render());
    }
}