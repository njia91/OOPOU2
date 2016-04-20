import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dv15man on 2016-04-18.
 */
public class MazeTest {
    /**
     * Tests if Maze can read a correct maze from file.
     * @throws Exception
     */
    @Test
    public void shouldReadCorrectMaze() throws Exception{
           File file = new File("mazetest");
           FileReader stream = new FileReader(file);
           Maze maze = new Maze(stream);

    }

    /**
     * Tests that Maze throws an exception if no start position in maze.
     * @throws Exception
     */
    @Test (expected = IOException.class)
    public void shouldReadInvalidMazeNoStart() throws Exception{

            File file = new File("mazetest2");
            FileReader stream = new FileReader(file);
            Maze maze = new Maze(stream);
    }

    /**
     * Tests that Maze throws an exception if no goal in maze.
     * @throws Exception
     */
    @Test (expected = IOException.class)
    public void shouldReadInvalidMazeNoGoal() throws Exception{

        File file = new File("mazetest5");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
    }

    /**
     * Tests that Maze throws an exception if multiple start position maze.
     * @throws Exception
     */
    @Test (expected = IOException.class)
    public void shouldReadInvalidMazeMultipleStart() throws Exception{

        File file = new File("mazetest3");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
    }

    /**
     * Tests that Maze throws an exception if multiple start position maze.
     * @throws Exception
     */
    @Test
    public void shouldReadCorrectMazeMultipleGoals() throws Exception{
        File file = new File("mazetest4");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);

    }

    /**
     * Test if blank space is movable
     * @throws Exception
     */
    @Test
    public void shouldReturnMovablePosition() throws Exception{
        File file = new File("movableTest");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
        Position p = new Position(0,0);

        assertEquals(true, maze.IsMovable(p));
    }

    /**
     * Test that IsMovable returns false on * (Sign for a Wall).
     * @throws Exception
     */
    @Test
    public void shouldNotReturnMovablePosition() throws Exception{
        File file = new File("movableTest");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
        Position p = new Position(1,0);

        assertEquals(false, maze.IsMovable(p));
    }

    /**
     * Test that isMovable return false when array index is out of bounds.
     * @throws Exception
     */
    @Test
    public void shouldGoOutOfBound() throws Exception{
        File file = new File("movableTest");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
        Position p = new Position(0,1);

        assertEquals(false, maze.IsMovable(p));
    }

    /**
     * isMovable should return true for a start position(S).
     * @throws Exception
     */
    @Test
    public void shouldReturnMovableStartPosition() throws Exception{
        File file = new File("movableTest");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
        Position p = new Position(2,0);

        assertEquals(true, maze.IsMovable(p));
    }

    /**
     * isMovable should return true for a Goal position(G).
     * @throws Exception
     */
    @Test
    public void shouldReturnMovableGoalPosition() throws Exception{
        File file = new File("movableTest");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
        Position p = new Position(3,0);

        assertEquals(true, maze.IsMovable(p));
    }

    /**
     * isGoal should return true for  Goal position(G).
     * @throws Exception
     */
    @Test
    public void shouldReturnTrueForGoalPosition() throws Exception{
        File file = new File("movableTest");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
        Position p = new Position(3,0);

        assertEquals(true, maze.isGoal(p));
    }

    /**
     * isGoal should return false for invalid Goal position(G).
     * @throws Exception
     */
    @Test
    public void shouldReturnFalseForInvalidGoalPosition() throws Exception{
        File file = new File("movableTest");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
        Position p = new Position(2,0);

        assertEquals(false, maze.isGoal(p));
    }

    /**
     * isGoal should return false for invalid index.
     * @throws Exception
     */
    @Test
    public void shouldReturnFalseForInvalidIndex() throws Exception{
        File file = new File("movableTest");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
        Position p = new Position(6,0);

        assertEquals(false, maze.isGoal(p));
    }


    /**
     * Controlls that getStartPosition returns correct position.
     * @throws Exception
     */
    @Test
    public void shouldReturnCorrectStartPosition() throws Exception{
        File file = new File("movableTest");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
        Position p = new Position(2,0);
        Position p1 = maze.getStartPosition();

        assertEquals(true, p1.equals(p));
    }


    /**
     * Controlls that getStartPosition return invalid.
     * @throws Exception
     */
    @Test
    public void shouldReturnInvalidStartPosition() throws Exception{
        File file = new File("movableTest");
        FileReader stream = new FileReader(file);
        Maze maze = new Maze(stream);
        Position p = new Position(1,6);
        Position p1 = maze.getStartPosition();

        assertEquals(false, p1.equals(p));
    }







}
