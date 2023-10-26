public class Arrow {
    private int x_find;
    private int y_find;

    private int startX;
    private int startY;
    private int currentX;
    private int currentY;
    private int xSpeed;
    private int ySpeed;
    public Arrow(int x_find, int y_find,int startX, int startY){

        this.x_find = x_find;
        this.y_find = y_find;
        this.startX=startX;
        this.startY=startY;
        this.currentX=startX;
        this.currentY=startY;
    }

    public void draw(Game game){
        game.line(currentX,currentY, 12, 12);
        updateLocation();
    }

    private void updateLocation() {
        int difX = x_find - currentX;
        int difY = y_find - currentY;
        xSpeed = difX/60;
        ySpeed = difY/60;
        currentX += xSpeed;
        currentY += ySpeed;
    }


    //33 pixels p frame







}
