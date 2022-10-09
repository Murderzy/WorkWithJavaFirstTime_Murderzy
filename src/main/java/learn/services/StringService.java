package learn.services;

import com.google.inject.Inject;

public class StringService {
    @Inject
    private SymbolService charService;  //  нтерфейс, charService - его реализация
     //private CharService charService;

    @Inject
     private RandomProvider randomProvider;

    public String getString()
    {
        return String.format("Hello %c World!!! %d",charService.getChar(), randomProvider.getN());
    }
}
