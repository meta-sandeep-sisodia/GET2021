import java.sql.Timestamp;
import java.util.Date;

public class Square implements Shape
{
    final String shapeType = Shape.shapeType.Square.toString();
    double side;
    Point origin;
    Timestamp timeStamp;

    Square(Point origin, double side)
    {
        this.side = side;
        this.origin = origin;
        this.timeStamp = new Timestamp(new Date().getTime());
    }

    @Override
    public double getOriginDistance()
    {
        return Math.sqrt(Math.pow(origin.xCoordinate, 2)
                + Math.pow(origin.yCoordinate, 2));
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

    @Override
    public double getParameter()
    {
        return (4 * side);
    }

    @Override
    public Point getOrigin()
    {
        return origin;
    }

    @Override
    public double getArea()
    {
        return side * side;
    }

    private Point getBottomRightCorner()
    {
        return new Point(origin.xCoordinate + side, origin.yCoordinate);
    }

    private Point getTopLeftCorner()
    {
        return new Point(origin.xCoordinate, origin.yCoordinate + side);
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