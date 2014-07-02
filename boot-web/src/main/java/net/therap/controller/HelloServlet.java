package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.HelloService;
import net.therap.service.impl.TestBean;

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
    private HelloService helloService;

    @EJB
    private TestBean testBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("hello", helloService.sayHello());
        User user = helloService.testQuery();
        testBean.doTask();
        request.setAttribute("user", user);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
