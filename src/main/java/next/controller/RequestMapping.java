package next.controller;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    private static Map<String, Controller> controllers = new HashMap<String, Controller>();

    static {
        controllers.put("/", new HomeController());
        controllers.put("/users", new ListUserController());
        controllers.put("/users/login", new LoginController());
        controllers.put("/users/loginForm", new LoginController());
    }

    public static Controller findController(String path) {
        Controller controller = controllers.get(path);
        if (controller == null) controller = controllers.get("/");
        return controller;
    }
}
