import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.List;


public class Card {
    protected int elixirPrice;
    protected int strength;
    protected int health;
    protected int speed;
    protected int atkRadius;
    protected boolean giant;
    protected boolean alive;
    public int xLocation;
    public int yLocation;
    public Card(int elixirPrice, int strength, int speed, int atkRadius, boolean giant, boolean alive, int xLocation, int yLocation) {
        this.elixirPrice = elixirPrice;
        this.strength = strength;
        this.speed = speed;
        this.atkRadius = atkRadius;
        this.giant = giant;
        alive = true;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }
    public int getyLocation() {
        return yLocation;
    }
    public int getxLocation(){
        return xLocation;
    }

}
