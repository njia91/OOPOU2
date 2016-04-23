/**
 * Created by dv15man
 * This is an abstract class of an Robot.
 * The only method which is abstract is the move() function
 */
public abstract class Robot {

    private Position currentP;
    protected Maze maze;


    /**
     * Constructor for Robot class
     * @param maze - the maze that the robot should search through.
     * @throws IllegalStateException if robot is trapped/boxed in.
     */
    public Robot(Maze maze)throws IllegalStateException{
        this.maze = maze;

    }

    /**
     * Abstract method for moving the robot.
     * The movement pattern depends on the robot.
     * @throws IllegalStateException if the robot gets stuck
     * or unable to find the goal.
     */
    public abstract void move() throws IllegalStateException;

    /**
     * Returns the current position of the robot.
     * @return current position
     */
    public Position getCurrentPosition(){
        return this.currentP;
    }

    /**
     * Allows the user to set the position of the robot.
     * @param p an object of type Position.
     */
    protected void setCurrentPosition(Position p){
        this.currentP = p;

    }

    /**
     * Checks if robot has reached the goal.
     * @return True if robot is at goal.
     */
    public boolean hasReachedGoal(){
        return maze.isGoal(currentP);
    }

    /**
     * Function is used to check if Robot is trapped/boxed in.
     * @return True if trapped
     */
    protected  boolean checkIfTrapped(){
        if( !maze.isMovable(currentP.getPosToSouth()) &&
                !maze.isMovable(currentP.getPosToNorth()) &&
                !maze.isMovable(currentP.getPosToWest()) &&
                !maze.isMovable(currentP.getPosToEast())){
            return true;
        }
        return false;
    }

}
