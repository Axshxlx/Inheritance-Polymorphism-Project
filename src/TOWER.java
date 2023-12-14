
public class TOWER extends Card {
    protected int x_location;
    protected int y_location;
    protected boolean alive;
    protected int type;
    protected boolean Player;

    protected int attackRadius = 400;
    protected boolean attacking;
    protected Card name;
    protected int width = 200;

    protected int length = 200;



    public TOWER(int x_location, int y_location, boolean Player) {
        super(0, 30, 1800, 0, false, true, Player, x_location, y_location);
        this.x_location = x_location;
        this.y_location = y_location;
    }

    public int getY_location() {
        return y_location;
    }

    public Card findClosestEnemy(Game g) {
        Card closest = null;
        int closestdistance = 50;
        if (Player){
            for (int i = 0; i<g.cards.size(); i++){
                Card enemy = g.cards.get(i);
                int distance = FindDistance(enemy);
                if(enemy.p1){
                if(distance<=closestdistance){
                    closestdistance = distance;
                    closest = enemy;
                }}
            }

        }
        else{
            for (int i = 0; i<=g.cards.size(); i++){
                Card enemy = g.cards.get(i);
                int distance = FindDistance(enemy);
               if(!enemy.p1){
                if(distance<=closestdistance){
                    closestdistance = distance;
                    closest = enemy;
                }}
            }

        }
        if(closestdistance<=attackRadius) {
            return closest;
        }
        else{
            return null;
        }
    }

    public int FindDistance(Card c){
        int enemyY = c.getyLocation();
        int enemyX = c.getxLocation();
        int differenceSquaredX = (enemyX-this.x_location)*(enemyX-this.x_location);
        int differenceSquaredY = (enemyY-this.y_location)*(enemyY-this.y_location);
        double distance = Math.sqrt(differenceSquaredX+differenceSquaredY);
        return (int)distance;

    }


    public void draw(Game game){
        game.fill(0,0,120);
        game.rect((int)getxLocation(),(int)getyLocation(),200,200);
    }
    public void Attack(Game g) {
        Card closest = findClosestEnemy(g);
        if(closest!=null && Player==p1){
        if (!attacking) {
            damage(closest);
        }
        else{
            damage(name);
        }
    }
    public void damage(Card enemy){
        if(enemy!=null) {
            enemy.health -= 100;
            attacking = true;
            name = enemy;
        }
    }

    public void draw(Game game){
        game.fill(0,0,120);
        game.rect(x_location,y_location,length,width);
    }

    public int getyLocation() {
        return y_location-(width/2);
    }
    public int getxLocation(){
        return x_location-(length/2);
    }


}

