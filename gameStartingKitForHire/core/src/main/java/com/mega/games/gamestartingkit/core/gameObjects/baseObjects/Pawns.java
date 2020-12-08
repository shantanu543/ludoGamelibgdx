package com.mega.games.gamestartingkit.core.gameObjects.baseObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mega.games.gamestartingkit.core.Constants;

import java.util.ArrayList;

public class Pawns extends Circle {
    public static ArrayList<Circle>pawnList_First_player = new ArrayList<>();
    public static ArrayList<Circle>pawnList_Second_Player = new ArrayList<>();
    public static ArrayList<Circle>pawnList_Third_Player = new ArrayList<>();
    public static ArrayList<Circle>pawnList_Fourth_Player = new ArrayList<>();

    public Pawns(){
        super(Constants.RADIUS_PAWN, Color.BLACK);
    }
    @Override
    public void draw(Batch batch) {
        for(Circle obj:pawnList_First_player){
            obj.draw(batch);
        }
        for(Circle obj:pawnList_Second_Player){
            obj.draw(batch);
        }
        for(Circle obj:pawnList_Third_Player){
            obj.draw(batch);
        }
        for(Circle obj:pawnList_Fourth_Player){
            obj.draw(batch);
        }
    }


    // function to draw pawns.
    public void drawPawns(int arg){
        Color currentColor = new Color();
        switch(arg){
            case 0:
                currentColor = Color.RED;
                for(int i =0;i<4;i++){
                        Circle currentCircle = new Circle(5,Color.RED);
                        currentCircle.setPos((Constants.BOX_Width * Constants.initialPosition_Player1[i][0]) + (Constants.BOX_Width/ 2),
                                (Constants.BOX_Height *Constants.initialPosition_Player1[i][1])+ (Constants.BOX_Height/ 2));
                        currentCircle.setPosCoordinates(Constants.initialPosition_Player1[i][0],Constants.initialPosition_Player1[i][1]);
                        currentCircle.setInitialPos(currentCircle.getPos().x, currentCircle.getPos().y);
                        currentCircle.setId(Constants.Player1_intials + i);
                        currentCircle.setOutProperty(false);
                        currentCircle.setToHome(false);
                        pawnList_First_player.add(currentCircle);
                }
                break;
            case 1:
                currentColor = Color.YELLOW;
                for(int i =0;i<4;i++){
                    Circle currentCircle = new Circle(5,Color.YELLOW);
                    currentCircle.setPos((Constants.BOX_Width *Constants.initialPosition_Player2[i][0])+ (Constants.BOX_Width/ 2),
                            (Constants.BOX_Height *Constants.initialPosition_Player2[i][1])+ (Constants.BOX_Height/ 2));
                    currentCircle.setPosCoordinates(Constants.initialPosition_Player2[i][0],Constants.initialPosition_Player2[i][1]);
                    currentCircle.setInitialPos(currentCircle.getPos().x, currentCircle.getPos().y);
                    currentCircle.setId(Constants.Player2_initials + i);
                    currentCircle.setOutProperty(false);
                    currentCircle.setToHome(false);
                    pawnList_Second_Player.add(currentCircle);
                }
                break;
            case 2:
              currentColor = Color.GREEN;
                for(int i =0;i<4;i++){
                    Circle currentCircle = new Circle(5,Color.GREEN);
                    currentCircle.setPos((Constants.BOX_Width *Constants.initialPosition_Player3[i][0])+ (Constants.BOX_Width/ 2),
                            (Constants.BOX_Height *Constants.initialPosition_Player3[i][1])+ (Constants.BOX_Height/ 2));
                    currentCircle.setPosCoordinates(Constants.initialPosition_Player3[i][0],Constants.initialPosition_Player3[i][1]);
                    currentCircle.setInitialPos(currentCircle.getPos().x, currentCircle.getPos().y);
                    currentCircle.setId(Constants.Player3_initials + i);
                    currentCircle.setOutProperty(false);
                    currentCircle.setToHome(false);
                    pawnList_Third_Player.add(currentCircle);
                }
              break;
            case 3:
                currentColor = Color.BLUE;
                for(int i =0;i<4;i++){
                    Circle currentCircle = new Circle(5,Color.BLUE);
                    currentCircle.setPos((Constants.BOX_Width *Constants.initialPosition_Player4[i][0])+ (Constants.BOX_Width/ 2),
                            (Constants.BOX_Height *Constants.initialPosition_Player4[i][1])+ (Constants.BOX_Height/ 2));
                    currentCircle.setPosCoordinates(Constants.initialPosition_Player4[i][0],Constants.initialPosition_Player4[i][1]);
                    currentCircle.setInitialPos(currentCircle.getPos().x, currentCircle.getPos().y);
                    currentCircle.setId(Constants.Player4_initials + i);
                    currentCircle.setOutProperty(false);
                    currentCircle.setToHome(false);
                    pawnList_Fourth_Player.add(currentCircle);
                }
                break;
        }
    }

    // function to check current player's each pawn out property.
    public boolean checkEachPawnsProp(Pawns current_Player_Pawns, int current_Player_Number){
        boolean pawnOut= false;
        ArrayList<Circle>current_players_Pawn_Array = new ArrayList<>();
        switch(current_Player_Number){
            case 0:
                current_players_Pawn_Array = pawnList_First_player;
                break;
            case 1:
                current_players_Pawn_Array = pawnList_Third_Player;
                break;
            case 2:
                current_players_Pawn_Array = pawnList_Second_Player;
                break;
            case 3:
                current_players_Pawn_Array = pawnList_Fourth_Player;
                break;
        }
        for(Circle obj : current_players_Pawn_Array){
            if(obj.getOutProperty() == true)
                pawnOut= true;
        }
       return pawnOut;
    }

    // Function to get selected pawn of current player.
    public Circle getPawn(int x, int y,int currentPlayerNumber){
        ArrayList<Circle>currentPawnArray = new ArrayList<>();
        Circle CurrentPawn = new Circle(10,Color.CORAL);
        switch(currentPlayerNumber){
            case 0:
                currentPawnArray = pawnList_First_player;
                break;
            case 1:
                currentPawnArray = pawnList_Third_Player;
                break;
            case 2:
                currentPawnArray = pawnList_Second_Player;
                break;
            case 3:
                currentPawnArray = pawnList_Fourth_Player;
                break;
        }
        for(Circle obj : currentPawnArray){
            if((int)Math.floor(obj.getPos().x / Constants.BOX_Width)== x && (int)Math.floor(obj.getPos().y/ Constants.BOX_Height) == y)
               CurrentPawn = obj;
        }
        return CurrentPawn;
    }

    //function to cut another players pawn.
    public void cutAnotherPawn(int x, int y,int currentPlayerNumber){
        ArrayList<Circle>currentPawnArray = new ArrayList<>();
        switch(currentPlayerNumber){
            case 0:
                currentPawnArray = pawnList_First_player;
                break;
            case 1:
                currentPawnArray = pawnList_Third_Player;
                break;
            case 2:
                currentPawnArray = pawnList_Second_Player;
                break;
            case 3:
                currentPawnArray = pawnList_Fourth_Player;
                break;
        }
        for(Circle obj : currentPawnArray){
            if((int)obj.getPosCoordinates().x == (int)x && (int)obj.getPosCoordinates().y == (int)y){
                obj.setPos((obj.getInitialPos().x) , (obj.getInitialPos().y));
                obj.setPosCoordinates(obj.getInitialPos().x,obj.getInitialPos().y);
                obj.setToHome(false);
                obj.setOutProperty(false);
            }
        }
    }

    // function to place pawns of current player at one position.
    public void placeAnotherPawnOverStack(Circle currentPlayersPawn,int currentPlayerNumber){
        ArrayList<Circle>currentPawnArray = new ArrayList<>();
        switch(currentPlayerNumber){
            case 0:
                currentPawnArray = pawnList_First_player;
                break;
            case 1:
                currentPawnArray = pawnList_Third_Player;
                break;
            case 2:
                currentPawnArray = pawnList_Second_Player;
                break;
            case 3:
                currentPawnArray = pawnList_Fourth_Player;
                break;
        }
        for(Circle obj : currentPawnArray){
            if((int)obj.getPosCoordinates().x == (int)currentPlayersPawn.getPosCoordinates().x &&
                    (int)obj.getPosCoordinates().y == (int)currentPlayersPawn.getPosCoordinates().y){
                obj.setPos(obj.getPos().x  - Constants.Stacked_Pawns_Space, obj.getPos().y);
                currentPlayersPawn.setPos(currentPlayersPawn.getPos().x +Constants.Stacked_Pawns_Space, currentPlayersPawn.getPos().y);
            }
            else{
                obj.setPos(obj.getPos().x, obj.getPos().y);
            }
        }
    }

    // function to check win of current player.
    public boolean checkIfWin(int currentPlayerNumber){
        ArrayList<Circle> currentPawnList = new ArrayList<>();
        boolean isWin = false;
        switch(currentPlayerNumber){
            case 0:
                currentPawnList = pawnList_First_player;
                break;
            case 1:
                currentPawnList = pawnList_Third_Player;
                break;
            case 2:
                currentPawnList = pawnList_Second_Player;
                break;
            case 3:
                currentPawnList = pawnList_Fourth_Player;
                break;
        }
        for(Circle obj : currentPawnList){
            isWin = obj.getIsDone();
        }
        return  isWin;
    }
}
