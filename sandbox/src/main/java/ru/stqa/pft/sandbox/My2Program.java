package ru.stqa.pft.sandbox;

public class My2Program {
  public static void main(String[] args) {
    Point p1 = new Point(3, 3.5);
    Point p2 = new Point(6, -1);
    Point p3 = new Point(0, 0);
    Point p4 = new Point(-1.5, 2.5);

    p1.distance(p2);
    p1.distance(p3);
    p1.distance(p4);
    p4.distance(p2);
    p2.distance(p3);
  }
}
