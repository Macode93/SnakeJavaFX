package com.example.gamesnake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Food {

    Table table = Table.getTableInstance();
    private int x_coordinate;
    private int y_coordinate;
    private int x_drawCoordinate;
    private int y_drawCoordinate;
    private static Food foodInstance;
    private Food(){}

    public static Food getFoodInstance() {
        if(foodInstance == null){
            foodInstance = new Food();
        }
        return foodInstance;
    }

    public void generateFood(){

        x_coordinate = (int) (Math.random()*15);
        y_coordinate = (int) (Math.random()*15);

        x_drawCoordinate = x_coordinate * table.getFieldSize();
        y_drawCoordinate = y_coordinate * table.getFieldSize();

    }

    public void drawFood(GraphicsContext graphicsContext){

        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(x_drawCoordinate,y_drawCoordinate,table.getFieldSize(),table.getFieldSize());

    }

    public int getY_coordinate() {
        return y_coordinate;
    }

    public int getX_coordinate() {
        return x_coordinate;
    }
}
