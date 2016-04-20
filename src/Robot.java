/**
 * Created by dv15man on 2016-04-20.
 */
public abstract class Robot {

    private Position currentP;
    protected Maze maze;
    protected Position faceingP;

    public Robot(Maze maze){
        this.maze = maze;
    }

    /**
     * Abstract class for moving the robot.
     */
    public abstract void move();

    /**
     * Returns the current position of the robot.
     * @return
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
}
