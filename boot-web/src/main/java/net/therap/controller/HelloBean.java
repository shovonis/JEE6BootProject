package net.therap.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.Date;

/**
 * @author rifatul.islam
 * @since 7/3/14.
 */

@ManagedBean(name = "helloBean")
@RequestScoped
public class HelloBean implements Serializable {
    private String message = "Hello JSF This message is from Bean";


    @ManagedProperty(value = "#{param.pageId}")
    private String pageId;

    private Date date;

    private String text;

    public String getMessage() {
        return message;
    }

    public String sendHomeLink() {
        return "home.xhtml?faces-redirect=true";
    }

    public String showPage() {

        if (pageId == null) {
            return "home";
        } else if (pageId.equals("1")) {
            return "index";
        }
        return "home";
    }


    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getPageId() {
        return pageId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
