package com.mega.games.gamestartingkit.core.gameObjects.baseObjects;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.mega.games.gamestartingkit.core.Constants;
import com.mega.games.gamestartingkit.core.dataLoaders.GameAssetManager;
import com.mega.games.gamestartingkit.core.dataLoaders.GameData;

import java.util.ArrayList;
import java.util.List;

import sun.font.TrueTypeFont;

public class Player extends Circle {
    private int currentPlayer;
    private int currentPlayerNumber =0;
    private int currentDiceValue= 0;
    public ArrayList<Pawns>playerList = new ArrayList<>();
    private Pawns currentPlayersPawns;
    private Board boardObj;
    public GlobalObjects globalObjectsObj;
    private Vector2 currentPawnsCoordinates = new Vector2();
    private Dice dice;
    private int currentWinner = 1;
    private List<Integer> PlayerNumbersList=new ArrayList<Integer>();
    private Music sound;
    public  Player(Board board, GlobalObjects globalObjects){
        super(23, Color.CORAL);
        this.boardObj = board;
        this.globalObjectsObj = globalObjects;
    }

    @Override
    public void draw(Batch batch) {
        for(Pawns obj:playerList){
            obj.draw(batch);
        }
    }

    // intiialising the players.
    public void initPlayers(){
        for(int i =0;i<4;i++){
            currentPlayersPawns = new Pawns();
            currentPlayersPawns.drawPawns(i);
            currentPlayersPawns.setId(Constants.PlayerInitials + i);
            playerList.add(currentPlayersPawns);
            this.PlayerNumbersList.add(i);
        }
    }
    @Override
    public void onTouchDown(float x, float y) {
            if(Math.floor(x/Constants.BOX_Width) >= 0 && Math.floor(x/Constants.BOX_Width) <= 14 &&
                    Math.floor(y/Constants.BOX_Height) >= 0 && Math.floor(y/Constants.BOX_Height) <= 14 && globalObjectsObj.getDiceCanBePressedAgain() == true){
                double X = x;
                double Y = y;
                this.currentPawnsCoordinates.x = (float) Math.floor(X/Constants.BOX_Width);
                this.currentPawnsCoordinates.y = (float) Math.floor(Y/Constants.BOX_Height);
                setPlayersPawn((int)this.currentPawnsCoordinates.x,(int)this.currentPawnsCoordinates.y,currentPlayersPawns,this.currentPlayerNumber,getDiceValue());
            }
    }

    // Checking if current players pawns are out.
    public boolean isPlayers_Pawns_Out(int current_Player_Number){
       Pawns currentPlayerPawns = playerList.get(current_Player_Number);
        return currentPlayerPawns.checkEachPawnsProp(currentPlayerPawns,current_Player_Number);
    }

    // Switch current player
    public void setCurrentPlayer(int arg){
        boolean isPlayersPawnsOut = isPlayers_Pawns_Out(getCurrentPlayerNumber());
        if( isPlayersPawnsOut == false && arg != 6){
            boardObj.resetAlpha();
            boardObj.wobblePlayers(getCurrentPlayerNumber()+1 <4 ? getCurrentPlayerNumber()+1 : 0);
            setCurrentPlayerNumber();   // changing the current player number.
        }
    }

    // Getter setter for current player number
    public int getCurrentPlayerNumber(){
        return this.currentPlayerNumber;
    }
    public void setCurrentPlayerNumber(){
        int index = (PlayerNumbersList.indexOf(this.currentPlayerNumber) + 1) < PlayerNumbersList.size()
                ? (PlayerNumbersList.indexOf(this.currentPlayerNumber) + 1) : 0;
        this.currentPlayerNumber = PlayerNumbersList.get(index);
        boardObj.setCurrentPlayerNumberBoxLabel(this.currentPlayerNumber); // changing value of currrent player number in orange box.
        this.globalObjectsObj.setDiceEnabled(true);
    }

    // function to cut another players pawn at desired place.
    public void cutAnotherPawns(int x, int y,int currentPlayerNumber){
        for(Pawns obj: playerList){
            if(!obj.getId().matches(Constants.PlayerInitials + currentPlayerNumber)){
                obj.cutAnotherPawn(x,y,Integer.parseInt(String.valueOf(obj.getId().charAt(obj.getId().length() -1))));
            }
        }
    }

    // Check if current Player win.
    public boolean isWin(int currentPlayerNumber){
        Pawns currentPlayer = playerList.get(currentPlayerNumber);
        return currentPlayer.checkIfWin(currentPlayerNumber);
    }

    //changing current players current pawn position.
    public void change_CurrentPlayers_currentPawn_Position(int arg,Circle currentPlayersPawn, int currentPlayerNumber){
        int [][] current_Players_Pawn_Path = new int[Constants.maxRowPath][Constants.maxColumnPath];
        switch(currentPlayerNumber){
            case 0:
                current_Players_Pawn_Path = Constants.path_RED;
                break;
            case 1:
                current_Players_Pawn_Path = Constants.path_GREEN;
                break;
            case 2:
                current_Players_Pawn_Path = Constants.path_YELLOW;
                break;
            case 3:
                current_Players_Pawn_Path = Constants.path_BLUE;
                break;
        }
        cutAnotherPawns(current_Players_Pawn_Path[arg][0],current_Players_Pawn_Path[arg][1],currentPlayerNumber);
        currentPlayersPawn.setPosCoordinates(current_Players_Pawn_Path[arg][0],current_Players_Pawn_Path[arg][1]);
        currentPlayersPawn.setPos((current_Players_Pawn_Path[arg][0] * Constants.BOX_Width) + (Constants.BOX_Width/2),
                (current_Players_Pawn_Path[arg][1] * Constants.BOX_Height)+ (Constants.BOX_Height/2));
        currentPlayersPawn.setToHome(false);
        place_stack_elements_side_by_side(currentPlayerNumber,currentPlayersPawn);
        if(arg == 57){
            currentPlayersPawn.setIsDone(true);
        }
        if(isWin(currentPlayerNumber)){
            boardObj.setWinLabel(currentPlayerNumber,this.currentWinner++);
//            sound = Gdx.audio.newMusic(Gdx.files.internal("bg.mp3"));
//            sound.play();
            this.globalObjectsObj.setDiceEnabled(false);
            this.globalObjectsObj.setisWinOfAnyPlayerBool(true);
            return;
        }
        if(getDiceValue() != Constants.DICE_MAX){
            boardObj.resetAlpha();
            setCurrentPlayerNumber();
            boardObj.wobblePlayers(getCurrentPlayerNumber());
        }

//        setCurrentPlayer(getDiceValue());
    }

    // function to place pawns of same player at stack.
    public void place_stack_elements_side_by_side(int currentPlayerNumber,Circle currentPlayersPawn){
        for(Pawns obj: playerList){
            if(obj.getId().matches(Constants.PlayerInitials + currentPlayerNumber)){
                obj.placeAnotherPawnOverStack(currentPlayersPawn,Integer.parseInt(String.valueOf(obj.getId().charAt(obj.getId().length() -1))));
            }
        }
    }
    // function to getPositionIndex of players pawn
    public int getPositionIndex(Circle currentPlayersPawn, int currentPlayerNumber){
        int index = 0;
        int [][] current_Players_Pawn_Path = new int[Constants.maxRowPath][Constants.maxColumnPath];
        switch(currentPlayerNumber){
            case 0:
                current_Players_Pawn_Path = Constants.path_RED;
                break;
            case 1:
                current_Players_Pawn_Path = Constants.path_GREEN;
                break;
            case 2:
                current_Players_Pawn_Path = Constants.path_YELLOW;
                break;
            case 3:
                current_Players_Pawn_Path = Constants.path_BLUE;
                break;
        }
        int i =0;
        for(int[] obj : current_Players_Pawn_Path) {
            if ((int)currentPlayersPawn.getPosCoordinates().x ==(int)obj[0] && (int)currentPlayersPawn.getPosCoordinates().y == (int)obj[1])
                index = i;
            else
                i++;
        }
        return index;
    }

    // set player's pawn to home box means first box.
    public void setPawnToHomeBox(Circle currentPawn,int currentPlayerNumber){
        switch(currentPlayerNumber){
            case 0:
                currentPawn.setPos((Constants.homeBox_Player1[0] * Constants.BOX_Width) + (Constants.BOX_Width/2),
                        (Constants.homeBox_Player1[1] * Constants.BOX_Height)+ ( Constants.BOX_Height/2));
                currentPawn.setPosCoordinates(Constants.homeBox_Player1[0],Constants.homeBox_Player1[1]);
                currentPawn.setToHome(true);
                break;
            case 1:
                currentPawn.setPos((Constants.homeBox_Player2[0] * Constants.BOX_Width)+ (Constants.BOX_Width/2),
                        (Constants.homeBox_Player2[1] * Constants.BOX_Height)+ (Constants.BOX_Height/2));
                currentPawn.setPosCoordinates(Constants.homeBox_Player2[0],Constants.homeBox_Player2[1]);
                currentPawn.setToHome(true);
                break;
            case 2:
                currentPawn.setPos((Constants.homeBox_Player3[0] * Constants.BOX_Width)+ (Constants.BOX_Width/2),
                        (Constants.homeBox_Player3[1] * Constants.BOX_Height)+ (Constants.BOX_Height/2));
                currentPawn.setPosCoordinates(Constants.homeBox_Player3[0],Constants.homeBox_Player3[1]);
                currentPawn.setToHome(true);
                break;
            case 3:
                currentPawn.setPos((Constants.homeBox_Player4[0] * Constants.BOX_Width)+ (Constants.BOX_Width/2),
                        (Constants.homeBox_Player4[1] * Constants.BOX_Height)+ (Constants.BOX_Height/2));
                currentPawn.setPosCoordinates(Constants.homeBox_Player4[0],Constants.homeBox_Player4[1]);
                currentPawn.setToHome(true);
                break;
        }
    }


    // function to set current players pawn for current round.
    public void setPlayersPawn(int x,int y, Pawns currentPlayersPawns, int currentPlayerNumber, int diceValue){
        Circle currentPlayersPawn = currentPlayersPawns.getPawn(x,y,currentPlayerNumber);
        if(currentPlayersPawn.getOutProperty() == false && diceValue == Constants.DICE_MAX){
            setPawnToHomeBox(currentPlayersPawn,currentPlayerNumber);
            currentPlayersPawn.setOutProperty(true);
            this.globalObjectsObj.setDiceCanBePressedAgain(false);
            this.globalObjectsObj.setDiceEnabled(true);

        }else if(currentPlayersPawn.getOutProperty() == true && currentPlayersPawn.getIsDone() == false){
            int index = getPositionIndex(currentPlayersPawn,currentPlayerNumber);
            int newIndex = index + diceValue;
            if(newIndex <= 57){
                change_CurrentPlayers_currentPawn_Position(newIndex,currentPlayersPawn,currentPlayerNumber);
            }
            this.globalObjectsObj.setDiceEnabled(true);
            globalObjectsObj.setDiceCanBePressedAgain(false);
            this.globalObjectsObj.setPressDiceBool(true);
        }
    }

    // Getter Setter for dice value.
    public int getDiceValue(){
        return this.currentDiceValue;
    }
    public void setDiceValue(int arg){
        this.currentDiceValue = arg;
    }

}
