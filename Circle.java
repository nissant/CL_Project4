public class Circle extends Ellipse {
  public Circle(String newColor, double x, double y, double r) {
    super(newColor, x, y, x, y, r);
    // TODO Auto-generated constructor stub
  }

  @Override
  public double getArea() {
    return Math.PI * Math.pow((this.d), 2);
  }

  @Override
  public double getCirc() {
    return 2 * Math.PI * this.d;
  }

  @Override
  public boolean isPointInside(double x, double y) {
    double temp[] = new double[2];
    temp[0] = x - this.fp1[0];
    temp[1] = y - this.fp1[1];
    Vector pointDist = new Vector(temp);

    if (pointDist.magnitude() <= this.d) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Shape copyShapeShift(double xShift, double yShift) {
    Shape newShape = new Circle(this.getShapeColor(), this.fp1[0], this.fp1[1], this.d);
    newShape.shapeShift(xShift, yShift);
    return newShape;
  }
}
