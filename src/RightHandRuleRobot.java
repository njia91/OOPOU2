/**
 * Created by dv15man on 2016-04-20.
 */
public class RightHandRuleRobot extends Robot {



    public Robot(Maze maze){
        super(maze);
        super.setCurrentPosition(maze.getStartPosition());
    }

    public void move() throws Exception{
        try {
            getFacingPosition(maze.getStartPosition());
        }
        catch (Exception e) {
            throw new IllegalStateException();
        }

        while(!super.hasReachedGoal()) {

            if (faceingP.equals(getCurrentPosition().getPosToSouth())) {
                facingSouth();
            }
            if (faceingP.equals(getCurrentPosition().getPosToWest())){
                facingWest();
            }
            if (faceingP.equals(getCurrentPosition().getPosToWest())){
                facingWest();
        }
    }

    /**
     * Make the robot move if it is facing north
     */
    private void facingNorth(){
        Position p = getCurrentPosition();
        if (!maze.isMovable(p.getPosToNorth())){
            setCurrentPosition(p.getPosToWest());
        }
        else {
            setCurrentPosition(p.getPosToNorth());
            faceingP = getCurrentPosition().getPosToNorth();
        }
    }

    /**
     * Make the robot move if it is facing west
     */
    private void facingWest(){
        Position p = getCurrentPosition();
        if (!maze.isMovable(p.getPosToNorth())){
            setCurrentPosition(p.getPosToWest());
        }
        else {
            setCurrentPosition(p.getPosToNorth());
            faceingP = getCurrentPosition().getPosToNorth();
        }
    }

    /**
     * Make the robot move if it is facing south
     */
    private void facingSouth(){
        Position p = getCurrentPosition();
        if (!maze.isMovable(p.getPosToWest())){
            setCurrentPosition(p.getPosToSouth());
        }
        else {
            setCurrentPosition(p.getPosToWest());
            faceingP = getCurrentPosition().getPosToWest();
        }
    }

    private void getFacingPosition(Position start)throws IllegalStateException{

        if (!maze.isMovable(start.getPosToEast())){
            faceingP = start.getPosToNorth();
        }
        else if (!maze.isMovable(start.getPosToNorth())){
                faceingP = start.getPosToWest();
            }
        else if (!maze.isMovable(start.getPosToWest())){
            faceingP = start.getPosToSouth();
        }
        else if (!maze.isMovable(start.getPosToEast())){
            faceingP = start.getPosToNorth();
        }
        else{
            throw new IllegalStateException("Invalid maze!")
        }
    }
}
