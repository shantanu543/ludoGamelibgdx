package com.mega.games.gamestartingkit.core.gameObjects.baseObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mega.games.gamestartingkit.core.Constants;

import java.util.ArrayList;

public class Pawns extends Circle {
    public static ArrayList<Circle>pawnList_RED = new ArrayList<>();
    public static ArrayList<Circle>pawnList_YELLOW = new ArrayList<>();
    public static ArrayList<Circle>pawnList_GREEN = new ArrayList<>();
    public static ArrayList<Circle>pawnList_BLUE = new ArrayList<>();

    public Pawns(){
        super(12, Color.BLACK);
    }
    @Override
    public void draw(Batch batch) {
        for(Circle obj:pawnList_RED){
            obj.draw(batch);
        }
        for(Circle obj:pawnList_YELLOW){
            obj.draw(batch);
        }
        for(Circle obj:pawnList_GREEN){
            obj.draw(batch);
        }
        for(Circle obj:pawnList_BLUE){
            obj.draw(batch);
        }
    }


    public void drawPawns(int arg){
        Color currentColor = new Color();
        switch(arg){
            case 0:
                currentColor = Color.RED;
                for(int i =0;i<4;i++){
                        Circle currentCircle = new Circle(5,Color.RED);
                        currentCircle.setPos((23 * Constants.initialPosition_RED[i][0]) + (23/ 2),(23 *Constants.initialPosition_RED[i][1])+ (23/ 2));
                        currentCircle.setPosCoordinates(Constants.initialPosition_RED[i][0],Constants.initialPosition_RED[i][1]);
                        currentCircle.setInitialPos(currentCircle.getPos().x, currentCircle.getPos().y);
                        currentCircle.setId("pawn_RED_" + i);
                        currentCircle.setOutProperty(false);
                        currentCircle.setToHome(false);
                        pawnList_RED.add(currentCircle);
                }
                break;
            case 1:
                currentColor = Color.YELLOW;
                for(int i =0;i<4;i++){
                    Circle currentCircle = new Circle(5,Color.YELLOW);
                    currentCircle.setPos((23 *Constants.initialPosition_YELLOW[i][0])+ (23/ 2),(23 *Constants.initialPosition_YELLOW[i][1])+ (23/ 2));
                    currentCircle.setPosCoordinates(Constants.initialPosition_YELLOW[i][0],Constants.initialPosition_YELLOW[i][1]);
                    currentCircle.setInitialPos(currentCircle.getPos().x, currentCircle.getPos().y);
                    currentCircle.setId("pawn_YELLOW_" + i);
                    currentCircle.setOutProperty(false);
                    currentCircle.setToHome(false);
                    pawnList_YELLOW.add(currentCircle);
                }
                break;
            case 2:
              currentColor = Color.GREEN;
                for(int i =0;i<4;i++){
                    Circle currentCircle = new Circle(5,Color.GREEN);
                    currentCircle.setPos((23 *Constants.initialPosition_GREEN[i][0])+ (23/ 2),(23 *Constants.initialPosition_GREEN[i][1])+ (23/ 2));
                    currentCircle.setPosCoordinates(Constants.initialPosition_GREEN[i][0],Constants.initialPosition_GREEN[i][1]);
                    currentCircle.setInitialPos(currentCircle.getPos().x, currentCircle.getPos().y);
                    currentCircle.setId("pawn_GREEN_" + i);
                    currentCircle.setOutProperty(false);
                    currentCircle.setToHome(false);
                    pawnList_GREEN.add(currentCircle);
                }
              break;
            case 3:
                currentColor = Color.BLUE;
                for(int i =0;i<4;i++){
                    Circle currentCircle = new Circle(5,Color.BLUE);
                    currentCircle.setPos((23 *Constants.initialPosition_BLUE[i][0])+ (23/ 2),(23 *Constants.initialPosition_BLUE[i][1])+ (23/ 2));
                    currentCircle.setPosCoordinates(Constants.initialPosition_BLUE[i][0],Constants.initialPosition_BLUE[i][1]);
                    currentCircle.setInitialPos(currentCircle.getPos().x, currentCircle.getPos().y);
                    currentCircle.setId("pawn_BLUE_" + i);
                    currentCircle.setOutProperty(false);
                    currentCircle.setToHome(false);
                    pawnList_BLUE.add(currentCircle);
                }
                break;
        }
    }
    public boolean checkEachPawnsProp(Pawns current_Player_Pawns, int current_Player_Number){
        boolean pawnOut= false;
        ArrayList<Circle>current_players_Pawn_Array = new ArrayList<>();
        switch(current_Player_Number){
            case 0:
                current_players_Pawn_Array = pawnList_RED;
                break;
            case 1:
                current_players_Pawn_Array = pawnList_GREEN;
                break;
            case 2:
                current_players_Pawn_Array = pawnList_YELLOW;
                break;
            case 3:
                current_players_Pawn_Array = pawnList_BLUE;
                break;
        }
        for(Circle obj : current_players_Pawn_Array){
            if(obj.getOutProperty() == true)
                pawnOut= true;
        }
       return pawnOut;
    }

    public Circle getPawn(int x, int y,int currentPlayerNumber){
        ArrayList<Circle>currentPawnArray = new ArrayList<>();
        Circle CurrentPawn = new Circle(10,Color.CORAL);
        switch(currentPlayerNumber){
            case 0:
                currentPawnArray = pawnList_RED;
                break;
            case 1:
                currentPawnArray = pawnList_GREEN;
                break;
            case 2:
                currentPawnArray = pawnList_YELLOW;
                break;
            case 3:
                currentPawnArray = pawnList_BLUE;
                break;
        }
        for(Circle obj : currentPawnArray){
            if((int)Math.floor(obj.getPos().x / 23)== x && (int)Math.floor(obj.getPos().y/ 23) == y)
               CurrentPawn = obj;
        }
        return CurrentPawn;
    }

    public void cutAnotherPawn(int x, int y,int currentPlayerNumber){
        ArrayList<Circle>currentPawnArray = new ArrayList<>();
        switch(currentPlayerNumber){
            case 0:
                currentPawnArray = pawnList_RED;
                break;
            case 1:
                currentPawnArray = pawnList_GREEN;
                break;
            case 2:
                currentPawnArray = pawnList_YELLOW;
                break;
            case 3:
                currentPawnArray = pawnList_BLUE;
                break;
        }
        for(Circle obj : currentPawnArray){
            if((int)obj.getPosCoordinates().x == (int)x && (int)obj.getPosCoordinates().y == (int)y){
                obj.setPos((obj.getInitialPos().x * Constants.BOX_Width) + (Constants.BOX_Width/ 2),
                        (obj.getInitialPos().y * Constants.BOX_Height) + (Constants.BOX_Height /2));
                obj.setPosCoordinates(obj.getInitialPos().x,obj.getInitialPos().y);
                obj.setToHome(false);
            }
        }
    }

    public boolean checkIfWin(int currentPlayerNumber){
        ArrayList<Circle> currentPawnList = new ArrayList<>();
        boolean isWin = false;
        switch(currentPlayerNumber){
            case 0:
                currentPawnList = pawnList_RED;
                break;
            case 1:
                currentPawnList = pawnList_GREEN;
                break;
            case 2:
                currentPawnList = pawnList_YELLOW;
                break;
            case 3:
                currentPawnList = pawnList_BLUE;
                break;
        }
        for(Circle obj : currentPawnList){
            isWin = obj.getIsDone();
        }
        return  isWin;
    }
}
