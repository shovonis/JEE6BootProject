package net.therap.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author rifatul.islam
 * @since 7/1/14.
 */

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "admin")
    private int admin;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "dob")
    private Date dob;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date date) {
        this.dob = date;
    }
}
