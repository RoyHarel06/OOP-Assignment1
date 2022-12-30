package observer;

/**
 * The following class serves as the observer or the 'Member' in the 'Observer' design pattern and implements the appropriate interface.
 */
public class ConcreteMember implements Member{
    public UndoableStringBuilder shallow_copy;

    /**
     * Initializes a new instance of 'ConcreteMember'.
     */
    public ConcreteMember() {
        this.shallow_copy = null;
    }

    /**
     * Updates this member by doing a shallow copy of the given target.
     * @param usb the target to be copied.
     */
    public void update(UndoableStringBuilder usb) {
        this.shallow_copy = usb;
    }
}
