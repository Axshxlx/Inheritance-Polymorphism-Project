import processing.core.PApplet;

import java.util.ArrayList;

public class Game extends PApplet {
    ArrayList<Card> p1List = new ArrayList<>();
    ArrayList<Card> p2List = new ArrayList<>();
    Goblin test = new Goblin(true, (int)(Math.random()*400+200),(int)(Math.random()*400+200));

    public void settings() {
        size(800, 1000);
    }

    public void setup() {
    }

    public void draw() {

        background(255);    // paint screen white
        fill(0,255,0);
        test.draw(returnGame());
    }



    public Game returnGame() { return this;}
    public static void main(String[] args) {
        PApplet.main("Game");
    }
}
