package learn.services;

import java.util.Random;
import javax.inject.Singleton;
@Singleton
public class RandomProviderMax implements RandomProvider{
    public int getN() {
        return n;
    }

    private final int n = new Random().nextInt();
}
