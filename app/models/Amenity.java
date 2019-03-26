package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Amenity
{
    @Id
    private int amenityId;

    private String amenityName;
    private String membershipRequired;
    private String openHours;

    public int getAmenityId()
    {
        return amenityId;
    }

    public String getAmenityName()
    {
        return amenityName;
    }

    public String getMembershipRequired()
    {
        return membershipRequired;
    }

    public String getOpenHours()
    {
        return openHours;
    }
}
