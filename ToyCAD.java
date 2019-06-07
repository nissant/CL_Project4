import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class ToyCAD {
  private static LinkedList<Shape> shapeList = new LinkedList<Shape>();

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    while (true) {
      String rawString = scan.nextLine();
      String[] inputArgs = rawString.toLowerCase().split(" ");
      switch (inputArgs[0]) {
        case "new":
          CreateNewShape(inputArgs);
          break;
        case "delete":
          DeleteShape(Integer.parseInt(inputArgs[1]));
          break;
        case "move":
          ShapeShift(inputArgs);
          break;
        case "copy":
          CopyShapeShift(inputArgs);
          break;
        case "area":
          CalculateTotalArea(inputArgs[1]);
          break;
        case "color":
          ChangeColor(inputArgs);
          break;
        case "circumference":
          CalculateTotalCirc(inputArgs[1]);
          break;
        case "is_inside":
          IsPointInsideShape(inputArgs);
          break;
        case "exit":
          scan.close();
          System.exit(0);
          break;
      }
    }
  }

  private static void CreateNewShape(String[] ShapeParams) {
    Shape newShape = null;
    if (Arrays.asList(Shape.getSupportedColors()).contains(ShapeParams[2]) == false) return;
    switch (ShapeParams[1]) {
      case "triangle":
        newShape =
            new Triangle(
                ShapeParams[2],
                Double.parseDouble(ShapeParams[3]),
                Double.parseDouble(ShapeParams[4]),
                Double.parseDouble(ShapeParams[5]),
                Double.parseDouble(ShapeParams[6]),
                Double.parseDouble(ShapeParams[7]),
                Double.parseDouble(ShapeParams[8]));
        break;
      case "circle":
        newShape =
            new Circle(
                ShapeParams[2],
                Double.parseDouble(ShapeParams[3]),
                Double.parseDouble(ShapeParams[4]),
                Double.parseDouble(ShapeParams[5]));
        break;
      case "ellipse":
        newShape =
            new Ellipse(
                ShapeParams[2],
                Double.parseDouble(ShapeParams[3]),
                Double.parseDouble(ShapeParams[4]),
                Double.parseDouble(ShapeParams[5]),
                Double.parseDouble(ShapeParams[6]),
                Double.parseDouble(ShapeParams[7]));
        break;
      case "parallelogram":
        newShape =
            new Parallelogram(
                ShapeParams[2],
                Double.parseDouble(ShapeParams[3]),
                Double.parseDouble(ShapeParams[4]),
                Double.parseDouble(ShapeParams[5]),
                Double.parseDouble(ShapeParams[6]),
                Double.parseDouble(ShapeParams[7]),
                Double.parseDouble(ShapeParams[8]));
        break;
      case "rectangle":
        newShape =
            new Rectangle(
                ShapeParams[2],
                Double.parseDouble(ShapeParams[3]),
                Double.parseDouble(ShapeParams[4]),
                Double.parseDouble(ShapeParams[5]),
                Double.parseDouble(ShapeParams[6]));
        break;
      case "square":
        newShape =
            new Square(
                ShapeParams[2],
                Double.parseDouble(ShapeParams[3]),
                Double.parseDouble(ShapeParams[4]),
                Double.parseDouble(ShapeParams[5]));
        break;
      default:
        return;
    }
    shapeList.add(newShape);
    System.out.println(newShape.getShapeID());
  }

  private static void DeleteShape(int shapeID) {
    Shape selectShape = getShapeByID(shapeID);
    if (selectShape != null) shapeList.remove(selectShape);
  }

  private static void ShapeShift(String[] Params) {
    int shapeID = Integer.parseInt(Params[1]);
    double xShift = Double.parseDouble(Params[2]);
    double yShift = Double.parseDouble(Params[3]);

    Shape selectShape = getShapeByID(shapeID);
    if (selectShape != null) selectShape.shapeShift(xShift, yShift);
  }

  private static void CopyShapeShift(String[] Params) {
    Shape newShape = null;
    int shapeID = Integer.parseInt(Params[1]);
    double xShift = Double.parseDouble(Params[2]);
    double yShift = Double.parseDouble(Params[3]);

    Shape selectShape = getShapeByID(shapeID);
    if (selectShape != null) {
      newShape = selectShape.copyShapeShift(xShift, yShift);
      shapeList.add(newShape);
    }
    System.out.println(newShape.getShapeID());
  }

  private static void ChangeColor(String[] Params) {
    int shapeID = Integer.parseInt(Params[2]);
    Shape selectShape = getShapeByID(shapeID);
    selectShape.setShapeColor(Params[1]);
  }

  private static void CalculateTotalArea(String color) {
    double areaSum = 0;
    ListIterator<Shape> list_Iter = shapeList.listIterator(0);
    Shape nextShape = null;
    while (list_Iter.hasNext()) {
      nextShape = list_Iter.next();
      if (nextShape.getShapeColor().equals(color)) {
        areaSum += nextShape.getArea();
      }
    }
    System.out.println(String.format("%.2f", areaSum));
  }

  private static void CalculateTotalCirc(String color) {
    double circSum = 0;
    ListIterator<Shape> list_Iter = shapeList.listIterator(0);
    Shape nextShape = null;
    while (list_Iter.hasNext()) {
      nextShape = list_Iter.next();
      if (nextShape.getShapeColor().equals(color)) {
        circSum += nextShape.getCirc();
      }
    }
    System.out.println(String.format("%.2f", circSum));
  }

  private static void IsPointInsideShape(String[] Params) {
    int shapeID = Integer.parseInt(Params[1]);
    double x = Double.parseDouble(Params[2]);
    double y = Double.parseDouble(Params[3]);

    Shape selectShape = getShapeByID(shapeID);
    if (selectShape != null) {
      if (selectShape.isPointInside(x, y)) {
        System.out.println("1");
      } else {
        System.out.println("0");
      }
    }
  }

  private static Shape getShapeByID(int shapeID) {
    ListIterator<Shape> list_Iter = shapeList.listIterator(0);
    Shape nextShape = null;
    while (list_Iter.hasNext()) {
      nextShape = list_Iter.next();
      if (nextShape.getShapeID() == shapeID) {
        return nextShape;
      }
    }
    return nextShape;
  }
}
