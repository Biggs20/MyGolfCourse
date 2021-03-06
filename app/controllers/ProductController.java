package controllers;

import models.OrderDetail;
import models.OrderRequest;
import models.Orders;
import models.Product;
import play.Logger;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;


public class ProductController extends BaseController
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


    @Transactional(readOnly = true)
    public Result getProductAdd()
    {
        Result result = redirect("/login");

        if (isLoggedIn())
        {
            result = ok(views.html.productadd.render());
        }

        return result;
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

        Result result = redirect("/login");

        if (isLoggedIn())
        {
            result = ok(views.html.productadd.render());
        }

        return result;
    }


    @Transactional
    public Result postProductDelete(int productId)
    {
        TypedQuery<Product> query = db.em().createQuery("SELECT p FROM Product p WHERE productId = :productId", Product.class);
        query.setParameter("productId", productId);
        Product product = query.getSingleResult();
        db.em().remove(product);

        return ok("DELETED");
    }


    @Transactional(readOnly = true)
    public Result getPicture(int productId)
    {
        TypedQuery<Product> query = db.em().createQuery("SELECT p FROM Product p WHERE productId = :productId", Product.class);
        query.setParameter("productId", productId);
        Product product = query.getSingleResult();

        return ok(product.getPicture()).as("image/jpeg");
    }


    @Transactional(readOnly = true)
    public Result getOrderDetail()
    {
        TypedQuery<Orders> query = db.em().createQuery("SELECT NEW Orders(od.orderNumber, od.productId, od.memberId, od.quantity, od.extendedPrice, od.unitPrice, od.datePurchased, m.firstName, m.lastName) FROM OrderDetail od JOIN Member m ON od.memberId = m.memberId " +
                "ORDER BY datePurchased DESC", Orders.class);
        List<Orders> orders = query.getResultList();

        Result result = redirect("/login");

        if (isLoggedIn())
        {
            result = ok(views.html.orders.render(orders));
        }

        return result;
    }


    @Transactional(readOnly = true)
    public Result getNewOrder()
    {
        Result result = redirect("/login");

        if (isLoggedIn())
        {
            result = ok(views.html.neworder.render());
        }

        return result;
    }


    @Transactional
    public Result postNewOrder()
    {

        Random random = new Random();
        int randomNumber = random.nextInt((9999999) - 9000000);

        OrderDetail orderDetail = new OrderDetail();

        DynamicForm form = formFactory.form().bindFromRequest();
        int productId = Integer.parseInt(form.get("productId"));
        int memberId = Integer.parseInt(form.get("memberId"));
        int quantity = Integer.parseInt(form.get("quantity"));
        BigDecimal extendedPrice = new BigDecimal(form.get("extendedPrice"));
        BigDecimal unitPrice = new BigDecimal(form.get("unitPrice"));
        LocalDate datePurchased = LocalDate.parse(form.get("datePurchased"));

        Logger.debug(String.valueOf(productId));
        Logger.debug(String.valueOf(memberId));
        Logger.debug(String.valueOf(quantity));
        Logger.debug(String.valueOf(datePurchased));
        Logger.debug(String.valueOf(extendedPrice));
        Logger.debug(String.valueOf(unitPrice));

        orderDetail.setOrderNumber(randomNumber);
        orderDetail.setProductId(productId);
        orderDetail.setMemberId(memberId);
        orderDetail.setQuantity(quantity);
        orderDetail.setExtendedPrice(extendedPrice);
        orderDetail.setUnitPrice(unitPrice);
        orderDetail.setDatePurchased(datePurchased);

        db.em().persist(orderDetail);

        return ok("Saved");
    }


    @Transactional(readOnly = true)
    public Result getOrderEdit(int orderNumber)
    {
        TypedQuery<OrderDetail> query = db.em().createQuery("SELECT od FROM OrderDetail od WHERE orderNumber = :orderNumber", OrderDetail.class);
        query.setParameter("orderNumber", orderNumber);
        OrderDetail orderDetail = query.getSingleResult();

        Result result = redirect("/login");

        if (isLoggedIn())
        {
            result = ok(views.html.orderedit.render(orderDetail));
        }

        return result;
    }

    @Transactional
    public Result postOrderEdit(int orderNumber)
    {
        TypedQuery<OrderDetail> query = db.em().createQuery("SELECT od FROM OrderDetail od WHERE orderNumber = :orderNumber", OrderDetail.class);
        query.setParameter("orderNumber", orderNumber);
        OrderDetail orderDetail = query.getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();

        int productId = Integer.parseInt(form.get("productId"));
        int memberId = Integer.parseInt(form.get("memberId"));
        int quantity = Integer.parseInt(form.get("quantity"));
        BigDecimal extendedPrice = new BigDecimal(form.get("extendedPrice"));
        BigDecimal unitPrice = new BigDecimal(form.get("unitPrice"));
        LocalDate datePurchased = LocalDate.parse(form.get("datePurchased"));

        orderDetail.setProductId(productId);
        orderDetail.setMemberId(memberId);
        orderDetail.setQuantity(quantity);
        orderDetail.setExtendedPrice(extendedPrice);
        orderDetail.setUnitPrice(unitPrice);
        orderDetail.setDatePurchased(datePurchased);

        db.em().persist(orderDetail);

        return ok("saved");
    }


    @Transactional(readOnly = true)
    public Result getRequestOrder()
    {
        return ok(views.html.requestorder.render());
    }


    @Transactional
    public Result postRequestOrder()
    {

        OrderRequest orderRequest = new OrderRequest();

        DynamicForm form = formFactory.form().bindFromRequest();
        int productId = Integer.parseInt(form.get("productId"));
        int quantity = Integer.parseInt(form.get("quantity"));
        int memberId = Integer.parseInt(form.get("memberId"));
        LocalDate dateRequested = LocalDate.parse(form.get("dateRequested"));
        String notes = form.get("notes");

        Logger.debug(String.valueOf(productId));
        Logger.debug(String.valueOf(quantity));
        Logger.debug(String.valueOf(memberId));
        Logger.debug(String.valueOf(dateRequested));
        Logger.debug(notes);


        orderRequest.setProductId(productId);
        orderRequest.setQuantity(quantity);
        orderRequest.setMemberId(memberId);
        orderRequest.setDateRequested(dateRequested);
        orderRequest.setNotes(notes);

        db.em().persist(orderRequest);

        return ok("Saved");
    }


    @Transactional(readOnly = true)
    public Result getOrderRequest()
    {
        TypedQuery<OrderRequest> query = db.em().createQuery("SELECT o FROM OrderRequest o ORDER BY requestId", OrderRequest.class);
        List<OrderRequest> orderRequests = query.getResultList();

        return ok(views.html.orderrequest.render(orderRequests));
    }
}
