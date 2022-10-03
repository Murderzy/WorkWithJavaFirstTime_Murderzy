package learn.anno;

@MarkerAnnotation
public class ClassWithAnno {

    @FieldAnnotation(value = "For version1.1", priority = 1)
    public int field1;
    @FieldAnnotation(value = "For version1.2", priority = 2)
    public String field2;

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
