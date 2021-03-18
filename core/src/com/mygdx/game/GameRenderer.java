package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameRenderer {
    Stage stage;
    GameMaster.GameMasterListener gameMasterListener;

    GameRenderer(Stage stage, GameMaster.GameMasterListener gameMasterListener){
        this.stage = stage;
        this.gameMasterListener = gameMasterListener;
    }

    public void giveCardPlayer1(String i) {
        stage.addActor(new Carta(1, i, 0, 0, gameMasterListener));
    }

    public void giveCardPlayer2(String i) {
        stage.addActor(new Carta(2, i, 100, 100, gameMasterListener));
    }

    public void sacarCarta(Carta carta) {
        carta.mueve();
    }
}
