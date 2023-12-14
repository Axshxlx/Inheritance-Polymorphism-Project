import processing.core.PApplet;

import java.util.ArrayList;


public class Game extends PApplet {
    ArrayList<Card> cards = new ArrayList<>();
    ArrayList<TOWER> towers = new ArrayList<>();

    double elixirP1;
    double elixirP2;
    int frame_count = 0;

    public void settings() {
        size(800, 1000);
    }
    public void setup() {
        towers.add(new TOWER(400, 900, false));
        towers.add(new TOWER(400, 100, true));
    }


    public void draw() {
        frame_count++;//increment the frame counter for every frame
        if(elixirP1< 10){
            elixirP1 += .008333;}
        else{elixirP1=10;}
        if(elixirP2< 10){
            elixirP2 += .008333;}
        else{elixirP2=10;}
        background(0,180,0);
//        rect(mouseX-20,mouseY-20,40,40);
        fill(0,0,0);
        textSize(128);
        text(str((int)elixirP1),100,100);
        text(str((int)elixirP2),100,950);
        for(TOWER t: towers) {
                fill(255);
                t.draw(this);
                t.Attack(this);
        }
        if(!cards.isEmpty()){
            for (int i = cards.size() - 1; i != 0; i--) {
                if (cards.get(i).p1) fill(0, 180, 0);
                else fill(180, 0, 0);
                cards.get(i).draw(this);
                cards.get(i).setDead(this);
            }
        }
    }
    public void keyReleased(){
        if(key== 'g'){
            Card g = new Goblin(true, true, mouseX - 20, mouseY - 20, 150);
            if(elixirP1>=g.elixirPrice && mouseY-20 <= 500 ) {
                cards.add(g);
                elixirP1 -= g.elixirPrice;
            }
            else{
                System.out.println("no elixir");
            }
        }
        if(key== 'h'){
            Card h = new Goblin(true, false, mouseX - 20, mouseY - 20, 150);
            if(elixirP2>=h.elixirPrice && mouseY-20 > 500) {
                cards.add(h);
                elixirP2 -= h.elixirPrice;
            }
            else{
                System.out.println("no elixir");
            }
        }
    }
    public static void main(String[] args) {
        PApplet.main("Game");
    }
}

// need