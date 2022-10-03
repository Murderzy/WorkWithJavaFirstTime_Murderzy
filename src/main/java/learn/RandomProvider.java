package learn;

import java.util.Random;
import javax.inject.Singleton;
@Singleton
public class RandomProvider {
    public int getN() {
        return n;
    }

    private final int n = new Random().nextInt();
}
