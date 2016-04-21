/**
 * Created by dv15man.
 */
public class RightHandRuleRobot extends Robot {



    public RightHandRuleRobot(Maze maze){
        super(maze);
        super.setCurrentPosition(maze.getStartPosition());
        System.out.println(getCurrentPosition().getPosToSouth().getY());
        System.out.println(getCurrentPosition().getPosToSouth().getX());




    }

    public void move() throws IllegalStateException{
        try {
            checkIfTraped();
            getFacingPosition(getCurrentPosition());
        }
        catch (Exception e) {
            throw new IllegalStateException();
        }
        //System.out.println(getCurrentPosition().getY() + " " + getCurrentPosition().getX());

        switch (faceingP){

            case 1: facingEast();
                    break;

            case 2: facingSouth();
                    break;

            case 3: facingWest();
                    break;

            case 4: facingNorth();
                    break;

            default: break;
        }


    }


    /**
     * Make the robot move if it is facing east
     */
    private void facingEast(){
        Position p = getCurrentPosition();
        boolean movableEast = maze.isMovable(p.getPosToEast());
        boolean movableSouth = maze.isMovable(p.getPosToSouth());
        boolean movableNorth = maze.isMovable(p.getPosToNorth());

        if (!movableSouth && !movableEast && movableNorth){
            setCurrentPosition(p.getPosToNorth());
            faceingP = 4;
        }
        else  if (movableEast && !movableSouth) {
             setCurrentPosition(p.getPosToEast());
        }
        else if (movableSouth){
            setCurrentPosition(p.getPosToNorth());
            faceingP = 2;
        }
        else {
            setCurrentPosition(p.getPosToWest());
            faceingP = 3;
        }
    }

    /**
     * Make the robot move if it is facing north
     */
    private void facingNorth(){
        Position p = getCurrentPosition();
        boolean movableEast = maze.isMovable(p.getPosToEast());
        boolean movableWest = maze.isMovable(p.getPosToWest());
        boolean movableNorth = maze.isMovable(p.getPosToNorth());

        if (!movableNorth && !movableEast && movableWest){
            setCurrentPosition(p.getPosToWest());
            faceingP = 3;
        }
        else  if (movableNorth && !movableEast) {
            setCurrentPosition(p.getPosToNorth());
        }
        else if (movableEast){
            setCurrentPosition(p.getPosToEast());
            faceingP = 1;
        }
        else {
            setCurrentPosition(p.getPosToSouth());
            faceingP = 2;
        }
    }

    /**
     * Make the robot move if it is facing west
     */
    private void facingWest(){
        Position p = getCurrentPosition();
        boolean movableSouth = maze.isMovable(p.getPosToSouth());
        boolean movableWest = maze.isMovable(p.getPosToWest());
        boolean movableNorth = maze.isMovable(p.getPosToNorth());

        if (!movableNorth && !movableWest && movableSouth){
            setCurrentPosition(p.getPosToSouth());
            faceingP = 2;
        }
        else  if (movableWest && !movableNorth) {
            setCurrentPosition(p.getPosToWest());
        }
        else if (movableNorth){
            setCurrentPosition(p.getPosToNorth());
            faceingP = 4;
        }
        else {
            setCurrentPosition(p.getPosToEast());
            faceingP = 1;
        }


    }

    /**
     * Make the robot move if it is facing south
     */
    private void facingSouth(){
        Position p = getCurrentPosition();
        boolean movableEast = maze.isMovable(p.getPosToEast());
        boolean movableSouth = maze.isMovable(p.getPosToSouth());
        boolean movableWest = maze.isMovable(p.getPosToWest());

        if (!movableWest && !movableSouth && movableEast){
            setCurrentPosition(p.getPosToEast());
            faceingP = 1;
        }
        else  if (movableSouth && !movableWest) {
            setCurrentPosition(p.getPosToSouth());
        }
        else if (movableWest){
            setCurrentPosition(p.getPosToWest());
            faceingP = 3;
        }
        else {
            setCurrentPosition(p.getPosToNorth());
            faceingP = 4;
        }


    }

    private void getFacingPosition(Position start)throws IllegalStateException{

        if (!maze.isMovable(start.getPosToWest())){
            faceingP = 2;
        }
        else if (!maze.isMovable(start.getPosToNorth())){
                faceingP = 3;
            }
        else if (!maze.isMovable(start.getPosToEast())){
                faceingP = 4
        }
        else if (!maze.isMovable(start.getPosToSouth())){
                 faceingP = 1
        }
        else{
            throw new IllegalStateException("Invalid maze!");
        }

        //System.out.println("Y: "+ start.getY()+ " " + "X: " + start.getX());
       // System.out.println("FAceY: "+ faceingP.getY()+ " " + "X: " +faceingP.getX());
    }
}
