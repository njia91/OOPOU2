import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by dv15man
 */
public class PositionTest {

    /**
     * Test that a Position object can be created
     * @throws Exception
     */
    @Test
    public void testPositionConstructor() throws Exception{
        Position p = new Position(5,6);
    }

    /**
     * Test that Position sets correct X value
     * @throws Exception
     */
    @Test
    public void shouldGetCorrectX() throws Exception{
        Position p = new Position(5,6);
        assertEquals(6, p.getY());
    }

    /**
     * Test that Position sets correct X value
     * @throws Exception
     */
    @Test
    public void shouldNotGetCorrectX() throws Exception{
        Position p = new Position(5,6);
        assertNotEquals(5, p.getY());
    }

    /**
     * Test that Position sets correct Y value
     * @throws Exception
     */
    @Test
    public void shouldGetCorrectY() throws Exception{
        Position p = new Position(6,5);
        assertEquals(6, p.getX());
    }

    /**
     * Test that Position sets correct Y value
     * @throws Exception
     */
    @Test
    public void shouldNotGetCorrectY() throws Exception{
        Position p = new Position(5,6);
        assertNotEquals(6, p.getX());
    }

    /**
     * Tests if two position are equal.
     * @throws Exception
     */
    @Test
    public void twoPositionsEqual() throws Exception {
        Position p1 = new Position(10,10);
        Position p2 = new Position(10,10);
        assertEquals(true, p1.equals(p2));
    }

    /**
     * Test that equal function does not return true when it should not.
     * @throws Exception
     */
    @Test
    public void  twoPositionsNotEqual() throws Exception {
        Position p1 = new Position(10,10);
        Position p2 = new Position(10,11);
        assertNotEquals(true, p1.equals(p2));
    }

    /**
     * Test if Position moves one step to east
     * @throws Exception
     */
    @Test
    public void  shouldIncrementXValue() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        p2 = p1.getPosToEast();

        assertEquals(11,p2.getX());
    }

    /**
     * Test if Position moves one step to North
     * @throws Exception
     */
    @Test
    public void  shouldIncrementYValue() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        p2 = p1.getPosToNorth();

        assertEquals(9,p2.getY());
    }

    /**
     * Test if Position moves one step to South
     * @throws Exception
     */
    @Test
    public void  shouldDecrementYValue() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        p2 = p1.getPosToSouth();

        assertEquals(11,p2.getY());
    }


    /**
     * Test if Position moves one step to West
     * @throws Exception
     */
    @Test
    public void  shouldDecrementXValue() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        p2 = p1.getPosToWest();

        assertEquals(9,p2.getX());
    }


    /**
     * Test that  getposToEast and Equals work. And don't return invalid.
     * @throws Exception
     */
    @Test
    public void  shouldNotBeSamePosition() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        p2 = p1.getPosToEast();

        assertNotEquals(true, p2.equals(p1));
    }


    /**
     * Test that getposToEast function returns correct Position
     * @throws Exception
     */
    @Test
    public void  shouldBeSamePositionEast() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        Position p3 = new Position(11,10);
        p2 = p1.getPosToEast();
        assertEquals(true, p2.equals(p3));
    }

    /**
     * Test that getposToWest function returns correct Position
     * @throws Exception
     */
    @Test
    public void  shouldBeSamePositionWest() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        Position p3 = new Position(9,10);
        p2 = p1.getPosToWest();
        assertEquals(true, p2.equals(p3));
    }

    /**
     * Test that getposToSouth function returns correct Position
     * @throws Exception
     */
    @Test
    public void  shouldBeSamePositionSouth() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        Position p3 = new Position(10,11);
        p2 = p1.getPosToSouth();
        assertEquals(true, p2.equals(p3));
    }

    /**
     * Test that getposToNorth function returns correct Position
     * @throws Exception
     */
    @Test
    public void  shouldBeSamePositionNorth() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        Position p3 = new Position(10,9);
        p2 = p1.getPosToNorth();
        assertEquals(true, p2.equals(p3));
    }









}
