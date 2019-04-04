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

    public void setOrderNumber(int orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public void setMemberId(int memberId)
    {
        this.memberId = memberId;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public void setExtendedPrice(BigDecimal extendedPrice)
    {
        this.extendedPrice = extendedPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public void setDatePurchased(LocalDate datePurchased)
    {
        this.datePurchased = datePurchased;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}
