package learn.OOP;

import java.io.Serializable;

public class Hologram
        extends Literature
        implements Serializable{

    @Override
    public Hologram setTitle(String title) {
        return (Hologram)super.setTitle(title);
    }
}
