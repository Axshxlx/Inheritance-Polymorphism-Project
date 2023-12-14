

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
        if(xLocation<0 || xLocation>800 || yLocation<0 || yLocation>1000 ){
            alive=false;
        }
        Card closestEnem = findClosestEnemy(game);
            System.out.println("the closest enemy is : " + closestEnem);
            if(closestEnem instanceof Card){
              closestEnem.speedY=0;
              closestEnem.speedX=0;
              speedX=0;
              speedY=0;
                double diffX = closestEnem.xLocation-xLocation;
                double diffY = closestEnem.yLocation-yLocation;
                speedX=diffX/120;
                speedY=diffY/120;
                if(xLocation-radius!=closestEnem.xLocation+25){
                    xLocation+=speedX;
                    yLocation+=speedY;
                    Attack(game);
                }
            }
            if (closestEnem instanceof TOWER) {
                double diffX = closestEnem.xLocation-xLocation;
                double diffY = closestEnem.yLocation-yLocation;
                speedX=diffX/120;
                speedY=diffY/120;
            }
           xLocation += speedX;
           yLocation += speedY;

    }



    public void draw(Game game) {
        game.fill(0, 120, 0);
        if(this.p1) {

            game.ellipse((int)(getxLocation()), (int)getyLocation(), radius, radius);
            updateLocation(game);
        }
        else {
            game.ellipse((int)getxLocation(),(int)getyLocation(),radius,radius);
            updateLocation(game);
        }

    }

    public static int getRadius() {
        return radius;
    }






}