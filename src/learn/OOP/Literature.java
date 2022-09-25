package learn.OOP;

import java.io.Serializable;

public abstract class Literature implements Serializable {
    private String title;
    //Alt-Ins

    public String getTitle() {
        return title;
    }

    public Literature setTitle(String title) {
        this.title = title;
        return this;

    }


}
