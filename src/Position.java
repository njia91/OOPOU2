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

    public Position getPosToSouth(){
        return new Position(this.y-1, this.x);
    }

    public Position getPosToNorth(){
        return new Position(this.y+1, this.x);
    }

    public Position getPosToWest(){
        return new Position(this.y, this.x-1);
    }

    public Position getPosToEast(){
        return new Position(this.y, this.x+1);
    }


    /**
     *
     * @param o
     * @return
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
     * @return
     */
    @Override
    public int hashCode() {
        int result = y;
        result = 31 * result + x;
        return result;
    }
}
