import java.sql.Timestamp;

public interface Shape
{

    String getShapeType();

    double getParameter();

    double getArea();

    boolean isPointEnclosed(Point point);

    Point getOrigin();

    Timestamp getTimeStamp();

    double getOriginDistance();

    enum shapeType
    {
        Circle, Triangle, Rectangle, Polygon, Square
    }

}