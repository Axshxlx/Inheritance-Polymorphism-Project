import processing.core.PApplet;

import java.util.ArrayList;

public class Game extends PApplet {
    ArrayList<Card> p1List = new ArrayList<>();
    ArrayList<Card> p2List = new ArrayList<>();
    Goblin test;
    public void settings() {
        size(800, 1000);
    }
    public void setup() {
        test = new Goblin(true, (int)(Math.random()*400+200),(int)(Math.random()*400+200));
    }

    public void draw() {
        background(255);
        fill(0,255,0);
        test.draw(this);
        test.updateLocation();
    }
    public static void main(String[] args) {
        PApplet.main("Game");
    }
}
