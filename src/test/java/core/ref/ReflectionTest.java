package core.ref;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.model.Question;
import next.model.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    public void showClass() {
        Class<Question> clazz = Question.class;
        logger.debug(clazz.getName());
    }
    
    @Test
    public void newInstanceWithConstructorArgs() throws Exception {
        Class<User> clazz = User.class;
        logger.debug(clazz.getName());
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        User user = (User) constructors[0].newInstance(new Object[]{"id1", "password1", "name1", "email1"});
        logger.debug(user.getUserId());
        logger.debug(user.getPassword());
        logger.debug(user.getName());
        logger.debug(user.getEmail());
    }
    
    @Test
    public void privateFieldAccess() throws Exception {
        Class<Student> clazz = Student.class;
        logger.debug(clazz.getName());

        Field nameField = clazz.getDeclaredField("name");
        Field ageField = clazz.getDeclaredField("age");

        nameField.setAccessible(true);
        ageField.setAccessible(true);

        Student student = clazz.newInstance();

        nameField.set(student, "Alice");
        ageField.set(student, 20);
        logger.debug(student.getName());
        logger.debug(String.valueOf(student.getAge()));
    }
}
