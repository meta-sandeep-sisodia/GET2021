import java.sql.Timestamp;
import java.util.Date;

public class Rectangle implements Shape
{
    final String shapeType = Shape.shapeType.Rectangle.toString();
    double length, breadth;
    Point origin;
    Timestamp timeStamp;

    Rectangle(Point origin, double length, double breadth)
    {
        this.origin = origin;
        this.length = length;
        this.breadth = breadth;
        this.timeStamp = new Timestamp(new Date().getTime());
    }

    @Override
    public Timestamp getTimeStamp()
    {
        return this.timeStamp;
    }

    @Override
    public String getShapeType()
    {
        return shapeType;
    }

    public double getOriginDistance()
    {
        return Math.sqrt(Math.pow(origin.xCoordinate, 2)
                + Math.pow(origin.yCoordinate, 2));
    }

    @Override
    public double getParameter()
    {
        return 2 * (length + breadth);
    }

    @Override
    public Point getOrigin()
    {
        return origin;
    }

    @Override
    public double getArea()
    {
        return length * breadth;
    }

    private Point getBottomRightCorner()
    {
        return new Point(origin.xCoordinate + length, origin.yCoordinate);
    }

    private Point getTopLeftCorner()
    {
        return new Point(origin.xCoordinate, origin.yCoordinate + breadth);
    }

    @Override
    public boolean isPointEnclosed(Point givenPoint)
    {
        Point bottomRightCorner = getBottomRightCorner();
        Point topLeftCorner = getTopLeftCorner();
        return givenPoint.xCoordinate > origin.xCoordinate
                && givenPoint.xCoordinate <= bottomRightCorner.xCoordinate
                && givenPoint.yCoordinate > origin.yCoordinate
                && givenPoint.yCoordinate <= topLeftCorner.yCoordinate;
    }
}