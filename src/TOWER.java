
public class TOWER extends Card {
    protected double x_location;
    protected double y_location;

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



    public Card findClosestEnemy(Game g) {
        Card closest = null;
        int closestdistance = Integer.MAX_VALUE;
        if(!g.cards.isEmpty()){
            for (int i = 0; i < g.cards.size(); i++) {
                Card enemy = g.cards.get(i);
                int distance = FindDistance(enemy);
                if (Player != enemy.p1) {
                    if (distance <= closestdistance) {
                        closestdistance = distance;
                        closest = enemy;
                    }
                }
            }
        }
        if(closest==null){
            for (int i = 0; i <g.towers.size() ; i++) {
                Card enemy = g.towers.get(i);
                int distance = FindDistance(enemy);
                if (Player != enemy.p1) {
                    if (distance <= closestdistance) {
                        closestdistance = distance;
                        closest = enemy;
                    }
                }
            }
        }
        if (closestdistance <= attackRadius) {
            return closest;
        } else {
            return null;
        }
    }

    public int FindDistance(Card c) {
        if(c != null){
            double enemyY = c.getyLocation();
            double enemyX = c.getxLocation();
            double differenceSquaredX = (enemyX - this.x_location) * (enemyX - this.x_location);
            double differenceSquaredY = (enemyY - this.y_location) * (enemyY - this.y_location);
            double distance = Math.sqrt(differenceSquaredX + differenceSquaredY);
            return (int) distance;
        }
        return 0;
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
            name = closest;
            attacking= true;
        } else {
            System.out.println("attacking opp");
            damage(name);
            if(!name.alive){
                attacking=false;
            }
        }
        }

    }
    public void deductHealth(double healthDeducted){
        health -= healthDeducted;
    }
    public void damage(Card enemy) {
        enemy.deductHealth(strength/30);
    }
    public double getyLocation() {
        return y_location-((double) width /2);
    }
    public double getxLocation(){
        return x_location-((double) length /2);
    }


}

