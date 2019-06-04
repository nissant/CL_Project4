import java.util.Arrays;

public abstract class Shape {
  private static int nShapes = 0;
  private String color;
  private static final String[] shapeColors = {"blue", "red", "yello", "green"};
  private int id;

  public Shape(String newColor) {
    // This will validate the colors and allow dummy shapes do be created without registration
    if (Arrays.asList(shapeColors).contains(newColor)) {
      this.id = nShapes;
      this.color = newColor;
      Shape.nShapes += 1;
    }
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
