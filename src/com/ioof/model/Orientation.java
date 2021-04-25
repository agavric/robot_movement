package com.ioof.model;

public enum Orientation {

    NORTH, EAST, SOUTH, WEST;

    public Orientation left() {
        if(ordinal() == 0) {
            return values()[values().length-1];
        } else {
            return  values()[ordinal()-1];
        }
    }


    public Orientation right() {
        if(ordinal()+1 == values().length){
            return values()[0];
        } else {
            return  values()[ordinal()+1];
        }

    }


}
