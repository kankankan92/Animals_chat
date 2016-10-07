package ru.kourilenko;

import org.junit.*;
import ru.kourilenko.entity.Female;
import ru.kourilenko.entity.Male;
import ru.kourilenko.entity.User;
import ru.kourilenko.fake_dao.Storage;
import ru.kourilenko.dao.UserDao;

public class UserDaoTest {
    UserDao userDao = new UserDao();

    @Before
    public void before(){
        userDao.deleteUser("Nastia");
        userDao.deleteUser("Vova");
    }

    @Test
    public void findAllTest(){
        Assert.assertEquals(userDao.findAll().size(), 0);
        User user = new Female("Nastia");
        User user1 = new Male("Vova");
        userDao.create(user);
        Assert.assertEquals(userDao.findAll().size(), 1);
        userDao.create(user1);
        Assert.assertEquals(userDao.findAll().size(), 2);
    }

    @Test
    public void createTest() {
        Assert.assertEquals(true, userDao.findAll().isEmpty());
        User user = new Female("Nastia");
        userDao.create(user);
        Assert.assertEquals(userDao.findAll().size(), 1);
        Assert.assertEquals(userDao.findAll().get(0).getName(), "Nastia");
    }

   @Test
    public void checkUserTest() {
        User user = new Female("Nastia");
        userDao.create(user);
        Assert.assertFalse(userDao.checkExistenceUser("Kate"));
        Assert.assertTrue(userDao.checkExistenceUser("Nastia"));
        Assert.assertTrue(userDao.getUserByName("Nastia").getGender().equals("жен"));
    }

    @Test
    public void getUserByNameTest() {
        User user = new Female("Nastia");
        userDao.create(user);
        Assert.assertNull(userDao.getUserByName("Kate"));
        Assert.assertNotNull(userDao.getUserByName("Nastia"));
        Assert.assertEquals(userDao.getUserByName("Nastia").getName(), "Nastia");
        Assert.assertEquals(userDao.getUserByName("Nastia").getGender(), "жен");
    }

    @Test
    public void deleteUserTest(){
        User user = new Female("Nastia");
        userDao.create(user);
        Assert.assertNotNull(userDao.getUserByName("Nastia"));
        Assert.assertEquals(userDao.findAll().size(), 1);
        userDao.deleteUser("Nastia");
        Assert.assertNull(userDao.getUserByName("Nastia"));
        Assert.assertTrue(userDao.findAll().isEmpty());
    }
}
