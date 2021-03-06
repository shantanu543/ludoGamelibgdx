package com.mega.games.gamestartingkit.core;

import java.awt.Color;

public class Constants {
    public static String PlayerInitials = "Player_";
    public static String Player1_intials = "pawn_RED_";
    public static String Player2_initials = "pawn_GREEN_";
    public static String Player3_initials = "pawn_YELLOW_";
    public static String Player4_initials= "pawn_BLUE_";
    public static String Player1s_Box_intials = "RedBox";
    public static String Player2s_Box_initials = "GreenBox";
    public static String Player3s_Box_initials = "YellowBox";
    public static String Player4s_Box_initials= "BlueBox";
    public static int BOARD_W = 15;
    public static int BOARD_H = 15;
    public static int BOX_Width = 23;
    public static int BOX_Height = 23;
    public static int DICE_MIN = 1;
    public static int DICE_MAX = 6;
    public static int Stacked_Pawns_Space = 5;
    public static int DICE_BOX_X_POS = 7;
    public static int DICE_BOX_Y_POS = 16;
    public static int CURRENT_PLAYER_NUMBER_BOX_X_POS = 12;
    public static int CURRENT_PLAYER_NUMBER_BOX_Y_POS = 16;
    public static int RADIUS_PAWN = 12;
    public static int [][] initialPosition_Player1 = {
            {2,1}, {2,3}, {3,1}, {3,3}
    };
    public static int [][] initialPosition_Player2 = {
            {10,9}, {10,11}, {11,9}, {11,11}
    };
    public static int [][] initialPosition_Player3 = {
            {2,9}, {2,11}, {3,9}, {3,11}
    };
    public static int [][] initialPosition_Player4 = {
            {10,1}, {10,3}, {11,1}, {11,3}
    };
    public static int[] homeBox_Player1={6,1};
    public static int[] homeBox_Player2={1,8};
    public static int[] homeBox_Player3={8,13};
    public static int[] homeBox_Player4={13,6};
    public static int maxRowPath = 57;
    public static int maxColumnPath = 2;
    public static int [][] path_RED = {
            {6,1}, {6,2}, {6,3}, {6,4},{6,5},//red path
            {5,6},{4,6},{3,6},{2,6},{1,6},{0,6},{0,7},{0,8},{1,8},{2,8},{3,8},{4,8},{5,8},//green path
            {6,9},{6,10},{6,11},{6,12},{6,13},{6,14},{7,14},{8,14},{8,13},{8,12},{8,11},{8,10},{8,9},//yellow path
            {9,8},{10,8},{11,8},{12,8},{13,8},{14,8},{14,7},{14,6},{13,6},{12,6},{11,6},{10,6},{9,6},// blue path
            {8,5},{8,4},{8,3},{8,2},{8,1},{8,0},//red path
            {7,0},{7,1},{7,2},{7,3},{7,4},{7,5},{7,6}// home path
    };
    public static int [][] path_GREEN = {
            {1,8},{2,8},{3,8},{4,8},{5,8},//green path
            {6,9},{6,10},{6,11},{6,12},{6,13},{6,14},{7,14},{8,14},{8,13},{8,12},{8,11},{8,10},{8,9},//yellow path
            {9,8},{10,8},{11,8},{12,8},{13,8},{14,8},{14,7},{14,6},{13,6},{12,6},{11,6},{10,6},{9,6},// blue path
            {8,5},{8,4},{8,3},{8,2},{8,1},{8,0},{7,0},{6,0},{6,1}, {6,2}, {6,3}, {6,4},{6,5},// red path
            {5,6},{4,6},{3,6},{2,6},{1,6},{0,6},{0,7},//green path
            {1,7},{2,7},{3,7},{4,7},{5,7},{6,7}//home path
    };
    public static int [][] path_YELLOW = {
            {8,13},{8,12},{8,11},{8,10},{8,9},//yellow path
            {9,8},{10,8},{11,8},{12,8},{13,8},{14,8},{14,7},{14,6},{13,6},{12,6},{11,6},{10,6},{9,6},// blue path
            {8,5},{8,4},{8,3},{8,2},{8,1},{8,0},{7,0},{6,0},{6,1}, {6,2}, {6,3}, {6,4},{6,5},// red path
            {5,6},{4,6},{3,6},{2,6},{1,6},{0,6},{0,7},{0,8},{1,8},{2,8},{3,8},{4,8},{5,8},// green path
            {6,9},{6,10},{6,11},{6,12},{6,13},{6,14},{7,14},//yellow path
            {7,13},{7,12},{7,11},{7,10},{7,9},{7,8}// home path
    };
    public static int [][] path_BLUE = {
            {13,6},{12,6},{11,6},{10,6},{9,6},// blue path
            {8,5},{8,4},{8,3},{8,2},{8,1},{8,0},{7,0},{6,0},{6,1}, {6,2}, {6,3}, {6,4},{6,5},// red path
            {5,6},{4,6},{3,6},{2,6},{1,6},{0,6},{0,7},{0,8},{1,8},{2,8},{3,8},{4,8},{5,8},// green path
            {6,9},{6,10},{6,11},{6,12},{6,13},{6,14},{7,14},{8,14},{8,13},{8,12},{8,11},{8,10},{8,9},//yellow path
            {9,8},{10,8},{11,8},{12,8},{13,8},{14,8},{14,7},// blue path
            {13,7},{12,7},{11,7},{10,7},{9,7},{8,7} // home path
    };
}
