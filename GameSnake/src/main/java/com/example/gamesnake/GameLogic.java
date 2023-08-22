package com.example.gamesnake;

public class GameLogic {

    Food food = Food.getFoodInstance();
    Snake snake = Snake.getSnakeInstance();
    Table table = Table.getTableInstance();
    private static GameLogic gameLogicInstance;
    private int gameOverIndex = 0;
    public static GameLogic getGameLogicInstance() {
        if(gameLogicInstance == null){
            gameLogicInstance = new GameLogic();
        }
        return gameLogicInstance;
    }
    public void checkEaten(){

        int x_food = food.getX_coordinate();
        int y_food = food.getY_coordinate();
        int x_snakeHead = snake.snake.get(0).getX_coordinate();
        int y_snakeHead = snake.snake.get(0).getY_coordinate();

        if(x_food == x_snakeHead && y_food == y_snakeHead){
            snake.growSnake();
            food.generateFood();
        }
    }

    public void snakeGameover(){

        for(int index = 1; index < snake.snake.size(); index++){

            if(snake.snake.get(0).getX_coordinate() == snake.snake.get(index).getX_coordinate()
            && snake.snake.get(0).getY_coordinate() == snake.snake.get(index).getY_coordinate()){
                gameOverIndex = 1;
            }
        }

    }
    public void tableGameover(){

        if (snake.snake.get(0).getX_coordinate() == table.getRows() || snake.snake.get(0).getX_coordinate() == (table.getRows() - (table.getRows()+1)) ){
            gameOverIndex = 1;
        }
        if (snake.snake.get(0).getY_coordinate() == table.getRows() || snake.snake.get(0).getY_coordinate() == (table.getRows() - (table.getRows()+1)) ){
            gameOverIndex = 1;
        }

    }

    public void checkGameOver(){
        snakeGameover();
        tableGameover();
        if(gameOverIndex==1){
            Main.refresher.refresher.stop();
        }

    }


}
