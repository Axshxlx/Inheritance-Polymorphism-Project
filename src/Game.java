import processing.core.PApplet;

import java.util.ArrayList;

public class Game extends PApplet {
    ArrayList<Card> cards = new ArrayList<>();
    ArrayList<TOWER> towers = new ArrayList<>();
    Goblin test;
    TOWER t1,t2;

    public void settings() {
        size(800, 1000);
    }
    public void setup() {

        test = new Goblin(true, true,200, 200, 150);
        towers.add(new TOWER(200, 800,true));
        towers.add(new TOWER(200, 0,false));
        t1 = towers.get(0);
        t2 = towers.get(1);
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
        t1.draw(this);
        t2.draw(this);
    }




    public static void main(String[] args) {
        PApplet.main("Game");
    }
}
