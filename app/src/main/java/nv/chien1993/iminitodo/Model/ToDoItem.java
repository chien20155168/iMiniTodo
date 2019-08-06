package nv.chien1993.iminitodo.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class ToDoItem implements Serializable {

    private String mTodo_title;
    private String mTodo_des ;
    private Date mTodo_date ;
    private Boolean hasRemind = false;
    private int color ;
    private UUID mToDoIdentifer ;

    public ToDoItem(String mTodo_title, String mTodo_des, Date mTodo_date, Boolean hasRemind) {
        this.mTodo_title = mTodo_title;
        this.mTodo_des = mTodo_des;
        this.mTodo_date = mTodo_date;
        this.hasRemind = hasRemind;

    }


    public String getmTodo_title() {
        return mTodo_title;
    }

    public void setmTodo_title(String mTodo_title) {
        this.mTodo_title = mTodo_title;
    }

    public String getmTodo_des() {
        return mTodo_des;
    }

    public void setmTodo_des(String mTodo_des) {
        this.mTodo_des = mTodo_des;
    }

    public Date getmTodo_date() {
        return mTodo_date;
    }

    public void setmTodo_date(Date mTodo_date) {
        this.mTodo_date = mTodo_date;
    }

    public Boolean getHasRemind() {
        return hasRemind;
    }

    public void setHasRemind(Boolean hasRemind) {
        this.hasRemind = hasRemind;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public UUID getmToDoIdentifer() {
        return mToDoIdentifer;
    }

    public void setmToDoIdentifer(UUID mToDoIdentifer) {
        this.mToDoIdentifer = mToDoIdentifer;
    }
}
