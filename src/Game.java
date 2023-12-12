import processing.core.PApplet;

import java.util.ArrayList;

public class Game extends PApplet {
    ArrayList<Card> cards = new ArrayList<>();
    ArrayList<TOWER> towers = new ArrayList<>();
    Goblin test;
    TOWER t1,t2;

    double elixerP1;
    double elixerP2;

    int frame_count = 0;

    public void settings() {
        size(800, 1000);
    }
    public void setup() {

        test = new Goblin(true, true, 200, 200, 150);
        towers.add(new TOWER(200, 650, false));
        towers.add(new TOWER(200, 0, true));
        t1 = towers.get(0);
        t2 = towers.get(1);
        cards.add(test);


    }

    public void draw() {
        frame_count++;//increment the frame counter for every frame
        if(elixerP1< 10){
        elixerP1 += .008333;}
        else{elixerP1=10;}
        if(elixerP2< 10){
            elixerP2 += .008333;}
        else{elixerP2=10;}
        background(255);
        fill(0,0,180);
        rect(0,450,800, 100); //river
        fill(0,180,0);
        rect(0,0,800, 450);
        rect(0,550,800, 450);
        rect(mouseX-20,mouseY-20,40,40);

        fill(101,67,32);
        rect(350,400, 100,200); // bridge
        for (Card card:cards) {
//            card.draw(this);
        }
        test.draw(this);
        test.ifInContact(this);
        textSize(128);
        text(str((int)elixerP1),200,100);

    }
    public void keyReleased(){
        if(key== 'g'){
            cards.add(new Goblin(true, true, mouseX-20, mouseY-20, 150));

        }
    }
    public static void main(String[] args) {
        PApplet.main("Game");
    }
}
