package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameMaster {
    int p1, p2;
    int turn = 0;
    GameRenderer gameRenderer;

    interface GameMasterListener {
        void touched(Carta carta);
    }

    GameMasterListener gameMasterListener = new GameMasterListener() {
        @Override
        public void touched(Carta carta) { onCardTouched(carta); }
    };

    GameMaster(Stage stage){
        this.gameRenderer = new GameRenderer(stage, gameMasterListener);
    }

    public void start() {
        p1 = 1;
        p2 = 2;

        gameRenderer.giveCardPlayer1("cardA");
        gameRenderer.giveCardPlayer2("cardB");
    }

    public void onCardTouched(Carta carta){
        if(carta.player == turn+1){
            gameRenderer.sacarCarta(carta);
            turn = ++turn%2;
        }
    }
}
