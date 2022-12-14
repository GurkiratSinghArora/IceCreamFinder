package com.example.myapplication.model;

import java.util.ArrayList;
import java.util.Random;
// Game class takes attributes such as number of rows, number of columns and number of mines and etc
public class Game {
    private int numberOfMines;
    private int numberOfRows;
    private int numberOfColumns;
    private int scansUsed;
    private int minesfound;

    public String gametoString(){
        String g;
        g = "Number of rows: " + numberOfRows + ", Number of Columns: " + numberOfColumns + ", Number of Mines: " + numberOfMines +  ", Score: " + this.scoreCalculator();
        return g;
    }

    public int scoreCalculator(){
        int score = 0;
        score = (numberOfRows*numberOfColumns)-scansUsed;

        return score;
    }

    public int getScansUsed() {
        return scansUsed;
    }

    public void setScansUsed(int scansUsed) {
        this.scansUsed = scansUsed;
    }

    public int getMinesfound() {
        return minesfound;
    }

    public void setMinesfound(int minesfound) {
        this.minesfound = minesfound;
    }

    private ArrayList<Mine> mines;

    public Game(){
        this.numberOfMines = 6;
        this.numberOfRows = 4;
        this.numberOfColumns = 6;
        this.mines = new ArrayList<Mine>();
    }

    public ArrayList<Mine> getMines() {
        return mines;
    }

    public void setMines(ArrayList<Mine> mines) {
        this.mines = mines;
    }

    private int scans;

    public int getScans() {
        return scans;
    }

    public void setScans(int scans) {
        this.scans = scans;
    }

    public int getMinesFound() {
        return minesFound;
    }

    public void setMinesFound(int minesFound) {
        this.minesFound = minesFound;
    }

    private int minesFound;


    public Game(int numberOfMines, int numberOfRows, int numberOfColumns) {
        this.numberOfMines = numberOfMines;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.mines = new ArrayList<Mine>();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                Mine m = new Mine(i, j);
                mines.add(m);
            }
        }
    }

    public void addArray(){
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                Mine m = new Mine(i, j);
                mines.add(m);
            }
        }
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public void setNumberOfMines(int numberOfMines) {
        this.numberOfMines = numberOfMines;

    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public void randomMineGenerator() {
        int total = numberOfRows * numberOfColumns;

    }

    public void addingMines() {

        for (int i = 0; i < numberOfMines; i++) {
            Random rand = new Random();
            int random = rand.nextInt(numberOfRows * numberOfColumns);
            if (mines.get(random).getMIne() == false) {
                mines.get(random).setMIne(true);
            } else {
                i--;
            }

        }
    }



    public void checkMines() {
        for (int i = 0; i < numberOfRows * numberOfColumns; i++) {
            int count = 0;
            int x = mines.get(i).getCo_x();
            int y = mines.get(i).getCo_y();
            for (int j = 0; j < mines.size(); j++) {
                if (mines.get(j).getCo_x() == x && mines.get(j).getMIne() == true) {
                    count++;
                } else if (mines.get(j).getCo_y() == y && mines.get(j).getMIne() == true) {
                    count++;
                }
            }
            mines.get(i).setHint(count);
        }

    }

    public int ReturnIndex(int x, int y) {
        int index = 0;
        for (int i = 0; i < this.getMines().size(); i++) {
            if (this.getMines().get(i).getCo_x() == x && this.getMines().get(i).getCo_y() == y) {
                index = i;
            }
        }
        return index;

    }
}

