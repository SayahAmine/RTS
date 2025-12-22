package com.game.map;


import java.util.Random;

public class MapGrid {

    private Tile[][] grid;
    private  int width;
    private  int height;

    public MapGrid(int width, int height){
        this.width = width;
        this.height = height;
        this.grid = new Tile[width][height];
        generateRandomMap();
    }
    private void generateRandomMap(){


        Random rand = new Random();

        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){

                TerrainType terrain = TerrainType.values()[rand.nextInt(TerrainType.values().length)];
                grid[x][y] = new Tile(terrain);
            }
        }


    }


     public Tile getTile(int x, int y){

        return grid[x][y];

     }



}


