package com.ioof;

import com.ioof.model.Robot;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Robot robot = new Robot();
        Game game = new Game(robot);
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()) {
            if(!game.parseCommand(scan.nextLine().toUpperCase().trim())) {
                break;
            }
        }

        System.exit(0);
    }
}
