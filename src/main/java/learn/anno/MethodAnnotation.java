package learn.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  //  аннотация доступна при запуске
@Target(ElementType.METHOD)  //  аннотация для маркеровки method
public @interface MethodAnnotation {
    String value() default "";  //  аннотация со значением; value - имя по умолчанию;
                                // "" - значение по умолчанию


}
