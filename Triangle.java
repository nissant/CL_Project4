public class Triangle extends Shape {
  private double p1[] = new double[2];
  private double p2[] = new double[2];
  private double p3[] = new double[2];
  private Vector v1 = null;
  private Vector v2 = null;
  private Vector v3 = null;

  public Triangle(
      String newColor, double x1, double y1, double x2, double y2, double x3, double y3) {
    super(newColor);
    assignPoints(x1, y1, x2, y2, x3, y3);
    createVectors();
  }

  private void assignPoints(double x1, double y1, double x2, double y2, double x3, double y3) {
    this.p1[0] = x1;
    this.p1[1] = y1;

    this.p2[0] = x2;
    this.p2[1] = y2;

    this.p3[0] = x3;
    this.p3[1] = y3;
  }

  private void createVectors() {
    double temp[] = new double[2];
    temp[0] = p2[0] - p1[0];
    temp[1] = p2[1] - p1[1];
    v1 = new Vector(temp);

    temp[0] = p3[0] - p1[0];
    temp[1] = p3[1] - p1[1];
    v2 = new Vector(temp);

    temp[0] = p3[0] - p2[0];
    temp[1] = p3[1] - p2[1];
    v3 = new Vector(temp);
  }

  @Override
  public double getArea() {
    return v1.determinantAbs2D(v2) / 2;
  }

  @Override
  public double getCirc() {
    return v1.magnitude() + v2.magnitude() + v3.magnitude();
  }

  @Override
  public void shapeShift(double xShift, double yShift) {
    assignPoints(
        p1[0] + xShift,
        p1[1] + yShift,
        p2[0] + xShift,
        p2[1] + yShift,
        p3[0] + xShift,
        p3[1] + yShift);
    createVectors();
  }

  @Override
  public Shape copyShapeShift(double xShift, double yShift) {
    Shape newShape =
        new Triangle(
            this.getShapeColor(),
            this.p1[0],
            this.p2[1],
            this.p2[0],
            this.p2[1],
            this.p3[0],
            this.p3[1]);
    newShape.shapeShift(xShift, yShift);
    return newShape;
  }

  @Override
  public boolean isPointInside(double x, double y) {
    Triangle subTriangle_1 = new Triangle("", p1[0], p1[1], p2[0], p2[1], x, y);
    Triangle subTriangle_2 = new Triangle("", p1[0], p1[1], p3[0], p3[1], x, y);
    Triangle subTriangle_3 = new Triangle("", p3[0], p3[1], p2[0], p2[1], x, y);

    if (this.getArea()
        == (subTriangle_1.getArea() + subTriangle_2.getArea() + subTriangle_3.getArea()))
      return true;
    else return false;
  }

  public double[] getTriangle2DPoints() {
    double points[] = new double[6];
    points[0] = this.p1[0];
    points[1] = this.p1[1];
    points[2] = this.p1[0];
    points[3] = this.p1[1];
    points[4] = this.p1[0];
    points[5] = this.p1[1];
    return points;
  }
}
