

public class Goblin extends Card {
    private static int elixirPrice = 3;
    private static int strength = 1;
    private int health = 75;
    private static boolean giant = false;
    private static int atkRadius = 120;
    private static int speedX, speedY;
    private boolean alive;
    private boolean p1;
    private static int initialX, initialY;
    private static int sightRadius = 400;

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

    public void updateLocation(Game game) {
        if (getxLocation() == 400) speedX = 0;
        xLocation += speedX;
        yLocation += speedY;
        if(getyLocation()==600) {

            if (null == findClosestEnemy(game)) {
               TOWER opp = findClosestTower(game);
                int distFromBridgeX = getxLocation() - opp.getxLocation();
                int distFromBridgeY = getyLocation() - opp.getyLocation();
                if (distFromBridgeY < 0) speedY = 1;
                if (distFromBridgeX < 0) speedX = 1;
                if (distFromBridgeX > 0) speedX = -1;
                if (distFromBridgeY > 0) speedY = -1;
            } else{
                Card closest = findClosestEnemy(game);
                int distFromBridgeX = getxLocation() - closest.getxLocation();
                int distFromBridgeY = getyLocation() - closest.getyLocation();
                if (distFromBridgeY < 0) speedY = 1;
                if (distFromBridgeX < 0) speedX = 1;
                if (distFromBridgeX > 0) speedX = -1;
                if (distFromBridgeY > 0) speedY = -1;
            }
        }
    }

    public void draw(Game game) {
        game.fill(0, 120, 0);
        game.ellipse(getxLocation(), getyLocation(), 25, 25);
        game.cards.add(this);
        updateLocation(game);
    }




}