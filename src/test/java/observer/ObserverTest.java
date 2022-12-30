package observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * A Junit test class for the following classes: 'GroupAdmin', 'ConcreteMember'.
 * @version 1.0 29 Dec 2022
 * @author Roy Harel (213055601) and Daniel Kuris (214539397)
 */
class ObserverTest {

    @Test
    void register() {
        GroupAdmin admin = new GroupAdmin();
        int start_state = admin.members.size();

        ConcreteMember member1 = new ConcreteMember();
        admin.register(member1);

        int end_state = admin.members.size();

        assertEquals(start_state + 1, end_state);
    }

    @Test
    void unregister() {
        GroupAdmin admin = new GroupAdmin();
        int start_state = admin.members.size();

        ConcreteMember member1 = new ConcreteMember();
        admin.register(member1);
        admin.unregister(member1);

        int end_state = admin.members.size();

        assertEquals(start_state, end_state);
    }

    @Test
    void append() {
        GroupAdmin admin = new GroupAdmin();

        ConcreteMember member1 = new ConcreteMember();
        admin.register(member1);

        admin.append("test");

        assertEquals(admin.data.toString(), member1.shallow_copy.toString());
        assertEquals(admin.data.toString(), "test");
    }

    @Test
    void insert() {
        GroupAdmin admin = new GroupAdmin();

        ConcreteMember member1 = new ConcreteMember();
        admin.register(member1);

        admin.append("test");
        admin.insert(0, "test");

        assertEquals(admin.data.toString(), member1.shallow_copy.toString());
        assertEquals(admin.data.toString(), "testtest");
    }

    @Test
    void delete() {
        GroupAdmin admin = new GroupAdmin();

        ConcreteMember member1 = new ConcreteMember();
        admin.register(member1);

        admin.append("test");
        admin.delete(0, 3);

        assertEquals(admin.data.toString(), member1.shallow_copy.toString());
        assertEquals(admin.data.toString(), "t");
    }

    @Test
    void undo() {
        GroupAdmin admin = new GroupAdmin();

        ConcreteMember member1 = new ConcreteMember();
        admin.register(member1);

        admin.append("test");
        admin.insert(0, "test");
        admin.undo();

        assertEquals(admin.data.toString(), member1.shallow_copy.toString());
        assertEquals(admin.data.toString(), "test");
    }
}