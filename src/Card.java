import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.List;


public class Card {
    protected int elixirPrice;
    protected int strength;
    protected int health;
    protected double speedX, speedY;
    protected int atkRadius;
    protected boolean giant;
    protected boolean alive;
    protected double xLocation;
    protected double yLocation;
    protected boolean p1;
    private static int radius=25;

    public Card(int elixirPrice, int strength, int health, int atkRadius, boolean giant, boolean alive, boolean p1, int xLocation, int yLocation) {
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
    public int getHealth() {
        return health;
    }
    public void deductHealth(int healthDeducted){
        health -= healthDeducted;
    }
    public int FindDistance(Card c) {
        double enemyY = c.getyLocation();
        double enemyX = c.getxLocation();
        double differenceSquaredX = (enemyX - this.xLocation) * (enemyX - this.xLocation);
        double differenceSquaredY = (enemyY - this.yLocation) * (enemyY - this.yLocation);
        double distance = Math.sqrt((double) (differenceSquaredX + differenceSquaredY));
        return (int) distance;
    }
    public void setDead(Game game){
        if(health<=0){
            alive=false;
            game.cards.remove(this);
            System.out.println(getHealth()+ " yay I died");
        }
    }


    public Card findClosestEnemy(Game g) {
        Card closest = null;
        int closestdistance = 10000;

        for (int i = 0; i < g.cards.size(); i++) {
            Card enemy = g.cards.get(i);
            if(this.p1 != enemy.p1){
                int distance = FindDistance(enemy);
                    if (distance <= closestdistance) {
                        closestdistance = distance;
                        closest =   enemy;
                }

            }}
        return closest;
        }


    public boolean ifInContact(Game g){
        Card closestEnem =findClosestEnemy(g);
        if(closestEnem!=null && closestEnem.p1 != this.p1){
            double distance = distBetweenCards(this,closestEnem);
            if(distance > (this.atkRadius + closestEnem.radius)){
                this.speedY =0;
                this.speedX = 0;
                    closestEnem.deductHealth(this.strength);

            }
        }
        return true;
    }





    public double distBetweenCards(Card one, Card two){
        return Math.sqrt(Math.pow(one.getyLocation()-two.getyLocation(),2) + Math.pow(one.getxLocation()-two.getxLocation(),2));
    }

    public static int getRadius() {
        return radius;
    }

    public void draw(Game game) {
        if(alive && game.elixirP1 < elixirPrice){
            if (this instanceof Goblin) {
                    game.ellipse((int)getxLocation(), (int)getyLocation(), radius, radius);
                    ((Goblin) this).updateLocation(game);
                }
            }
        }
    public void damage(Card enemy) {
        enemy.deductHealth(strength/30);
    }

    public void Attack(Game g) {
        Card closest = findClosestEnemy(g);
        if(closest!=null){
            if(FindDistance(closest)<=atkRadius){
            if (!attacking) {
                damage(closest);
                name = closest;
                attacking= true;
            } else {
                damage(name);
                if(!name.alive){
                    attacking=false;
                }
            }
        }}

    }
}

