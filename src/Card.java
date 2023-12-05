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

    public int FindDistance(TOWER t) {
        int enemyY = t.getyLocation();
        int enemyX = t.getxLocation();
        int differenceSquaredX = (enemyX - this.xLocation) * (enemyX - this.xLocation);
        int differenceSquaredY = (enemyY - this.yLocation) * (enemyY - this.yLocation);
        double distance = Math.sqrt((double)(differenceSquaredX + differenceSquaredY));
        return (int)distance;
    }
    public int getHealth() {
        return health;
    }

    public void deductHealth(int healthDeducted){
        health -= healthDeducted;
    }

    public void setDead(Game game){
        if(health<=0){
            alive=false;
        }
        game.cards.remove(this);
    }


    public Card findClosestEnemy(Game g) {
        Card closest = null;
        int closestdistance = FindDistance(findClosestTower(g));
        for (int i = 0; i <= g.cards.size()-1; i++) {
            Card enemy = g.cards.get(i);
            if (enemy instanceof Card) {
                int distance = FindDistance(enemy);
                if (distance <= atkRadius) {
                    if (distance <= closestdistance) {
                        closestdistance = distance;
                        closest = enemy;
                    }
                }

            }
        }
        return closest;
    }


    public TOWER findClosestTower(Game g){
        TOWER closest = null;
        int closestdistance = 10000;
        for (int i = 0; i <= g.towers.size()-1; i++) {
            TOWER enemy = g.towers.get(i);
            int distance = FindDistance(enemy);
            if (distance <= closestdistance) {
                    closestdistance = distance;
                    closest = enemy;
            }

        }
        return closest;
    }
}
