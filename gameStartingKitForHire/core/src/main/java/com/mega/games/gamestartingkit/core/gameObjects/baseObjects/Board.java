package com.mega.games.gamestartingkit.core.gameObjects.baseObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.mega.games.gamestartingkit.core.Constants;
import com.mega.games.gamestartingkit.core.dataLoaders.GameAssetManager;
import com.mega.games.gamestartingkit.core.dataLoaders.GameData;

import java.util.ArrayList;

public class Board extends Box{
    //Member variables
    private TextureAtlas.AtlasRegion currReg;
    private ArrayList<Box>boardArray = new ArrayList<>();
    private Box currentBox;
    private Label HomeBoxLabel = new Label("", GameAssetManager.getInstance().scoreLabelStyle);
    private Box CurrentPlayerNumberBox;
    private Label CurrentPlayerNumberBoxLabel = new Label("", GameAssetManager.getInstance().scoreLabelStyle);
    public Board() {
        super(Constants.BOX_Width,Constants.BOX_Height,Color.LIGHT_GRAY);
        this.HomeBoxLabel.setSize(GameData._virtualWidth,GameAssetManager.getInstance().scoreFontSize);
        this.HomeBoxLabel.setAlignment(Align.left);
        this.HomeBoxLabel.setWrap(true);
        this.CurrentPlayerNumberBox = new Box(Constants.BOX_Width,Constants.BOX_Height,Color.ORANGE);
        this.CurrentPlayerNumberBox.setPos((Constants.BOX_Width * Constants.CURRENT_PLAYER_NUMBER_BOX_X_POS),
                (Constants.BOX_Height * Constants.CURRENT_PLAYER_NUMBER_BOX_Y_POS));
        this.CurrentPlayerNumberBoxLabel.setPosition((Constants.BOX_Width * Constants.CURRENT_PLAYER_NUMBER_BOX_X_POS) +(Constants.BOX_Width / 2) ,
                (Constants.BOX_Height * Constants.CURRENT_PLAYER_NUMBER_BOX_Y_POS));
        this.CurrentPlayerNumberBoxLabel.setSize(GameData._virtualWidth,GameAssetManager.getInstance().scoreFontSize);
        this.CurrentPlayerNumberBoxLabel.setAlignment(Align.left);
        this.CurrentPlayerNumberBoxLabel.setWrap(true);
    }

    public void onTouchDown(float x, float y) {

    }

    public void onTouchUp(float x, float y) {

    }

    public void onTouchDragged(float x, float y) {

    }

    public void update(float dt) {
    }

    @Override
    public void draw(Batch batch) {
        for(Box obj:boardArray){
            obj.draw(batch);
        }
        this.CurrentPlayerNumberBox.draw(batch);
        this.CurrentPlayerNumberBoxLabel.draw(batch,1);
    }

    // function to set current player's number in player number box.
    public void setCurrentPlayerNumberBoxLabel(int arg){
        this.CurrentPlayerNumberBoxLabel.setText(arg);
    }

    public void drawBoard(){
        for(int i = 0; i< Constants.BOARD_W; i++){
            for(int j = 0;j<Constants.BOARD_H;j++){
                Color currentColor = Color.LIGHT_GRAY;
                String currentBoxId = "";
                if((i == 7 & j>=1 & j<=5) || (i == 6 & j== 1)) {
                    currentColor = Color.SALMON;
                    currentBoxId = "RedBox";
                }
                else if((i == 7 & j>=9 & j<=13) ||(i == 8 & j== 13)){
                    currentColor = Color.GOLDENROD;
                    currentBoxId = "YellowBox";
                }
                else if((j == 7 & i>=1 & i<=5) || (i == 1 & j== 8)){
                    currentColor = Color.FOREST;
                    currentBoxId = "GreenBox";
                }
                else if((j == 7 & i>=9 & i<=13) || (i == 13 & j== 6)) {
                    currentColor = Color.SKY;
                    currentBoxId = "BlueBox";
                }
                else if((i >=0 & i<=5 & j>=0 & j<=5) || (i >=9 & i<=14 & j>=0 & j<=5) ||
                        (i >=0 & i<=5 & j>=9 & j<=14) || (i >=9 & i<=14 & j>=9 & j<=14))
                    currentColor = Color.WHITE;
                else if(i>= 6 && i<= 8 && j>= 6 && j<= 8)
                    currentColor = Color.MAGENTA;
                currentBox = new Box(Constants.BOX_Width,Constants.BOX_Height, currentColor);
                currentBox.setId(currentBoxId);
                currentBox.setPos(Constants.BOX_Width*i,Constants.BOX_Height*j);
                this.HomeBoxLabel.setPosition(Constants.BOX_Width * i,Constants.BOX_Height * j);
                boardArray.add(currentBox);
            }
        }
    }
    public void setHomeBoxLabel(int arg){
        this.HomeBoxLabel.setText(arg);
    }

    public void resetAlpha(){
        for(Box obj : boardArray){
            Color currentColor = obj.getColor();
            if(currentColor == Color.MAROON)
                obj.setColor(Color.SALMON);
            else if(currentColor == Color.GOLD)
                obj.setColor(Color.GOLDENROD);
            else if(currentColor == Color.OLIVE)
                obj.setColor(Color.FOREST);
            else if(currentColor == Color.ROYAL)
                obj.setColor(Color.SKY);
        }
    }
    public void changeAlpha(Box obj){
        Color currentColor = obj.getColor();
        if(currentColor == Color.SALMON)
            obj.setColor(Color.MAROON);
        else if(currentColor == Color.GOLDENROD)
            obj.setColor(Color.GOLD);
        else if(currentColor == Color.FOREST)
            obj.setColor(Color.OLIVE);
        else if(currentColor == Color.SKY)
            obj.setColor(Color.ROYAL);
    }

    public void wobblePlayers(int arg){
        switch(arg){
            case 0:
                for(Box obj : boardArray){
                    if(obj.getId() == Constants.Player1s_Box_intials){
                        changeAlpha(obj);
                    }
                }
                break;
            case 1:
                for(Box obj : boardArray){
                    if(obj.getId() == Constants.Player2s_Box_initials){
                        changeAlpha(obj);
                    }
                }
                break;
            case 2:
                for(Box obj : boardArray){
                    if(obj.getId() == Constants.Player3s_Box_initials){
                        changeAlpha(obj);
                    }
                }
                break;
            case 3:
                for(Box obj : boardArray){
                    if(obj.getId() == Constants.Player4s_Box_initials){
                        changeAlpha(obj);
                    }
                }
                break;
        }
    }

    // function to set winner id for players.
    public void setWinLabel(int currentPlayerNumber, int currentWinner){
        int[] currentPlayersHomeBox = new int[2];
        switch(currentPlayerNumber){
            case 0:
                currentPlayersHomeBox = Constants.homeBox_Player1;
                break;
            case 1:
                currentPlayersHomeBox = Constants.homeBox_Player2;
                break;
            case 2:
                currentPlayersHomeBox = Constants.homeBox_Player3;
                break;
            case 3:
                currentPlayersHomeBox = Constants.homeBox_Player4;
                break;
        }
        for(Box obj: boardArray){
            if(obj.getPos().x == (currentPlayersHomeBox[0] * Constants.BOX_Width) && obj.getPos().y == (currentPlayersHomeBox[1]*Constants.BOX_Height)){
                setHomeBoxLabel(currentWinner);
            }
        }
    }
}
