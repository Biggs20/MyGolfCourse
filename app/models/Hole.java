package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hole
{
    @Id
    private int holeNumber;

    private int redTeeLength;
    private int goldTeeLength;
    private int whiteTeeLength;
    private int blueTeeLength;
    private int blackTeeLength;
    private int courseId;
    private int par;
    private int mensHandicap;
    private int womensHandicap;

    public int getHoleNumber()
    {
        return holeNumber;
    }

    public int getRedTeeLength()
    {
        return redTeeLength;
    }

    public int getGoldTeeLength()
    {
        return goldTeeLength;
    }

    public int getWhiteTeeLength()
    {
        return whiteTeeLength;
    }

    public int getBlueTeeLength()
    {
        return blueTeeLength;
    }

    public int getBlackTeeLength()
    {
        return blackTeeLength;
    }

    public int getCourseId()
    {
        return courseId;
    }

    public int getPar()
    {
        return par;
    }

    public int getMensHandicap()
    {
        return mensHandicap;
    }

    public int getWomensHandicap()
    {
        return womensHandicap;
    }
}
