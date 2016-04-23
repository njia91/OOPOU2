import java.util.EmptyStackException;
import java.util.Hashtable;
import java.util.Stack;

/**
 * Created by dv15man.
 * This memory robot is doing a depth-first search to find the goal in a maze.
 * To do this it uses an stack to remember its previous positions and
 * a hash table to keep track of which positions that have been visited.
 *
 * This is a subclass of the abstract class Robot
 */

public class MemoryRobot extends Robot {

    private Stack<Position> positionStack;
    private Hashtable<String, Integer> wayTracker;


    /**
     * Constructor for MemoryRobot.
     * Initiate the stack and hash table and controlls that the
     * robot is not boxed in.
     * @param maze The maze...
     * @throws IllegalStateException if maze is invalid because
     * the robot is boxed in.
     */
    public MemoryRobot(Maze maze) throws IllegalStateException {
        super(maze);
        positionStack = new Stack<Position>();
        wayTracker = new Hashtable<>();
        super.setCurrentPosition(maze.getStartPosition());
        if (checkIfTrapped()){
            throw new IllegalStateException("Error: Robot is boxed in!");
        }
    }

    /**
     * This method Overrides the method from superclass.
     * Use this function to make the robot move in the maze.
     */
    @Override
    public void move() throws IllegalStateException{

        Position p = getCurrentPosition();



        //Checks what possible ways the robot can go.
        boolean movableEast = maze.isMovable(p.getPosToEast());
        boolean movableSouth = maze.isMovable(p.getPosToSouth());
        boolean movableNorth = maze.isMovable(p.getPosToNorth());
        boolean movableWest = maze.isMovable(p.getPosToWest());

        //If way movable and not visited push position to stack
        // and move robot depending on direction.
        if (movableEast && !isVisited(p.getPosToEast())) {
            positionStack.push(p);
            setCurrentPosition(p.getPosToEast());
        }
        else if (movableSouth && !isVisited(p.getPosToSouth())) {
            positionStack.push(p);
            setCurrentPosition(p.getPosToSouth());
        }
        else if (movableNorth && !isVisited(p.getPosToNorth())) {
            positionStack.push(p);
            setCurrentPosition(p.getPosToNorth());
        }
        else if (movableWest && !isVisited(p.getPosToWest())) {
            positionStack.push(p);
            setCurrentPosition(p.getPosToWest());

        }
        //If not possible directions to move and/or all directions
        //visited. Move back to the position which is on stack.
        else {
            try {
                setCurrentPosition(positionStack.pop());
            } catch (EmptyStackException e) {
                throw new IllegalStateException("Error: Robot could not find the goal");
            }

        }
        //Mark the recent position as visited by adding it to the hash table.
        addPositiontoHashTable(p);

    }

    /**
     * Help function that checks if a position has been visited.
     * @param p - the position to check.
     * @return Returns true if visited, false otherwise.
     */
    private boolean isVisited(Position p) {
        if (wayTracker.containsKey(p.getX() + " " + p.getY())) {
            return true;
        }
        return false;
    }

    /**
     * Help function that adds the current position to the hash table.
     * Converts the positions X and Y values to a string and use it as key.
     * @param p the position to be added.
     */
    private void addPositiontoHashTable(Position p) {

        if (!wayTracker.containsKey(p.getX() + " " + p.getY())) {
            wayTracker.put(p.getX() + " " + p.getY(), 1);
        }
    }

}

