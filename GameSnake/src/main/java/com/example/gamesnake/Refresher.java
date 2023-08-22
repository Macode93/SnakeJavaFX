package com.example.gamesnake;

import javafx.animation.AnimationTimer;

public class Refresher {

    Actions actions = Actions.getActionsInstance();






    public AnimationTimer refresher = new AnimationTimer() {

        long lastUpdate = 0;

        @Override
        public void handle(long now) {
            if (now-lastUpdate >= 99999999){
                actions.refreshTick();
                lastUpdate = now;
            }
        }
    };

}
