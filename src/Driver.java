import java.util.ArrayList;
import java.util.List;

public class Driver
{
    public static void main(String[] args)
    {
        Screen screen = new Screen(200.0, 200.0);
        List<Double> squareParameters = new ArrayList<Double>()
        {{
            add(5.0);
        }};
        List<Double> circleParameters = new ArrayList<Double>()
        {{
            add(7.0);
        }};
        List<Double> rectangleParameters = new ArrayList<Double>()
        {{
            add(4.0);
            add(5.0);
        }};
        List<Double> polygonParameters = new ArrayList<Double>()
        {{
            add(5.0);
            add(4.0);
        }};

        Shape square = ShapeFactory.createShape("SQUARE", new Point(0, 0), squareParameters);
        Shape circle = ShapeFactory.createShape("CIRCLE", new Point(5, 5), circleParameters);
        Shape rectangle = ShapeFactory.createShape("RECTANGLE", new Point(10, 10), rectangleParameters);
        Shape polygon = ShapeFactory.createShape("POLYGON", new Point(15, 15), polygonParameters);

        screen.addShape(square);
        screen.addShape(circle);
        screen.addShape(rectangle);
        screen.addShape(polygon);


        printList("AREA", screen.sortShapesByArea());
        printList("PARAMETER", screen.sortShapesByPerameter());
        printList("DISTANCE FROM ORIGIN", screen.sortShapesByOriginDistance());
    }

    public static void printList(String typeOfSorting, List<Shape> shape)
    {
        System.out.println("Sorted list by " + typeOfSorting + " in ascending order:");
        switch (typeOfSorting.toUpperCase())
        {
            case "AREA":
                for (Shape object : shape)
                {
                    System.out.print(object.getShapeType() + " " + object.getArea() + "\t<\t");
                }
                break;
            case "PARAMETER":
                for (Shape object : shape)
                {
                    System.out.print(object.getShapeType() + " " + object.getParameter() + "\t<\t");
                }
                break;
            case "DISTANCE FROM ORIGIN":
                for (Shape object : shape)
                {
                    System.out.print(object.getShapeType() + " " + object.getOriginDistance() + "\t<\t");
                }
                break;
            case "TIME STAMP":
                for (Shape object : shape)
                {
                    System.out.print(object.getShapeType() + " " + object.getTimeStamp() + "\t<\t");
                }
                break;
        }
        System.out.println();
    }
}
