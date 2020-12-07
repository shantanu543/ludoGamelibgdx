package com.mega.games.gamestartingkit.core.gameObjects.baseObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mega.games.gamestartingkit.core.dataLoaders.GameAssetManager;

public class Box extends GameObject {
    //Member variables
    private TextureAtlas.AtlasRegion currReg;
    private String id;

    public Box(float width, float height, Color color) {
        currReg = GameAssetManager.getInstance().square;
        setSize(width, height);
        setColor(color);
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
        batch.draw(currReg,getPos().x-1,getPos().y-1,getSize().x+1, getSize().y+1);
        batch.setColor(new Color(0,0,0,1));
        batch.setColor(getColor());
        batch.draw(currReg,getPos().x,getPos().y,getSize().x, getSize().y);
        batch.setColor(new Color(1,1,1,1));

    }
    public void setId(String str){
        this.id = str;
    }
    public String getId(){
        return this.id;
    }

}
