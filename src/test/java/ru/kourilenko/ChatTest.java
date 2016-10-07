package ru.kourilenko;


import org.junit.*;
import ru.kourilenko.entity.User;
import sun.tracing.PrintStreamProviderFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ChatTest {
//    Chat chat = null;
//
//    @Before
//    public void before(){
//        chat = new Chat();
//    }
//
//    @BeforeClass
//    public static void beforeClass(){
//
//    }
//
//    @After
//    public void after(){
//    }
//
//    @Test
//    public void addUserTest(){
//        ByteArrayInputStream in = new ByteArrayInputStream("Вова\nм\n".getBytes());
//        System.setIn(in);
//        Assert.assertNull(chat.getUserByName("Вова"));
//        chat.addUser();
//        User user = chat.getUserByName("Вова");
//        Assert.assertEquals(user.getName(), "Вова");
//        Assert.assertEquals(user.getGender(), "муж");
//    }
//
//    @Test
//    public void printUsersTest() {
//        ByteArrayInputStream in = new ByteArrayInputStream("Вова\nм\n".getBytes());
//        System.setIn(in);
//        chat.addUser();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        PrintStream out = new PrintStream(baos);
//        System.setOut(out);
//        chat.printAllUser();
//        Assert.assertEquals(baos.toString(), "Вова(муж)" + System.getProperty("line.separator"));
//    }
}
