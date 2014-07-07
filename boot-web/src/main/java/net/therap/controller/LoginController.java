package net.therap.controller;

import net.therap.dao.UserDao;
import net.therap.domain.User;
import net.therap.service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author rifatul.islam
 * @since 7/3/14.
 */

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {

    private User user;

    @EJB
    private UserService userService;

    @PostConstruct
    public void setUp() {
        user = new User();
    }

    public String loginCheck() {
        user = userService.getUser(user.getUserName(), user.getPassword());
        if (user == null) {
            return "login.xhtml?faces-redirect=true";
        }
        return "home.xhtml?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isUserLoggedIn() {
        return user != null;
    }
}
