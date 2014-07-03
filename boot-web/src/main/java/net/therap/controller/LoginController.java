package net.therap.controller;

import net.therap.dao.UserDao;
import net.therap.domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 * @author rifatul.islam
 * @since 7/3/14.
 */

@ManagedBean(name = "loginController")
public class LoginController {

    private User user;

    @EJB
    private UserDao userDao;

    @PostConstruct
    public void setUp() {
        user = new User();
    }

    public String loginCheck() {
        user = userDao.getUser(user.getUserName(), user.getPassword());
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
}
