package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Orders
{
    @Id
    private int orderNumber;

    private int productId;
    private int memberId;
    private int quantity;
    private String brand;
    private String category;
    private BigDecimal extendedPrice;
    private BigDecimal unitPrice;
    private LocalDate datePurchased;
    private String firstName;
    private String lastName;

    public Orders(int orderNumber, int productId, int memberId, int quantity, BigDecimal extendedPrice, BigDecimal unitPrice, LocalDate datePurchased, String firstName, String lastName)
    {
        this.orderNumber = orderNumber;
        this.productId = productId;
        this.memberId = memberId;
        this.quantity = quantity;
        this.extendedPrice = extendedPrice;
        this.unitPrice = unitPrice;
        this.datePurchased = datePurchased;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getOrderNumber()
    {
        return orderNumber;
    }

    public int getProductId()
    {
        return productId;
    }

    public int getMemberId()
    {
        return memberId;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public BigDecimal getExtendedPrice()
    {
        return extendedPrice;
    }

    public BigDecimal getUnitPrice()
    {
        return unitPrice;
    }

    public LocalDate getDatePurchased()
    {
        return datePurchased;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getCategory()
    {
        return category;
    }
}
