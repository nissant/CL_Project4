public class Square extends Parallelogram {

  public Square(String newColor, double x1, double y1, double length) {

    super(
        newColor,
        x1 - length / 2,
        y1 + length / 2,
        x1 - length / 2,
        y1 - length / 2,
        x1 + length / 2,
        y1 - length / 2);
  }
}
