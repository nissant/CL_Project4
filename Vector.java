// This class was inspired by Robert Sedgewick and Kevin Wayne - Computer Science Designing Data
// Types
// https://introcs.cs.princeton.edu/java/33design/
public class Vector {
  private final int n; // length of the vector
  private double[] data; // array of vector's components

  // create the zero vector of length n
  public Vector(int n) {
    this.n = n;
    this.data = new double[n];
  }

  // create a vector from an array
  public Vector(double[] data) {
    n = data.length;
    this.data = new double[n];
    for (int i = 0; i < n; i++) this.data[i] = data[i];
  }

  // return the length of the vector
  public int length() {
    return n;
  }

  // return the inner product of this Vector a and b
  public double dot(Vector that) {
    if (this.length() != that.length()) throw new IllegalArgumentException("dimensions disagree");
    double sum = 0.0;
    for (int i = 0; i < n; i++) sum = sum + (this.data[i] * that.data[i]);
    return sum;
  }

  // returns the magnitude of the cross product of this and that vectors that are assumed to be in
  // 2d space
  public double determinantAbs2D(Vector that) {
    Vector c = new Vector(n);
    c.data[0] = 0;
    c.data[1] = this.data[0] * that.data[1] - this.data[1] * that.data[0];
    return c.magnitude();
  }

  // return the Euclidean norm of this Vector
  public double magnitude() {
    return Math.sqrt(this.dot(this));
  }

  // return this + that
  public Vector plus(Vector that) {
    if (this.length() != that.length()) throw new IllegalArgumentException("dimensions disagree");
    Vector c = new Vector(n);
    for (int i = 0; i < n; i++) c.data[i] = this.data[i] + that.data[i];
    return c;
  }

  // return this - that
  public Vector minus(Vector that) {
    if (this.length() != that.length()) throw new IllegalArgumentException("dimensions disagree");
    Vector c = new Vector(n);
    for (int i = 0; i < n; i++) c.data[i] = this.data[i] - that.data[i];
    return c;
  }

  public double[] getComponents() {
    return this.data;
  }
}
