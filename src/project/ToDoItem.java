
package project;

import java.sql.Date;

public class ToDoItem {
    String name;
    String desc;
    Date date;
    Boolean status;
    Integer id;

    public ToDoItem(String name, String desc, Date date, Boolean status,Integer id) {
        this.name = name;
        this.desc = desc;
        this.date = date;
        this.status = status;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    
    
}
