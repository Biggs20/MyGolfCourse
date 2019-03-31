package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Amenity
{
    @Id
    private int amenityId;

    private String amenityName;
    private String membershipIdRequired;
    private String openHours;

    public int getAmenityId()
    {
        return amenityId;
    }

    public String getAmenityName()
    {
        return amenityName;
    }

    public String getMembershipIdRequired()
    {
        return membershipIdRequired;
    }

    public String getOpenHours()
    {
        return openHours;
    }
}
