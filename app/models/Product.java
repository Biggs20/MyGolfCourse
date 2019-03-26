package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product
{
    @Id
    private int productId;

    private String roductName;
    private BigDecimal price; 
    private String brand;
    private String category;

    public int getProductId()
    {
        return productId;
    }

    public String getRoductName()
    {
        return roductName;
    }

    public BigDecimal getPrice()
    {
        return price;
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
