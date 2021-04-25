package com.ioof.model;

public class Robot {

    public static final int minXY = 0;
    public static final int maxXY = 4;

    private boolean isPlaced = false;
    private int x;
    private int y;
    private Orientation orientation;

    public void place(int x, int y, Orientation orientation) {

        if(isValidPosition(x) && isValidPosition(y)){
            this.x = x;
            this.y = y;
            this.orientation = orientation;
            this.isPlaced = true;
        }

    }

    public void move() {

        if(!isPlaced) return;

        switch(orientation) {
            case NORTH:
                if(isValidPosition(y+1)) {
                    y++;
                }
                break;
            case EAST:
                if(isValidPosition(x+1)) {
                    x++;
                }
                break;
            case SOUTH:
                if(isValidPosition(y-1)) {
                    y--;
                }
                break;
            case WEST:
                if(isValidPosition(x-1)) {
                    x--;
                }
                break;
        }

    }

    public void left() {

        if(!isPlaced) return;

        orientation = orientation.left();

    }

    public void right() {

        if(!isPlaced) return;

        orientation = orientation.right();

    }

    public String report() {

        String res = "";
        if(!isPlaced) return res;

        res = String.format("%d,%d,%s", x, y, orientation);
        System.out.println(res);
        return res;

    }

    private boolean isValidPosition(int newPosition) {

        boolean res = true;

        if(newPosition < minXY || newPosition > maxXY) {
            res = false;
        }

        return res;

    }

}
