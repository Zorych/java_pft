package ru.stqa.pft.sandbox;

public class My1Program {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Igor");

    Square s = new Square(5);
    System.out.println("Площадь квадрата стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(3, 8);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
}