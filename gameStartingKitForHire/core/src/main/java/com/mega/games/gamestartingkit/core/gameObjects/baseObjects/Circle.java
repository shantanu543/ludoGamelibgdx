package com.mega.games.gamestartingkit.core.gameObjects.baseObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.mega.games.gamestartingkit.core.dataLoaders.GameAssetManager;

public class Circle extends GameObject {
    //Member variables
    private TextureAtlas.AtlasRegion currReg;

    private float rad;
    private String id;
    private Vector2 initialPos = new Vector2();
    private Vector2 posCoordinates = new Vector2();
    private boolean currenPlayerPawnOutProp = false;
    private boolean currentPlayerPawnAtHome = false;
    private boolean isDone = false;
    public Circle(float radius, Color color) {
        currReg = GameAssetManager.getInstance().circle;
        setRadius(radius);
        setColor(color);
    }

    public void setRadius(float rad){
        this.rad = rad;
    }

    public float getRadius(){
        return rad;
    }

    @Override
    public void setSize(float sizeX, float sizeY) {
        throw new RuntimeException("Set size of a circle using setRadius(float rad)");
    }

    @Override
    public Vector2 getSize() {
        throw new RuntimeException("Get size of a circle using getRadius");
    }

    @Override
    public void onTouchDown(float x, float y) {

    }

    @Override
    public void onTouchUp(float x, float y) {

    }

    @Override
    public void onTouchDragged(float x, float y) {

    }

    @Override
    public void update(float dt) {
    }

    @Override
    public void draw(Batch batch) {
        batch.setColor(getColor());
        batch.draw(currReg,getPos().x - rad,getPos().y - rad,2*rad,2*rad);
        batch.setColor(new Color(1,1,1,1));
    }

    public void setId(String str){
        this.id = str;
    }
    public String getId(){
        return this.id;
    }
    public void setOutProperty(boolean arg){
        this.currenPlayerPawnOutProp = arg;
    }
    public boolean getOutProperty(){
        return this.currenPlayerPawnOutProp;
    }
    public void setInitialPos(float x, float y){
        this.initialPos.x = x;
        this.initialPos.y = y;
    }
    public Vector2 getInitialPos(){
        return this.initialPos;
    }
    public void setToHome(boolean arg){
        this.currentPlayerPawnAtHome = arg;
    }
    public boolean getToHome(){
        return this.currentPlayerPawnAtHome;
    }
    public void setPosCoordinates(float x, float y){
        this.posCoordinates.x = x;
        this.posCoordinates.y = y;
    }
    public Vector2 getPosCoordinates(){
        return this.posCoordinates;
    }
    public void setIsDone(boolean arg){
        this.isDone = arg;
    }
    public boolean getIsDone(){
        return this.isDone;
    }
}
