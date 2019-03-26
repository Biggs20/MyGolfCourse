package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Membership
{
    @Id
    private int membershipId;

    private String membershipName;
    private BigDecimal membershipPrice;
    private String description;

    public int getMembershipId()
    {
        return membershipId;
    }

    public String getMembershipName()
    {
        return membershipName;
    }

    public BigDecimal getMembershipPrice()
    {
        return membershipPrice;
    }

    public String getDescription()
    {
        return description;
    }
}
