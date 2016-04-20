/**
 * Created by dv15man on 2016-04-18.
 */
public class Position {

    private int y;
    private int x;


    /**
     * Constructor that sets the X and Y position
     * @param x position
     * @param y position
     */
    public Position(int y, int x){

        this.y = y;
        this.x = x;
    }

    /**
     * Getter that returns X position
     * @return X position
     */
    public int getX(){
        return this.x;
    }

    /**
     * Getter that returns Y position
     * @return Y position
     */
    public int getY(){
        return this.y;
    }

    /**
     * Method that returns the position to the south of current position.
     * @return Position
     */
    public Position getPosToSouth(){
        return new Position(this.y+1, this.x);
    }

    /**
     * Method that returns the position to the north of current position.
     * @return Position
     */
    public Position getPosToNorth(){
        return new Position(this.y-1, this.x);
    }

    /**
     * Method that returns the position to the west of current position.
     * @return Position
     */
    public Position getPosToWest(){
        return new Position(this.y, this.x-1);
    }
    /**
     * Method that returns the position to the east of current position.
     * @return Position
     */
    public Position getPosToEast(){
        return new Position(this.y, this.x+1);
    }


    /**
     *Method that can be used to compare two objects
     * @param o Object that will be compared with.
     * @return True if they have same values.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (y != position.y) return false;
        return x == position.x;

    }

    /**
     * Creates a hashcode for the object
     * @return the hashcode.
     */
    @Override
    public int hashCode() {
        int result = y;
        result = 31 * result + x;
        return result;
    }
}
