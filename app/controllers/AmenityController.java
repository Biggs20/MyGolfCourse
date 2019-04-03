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

    @Transactional(readOnly = true)
    public Result getAmenity()
    {
        TypedQuery<Amenity> query = db.em().createQuery("SELECT a FROM Amenity a ORDER BY amenityId", Amenity.class);
        List<Amenity> amenities = query.getResultList();

        return ok(views.html.amenity.render(amenities));
    }


    @Transactional(readOnly = true)
    public Result getRestaurant()
    {
        TypedQuery<Amenity> query = db.em().createQuery("SELECT a FROM Amenity a WHERE amenityId = 3", Amenity.class);
        List<Amenity> amenities = query.getResultList();

        return ok(views.html.restaurant.render(amenities));
    }


    @Transactional(readOnly = true)
    public Result getFitnessCenter()
    {
        TypedQuery<Amenity> query = db.em().createQuery("SELECT a FROM Amenity a WHERE amenityId = 2", Amenity.class);
        List<Amenity> amenities = query.getResultList();

        return ok(views.html.fitnesscenter.render(amenities));
    }


    @Transactional(readOnly = true)
    public Result getPool()
    {
        TypedQuery<Amenity> query = db.em().createQuery("SELECT a FROM Amenity a WHERE amenityId = 4", Amenity.class);
        List<Amenity> amenities = query.getResultList();

        return ok(views.html.pool.render(amenities));
    }


    @Transactional(readOnly = true)
    public Result getRestaurantMenu()
    {
        return ok(views.html.restaurantmenu.render());
    }
}