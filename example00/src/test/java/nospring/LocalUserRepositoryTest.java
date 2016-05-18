package nospring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LocalUserRepositoryTest {

    private UserRepository userRepository;

    @Before
    public void setup() {
        userRepository = new LocalUserRepository();
    }

    @Test
    public void containsAUserByDefault() {
        Assert.assertEquals(1, userRepository.findAll().size());
        Assert.assertEquals("Foo Bar", userRepository.findAll().get(0).getName());
    }

    @Test
    public void saveAddsAUserToTheEnd() {
        User u = new User("new user");
        userRepository.save(u);

        Assert.assertEquals(2, userRepository.findAll().size());
        Assert.assertSame(u, userRepository.findAll().get(1));
    }
}
