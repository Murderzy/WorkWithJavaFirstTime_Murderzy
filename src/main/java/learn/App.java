package learn;

import com.google.inject.Inject;
import learn.services.*;

import javax.inject.Named;

public class App {


//    @Inject
//    private StringService stringService;
//
//    //@Inject
//    //private RandomProvider randomProvider;
//
//    @Inject @Named("128")
//    private HashService hash128;
//    @Inject @Named("160")
//    private HashService hash160;
//
//    @Inject @Named("SQL")
//    private ConnectionStringService sql;
//    @Inject @Named("oracle")
//    private ConnectionStringService oracle;


     @Inject @Named("max")
    private final  RandomProvider randomProvider ;

    @Inject @Named("ten")
    private final  RandomProvider randomProvider10 ;


    @Inject
    public App(@Named("max") RandomProvider randomProvider, @Named("ten") RandomProvider randomProvider10,
               @Named("Char")SymbolService charService, @Named("Time") TimeService timeService, @Named("Date")DateService dateService)
    {
        // иньекция через конструктор лучше тем, что позволяет использовать final поля
        this.randomProvider = randomProvider;
        this.randomProvider10 = randomProvider10;

        this.charService = charService;
        this.timeService = timeService;
        this.dateService = dateService;
    }

    @Inject @Named("Char")
    private final SymbolService charService;

    @Inject @Named("Time")
    private final TimeService timeService;
    @Inject @Named("Date")
    private final DateService dateService;




    public void run() {
        //System.out.println( "IoC Demo" ) ;
        //System.out.println( "StringService: " + stringService.getString() ) ;
        System.out.println( "RandomProvider: " + randomProvider.getN() ) ;
        System.out.println( "CharProvider: " + charService.getChar() ) ;
        System.out.println( "TimeProvider: " + timeService.getTime() ) ;
        System.out.println( "DateProvider: " + dateService.getDate() ) ;
        System.out.println( "RandomProvider10: " + randomProvider10.getN() ) ;
        //System.out.println( "HashService (128bit): " + hash128.hash( "Hello" ) ) ;
        //System.out.println( "HashService (160bit): " + hash160.hash( "Hello" ) ) ;
        //System.out.println( "MsConnectionString: " + msConnectionString ) ;
        //System.out.println( "OracleConnectionString: " + oracleConnectionString ) ;
    }
}
