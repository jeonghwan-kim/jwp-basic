package next.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.db.DataBase;
import next.model.User;

public class LoginController implements Controller {
    private static final long serialVersionUID = 1L;

    private void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forward("/user/login.jsp", req, resp);
    }

    private void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        User user = DataBase.findUserById(userId);
        if (user == null) {
            req.setAttribute("loginFailed", true);
            forward("/user/login.jsp", req, resp);
            return;
        }

        if (user.matchPassword(password)) {
            HttpSession session = req.getSession();
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("loginFailed", true);
            forward("/user/login.jsp", req, resp);
        }
    }

    private void forward(String forwardUrl, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(forwardUrl);
        rd.forward(req, resp);
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println("method: " + method);
        if (method == "POST") doPost(req, resp);
        if (method == "GET") doGet(req, resp);
    }
}
