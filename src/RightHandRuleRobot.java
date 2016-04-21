import java.util.IllegalFormatCodePointException;

/**
 * Created by dv15man.
 */
public class RightHandRuleRobot extends Robot {



    public RightHandRuleRobot(Maze maze) throws IllegalStateException{
        super(maze);
        try {
            super.setCurrentPosition(maze.getStartPosition());
            checkIfTraped();
            getFacingPosition(getCurrentPosition());
        } catch (IllegalArgumentException e){
            System.err.println("Robot is boxed in!");
        }
    }

    @Override
    public void move()  throws IllegalStateException{

        switch (facingP){

            case 1: facingEast();
                    break;

            case 2: facingSouth();
                    break;

            case 3: facingWest();
                    break;

            case 4: facingNorth();
                    break;

           default:
                    throw new IllegalStateException("Invalid maze: " +
                         "No walls around the robot!");

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
            facingP = 4;
        }
        else  if (movableEast && !movableSouth) {
             setCurrentPosition(p.getPosToEast());
        }
        else if (movableSouth){
            setCurrentPosition(p.getPosToSouth());
            facingP = 2;
        }
        else {
            setCurrentPosition(p.getPosToWest());
            facingP = 3;
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
            facingP = 3;
        }
        else  if (movableNorth && !movableEast) {
            setCurrentPosition(p.getPosToNorth());
        }
        else if (movableEast){
            setCurrentPosition(p.getPosToEast());
            facingP = 1;
        }
        else {
            setCurrentPosition(p.getPosToSouth());
            facingP = 2;
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
            facingP = 2;
        }
        else  if (movableWest && !movableNorth) {
            setCurrentPosition(p.getPosToWest());
        }
        else if (movableNorth){
            setCurrentPosition(p.getPosToNorth());
            facingP = 4;
        }
        else {
            setCurrentPosition(p.getPosToEast());
            facingP = 1;
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
            facingP = 1;
        }
        else  if (movableSouth && !movableWest) {
            setCurrentPosition(p.getPosToSouth());
        }
        else if (movableWest){
            setCurrentPosition(p.getPosToWest());
            facingP = 3;
        }
        else {
            setCurrentPosition(p.getPosToNorth());
            facingP = 4;
        }


    }

    private void getFacingPosition(Position start){

        if (!maze.isMovable(start.getPosToWest())) {
            facingP = 2;
        }
        else if (!maze.isMovable(start.getPosToNorth())) {
            facingP = 3;
        }
        else if (!maze.isMovable(start.getPosToEast())) {
            facingP = 4;
        }
        else if (!maze.isMovable(start.getPosToSouth())) {
            facingP = 1;
        }
        else {
            facingP = 0;
        }
    }

}
