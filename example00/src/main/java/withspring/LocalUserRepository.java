package withspring;

import java.util.LinkedList;
import java.util.List;

public class LocalUserRepository implements UserRepository {

    private final List<User> users = new LinkedList<>();

    public LocalUserRepository() {
        // simulate some entries in the repository
        users.add(new User("Foo Bar"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

}