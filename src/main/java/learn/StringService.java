package learn;

import com.google.inject.Inject;

public class StringService {
    @Inject
     private CharService charService;

    @Inject
     private RandomProvider randomProvider;

    public String getString()
    {
        return String.format("Hello %c World!!! %d",charService.getChar(), randomProvider.getN());
    }
}
