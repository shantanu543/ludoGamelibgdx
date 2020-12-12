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
    public GlobalObjects globalObjectsObj;
    private int curr = 1;
    public Dice(Player player, GlobalObjects globalObjects){
        super(Constants.BOX_Width,Constants.BOX_Height,Color.CORAL);
        this.playerObj = player;
        this.DiceBox = new Box(Constants.BOX_Width,Constants.BOX_Height,Color.CYAN);
        this.DiceBox.setPos((Constants.BOX_Width * Constants.DICE_BOX_X_POS),(Constants.BOX_Height * Constants.DICE_BOX_Y_POS));
        this.DiceLabel.setPosition((Constants.BOX_Width * Constants.DICE_BOX_X_POS),(Constants.BOX_Height * Constants.DICE_BOX_Y_POS));
        this.DiceLabel.setSize(GameData._virtualWidth,GameAssetManager.getInstance().scoreFontSize);
        this.DiceLabel.setAlignment(Align.left);
        this.DiceLabel.setWrap(true);
        this.globalObjectsObj = globalObjects;
    }
    @Override
    public void onTouchDown(float x, float y) {
        if(x >= Constants.BOX_Width * Constants.DICE_BOX_X_POS && x <=( Constants.BOX_Width * Constants.DICE_BOX_X_POS) + Constants.BOX_Width
                && y >= Constants.BOX_Height * Constants.DICE_BOX_Y_POS && y<= (Constants.BOX_Height * Constants.DICE_BOX_Y_POS) + Constants.BOX_Height
        && this.globalObjectsObj.getDiceEnabled() == true){
            this.globalObjectsObj.setDiceCanBePressedAgain(true);
            this.globalObjectsObj.setPressDiceBool(false);
            this.globalObjectsObj.setDiceEnabled(false);
            setDiceLabel(1);
            playerObj.setDiceValue(Integer.parseInt(this.DiceLabel.getText().toString()));
            playerObj.setCurrentPlayer(Integer.parseInt(this.DiceLabel.getText().toString()));
        }
    }

    @Override
    public void draw(Batch batch) {
        this.DiceBox.draw(batch);
        this.DiceLabel.draw(batch,1);
    }

    // setter & getter for dice label.
    public void setDiceLabel(int arg){
        this.DiceLabel.setText(Constants.DICE_MIN + (int)(Math.random() * Constants.DICE_MAX) );

    }
    public int getDiceLabel(){
        return Integer.parseInt(this.DiceLabel.getText().toString());
    }
    @Override
    public void update(float dt) {
        if(this.globalObjectsObj.getPressDiceBool() == true)
            this.DiceLabel.setText("Click Here");
        if(this.globalObjectsObj.getisWinOfAnyPlayerBool() == true)
            this.DiceLabel.setText("Game End");
    }

}
