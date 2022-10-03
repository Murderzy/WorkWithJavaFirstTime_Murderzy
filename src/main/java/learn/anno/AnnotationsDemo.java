package learn.anno;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class AnnotationsDemo {

    public void annoByType()
    {
        Class<?> type = ClassWithAnno.class;  //  по классу
        Class<?> thisType = this.getClass();  // по объекту
        Class<?> nameType;
        try {
            nameType = Class.forName("learn.anno.ClassWithoutAnno");  //  по названию класса
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            return;
        }
         // запрос аннотации из типа
        MarkerAnnotation marker =type.getAnnotation(MarkerAnnotation.class);
        if(marker != null)
        {
            System.out.printf("Class '%s' has MarkerAnnotation%n", type.getName());
        }
        else {
            System.out.printf("Class '%s' hasn't  MarkerAnnotation%n", type.getName());
        }

         marker =thisType.getAnnotation(MarkerAnnotation.class);
        if(marker != null)
        {
            System.out.printf("Class '%s' has MarkerAnnotation %n", thisType.getName());
        }
        else {
            System.out.printf("Class '%s' hasn't  MarkerAnnotation %n", thisType.getName());
        }

        marker =nameType.getAnnotation(MarkerAnnotation.class);
        if(marker != null)
        {
            System.out.printf("Class '%s' has MarkerAnnotation %n ", nameType.getName());
        }
        else {
            System.out.printf("Class '%s' hasn't  MarkerAnnotation%n", nameType.getName());
        }
    }

    public void annoByMethods()
    {
        Class<?> type = ClassWithAnno.class;  //  по классу
        Class<?> thisType = this.getClass();  // по объекту
        Class<?> nameType;
        try {
            nameType = Class.forName("learn.anno.ClassWithoutAnno");  //  по названию класса
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            return;
        }



        Method[] methods = type.getDeclaredMethods();
        Object obj;
        try {
            obj = type.newInstance();
        } catch (InstantiationException e) {
            System.out.println(e.getMessage());
            return;
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
            return;
        }
        for(Method method : methods)
        {
            if(method.isAnnotationPresent(MethodAnnotation.class))
            {
                MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
                System.out.printf("Method '%s' of class '%s' does have '%s' method annotation %n",
                        method.getName(),type.getName(),methodAnnotation.value());

                //run
                try {
                    if(methodAnnotation.value().contentEquals("Recommended") ){
                        method.setAccessible(true);
                        method.invoke(obj);}

                } catch (IllegalAccessException e) {
                    System.out.println(e.getMessage());
                    return;
                } catch (InvocationTargetException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
            else {
                System.out.printf("Method '%s' of class '%s' has not method annotation %n",
                        method.getName(),type.getName());
            }
        }
    }

    public void annoByField()
    {
        Class<?> type = ClassWithAnno.class;  //  по классу
        Class<?> thisType = this.getClass();  // по объекту
        Class<?> nameType;
        try {
            nameType = Class.forName("learn.anno.ClassWithoutAnno");  //  по названию класса
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            return;
        }


        //аннотации для полей

        Field[] fields = type.getDeclaredFields();
        for(Field field : fields)
        {
            if(field.isAnnotationPresent(FieldAnnotation.class)){
                FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
                System.out.printf("Field '%s' of class '%s' if %s with priority %d %n",
                        field.getName(),type.getName(),fieldAnnotation.value(),fieldAnnotation.priority());
            }
            else {
                System.out.printf("Field '%s' of class '%s' has no annotation %n",
                        field.getName(),type.getName());
            }
        }
    }
    @MethodAnnotation("Entry Point")
    public void run()
    {
        start();
    }

    public void start()
    {
        boolean flag = true;

        while(flag) {
            System.out.printf(" \n1.Info about methods\n" +
                    "2.Info about fields\n" +
                    "3.Info about class anno\n" +
                    "0.Exit");
            System.out.println();

            Scanner kbScanner = new Scanner(System.in);
            String digit = kbScanner.nextLine();

            switch (digit) {
                case "1":
                   annoByType();
                    break;
                case "2":
                    annoByMethods();
                    break;
                case "3":
                   annoByField();
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
}
