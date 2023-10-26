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
        test = new Goblin(true, true,200, 200, 75);
    }

    public void draw() {
        background(255);
        fill(0,0,180);
        rect(0,450,800, 100); //river
        fill(0,180,0);
        rect(0,0,800, 450);
        rect(0,550,800, 450);
        fill(101,67,32);
        rect(350,400, 100,200); // bridge
        test.draw(this);
    }




    public static void main(String[] args) {
        PApplet.main("Game");
    }
}
