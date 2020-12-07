package com.mega.games.gamestartingkit.core;

import java.awt.Color;

public class Constants {
    public static int BOARD_W = 15;
    public static int BOARD_H = 15;
    public static int BOX_Width = 23;
    public static int BOX_Height = 23;
    public static int DICE_MIN = 1;
    public static int DICE_MAX = 6;
    public static int [][] initialPosition_RED = {
            {2,1}, {2,3}, {3,1}, {3,3}
    };
    public static int [][] initialPosition_YELLOW = {
            {10,9}, {10,11}, {11,9}, {11,11}
    };
    public static int [][] initialPosition_GREEN = {
            {2,9}, {2,11}, {3,9}, {3,11}
    };
    public static int [][] initialPosition_BLUE = {
            {10,1}, {10,3}, {11,1}, {11,3}
    };
    public static int[] homeBox_RED={6,1};
    public static int[] homeBox_YELLOW={8,13};
    public static int[] homeBox_GREEN={1,8};
    public static int[] homeBox_BLUE={13,6};
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
