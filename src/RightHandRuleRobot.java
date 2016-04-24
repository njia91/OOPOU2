import java.util.IllegalFormatCodePointException;

/**
 * Created by dv15man.
 * This class depicts a Robot that follows the wall to its right hand side wall
 * to find its way to the goal.
 */
public class RightHandRuleRobot extends Robot {

    // 1 = east, 2 = south, 3 = west, 4 = north
    private int facingP;

    /**
     * Constructs Righthandrulerobot.
     * @param maze The maze that the robot should walk through.
     * @throws IllegalStateException - if the robot is trapped/boxed in.
     */
    public RightHandRuleRobot(Maze maze) throws IllegalStateException{
        super(maze);

            super.setCurrentPosition(maze.getStartPosition());

            getFacingPosition(getCurrentPosition());

        if (checkIfTrapped()){
            throw new IllegalStateException("Error: Robot is boxed in!");
        }
    }


    /**
     * This method moves the robot. It uses private functions to decide
     * what position the robot should move to.
     * @throws IllegalStateException - in case Robot has no walls around.
     */
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
        // If Robot came back to start position, it is unable to find the goal.
        if (maze.getStartPosition().equals(getCurrentPosition())){
            throw new IllegalStateException("Robot could not find a goal!");
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

    /**
     * Method that which position the robot face in the start.
     * @param start - the start position for the robot.
     */
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
