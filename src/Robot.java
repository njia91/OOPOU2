/**
 * Created by dv15man on 2016-04-20.
 */
public abstract class Robot {

    private Position currentP;
    protected Maze maze;
    // 1 = east, 2 = south, 3 = west, 4 = north
    protected int facingP;

    public Robot(Maze maze){
        this.maze = maze;
    }

    /**
     * Abstract class for moving the robot.
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
     * @throws IllegalStateException
     */
    protected  void checkIfTraped() throws IllegalStateException{
        if( !maze.isMovable(currentP.getPosToSouth()) &&
                !maze.isMovable(currentP.getPosToNorth()) &&
                !maze.isMovable(currentP.getPosToWest()) &&
                !maze.isMovable(currentP.getPosToEast())){
            throw new IllegalStateException();
        }
    }



    }
