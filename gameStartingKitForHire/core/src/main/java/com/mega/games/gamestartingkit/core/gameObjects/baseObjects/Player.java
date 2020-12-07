package com.mega.games.gamestartingkit.core.gameObjects.baseObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mega.games.gamestartingkit.core.Constants;
import com.mega.games.gamestartingkit.core.dataLoaders.GameAssetManager;

import java.util.ArrayList;

import sun.font.TrueTypeFont;

public class Player extends Circle {
    public ArrayList<Pawns>playerList = new ArrayList<>();
    private Pawns currentPlayersPawns;
    private Board boardObj;
    private int currentPlayer;
    private int currentPlayerNumber =0;
    private int currentDiceValue= 0;
    private Vector2 currentPawnsCoordinates = new Vector2();
    private Dice dice;
    private int currentWinner = 1;
    public  Player(Board board){
        super(15, Color.CORAL);
        this.boardObj = board;
    }

    @Override
    public void draw(Batch batch) {
        for(Pawns obj:playerList){
            obj.draw(batch);
        }
    }
    public int getDiceValue(){
        return this.currentDiceValue;
    }
    public void setDiceValue(int arg){
         this.currentDiceValue = arg;
    }
    public void initPlayers(){
        for(int i =0;i<4;i++){
            currentPlayersPawns = new Pawns();
            currentPlayersPawns.drawPawns(i);
            currentPlayersPawns.setId("Player_" + i);
            playerList.add(currentPlayersPawns);
        }
    }
    @Override
    public void onTouchDown(float x, float y) {
            if(x/23 >= 0 && x/23 <= 14 && y/23 >= 0 && y/23 <= 14){
                double X = x;
                double Y = y;
                this.currentPawnsCoordinates.x = (float) Math.floor(X/23);
                this.currentPawnsCoordinates.y = (float) Math.floor(Y/23);
                setPlayersPawn((int)this.currentPawnsCoordinates.x,(int)this.currentPawnsCoordinates.y,currentPlayersPawns,this.currentPlayerNumber,getDiceValue());
            }
    }

    public boolean checkPlayerPawnOut(int current_Player_Number){
       Pawns currentPlayerPawns = playerList.get(current_Player_Number);
        return currentPlayerPawns.checkEachPawnsProp(currentPlayerPawns,current_Player_Number);
    }

    public void setCurrentPlayer(int arg){
        boolean checkPlayerPawnOut = checkPlayerPawnOut(this.currentPlayerNumber);
        if( checkPlayerPawnOut == false && arg != 6){
            boardObj.resetAlpha();
            boardObj.wobblePlayers(this.currentPlayerNumber);
            this.currentPlayerNumber++;
            if(this.currentPlayerNumber > 3)
                this.currentPlayerNumber = 0;
        }
        else if(checkPlayerPawnOut == false && arg == 6){
            this.currentPlayerNumber--;
            if(this.currentPlayerNumber == -1)
                this.currentPlayerNumber = 3;
        }
    }
    public void cutAnotherPawns(int x, int y,int currentPlayerNumber){
        for(Pawns obj: playerList){
            if(obj.getId().indexOf(currentPlayerNumber) == -1){
                obj.cutAnotherPawn(x,y,currentPlayerNumber);
            }
        }
    }
    public boolean getIfWin(int currentPlayerNumber){
        Pawns currentPlayer = playerList.get(currentPlayerNumber);
        return currentPlayer.checkIfWin(currentPlayerNumber);
    }
    public void changePawnPosition(int arg,Circle currentPlayersPawn, int currentPlayerNumber){
        int [][] currentPawnPath = new int[Constants.maxRowPath][Constants.maxColumnPath];
        switch(currentPlayerNumber){
            case 0:
                currentPawnPath = Constants.path_RED;
                break;
            case 1:
                currentPawnPath = Constants.path_YELLOW;
                break;
            case 2:
                currentPawnPath = Constants.path_GREEN;
                break;
            case 3:
                currentPawnPath = Constants.path_BLUE;
                break;
        }
        cutAnotherPawns(currentPawnPath[arg][0],currentPawnPath[arg][1],currentPlayerNumber);
        currentPlayersPawn.setPosCoordinates(currentPawnPath[arg][0],currentPawnPath[arg][1]);
        currentPlayersPawn.setPos((currentPawnPath[arg][0] * 23) + (23/2), (currentPawnPath[arg][0] * 23)+ (23/2));
        currentPlayersPawn.setToHome(false);
        if(arg == 57){
            currentPlayersPawn.setIsDone(true);
        }
        if(getIfWin(currentPlayerNumber)){
            boardObj.setWinLabel(currentPlayerNumber,this.currentWinner++);
        }
        boardObj.resetAlpha();
        boardObj.wobblePlayers(this.currentPlayerNumber);
        this.currentPlayerNumber++;
        if(this.currentPlayerNumber > 3)
            this.currentPlayerNumber = 0;
        setCurrentPlayer(getDiceValue());
    }
    public int getPositionIndex(Circle currentPlayersPawn, int currentPlayerNumber){
        int index = 0;
        int [][] currentPawnPath = new int[Constants.maxRowPath][Constants.maxColumnPath];
        switch(currentPlayerNumber){
            case 0:
                currentPawnPath = Constants.path_RED;
                break;
            case 1:
                currentPawnPath = Constants.path_YELLOW;
                break;
            case 2:
                currentPawnPath = Constants.path_GREEN;
                break;
            case 3:
                currentPawnPath = Constants.path_BLUE;
                break;
        }
        int i =0;
        for(int[] obj : currentPawnPath) {
            if (currentPlayersPawn.getPosCoordinates().x == obj[0] && currentPlayersPawn.getPosCoordinates().y == obj[1])
                index = i;
            else
                i++;
        }
        return index;
    }
    public void setPawnToHomeBox(Circle currentPawn,int currentPlayerNumber){
        switch(currentPlayerNumber){
            case 0:
                currentPawn.setPos((Constants.homeBox_RED[0] * 23) + (23/2), (Constants.homeBox_RED[1] * 23)+ (23/2));
                currentPawn.setPosCoordinates(Constants.homeBox_RED[0],Constants.homeBox_RED[1]);
                currentPawn.setToHome(true);
                break;
            case 1:
                currentPawn.setPos((Constants.homeBox_GREEN[0] * 23)+ (23/2), (Constants.homeBox_GREEN[1] * 23)+ (23/2));
                currentPawn.setPosCoordinates(Constants.homeBox_GREEN[0],Constants.homeBox_GREEN[1]);
                currentPawn.setToHome(true);
                break;
            case 2:
                currentPawn.setPos((Constants.homeBox_YELLOW[0] * 23)+ (23/2), (Constants.homeBox_YELLOW[1] * 23)+ (23/2));
                currentPawn.setPosCoordinates(Constants.homeBox_YELLOW[0],Constants.homeBox_YELLOW[1]);
                currentPawn.setToHome(true);
                break;
            case 3:
                currentPawn.setPos((Constants.homeBox_BLUE[0] * 23)+ (23/2), (Constants.homeBox_BLUE[1] * 23)+ (23/2));
                currentPawn.setPosCoordinates(Constants.homeBox_BLUE[0],Constants.homeBox_BLUE[1]);
                currentPawn.setToHome(true);
                break;
        }

    }


    public void setPlayersPawn(int x,int y, Pawns currentPlayersPawns, int currentPlayerNumber, int diceValue){
        Circle currentPlayersPawn = currentPlayersPawns.getPawn(x,y,currentPlayerNumber);
        if(currentPlayersPawn.getOutProperty() == false){
            setPawnToHomeBox(currentPlayersPawn,currentPlayerNumber);
            currentPlayersPawn.setOutProperty(true);
        }else if(currentPlayersPawn.getOutProperty() == true){
            int index = getPositionIndex(currentPlayersPawn,currentPlayerNumber);
            int newIndex = index + diceValue;
            if(newIndex <= 57){
                changePawnPosition(newIndex,currentPlayersPawn,currentPlayerNumber);
            }
        }
    }

}
