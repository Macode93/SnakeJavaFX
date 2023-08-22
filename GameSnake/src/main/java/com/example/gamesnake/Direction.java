package com.example.gamesnake;

public class Direction {

    private int actualDirection = 0;
    private static Direction instance;
    private Direction(){}
    public static Direction getInstance(){
        if(instance==null){
            instance = new Direction();
        }
        return instance;
    }

    public int getActualDirection() {
        return actualDirection;
    }

    public void setActualDirection(int actualDirection) {
        this.actualDirection = actualDirection;
    }
}
