package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(3, 5);
    Point p2 = new Point(0, 1);
    Point p3 = new Point(-10, 0);
    Point p4 = new Point(0, 0);
    Point p5 = new Point(8, -4);

    Assert.assertEquals(p1.distance(p2), 5);
    Assert.assertEquals(p2.distance(p3), 10.04987562112089);
    Assert.assertEquals(p3.distance(p4), 10);
    Assert.assertEquals(p4.distance(p5), 8.94427190999916);
    Assert.assertEquals(p5.distance(p1), 10.295630140987);
  }
}
