package learn.services;

import java.util.Random;

public class RandomProviderTen implements RandomProvider{
    public int getN() {
        return n;
    }

    private final int n = new Random().nextInt(10);
}
