import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by dv15man on 2016-04-18.
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
        assertEquals(5, p.getX());
    }

    /**
     * Test that Position sets correct X value
     * @throws Exception
     */
    @Test
    public void shouldNotGetCorrectX() throws Exception{
        Position p = new Position(5,6);
        assertNotEquals(6, p.getX());
    }

    /**
     * Test that Position sets correct Y value
     * @throws Exception
     */
    @Test
    public void shouldGetCorrectY() throws Exception{
        Position p = new Position(5,6);
        assertEquals(6, p.getY());
    }

    /**
     * Test that Position sets correct Y value
     * @throws Exception
     */
    @Test
    public void shouldNotGetCorrectY() throws Exception{
        Position p = new Position(5,6);
        assertNotEquals(5, p.getY());
    }


    @Test
    public void twoPositionsEqual() throws Exception {
        Position p1 = new Position(10,10);
        Position p2 = new Position(10,10);
        assertEquals(true, p1.equals(p2));
    }

    @Test
    public void  twoPositionsNotEqual() throws Exception {
        Position p1 = new Position(10,10);
        Position p2 = new Position(10,11);
        assertNotEquals(true, p1.equals(p2));
    }

    @Test
    public void  shouldIncrementXValue() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        p2 = p1.getPosToEast();

        assertEquals(11,p2.getX());
    }

    @Test
    public void  shouldIncrementYValue() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        p2 = p1.getPosToNorth();

        assertEquals(11,p2.getY());
    }

    @Test
    public void  shouldIncrementYValue() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        p2 = p1.getPosToNorth();

        assertEquals(11,p2.getY());
    }




    @Test
    public void  shouldNotBeSamePosition() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        p2 = p1.getPosToEast();

        assertNotEquals(true, p2.equals(p1));
    }




    @Test
    public void  should() throws Exception {
        Position p1 = new Position(10,10);
        Position p2;
        Position p3 = new Position(10,11);
        p2 = p1.getPosToEast();

        assertNotEquals(false, p2.equals(p2));
    }






}
