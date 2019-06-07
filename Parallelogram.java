public class Parallelogram extends Shape {
  private Triangle tri1 = null;
  private Triangle tri2 = null;
  private double diagonal;

  public Parallelogram(
      String newColor, double x1, double y1, double x2, double y2, double x3, double y3) {
    super(newColor);
    double p4[] = getFourthPoint(x1, y1, x2, y2, x3, y3);
    calcDiagonal(x1, y1, x3, y3);
    // Dummy triangles that are not registered with class id
    this.tri1 = new Triangle(x1, y1, x2, y2, x3, y3);
    this.tri2 = new Triangle(x1, y1, x3, y3, p4[0], p4[1]);
  }

  private double[] getFourthPoint(
      double x1, double y1, double x2, double y2, double x3, double y3) {
    double temp[] = new double[2];
    temp[0] = x2;
    temp[1] = y2;
    Vector v_pos = new Vector(temp);

    temp[0] = x1 - x2;
    temp[1] = y1 - y2;
    Vector v1 = new Vector(temp);

    temp[0] = x3 - x2;
    temp[1] = y3 - y2;
    Vector v2 = new Vector(temp);

    Vector v3 = v1.plus(v2);

    return v_pos.plus(v3).getComponents();
  }

  private void calcDiagonal(double x1, double y1, double x3, double y3) {
    double temp[] = new double[2];
    temp[0] = x1 - x3;
    temp[1] = y1 - y3;
    Vector v_diagonal = new Vector(temp);
    this.diagonal = v_diagonal.magnitude();
  }

  @Override
  public double getArea() {
    return this.tri1.getArea() + this.tri2.getArea();
  }

  @Override
  public double getCirc() {
    return this.tri1.getCirc() + this.tri2.getCirc() - 2 * this.diagonal;
  }

  @Override
  public void shapeShift(double xShift, double yShift) {
    this.tri1.shapeShift(xShift, yShift);
    this.tri2.shapeShift(xShift, yShift);
  }

  @Override
  public boolean isPointInside(double x, double y) {
    if (this.tri1.isPointInside(x, y) || this.tri2.isPointInside(x, y)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Shape copyShapeShift(double xShift, double yShift) {
    double points[] = this.tri1.getTriangle2DPoints();
    Shape newShape =
        new Parallelogram(
            this.getShapeColor(), points[0], points[1], points[2], points[3], points[4], points[5]);
    newShape.shapeShift(xShift, yShift);
    return newShape;
  }
}
