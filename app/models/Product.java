package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product
{
    @Id
    private int productId;

    private String productName;
    private BigDecimal price;
    private String brand;
    private String category;
    private byte[] picture;

    public int getProductId()
    {
        return productId;
    }

    public String getProductName()
    {
        return productName;
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

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public byte[] getPicture()
    {
        return picture;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public void setPicture(byte[] picture)
    {
        this.picture = picture;
    }
}
