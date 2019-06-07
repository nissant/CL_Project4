import java.util.Arrays;

public abstract class Shape {
  private static int nShapes = 0;
  private static final String[] shapeColors = {"blue", "red", "yellow", "green"};
  private String color;
  private int id;

  public Shape(String newColor) {
    // This will validate the colors
    if (Arrays.asList(shapeColors).contains(newColor)) {
      this.id = nShapes;
      this.color = newColor;
      Shape.nShapes += 1;
    }
  }

  public Shape() {
    //  Allow shapes do be created as sub class data members without class id registration
  }

  public int getShapeID() {
    return this.id;
  }

  public String getShapeColor() {
    return this.color;
  }

  public void setShapeColor(String newColor) {
    if (Arrays.asList(shapeColors).contains(newColor)) {
      this.color = newColor;
    }
  }

  public static int getShapeNextID() {
    return nShapes;
  }

  public static String[] getSupportedColors() {
    return shapeColors;
  }

  public abstract double getArea();

  public abstract double getCirc();

  public abstract void shapeShift(double xShift, double yShift);

  public abstract Shape copyShapeShift(double xShift, double yShift);

  public abstract boolean isPointInside(double x, double y);
}
