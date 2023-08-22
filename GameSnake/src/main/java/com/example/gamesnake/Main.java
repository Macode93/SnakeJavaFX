package com.example.gamesnake;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public static GraphicsContext graphicsContext;
    Table table = Table.getTableInstance();
    Direction direction = Direction.getInstance();
    public static Refresher refresher = new Refresher();
    Actions actions = Actions.getActionsInstance();

    @Override
    public void start(Stage primaryStage) {

        Group group = new Group();
        Scene scene = new Scene(group);
        Canvas canvas = new Canvas(table.getHeight(),table.getWidth());
        group.getChildren().add(canvas);
        graphicsContext = canvas.getGraphicsContext2D();

        scene.setOnKeyPressed(event ->{

            if(KeyCode.UP == event.getCode() && direction.getActualDirection() != 1){
                direction.setActualDirection(0);
            }
            if(KeyCode.DOWN == event.getCode() && direction.getActualDirection() != 0){
                direction.setActualDirection(1);
            }
            if(KeyCode.LEFT == event.getCode() && direction.getActualDirection() != 3){
                direction.setActualDirection(2);
            }
            if(KeyCode.RIGHT == event.getCode() && direction.getActualDirection() != 2){
                direction.setActualDirection(3);
            }

        });

        primaryStage.setTitle("Snake");
        primaryStage.setScene(scene);
        primaryStage.show();
        actions.initializeGame();
        refresher.refresher.start();





    }
}
