package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CourseLength
{
    @Id
    private int courseId;

    private int redFrontNineLength;
    private int redBackNineLength;
    private int redTotalLength;
    private int goldFrontNineLength;
    private int goldBackNineLength;
    private int goldTotalLength;
    private int whiteFrontNineLength;
    private int whiteBackNineLength;
    private int whiteTotalLength;
    private int blueFrontNineLength;
    private int blueBackNineLength;
    private int blueTotalLength;
    private int blackFrontNineLength;
    private int blackBackNineLength;
    private int blackTotalLength;

    public int getCourseId()
    {
        return courseId;
    }

    public int getRedFrontNineLength()
    {
        return redFrontNineLength;
    }

    public int getRedBackNineLength()
    {
        return redBackNineLength;
    }

    public int getRedTotalLength()
    {
        return redTotalLength;
    }

    public int getGoldFrontNineLength()
    {
        return goldFrontNineLength;
    }

    public int getGoldBackNineLength()
    {
        return goldBackNineLength;
    }

    public int getGoldTotalLength()
    {
        return goldTotalLength;
    }

    public int getWhiteFrontNineLength()
    {
        return whiteFrontNineLength;
    }

    public int getWhiteBackNineLength()
    {
        return whiteBackNineLength;
    }

    public int getWhiteTotalLength()
    {
        return whiteTotalLength;
    }

    public int getBlueFrontNineLength()
    {
        return blueFrontNineLength;
    }

    public int getBlueBackNineLength()
    {
        return blueBackNineLength;
    }

    public int getBlueTotalLength()
    {
        return blueTotalLength;
    }

    public int getBlackFrontNineLength()
    {
        return blackFrontNineLength;
    }

    public int getBlackBackNineLength()
    {
        return blackBackNineLength;
    }

    public int getBlackTotalLength()
    {
        return blackTotalLength;
    }
}
