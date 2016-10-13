package ru.kourilenko;
import org.junit.*;
import ru.kourilenko.dao.UserDao;
import ru.kourilenko.entity.Female;
import ru.kourilenko.entity.Male;
import ru.kourilenko.entity.Message;
import ru.kourilenko.dao.MessageDao;
import ru.kourilenko.entity.User;
import ru.kourilenko.interfaces.IUserDao;

import java.time.LocalDateTime;

public class MessageDaoTest {
    MessageDao messageDao = new MessageDao();
    static UserDao userDao = new UserDao();

    @BeforeClass
    public static void beforeClass(){
        User user = new Female("Nastia");
        User user1 = new Male("Vova");
        userDao.create(user);
        userDao.create(user1);
    }

    @AfterClass
    public static void afterClass(){
        userDao.deleteUser("Nastia");
        userDao.deleteUser("Vova");
    }

    @Before
    public void before(){
        messageDao.deleteAllMessagesUser("Nastia");
        messageDao.deleteAllMessagesUser("Vova");

    }

    @Test
    public void createTest(){
        Assert.assertEquals(true, messageDao.findAll().isEmpty());
        Message message = new Message("Hi, Vova!", "Nastia", "Vova", LocalDateTime.now());
        messageDao.create(message);
        Assert.assertEquals(messageDao.findAll().size(), 1);
        Assert.assertEquals(messageDao.findAll().get(0).getFrom(), "Nastia");

    }

    @Test
    public void findAllTest(){
        Assert.assertEquals(messageDao.findAll().size(), 0);
        Message message = new Message("Hi, Vova!", "Nastia", "Vova", LocalDateTime.now());
        Message message1 = new Message("Hi, Nastia!", "Vova","Nastia", LocalDateTime.now());
        messageDao.create(message);
        Assert.assertEquals(messageDao.findAll().size(), 1);
        messageDao.create(message1);
        Assert.assertEquals(messageDao.findAll().size(), 2);
    }

    @Test
    public void deleteUserTest(){
        Message message = new Message("Hi, Nastia!", "Vova","Nastia", LocalDateTime.now());
        Message message1 = new Message("How are you&", "Vova","Nastia", LocalDateTime.now());
        messageDao.create(message);
        messageDao.create(message1);
        Assert.assertNotNull(messageDao.findAll());
        Assert.assertEquals(messageDao.findAll().size(), 2);
        messageDao.deleteAllMessagesUser("Nastia");
        Assert.assertTrue(messageDao.findAll().isEmpty());
    }
}
