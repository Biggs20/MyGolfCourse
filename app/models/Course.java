package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course
{
    @Id
    private int courseId;

    private String courseName;
    private String address;
    private String city;
    private String stateId;

    public int getCourseId()
    {
        return courseId;
    }

    public String getCourseName()
    {
        return courseName;
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
}
