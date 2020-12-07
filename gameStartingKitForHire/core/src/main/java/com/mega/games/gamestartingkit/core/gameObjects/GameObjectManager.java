package com.mega.games.gamestartingkit.core.gameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mega.games.gamestartingkit.core.dataLoaders.GameData;
import com.mega.games.gamestartingkit.core.gameObjects.baseObjects.Board;
import com.mega.games.gamestartingkit.core.gameObjects.baseObjects.Box;
import com.mega.games.gamestartingkit.core.gameObjects.baseObjects.Dice;
import com.mega.games.gamestartingkit.core.gameObjects.baseObjects.Pawns;
import com.mega.games.gamestartingkit.core.gameObjects.baseObjects.Player;
import com.mega.games.gamestartingkit.core.gameObjects.entities.Ball;
import com.mega.games.gamestartingkit.core.gameObjects.baseObjects.GameObject;

import java.util.ArrayList;

public class GameObjectManager {
//    private Ball ball;
    private Board board;
    private Player player;
    private Dice dice;
    private ArrayList<GameObject> objs;

    public void reset(){
        //on reset, clear the object list and just add a ball
        objs.clear();

//        ball = new Ball(25, Color.RED);
//        ball.setPos(GameData._virtualWidth/2f, GameData._virtualHeight/2f);
        board = new Board();
        board.drawBoard();
        player = new Player(board);
        player.initPlayers();
        dice = new Dice(player);
//        board.setPos(GameData._virtualWidth/2f, GameData._virtualHeight/2f);
//        box = new Box(25,25,Color.BLUE);
//        box.setPos(GameData._virtualWidth/2f, GameData._virtualHeight/2f);
//        board = new Board();
//        objs.add(box);
//        objs.add(ball);
        player.setCurrentPlayer(0);
        objs.add(board);
        objs.add(player);
        objs.add(dice);
    }

    public ArrayList<GameObject> getObjs() {
        return objs;
    }


    public void update(float dt){
        //Automatically called every frame before draw function
        for(GameObject obj:objs){
            obj.update(dt);
        }
    }

    public void draw(Batch batch){
        //automatically called every frame after update function
        for(GameObject obj:objs){
            obj.draw(batch);
        }
    }

    //set singleton
    private static final GameObjectManager _myInstance = new GameObjectManager();
    public static GameObjectManager getInstance(){
        return _myInstance;
    }
    private GameObjectManager(){
        objs = new ArrayList<>();
    }
}
