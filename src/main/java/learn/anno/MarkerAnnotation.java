package learn.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  //  аннотация доступна при запуске
@Target(ElementType.TYPE)  //  аннотация для маркеровки классов
public @interface MarkerAnnotation {

}
