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
}
