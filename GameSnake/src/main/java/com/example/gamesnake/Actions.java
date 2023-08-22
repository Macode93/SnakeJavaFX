package com.example.gamesnake;

public class Actions {

    Snake snake = Snake.getSnakeInstance();
    Food food = Food.getFoodInstance();
    Table table = Table.getTableInstance();
    GameLogic gameLogic = GameLogic.getGameLogicInstance();
    private static Actions actionsInstance;

    public static Actions getActionsInstance() {
        if(actionsInstance == null){
            actionsInstance = new Actions();
        }
        return actionsInstance;
    }

    public void initializeGame(){
        food.generateFood();
        snake.initializeSnake();
    }

    public void refreshTick() {

        table.drawTable(Main.graphicsContext);
        gameLogic.checkGameOver();
        gameLogic.checkEaten();
        food.drawFood(Main.graphicsContext);
        snake.moveBody();
        snake.moveHead();
        snake.drawSnake(Main.graphicsContext);
    }


}
