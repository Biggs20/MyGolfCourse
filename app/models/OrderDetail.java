package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class OrderDetail
{
    @Id
    private int orderNumber;

    private int productId;
    private int memberId;
    private int quantity;
    private BigDecimal extendedPrice;
    private BigDecimal unitPrice;
    private LocalDate datePurchased;

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
}
