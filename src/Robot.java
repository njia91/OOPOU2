/**
 * Created by dv15man on 2016-04-20.
 */
public abstract class Robot {

    private Position p;
    protected Maze maze;

    public Robot(Maze maze){
        this.maze = maze;
    }

    /**
     * Abstract class for moving the robot.
     */
    public abstract void move();


    public Position getCurrentPosition(){
        return this.p;
    }

    /**
     * Allows the user to set the position of the robot.
     * @param p an object of type Position.
     */
    protected void setCurrentPosition(Position p){
        this.p = p;
    }

    /**
     * Checks if robot has reached the goal.
     * @return True if robot is at goal.
     */
    public boolean hasReachedGoal(){
        return maze.isGoal(p);
    }
}
