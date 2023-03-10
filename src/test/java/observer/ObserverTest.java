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

    @Test
    void memory_member() {
        GroupAdmin admin = new GroupAdmin();

        ConcreteMember member = new ConcreteMember();
        admin.register(member);

        System.out.print("ADMIN\n" + JvmUtilities.objectFootprint(admin));
        System.out.print("MEMBER\n" + JvmUtilities.objectFootprint(member));

        admin.append("test");

        System.out.print("\nAPPENDED\n\n");

        System.out.print("ADMIN\n" + JvmUtilities.objectFootprint(admin));
        System.out.print("MEMBER\n" + JvmUtilities.objectFootprint(member));
    }

    @Test
    void memory_admin() {
        GroupAdmin admin = new GroupAdmin();

        System.out.print("BASE\n" + JvmUtilities.objectFootprint(admin));

        ConcreteMember member1 = new ConcreteMember();
        ConcreteMember member2 = new ConcreteMember();
        ConcreteMember member3 = new ConcreteMember();

        admin.register(member1);
        System.out.print("ADDED 1 MEMBER\n" + JvmUtilities.objectFootprint(admin));

        admin.register(member2);
        System.out.print("ADDED 2 MEMBERS\n" + JvmUtilities.objectFootprint(admin));

        admin.register(member3);
        System.out.print("ADDED 3 MEMBERS\n" + JvmUtilities.objectFootprint(admin));
    }
}