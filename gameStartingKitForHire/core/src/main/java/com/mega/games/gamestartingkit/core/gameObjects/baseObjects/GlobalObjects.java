package com.mega.games.gamestartingkit.core.gameObjects.baseObjects;

public class GlobalObjects {
    private boolean isDiceEnabled = true;
    private boolean isDiceCanBePressedAgain = true;
    private boolean PressDice = true;
    private boolean isWinOfAnyPlayer = false;
    public GlobalObjects(){

    }
    public void setDiceEnabled(boolean arg){
        this.isDiceEnabled = arg;
    }
    public boolean getDiceEnabled(){
        return this.isDiceEnabled;
    }

    public void setDiceCanBePressedAgain(boolean arg){
        this.isDiceCanBePressedAgain = arg;
    }
    public boolean getDiceCanBePressedAgain(){
        return this.isDiceCanBePressedAgain;
    }
    public void setPressDiceBool(boolean arg){
        this.PressDice = arg;
    }
    public boolean getPressDiceBool(){
        return this.PressDice;
    }
    public void setisWinOfAnyPlayerBool(boolean arg){
        this.isWinOfAnyPlayer = arg;
    }
    public boolean getisWinOfAnyPlayerBool(){
        return this.isWinOfAnyPlayer;
    }
}
