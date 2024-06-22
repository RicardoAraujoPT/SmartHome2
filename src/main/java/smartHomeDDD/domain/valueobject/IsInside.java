package smartHomeDDD.domain.valueobject;

/**
 * This class represents a value object that indicates whether a room is inside the house.
 */
public class IsInside {

    /**
     * boolean value that indicates whether the room is inside the house.
     */
    private final boolean isInside;

    /**
     * Constructor of the IsInside class.
     * @param isInside boolea   n value that indicates whether the room is inside the house.
     */
    public IsInside(boolean isInside) {
        this.isInside = isInside;
    }

    /**
     * Method to get the boolean value that indicates whether the room is inside the house.
     * @return The boolean value that indicates whether the room is inside the house.
     */
    public boolean getIsInside() {
        return isInside;
    }
}
