package com.ioof;

import com.ioof.model.Robot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Robot robot;
    private Game game;

    @Before
    public void setup() {
        this.robot = new Robot();
        this.game = new Game(robot);
    }

    @Test
    public void placeLessThanMinX() {
        game.parseCommand("PLACE -1,0,NORTH");
        Assert.assertEquals("", robot.report());
    }

    @Test
    public void placeLessThanMinY() {
        game.parseCommand("PLACE 0,-1,NORTH");
        Assert.assertEquals("", robot.report());
    }

    @Test
    public void placeGreaterThanMaxX() {
        game.parseCommand("PLACE 0,5,NORTH");
        Assert.assertEquals("", robot.report());
    }

    @Test
    public void placeGreaterThanMaxY() {
        game.parseCommand("PLACE 0,5,NORTH");
        Assert.assertEquals("", robot.report());
    }

    @Test
    public void notPlaced() {
        game.parseCommand("LEFT");
        Assert.assertEquals("", robot.report());
    }

    @Test
    public void invalidOrientation() {
        game.parseCommand("PLACE 0,0,NORT");
        Assert.assertEquals("", robot.report());
    }

    @Test
    public void invalidPlaceCommand() {
        game.parseCommand("PLACE A,B,NORTH");
        Assert.assertEquals("", robot.report());
    }

    /*
        a)----------------
        PLACE 0,0,NORTH
        MOVE
        REPORT

        Output: 0,1,NORTH
     */
    @Test
    public void gameTestA() {
        game.parseCommand("PLACE 0,0,NORTH");
        game.parseCommand("MOVE");
        Assert.assertEquals("0,1,NORTH", robot.report());
    }

    /*
        b)----------------
        PLACE 0,0,NORTH
        LEFT
        REPORT

        Output: 0,0,WEST
    */
    @Test
    public void gameTestB() {
        game.parseCommand("PLACE 0,0,NORTH");
        game.parseCommand("LEFT");
        Assert.assertEquals("0,0,WEST", robot.report());
    }

    /*
        c)----------------
        PLACE 1,2,EAST
        MOVE
        MOVE
        LEFT
        MOVE
        REPORT

        Output: 3,3,NORTH
     */
    @Test
    public void gameTestC() {
        game.parseCommand("PLACE 1,2,EAST");
        game.parseCommand("MOVE");
        game.parseCommand("MOVE");
        game.parseCommand("LEFT");
        game.parseCommand("MOVE");
        Assert.assertEquals("3,3,NORTH", robot.report());
    }

}
