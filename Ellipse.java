public class Ellipse extends Shape {
  protected double fp1[] = new double[2]; // Used as center for Circle sub class
  private double fp2[] = new double[2];
  protected double d; // Used as radius for Circle sub class
  private double a, b, c;

  public Ellipse(String newColor, double x1, double y1, double x2, double y2, double d) {
    super(newColor);
    this.fp1[0] = x1;
    this.fp1[1] = y1;

    this.fp2[0] = x2;
    this.fp2[1] = y2;

    this.d = d;
  }

  private void calcEllipsParams() {
    double temp[] = new double[2];
    temp[0] = this.fp2[0] - this.fp1[0];
    temp[1] = this.fp2[1] - this.fp1[1];
    Vector vfp12 = new Vector(temp);
    this.c = vfp12.magnitude() / 2;
    this.a = this.d / 2;
    this.b = Math.sqrt(a * a - c * c);
  }

  @Override
  public double getArea() {
    calcEllipsParams();
    return Math.PI * b * a;
  }

  @Override
  public double getCirc() {
    calcEllipsParams();
    double summation = 0;
    // Srinivasa Ramanujan gives a very good approximation
    double h = Math.pow(a - b, 2) / Math.pow(a + b, 2);
    summation = (3 * h) / (10 + Math.sqrt(4 - 3 * h));
    return Math.PI * (a + b) * (1 + summation);
  }

  @Override
  public void shapeShift(double xShift, double yShift) {
    this.fp1[0] += xShift;
    this.fp1[1] += yShift;

    this.fp2[0] += xShift;
    this.fp2[1] += yShift;
  }

  @Override
  public boolean isPointInside(double x, double y) {
    double temp[] = new double[2];
    temp[0] = x - this.fp1[0];
    temp[1] = y - this.fp1[1];
    Vector dist_fp1 = new Vector(temp);

    temp[0] = x - this.fp2[0];
    temp[1] = y - this.fp2[1];
    Vector dist_fp2 = new Vector(temp);

    if ((dist_fp1.magnitude() + dist_fp2.magnitude()) <= this.d) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Shape copyShapeShift(double xShift, double yShift) {
    Shape newShape =
        new Ellipse(
            this.getShapeColor(), this.fp1[0], this.fp1[1], this.fp2[0], this.fp2[1], this.d);
    newShape.shapeShift(xShift, yShift);
    return newShape;
  }
}
