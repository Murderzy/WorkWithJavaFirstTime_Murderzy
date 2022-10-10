package learn;

import com.google.inject.Inject;
import learn.anno.AnnotationsDemo;
import learn.services.DateService;
import learn.services.RandomProvider;
import learn.services.StringService;
import learn.services.TimeService;
import learn.services.connectionString.ConnectionStringService;
import learn.services.hash.HashService;
import learn.thread.Inflation;
import learn.thread.ThreadDemo;

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

//    @Inject
//    public App(@Named("max") RandomProvider randomProvider)
//    {
//        this.randomProvider = randomProvider;
//    }

    @Inject
    private DateService dateService;

    @Inject
    private TimeService timeService;

    public  void run() {
//        System.out.println("IoC Demo");
//        System.out.println("StringService : " + stringService.getString());
//        System.out.println("RandomProvider : " + randomProvider.getN());
//        System.out.println("HashService(128) : " + hash128.hash("hello"));
//        System.out.println("HashService(160) : " + hash160.hash("hello"));
//        System.out.println("Connection SQL : " + sql.connectionString());
//        System.out.println("Connection oracle : " + oracle.connectionString());
        // new AnnotationsDemo().run();
        // new FilesNavigator().run();
        //new ThreadDemo().run();
        new Inflation().run();
        //System.out.println(dateService.getDate());
       //System.out.println(timeService.getTime());
    }
}
