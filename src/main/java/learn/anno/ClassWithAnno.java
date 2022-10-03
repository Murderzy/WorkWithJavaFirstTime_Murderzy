package learn.anno;

import java.util.Random;

@MarkerAnnotation
public class ClassWithAnno {

    @FieldAnnotation(value = "For version1.1", priority = 1)
    public int field1;
    @FieldAnnotation(value = "For version1.2", priority = 2)
    public String field2;

    public String getField2() {
        return field2;
    }

    public int getField1() {
        return field1;
    }

    public int getField3() {
        return field3;
    }

    @FieldAnnotation(value = "For version1.3", priority = 3)
    public int field3 = new Random().nextInt();

    @MethodAnnotation("Deprecated")
    public void method1()
    {
        System.out.println("Work 1 deprecated");
    }

    @MethodAnnotation("Recommended")
    private void method2()
    {
        System.out.println("Work 2 recommended" );
    }
}
