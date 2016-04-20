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

    public void move() throws Exception{
        try {

            checkIfTraped();
            getFacingPosition(getCurrentPosition());

        }
        catch (Exception e) {
            throw new IllegalStateException();
        }
        //System.out.println(getCurrentPosition().getY() + " " + getCurrentPosition().getX());

            if (faceingP.equals(getCurrentPosition().getPosToSouth())) {
                facingSouth();
                System.out.println("Hej");
            }
            else if (faceingP.equals(getCurrentPosition().getPosToWest())){
                facingWest();
                System.out.println("Hej2");
            }
            else if (faceingP.equals(getCurrentPosition().getPosToNorth())){
                facingNorth();
                System.out.println("Hej3");
             }
            else if(faceingP.equals(getCurrentPosition().getPosToEast())){
                facingEast();
                System.out.println("Hej4");
            }


    }


    /**
     * Make the robot move if it is facing east
     */
    private void facingEast(){
        Position p = getCurrentPosition();
        if (!maze.isMovable(p.getPosToSouth()) &&
                maze.isMovable(p.getPosToEast())){
            setCurrentPosition(p.getPosToEast());
            faceingP = getCurrentPosition().getPosToEast();
        }
        else if (!maze.isMovable(p.getPosToSouth()) &&
                !maze.isMovable(p.getPosToEast())){
            faceingP = getCurrentPosition().getPosToNorth();
        }
        else {
            faceingP = getCurrentPosition().getPosToSouth();
        }
    }

    /**
     * Make the robot move if it is facing north
     */
    private void facingNorth(){
        Position p = getCurrentPosition();
        if (!maze.isMovable(p.getPosToEast()) &&
                maze.isMovable(p.getPosToNorth())){
            setCurrentPosition(p.getPosToNorth());
            faceingP = getCurrentPosition().getPosToNorth();
        }
        else if (!maze.isMovable(p.getPosToEast()) &&
                !maze.isMovable(p.getPosToNorth())){
            faceingP = getCurrentPosition().getPosToWest();
        }
        else {
            faceingP = getCurrentPosition().getPosToEast();
        }
    }

    /**
     * Make the robot move if it is facing west
     */
    private void facingWest(){
        Position p = getCurrentPosition();
        if (!maze.isMovable(p.getPosToNorth()) &&
                maze.isMovable(p.getPosToWest())){
            setCurrentPosition(p.getPosToWest());
            faceingP = getCurrentPosition().getPosToWest();
        }
        else if (!maze.isMovable(p.getPosToNorth()) &&
                !maze.isMovable(p.getPosToWest())){
            faceingP = getCurrentPosition().getPosToSouth();
        }
        else {
            faceingP = getCurrentPosition().getPosToNorth();
        }
    }

    /**
     * Make the robot move if it is facing south
     */
    private void facingSouth(){
        Position p = getCurrentPosition();
        if (!maze.isMovable(p.getPosToWest()) &&
                maze.isMovable(p.getPosToSouth())){
            setCurrentPosition(p.getPosToSouth());
            faceingP = getCurrentPosition().getPosToSouth();
        }
        else if(!maze.isMovable(p.getPosToWest()) &&
                !maze.isMovable(p.getPosToSouth())){
            faceingP = getCurrentPosition().getPosToEast();
        }
        else {
            setCurrentPosition(p.getPosToWest());
            faceingP = getCurrentPosition().getPosToWest();
        }
    }

    private void getFacingPosition(Position start)throws IllegalStateException{

        if (!maze.isMovable(start.getPosToWest())){
            faceingP = start.getPosToSouth();
            //System.out.println("SOUTH");

        }
        else if (!maze.isMovable(start.getPosToNorth())){
                faceingP = start.getPosToWest();
            }
        else if (!maze.isMovable(start.getPosToEast())){
                faceingP = start.getPosToNorth();
        }
        else if (!maze.isMovable(start.getPosToEast())){
                 faceingP = start.getPosToNorth();
        }
        else{
            throw new IllegalStateException("Invalid maze!");
        }

        //System.out.println("Y: "+ start.getY()+ " " + "X: " + start.getX());
       // System.out.println("FAceY: "+ faceingP.getY()+ " " + "X: " +faceingP.getX());
    }
}
