package com.example.gamesnake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Snake {
    private static Snake snakeInstance;
    private int x_coordinate;
    private int y_coordinate;
    ArrayList<Snake> snake = new ArrayList<>();
    Table table = Table.getTableInstance();
    Food food = Food.getFoodInstance();
    Direction direction = Direction.getInstance();

    public static Snake getSnakeInstance() {
        if(snakeInstance == null){
            snakeInstance = new Snake();
        }
        return snakeInstance;
    }

    private Snake(int x_coordinate, int y_coordinate){

        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;

    }
    private Snake(){}

    public void initializeSnake(){

        snake.add(0,new Snake(8,8));
        snake.add(1,new Snake(8,9));
        snake.add(2,new Snake(8,10));

    }

    public void drawSnake(GraphicsContext graphicsContext){

        for(int index = 0; index < snake.size(); index++){

            if(index != 0){
                graphicsContext.setFill(Color.BLUE);
            }else {
                graphicsContext.setFill(Color.SKYBLUE);
            }
            graphicsContext.fillRect(snake.get(index).getX_coordinate() * table.getFieldSize(),snake.get(index).getY_coordinate() * table.getFieldSize(),
                    table.getFieldSize(), table.getFieldSize());

        }

    }

    public void moveHead(){

        switch (direction.getActualDirection()){

            case 0:
                snake.get(0).setY_coordinate(snake.get(0).getY_coordinate()-1);
                break;
            case 1:
                snake.get(0).setY_coordinate(snake.get(0).getY_coordinate()+1);
                break;
            case 2:
                snake.get(0).setX_coordinate(snake.get(0).getX_coordinate()-1);
                break;
            case 3:
                snake.get(0).setX_coordinate(snake.get(0).getX_coordinate()+1);
                break;
        }

    }
    public void moveBody(){

        for(int index = snake.size()-1; index > 0; index--){
            snake.get(index).setX_coordinate(snake.get(index-1).getX_coordinate());
            snake.get(index).setY_coordinate(snake.get(index-1).getY_coordinate());
        }
    }

    public void growSnake(){

        snake.add(snake.size(),new Snake(food.getX_coordinate(), food.getY_coordinate()));

    }

    public int getY_coordinate() {
        return y_coordinate;
    }

    public int getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public ArrayList<Snake> getSnake() {
        return snake;
    }
}
