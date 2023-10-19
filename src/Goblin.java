public class Goblin extends Card{
    private static int elixirPrice = 3;
    private static int strength = 10;
    private static int health = 75;
    private static boolean giant = false;
    private static int atkRadius = 4;
    private static int speed;
    private boolean alive;

    public Goblin(boolean alive, int xLocation, int yLocation){
        super(elixirPrice,strength,speed, atkRadius, giant, alive,xLocation, yLocation);
        if(getyLocation() > 400) speed=-3;
        else speed=3;
    }
    public void updateLocation() {
        yLocation+=speed;
    }
    public void draw(Game game){
        System.out.println("drawing at: " + getyLocation());
        game.ellipse(getxLocation(),getyLocation(),25,25);
//        game.p1List.add(this);
    }


}
