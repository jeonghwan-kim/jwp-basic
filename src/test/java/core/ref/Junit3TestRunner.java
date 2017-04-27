package core.ref;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class Junit3TestRunner {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    public void run() throws Exception {
        Class<Junit3Test> clazz = Junit3Test.class;
        Junit3Test junit3Test = clazz.newInstance();

        for (Method method : clazz.getDeclaredMethods()) {
            String name = method.getName();
            if (name.startsWith("test")) {
                method.invoke(junit3Test);
            }
        }
    }
}
