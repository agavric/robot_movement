package com.ioof;

import com.ioof.model.Orientation;
import com.ioof.model.Robot;

public class Game {

    private Robot robot;

    public Game(Robot robot) {
        this.robot = robot;
    }

    public boolean parseCommand(String input) {

        boolean res = true;
        String[] inputArgs = input.replace(",", " ").split("\\s+");

        if(inputArgs.length==1 || inputArgs.length==4){
            switch (inputArgs[0]) {
                case "PLACE":
                    parsePlaceCommand(inputArgs);
                    break;
                case "MOVE":
                    robot.move();
                    break;
                case "LEFT":
                    robot.left();
                    break;
                case "RIGHT":
                    robot.right();
                    break;
                case "REPORT":
                    robot.report();
                    break;
                case "EXIT":
                    res = false;
                    break;
            }
        }

        return res;

    }

    private void parsePlaceCommand(String[] inputArgs) {

        try{
            int x = Integer.parseInt(inputArgs[1]);
            int y = Integer.parseInt(inputArgs[2]);
            robot.place(x, y, Orientation.valueOf(inputArgs[3]));
        } catch (Exception e) {
            System.out.println(String.format("ERROR: Invalid place command; %s", e.getMessage()));
        }

     }
}
