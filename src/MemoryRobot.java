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
        wayTracker = new Hashtable<String, Integer>();
        try {
            super.setCurrentPosition(maze.getStartPosition());
            checkIfTraped();
        } catch (IllegalStateException e) {
            System.err.println("Robot is boxed in!");
        }
    }

    /**
     * This method Overrides the method
     */
    @Override
    public void move() throws IllegalStateException{

        Position p = getCurrentPosition();

        System.out.println("X: " + p.getX() + " Y: " + p.getY());

        boolean movableEast = maze.isMovable(p.getPosToEast());
        boolean movableSouth = maze.isMovable(p.getPosToSouth());
        boolean movableNorth = maze.isMovable(p.getPosToNorth());
        boolean movableWest = maze.isMovable(p.getPosToWest());

        if (movableEast && !isVisited(p.getPosToEast())) {
            positionStack.push(p);
            setCurrentPosition(p.getPosToEast());
        } else if (movableSouth && !isVisited(p.getPosToSouth())) {
            positionStack.push(p);
            setCurrentPosition(p.getPosToSouth());
        } else if (movableNorth && !isVisited(p.getPosToNorth())) {
            positionStack.push(p);
            setCurrentPosition(p.getPosToNorth());
        } else if (movableWest && !isVisited(p.getPosToWest())) {
            positionStack.push(p);
            setCurrentPosition(p.getPosToWest());
        } else {
            try {
                setCurrentPosition(positionStack.pop());
            } catch (EmptyStackException e) {
                throw new IllegalStateException("Error: Robot could not find the goal");
            }

        }
        addPositiontoHashTable(p);


    }

    private boolean isVisited(Position p) {
        if (wayTracker.containsKey(p.getX() + " " + p.getY())) {
            return true;
        }
        return false;
    }


    private void addPositiontoHashTable(Position p) {
        Integer i = 1;
        if (!wayTracker.containsKey(p.getX() + " " + p.getY())) {
            wayTracker.put(p.getX() + " " + p.getY(), i);
        }
    }

}

