import java.sql.Timestamp;
import java.util.Date;

public class Circle implements Shape
{
    final String shapeType = Shape.shapeType.Circle.toString();
    double radius;
    Point origin;
    Timestamp timeStamp;

    Circle(Point origin, double radius)
    {
        this.radius = radius;
        this.origin = origin;
        this.timeStamp = new Timestamp(new Date().getTime());
    }

    public double getOriginDistance()
    {
        return Math.sqrt(Math.pow(origin.xCoordinate, 2)
                + Math.pow(origin.yCoordinate, 2));
    }

    private double distanceBtwTwoPoints(Point firstPoint, Point secondPoint)
    {
        double differenceX = firstPoint.xCoordinate - secondPoint.xCoordinate;
        double differenceY = firstPoint.yCoordinate - secondPoint.yCoordinate;

        return Math.sqrt(Math.pow(differenceX, 2) + Math.pow(differenceY, 2));
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
        return (2 * (Math.PI) * radius);
    }

    @Override
    public Point getOrigin()
    {
        return origin;
    }

    @Override
    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean isPointEnclosed(Point givenPoint)
    {
        return (distanceBtwTwoPoints(givenPoint, origin) >= radius);

    }
}