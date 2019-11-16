package ru.stqa.pft.sandbox;

public class My2Program {
  public static void main(String[] args) {
    Point p1 = new Point(3, 3.5);
    Point p2 = new Point(6, -1);
    Point p3 = new Point(0, 0);
    Point p4 = new Point(-1.5, 2.5);

    System.out.println("Расстояние между точками с координатами [" + p1.x + ";" + p1.y + "] и [" + p2.x + ";" + p2.y + "] = " + p1.distance(p2));
    System.out.println("Расстояние между точками с координатами [" + p1.x + ";" + p1.y + "] и [" + p3.x + ";" + p3.y + "] = " + p1.distance(p3));
    System.out.println("Расстояние между точками с координатами [" + p1.x + ";" + p1.y + "] и [" + p4.x + ";" + p4.y + "] = " + p1.distance(p4));
    System.out.println("Расстояние между точками с координатами [" + p4.x + ";" + p4.y + "] и [" + p2.x + ";" + p2.y + "] = " + p4.distance(p2));
    System.out.println("Расстояние между точками с координатами [" + p2.x + ";" + p2.y + "] и [" + p3.x + ";" + p3.y + "] = " + p2.distance(p3));
  }
}