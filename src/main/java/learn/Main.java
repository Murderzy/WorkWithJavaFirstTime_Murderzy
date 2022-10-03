package learn;

import com.google.inject.Guice;
import com.google.inject.Injector;
import learn.OOP.Library;
import learn.anno.AnnotationsDemo;
import learn.files.FilesDemo;

public class Main {
    public static void main(String[] args)
    {
        //new App().run();
        Injector injector = Guice.createInjector();
        App app = injector.getInstance(App.class);
        app.run();
    }
}