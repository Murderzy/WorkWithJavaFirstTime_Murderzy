package learn;

import com.google.inject.Inject;
import learn.anno.AnnotationsDemo;
import learn.files.FilesNavigator;

public class App {

    @Inject
    private StringService stringService;

    @Inject
    private RandomProvider randomProvider;

    public  void run() {
//        System.out.println("IoC Demo");
//        System.out.println("StringService : " + stringService.getString());
//        System.out.println("RandomProvider : " + randomProvider.getN());
//
         new AnnotationsDemo().run();
        // new FilesNavigator().run();
    }
}
