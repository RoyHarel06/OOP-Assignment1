package observer;
import java.util.Stack;

import java.util.*;

/**
 * A rework of StringBuilder that contains undo methods for the following methods: Append, Delete, Insert, Replace and Reverse
 * @version 1.0 13 Nov 2022
 * @author Roy Harel (213055601) and Daniel Kuris (214539397)
 */
public class UndoableStringBuilder {
    /**
     * Contains the string history after changes.
     */
    List<String> value_history;
    /**
     * Our instance of StringBuilder.
     */
    StringBuilder string;

    /**
     * Empty constructor. Initializes 'string' and 'value_history'.
     */
    public UndoableStringBuilder() {
        this.value_history = new ArrayList<>();
        this.string = new StringBuilder();
    }

    /**
     * Appends the specified string to this character seque.
     * @param str string to be appended.
     * @return pointer to this class
     */
    public UndoableStringBuilder append(String str) {
        value_history.add(string.toString());

        string.append(str);

        return this;
    }

    /**
     * Removes the characters in a substring of this sequence. The substring begins at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists. f start is equal to end, no changes are made.
     * @param start index of the first character in the sequence that should be deleted.
     * @param end index of the last character in the sequence that should be deleted.
     * @return null, on faulty input. Otherwise, pointer to this class.
     */
    public UndoableStringBuilder delete(int start, int end) {
        if (start < 0 || end > string.toString().length())
            return null;

        value_history.add(string.toString());

        string.delete(start, end);

        return this;
    }

    /**
     * Inserts the string into this character seque.
     * @param offset offset in our string.
     * @param str string to be inserted.
     * @return null, on faulty input. Otherwise, pointer to this class.
     */
    public UndoableStringBuilder insert(int offset, String str) {
        if (offset < 0 || offset > string.toString().length())
            return null;

        value_history.add(string.toString());

        string.insert(offset, str);

        return this;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in the specified String. The substring begins at the specified start and
     * extends to the character at index end - 1 or to the end of the sequence if no such character exists. First the characters in the substring are removed
     * and then the specified String is inserted at start. (This sequence will be lengthened to accommodate the specified String if necessary).
     * @param start index of the first character in the sequence that should be replaced.
     * @param end index of the last character in the sequence that should be replaced.
     * @param str string to replace the existing one in the given area.
     * @return null, on faulty input. Otherwise, pointer to this class.
     */
    public UndoableStringBuilder replace(int start,int end, String str) {
        if (start < 0 || start > string.toString().length() || end < 0 || end > string.toString().length() || end < start)
            return null;

        value_history.add(string.toString());

        string.replace(start, end, str);

        return this;
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the sequence.
     * @return pointer to this class.
     */
    public UndoableStringBuilder reverse() {
        value_history.add(string.toString());

        string.reverse();

        return this;
    }

    /**
     * Undoes the last operation on 'string'.
     */
    public void undo() {
        if (value_history.size() != 0) {
            string.setLength(0);
            string.append( value_history.get(value_history.size() - 1) );

            value_history.remove(value_history.size() - 1);
        }
    }

    /**
     * return current string.
     */
    public String toString() {
        return string.toString();
    }
}