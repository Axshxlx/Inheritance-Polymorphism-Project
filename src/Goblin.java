

public class Goblin extends Card {
    private static int elixirPrice = 3;
    private static int strength = 10;
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
        initialX = getxLocation();
        initialY = getyLocation();
    }

    public void updateLocation() {
        if (getxLocation() == 400) speedX = 0;
        if (getyLocation() == 600) speedY = 0;
        xLocation += speedX;
        yLocation += speedY;
        if (getxLocation() == 400 && p1) speedX = 0;
        if (getyLocation() == 600 && p1) speedY = 0;
    }


    public void draw(Game game) {
        game.fill(0, 120, 0);
        game.ellipse(getxLocation(), getyLocation(), 25, 25);
        if (p1) game.p1List.add(this);
        else game.p2List.add(this);
        updateLocation();

    }



    private int[] destination(Game game) {
        //p1 = bottom |  RIVER ==> rect(0,450,800, 100); | Field ==> 800 by 1000 top left: 0,0
        // Bridge ==> rect(350,400, 100,200);
        if (p1) {
            if (yLocation > 600) {
                int[] destination = {400, 600};
                return destination;
            } else if (yLocation <= 600 && yLocation <= 400) {
                int[] destination = {400, 400};
                return destination;
            } else {
                int[] destination = {1, 1};
                return destination;
            }
        } else {
            int[] destination = {400, 400};
            return destination;
        }
    }


    private boolean onBridge() {
        return (350 < getxLocation() && getxLocation() < 450 && 400 < getyLocation() && getyLocation() < 600);
    }


    public Card findClosestEnemy(Game g) {
        Card closest = null;
        int closestdistance = 1000;
        if (p1 == false) {
            for (int i = 0; i <= g.p2List.size(); i++) {
                Card enemy = g.p2List.get(i);
                if (enemy instanceof Card) {
                    int distance = FindDistance(enemy);
                    if (distance <= atkRadius) {
                        if (distance <= closestdistance) {
                            closestdistance = distance;
                            closest = enemy;
                        }
                    }
                } else {
                    int distance = FindDistance(enemy);
                    if (distance <= closestdistance) {
                        closestdistance = distance;
                        closest = enemy;
                    }
                }
            }

        } else {
            for (int i = 0; i <= g.p2List.size(); i++) {
                Card enemy = g.p2List.get(i);
                if (enemy instanceof Card) {
                    int distance = FindDistance(enemy);
                    if (distance <= atkRadius) {
                        if (distance <= closestdistance) {
                            closestdistance = distance;
                            closest = enemy;
                        }
                    }
                } else {
                    int distance = FindDistance(enemy);
                    if (distance <= closestdistance) {
                        closestdistance = distance;
                        closest = enemy;
                    }
                }

            }


        }
        return closest;
    }

}