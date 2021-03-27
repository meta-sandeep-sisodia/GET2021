import java.sql.Timestamp;

public class Polygon implements Shape
{
    final String shapeType = Shape.shapeType.Polygon.toString();
    private final double side;
    private final double numberOfSide;
    private final Point origin;
    private Timestamp timeStamp;

    Polygon(Point origin, double numberOfSide, double side)
    {
        this.side = side;
        this.numberOfSide = numberOfSide;
        this.origin = origin;
    }

    @Override
    public double getOriginDistance()
    {
        return Math.sqrt(Math.pow(origin.xCoordinate, 2)
                + Math.pow(origin.yCoordinate, 2));
    }

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
        return (numberOfSide * side);
    }

    @Override
    public Point getOrigin()
    {
        return new Point(origin.xCoordinate, origin.yCoordinate);
    }

    @Override
    public double getArea()
    {
        double angle = Math.toRadians(180 / numberOfSide);
        double tangentAngle = Math.tan(angle);
        double area = (side * side * numberOfSide) / (4 * tangentAngle);

        return area;
    }

    @Override
    public boolean isPointEnclosed(Point givenPoint)
    {
        return true;
    }
}