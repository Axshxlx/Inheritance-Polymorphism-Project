
public class TOWER {
    protected int tower_health;
    protected int x_location;
    protected int y_location;
    protected boolean alive;
    protected int type;
    protected boolean Player;
    public TOWER(int type,int x_location, int y_location, boolean Player){
        this.type = type;
        if (type == 0) {
            tower_health = 3600;
        }
        else{
            tower_health = 1800;
        }
        this.x_location = x_location;
        this.y_location = y_location;
        alive = true;
        this.Player = Player;

    }


    public Card findClosestEnemy(Game g) {
        Card closest = null;
        int closestdistance = 50;
        if (Player){
            for (int i = 0; i<=g.p1List.size(); i++){
                Card enemy = g.returnp1List().get(i);
                int distance = FindDistance(enemy);
                if(distance<=closestdistance){
                    closestdistance = distance;
                    closest = enemy;
                }
            }

        }

        return closest;
    }

    public int FindDistance(Card c){
        int enemyY = c.getyLocation();
        int enemyX = c.getxLocation();
        int differenceSquaredX = (enemyX-this.x_location)*(enemyX-this.x_location);
        int differenceSquaredY = (enemyY-this.y_location)*(enemyY-this.y_location);
        double distance = Math.sqrt(differenceSquaredX+differenceSquaredY);
        return (int)distance;

    }


}

