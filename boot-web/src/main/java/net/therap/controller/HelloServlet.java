package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.Hello;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rifatul.islam
 * @since 6/30/14.
 */

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @EJB(name = "HelloEJB")
    private Hello helloBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("hello", helloBean.sayHello());
        User user = helloBean.testQuery();
        request.setAttribute("user", user);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
