package com.ioof.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RobotTest {

    private Robot robot;

    @Before
    public void setup() {
        this.robot = new Robot();
    }

    @Test
    public void testPlace() {
        robot.place(0,0, Orientation.NORTH);
        Assert.assertEquals("0,0,NORTH", robot.report());
    }

    @Test
    public void testMove() {
        robot.place(0,0, Orientation.NORTH);
        robot.move();
        Assert.assertEquals("0,1,NORTH", robot.report());
    }

    @Test
    public void testLeft() {
        robot.place(0,0, Orientation.NORTH);
        robot.left();
        Assert.assertEquals("0,0,WEST", robot.report());
    }

    @Test
    public void testRight() {
        robot.place(0,0, Orientation.NORTH);
        robot.right();
        Assert.assertEquals("0,0,EAST", robot.report());
    }

    @Test
    public void placeLessThanMinX() {
        robot.place(-1,0, Orientation.NORTH);
        Assert.assertEquals("", robot.report());
    }

    @Test
    public void placeLessThanMinY() {
        robot.place(0,-1, Orientation.NORTH);
        Assert.assertEquals("", robot.report());
    }

    @Test
    public void placeGreaterThanMaxX() {
        robot.place(5,0, Orientation.NORTH);
        Assert.assertEquals("", robot.report());
    }

    @Test
    public void placeGreaterThanMaxY() {
        robot.place(0,5, Orientation.NORTH);
        Assert.assertEquals("", robot.report());
    }

    @Test
    public void notPlaced() {
        robot.left();
        Assert.assertEquals("", robot.report());
    }

}
