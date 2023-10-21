import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.List;


public class Card {
    protected int elixirPrice;
    protected int strength;
    protected int health;
    protected int speedX, speedY;
    protected int atkRadius;
    protected boolean giant;
    protected boolean alive;
    protected int xLocation;
    protected int yLocation;
    protected boolean p1;

    public Card(int elixirPrice, int strength, int health, int speedX, int speedY, int atkRadius, boolean giant, boolean alive, boolean p1, int xLocation, int yLocation) {
        this.elixirPrice = elixirPrice;
        this.strength = strength;
        this.p1=p1;
        if(p1){
        int distFromBridgeX = getxLocation() - 400;
        int distFromBridgeY = getyLocation() - 500;
        if(distFromBridgeY < 0 ) speedY=1;
        if(distFromBridgeX < 0 ) speedX=1;
        if(distFromBridgeX > 0 ) speedX=-1;
        if(distFromBridgeY > 0 ) speedY=-1;
        }else{
            //do something
        }
        this.speedX = speedX;
        this.speedY = speedY;
        this.atkRadius = atkRadius;
        this.giant = giant;
        alive = true;
        this.health =health;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }
    public int getyLocation() {
        return yLocation;
    }
    public int getxLocation(){
        return xLocation;
    }
    public int FindDistance(Card c) {
        int enemyY = c.getyLocation();
        int enemyX = c.getxLocation();
        int differenceSquaredX = (enemyX - this.xLocation) * (enemyX - this.xLocation);
        int differenceSquaredY = (enemyY - this.yLocation) * (enemyY - this.yLocation);
        double distance = Math.sqrt((double)(differenceSquaredX + differenceSquaredY));
        return (int)distance;
    }

}
