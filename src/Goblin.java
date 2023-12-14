

public class Goblin extends Card {
    private static int elixirPrice = 3;
    private static int strength = 1;
    private int health = 75;
    private static boolean giant = false;
    private static int atkRadius = 350;
    private double speedX, speedY;
    private boolean alive;
    private boolean p1;
    private static int radius=25;

    public Goblin(boolean alive, boolean p1, int xLocation, int yLocation, int health) {
        super(elixirPrice, strength, health, atkRadius, giant, alive, p1, xLocation, yLocation);
        double distFromBridgeX = 400 - getxLocation();
        double distFromBridgeY = 500 - getyLocation();
        if(this.p1){
            if (xLocation < 400) speedX = -1;
            else speedX = 1;
            if (yLocation > 500) speedY = 1;
            else speedY = -1;
        } else {
            if (xLocation < 400) speedX = 1;
            else speedX = -1;
            if (yLocation > 500) speedY = -1;
            else speedY = 1;
        }
    }

    public void updateLocation(Game game) {

        Card closestEnem = findClosestEnemy(game);
        if(closestEnem.alive) {
            if (closestEnem == null) closestEnem = findClosestTower(game);
            System.out.println("the closest enemy is : " + closestEnem);
            if (closestEnem instanceof TOWER) {
                if (xLocation == closestEnem.xLocation && !this.p1) speedX = 0; // + 50
                if (yLocation == closestEnem.yLocation && !this.p1) speedY = 0; //+100
                if (xLocation == closestEnem.xLocation && this.p1) speedX = 0;
            }
        }
        xLocation += speedX;
        yLocation += speedY;
    }
    public static int getRadius() {
        return radius;
    }

    public void draw(Game game) { // THERE'S A PROBLEM WITH FILLING, YOULL SEE BOTH GOBS AS RED REGARDLESS OF PLAYER variable value
        if(this.p1) {
            game.fill(0, 120, 0);
            game.ellipse((int)(getxLocation()), (int)getyLocation(), radius, radius);
            updateLocation(game);
        }
        else {
            game.fill(120,0,0);
            game.ellipse((int)getxLocation(),(int)getyLocation(),radius,radius);
            updateLocation(game);
        }

    }






}