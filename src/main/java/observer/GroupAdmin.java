package observer;

import org.junit.platform.commons.function.Try;

import java.util.ArrayList;
import java.util.List;

/**
 * The following class serves as the subject or the 'Sender' in the 'Observer' design pattern and implements the appropriate interface.
 */
public class GroupAdmin implements Sender{
    public UndoableStringBuilder data;
    public List<Member> members;

    /**
     * Initializes a new instance of 'GroupAdmin'.
     */
    public GroupAdmin() {
        this.data = new UndoableStringBuilder();
        this.members = new ArrayList<>();
    }

    /**
     * Notifies all related observers of a change in the data.
     */
    private void notifyObservers() {
        for (Member observer: this.members) {
            observer.update(this.data);
        }
    }

    /**
     * Registers a new observer of the admin.
     * @param obj the new observer.
     */
    public void register(Member obj) {
        this.members.add(obj);
        obj.update(this.data);
    }

    /**
     * Removes an existing observer of the admin. If the observer given is unrelated to this admin nothing will happen.
     * @param obj the observer to be removed.
     */
    public void unregister(Member obj) {
        try { // try-finally block to avoid runtime errors in case an unrelated observer is given.
            this.members.remove(obj);
        } finally {}
    }

    /**
     * Calls the 'insert' function of 'UndoableStringBuilder'.
     * @param offset offset in our string.
     * @param obj string to be inserted.
     */
    public void insert(int offset, String obj) {
        this.data.insert(offset, obj);
        notifyObservers();
    }

    /**
     * Calls the 'append' function of 'UndoableStringBuilder'.
     * @param obj string to be appended.
     */
    public void append(String obj) {
        this.data.append(obj);
        notifyObservers();
    }

    /**
     * Calls the 'delete' function of 'UndoableStringBuilder'.
     * @param start index of the first character in the sequence that should be deleted.
     * @param end index of the last character in the sequence that should be deleted.
     */
    public void delete(int start, int end) {
        this.data.delete(start, end);
        notifyObservers();
    }

    /**
     * Calls the 'undo' function of 'UndoableStringBuilder'.
     */
    public void undo() {
        this.data.undo();
        notifyObservers();
    }
}
