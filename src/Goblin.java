

public class Goblin extends Card {
    private static int elixirPrice = 3;
    private static int strength = 1;
    private int health = 75;
    private static boolean giant = false;
    private static int atkRadius = 350;
    private static int speedX, speedY;
    private boolean alive;
    private boolean p1;
    private static int initialX, initialY;
    private static int radius=25;

    public Goblin(boolean alive, boolean p1, int xLocation, int yLocation, int health) {
        super(elixirPrice, strength, health, speedX, speedY, atkRadius, giant, alive, p1, xLocation, yLocation);
        int distFromBridgeX = getxLocation() - 400;
        int distFromBridgeY = getyLocation() - 500;
        if(distFromBridgeY < 0 ) speedY=1;
        if(distFromBridgeX < 0 ) speedX=1;
        if(distFromBridgeX > 0 ) speedX=-1;
        if(distFromBridgeY > 0 ) speedY=-1;
            initialX = getxLocation();
            initialY = getyLocation();
    }

    public void updateLocation(Game game) { // (bridge coords --> (350,400,100,200)
        if(p1){
        int goXDist = 400-xLocation;
        speedX=goXDist/120;
        xLocation+=speedX;
            if (yLocation < 400) {
                xLocation += speedX;
                if (xLocation > 450) {
                    speedX= 0;
                }
            }
        }else{
            // starts at bottom
        }
    }




    public static int getRadius() {
        return radius;
    }

    public void draw(Game game) {
        game.fill(0, 120, 0);
        game.ellipse(getxLocation(), getyLocation(), radius, radius);
        game.cards.add(this);
        updateLocation(game);
    }






}