package com.example.gamesnake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Table {

    private int rows = 21;
    private int columns = 21;
    private int height = 800;
    private int width = 800;
    private int fieldSize = height/rows;
    private int colorIndex = 0;
    private static Table tableInstance;

    Table(){}
    public static Table getTableInstance() {
        if(tableInstance == null){
            tableInstance = new Table();
        }
        return tableInstance;
    }



    public void drawTable(GraphicsContext graphicsContext){

        for (int row = 0; row < rows; row++){
            for (int column = 0; column < columns; column++){

                if(colorIndex == 0){
                    graphicsContext.setFill(Color.DARKGREEN);
                    colorIndex = 1;
                }else {
                    graphicsContext.setFill(Color.GREEN);
                    colorIndex = 0;
                }
                graphicsContext.fillRect(row*fieldSize,column*fieldSize,fieldSize,fieldSize);
            }
        }
        colorIndex = 0;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}
