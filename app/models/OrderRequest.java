package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class OrderRequest
{
    @Id
    private int requestId;

    private int productId;
    private int quantity;
    private int memberId;
    private LocalDate dateRequested;
    private String notes;

    public int getRequestId()
    {
        return requestId;
    }

    public void setRequestId(int requestId)
    {
        this.requestId = requestId;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getMemberId()
    {
        return memberId;
    }

    public void setMemberId(int memberId)
    {
        this.memberId = memberId;
    }

    public LocalDate getDateRequested()
    {
        return dateRequested;
    }

    public void setDateRequested(LocalDate dateRequested)
    {
        this.dateRequested = dateRequested;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }
}
