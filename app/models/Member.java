package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Member
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private String stateId;
    private String phoneNumber;
    private LocalDate dateJoined;
    private int membershipId;
    private int handicap;

    public int getMemberId()
    {
        return memberId;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getAddress()
    {
        return address;
    }

    public String getCity()
    {
        return city;
    }

    public String getStateId()
    {
        return stateId;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public LocalDate getDateJoined()
    {
        return dateJoined;
    }

    public int getMembershipId()
    {
        return membershipId;
    }

    public int getHandicap()
    {
        return handicap;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setStateId(String stateId)
    {
        this.stateId = stateId;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setDateJoined(LocalDate dateJoined)
    {
        this.dateJoined = dateJoined;
    }

    public void setMembershipId(int membershipId)
    {
        this.membershipId = membershipId;
    }

    public void setHandicap(int handicap)
    {
        this.handicap = handicap;
    }
}


