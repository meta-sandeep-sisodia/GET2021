import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Screen
{
    static List<Shape> listOfShapes = new ArrayList<Shape>();
    private static final Comparator<Shape> sortByArea = new Comparator<Shape>()
    {
        public int compare(Shape shapeOne, Shape shapeTwo)
        {
            if (shapeOne.getArea() > shapeTwo.getArea())
            {
                return 1;
            } else
            {
                return -1;
            }
        }
    };
    private static final Comparator<Shape> sortByPerameter = new Comparator<Shape>()
    {
        public int compare(Shape shapeOne, Shape shapeTwo)
        {
            if (shapeOne.getParameter() > shapeTwo.getParameter())
            {
                return 1;
            } else
            {
                return -1;
            }
        }
    };
    private static final Comparator<Shape> sortByTimeStamp = new Comparator<Shape>()
    {
        public int compare(Shape shapeOne, Shape shapeTwo)
        {
            return (shapeOne.getTimeStamp().compareTo(shapeTwo.getTimeStamp()));
        }
    };
    private static final Comparator<Shape> sortByOriginDistance = new Comparator<Shape>()
    {
        public int compare(Shape shapeOne, Shape shapeTwo)
        {
            if (shapeOne.getOriginDistance() > shapeTwo.getOriginDistance())
            {
                return 1;
            } else
            {
                return -1;
            }
        }
    };
    double XMAX;
    double YMAX;

    Screen(double XMAX, double YMAX)
    {
        this.XMAX = XMAX;
        this.YMAX = YMAX;
    }

    public boolean addShape(Shape shape) throws NullPointerException
    {
        if (shape == null)
        {
            throw new NullPointerException();
        }
        listOfShapes.add(shape);
        return true;
    }

    public boolean deleteSpecificShape(String type)
    {
        if (type == null)
        {
            throw new NullPointerException();
        }
        if ("".equals(type))
        {
            throw new IllegalArgumentException();
        }
        List<Shape> shapesToDelete = new ArrayList<Shape>();
        for (Shape shape : listOfShapes)
        {
            if (shape.getShapeType().equals(type))
            {
                shapesToDelete.add(shape);
            }
        }
        listOfShapes.removeAll(shapesToDelete);
        return true;
    }

    public void showShapes()
    {
        for (Shape shape : listOfShapes)
        {
            System.out.println(shape.getShapeType());
        }
    }

    public List<Shape> allShapeEnclosedPoint(Point givenCoordinate)
    {
        List<Shape> finalList = new ArrayList<Shape>();
        for (Shape shape : listOfShapes)
        {
            if (shape.isPointEnclosed(givenCoordinate) == true)
            {
                finalList.add(shape);
            }
        }
        return finalList;
    }

    public List<Shape> sortShapesByArea()
    {
        List<Shape> shapesSortedByArea = new ArrayList<Shape>(listOfShapes);
        Collections.sort(shapesSortedByArea, sortByArea);

        return shapesSortedByArea;
    }

    public List<Shape> sortShapesByTimeStamp()
    {
        List<Shape> shapesSortedByTimeStamp = new ArrayList<Shape>(listOfShapes);
        Collections.sort(shapesSortedByTimeStamp, sortByTimeStamp);

        return shapesSortedByTimeStamp;
    }

    public List<Shape> sortShapesByPerameter()
    {
        List<Shape> shapesSortedByParameter = new ArrayList<Shape>(listOfShapes);
        Collections.sort(shapesSortedByParameter, sortByPerameter);

        return shapesSortedByParameter;
    }

    public List<Shape> sortShapesByOriginDistance()
    {
        List<Shape> shapesSortedByOriginDistance = new ArrayList<Shape>(listOfShapes);
        Collections.sort(shapesSortedByOriginDistance, sortByOriginDistance);

        return shapesSortedByOriginDistance;
    }
}