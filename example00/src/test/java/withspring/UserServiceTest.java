package withspring;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserServiceTest {

    @Test
    public void addNewUserIsPossible() {
        MockRepository userRepository = new MockRepository(new User("Foo Bar"));
        UserService userService = new UserService(userRepository);

        userService.addUser(new User("Hans Wurst"));

        assertTrue(userRepository.getSaveCalled());
    }

    @Test(expected = RuntimeException.class)
    public void addExistingUserIsNotPossible() {
        MockRepository userRepository = new MockRepository(new User("Hans Wurst"));
        UserService userService = new UserService(userRepository);

        userService.addUser(new User("Hans Wurst"));

        assertFalse(userRepository.getSaveCalled());
    }

    private class MockRepository implements UserRepository {
        private List<User> users = new LinkedList<>();
        private boolean saveCalled = false;

        public MockRepository(User mockUsers) {
            users.add(mockUsers);
        }

        @Override
        public List<User> findAll() {
            return users;
        }

        @Override
        public void save(User user) {
            saveCalled = true;
        }

        public boolean getSaveCalled() {
            return saveCalled;
        }
    }
}