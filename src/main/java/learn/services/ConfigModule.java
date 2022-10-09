package learn.services;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import learn.services.connectionString.ConnectionStringService;
import learn.services.connectionString.OracleConnection;
import learn.services.connectionString.SqlConnection;
import learn.services.hash.HashService;
import learn.services.hash.MD5HashService;
import learn.services.hash.Sha1HashService;

public class ConfigModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(SymbolService.class).to(CharService.class);
        bind(HashService.class).
                annotatedWith(Names.named("128"))
                .to(MD5HashService.class);
        bind(HashService.class).
                annotatedWith(Names.named("160"))
                .to(Sha1HashService.class);
        bind(ConnectionStringService.class).
                annotatedWith(Names.named("SQL"))
                .to(SqlConnection.class);

        bind(ConnectionStringService.class).
                annotatedWith(Names.named("oracle"))
                .to(OracleConnection.class);


        bind(DateService.class).to(DateModule.class);
        bind(TimeService.class).to(TimeModule.class);
    }
    //private RandomProvider r10;
    //@Provides//  альтернатива bind - методы-провайдеры
    //@Named("max")
   // RandomProvider getRandomProvider()  //  +  можно вызвать конструктор с параметрами
                                        //  - Синглетон нужно реализовать самим
    //{
//        if(r10 == null ||
//        RandomProvider.class.isAnnotationPresent())
   // }  //  связывание по типу возврата(RandomProvider)
       // - где понадобится внедрение RandomProvider, там будет запущен данный метод
}
