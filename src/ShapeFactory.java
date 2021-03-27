import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public abstract class ShapeFactory implements Shape
{
    shapeType type;
    Point origin;
    Timestamp timeStamp;
    Date d = new Date();
    List<Double> listOfParmeters;

    public static Shape createShape(String shapeType, Point origin,
                                    List<Double> listOfParameters) throws IllegalArgumentException
    {
        Shape shape = null;

        if (origin.xCoordinate < 0 || origin.yCoordinate < 0)
        {
            throw new IllegalArgumentException();
        }

        if (shapeType == null || origin == null || listOfParameters.size() == 0)
        {
            throw new NullPointerException();
        }

        switch (shapeType.toUpperCase())
        {
            case "CIRCLE":
                if (listOfParameters.size() == 1)
                {
                    shape = new Circle(origin, listOfParameters.get(0));
                }
                break;
            case "RECTANGLE":
                if (listOfParameters.size() == 2)
                {
                    shape = new Rectangle(origin, listOfParameters.get(0),
                            listOfParameters.get(1));
                }
                break;
            case "TRIANGLE":
                if (listOfParameters.size() == 2)
                {
                    shape = new Triangle(origin, listOfParameters.get(0),
                            listOfParameters.get(1));
                }
                break;
            case "SQUARE":
                if (listOfParameters.size() == 1)
                {
                    shape = new Square(origin, listOfParameters.get(0));
                }
                break;

            case "POLYGON":
                if (listOfParameters.size() == 2)
                {
                    shape = new Polygon(origin, listOfParameters.get(0),
                            listOfParameters.get(1));
                }
                break;
            default:
                throw new IllegalArgumentException();
        }
        return shape;
    }
}