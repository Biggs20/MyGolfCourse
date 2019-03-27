package controllers;

import models.Product;
import play.Logger;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;


public class ProductController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;


    @Inject
    public ProductController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }


    //routes to product list
    @Transactional(readOnly = true)
    public Result getProducts()
    {
        TypedQuery<Product> query = db.em().createQuery("SELECT p FROM Product p ORDER BY productId", Product.class);
        List<Product> products = query.getResultList();

        return ok(views.html.productlist.render(products));
    }


    @Transactional
    public Result getProductAdd()
    {
        return ok(views.html.productadd.render());
    }


    @Transactional
    public Result postProductAdd()
    {
        Product product = new Product();

        DynamicForm form = formFactory.form().bindFromRequest();
        String productName = form.get("productName");
        BigDecimal price = new BigDecimal(form.get("price"));
        String brand = form.get("brand");
        String category = form.get("category");

        Logger.debug(productName);
        Logger.debug(brand);
        Logger.debug(category);

        product.setProductName(productName);
        product.setPrice(price);
        product.setBrand(brand);
        product.setCategory(category);

        db.em().persist(product);

        return ok("Saved");
    }
}
