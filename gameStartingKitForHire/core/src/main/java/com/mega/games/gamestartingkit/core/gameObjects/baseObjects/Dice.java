package com.mega.games.gamestartingkit.core.gameObjects.baseObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.mega.games.gamestartingkit.core.Constants;
import com.mega.games.gamestartingkit.core.dataLoaders.GameAssetManager;
import com.mega.games.gamestartingkit.core.dataLoaders.GameData;

import java.util.ArrayList;

public class Dice extends Box {
    private Label DiceLabel = new Label("Click Here", GameAssetManager.getInstance().scoreLabelStyle);
    private Box DiceBox;
    private Player playerObj;
    private int curr = 1;
    public Dice(Player player){
        super(23,23,Color.CORAL);
        this.playerObj = player;
        this.DiceBox = new Box(23,23,Color.CYAN);
        this.DiceBox.setPos((Constants.BOX_Width * 7),(Constants.BOX_Height * 16));
        this.DiceLabel.setPosition((Constants.BOX_Width * 7),(Constants.BOX_Height * 16));
        this.DiceLabel.setSize(GameData._virtualWidth,GameAssetManager.getInstance().scoreFontSize);
        this.DiceLabel.setAlignment(Align.left);
        this.DiceLabel.setWrap(true);
    }
    @Override
    public void onTouchDown(float x, float y) {
        if(x >= Constants.BOX_Width * 7 & x <=( Constants.BOX_Width * 7) + 23 & y >= Constants.BOX_Height * 16 &
        y<= (Constants.BOX_Height * 16) + 23){
            setDiceLabel();
            playerObj.setDiceValue(Integer.parseInt(this.DiceLabel.getText().toString()));
            playerObj.setCurrentPlayer(Integer.parseInt(this.DiceLabel.getText().toString()));
        }
    }

    public void setDiceLabel(){
        this.DiceLabel.setText(Constants.DICE_MIN + (int)(Math.random() * Constants.DICE_MAX) );
//        this.DiceLabel.setText((this.curr++) % 7)
    }

    public int getDiceLabel(){
        return Integer.parseInt(this.DiceLabel.getText().toString());
    }

    @Override
    public void draw(Batch batch) {
        this.DiceBox.draw(batch);
        this.DiceLabel.draw(batch,1);
    }
}
