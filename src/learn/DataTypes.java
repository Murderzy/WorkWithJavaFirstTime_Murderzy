package learn;


import jdk.internal.icu.lang.UCharacter;

public class DataTypes {
    public void Run(){
        System.out.println(ConsoleColors.GREEN_BOLD + "Hello " +
                ConsoleColors.PURPLE +"from DataTypes" + ConsoleColors.RESET);

        String s1 = new String("Hello");
        String s2 = new String("Hello");

        if(s1 == s2) System.out.println("==");
        else System.out.println("!=");

        if(s1.equals(s2))System.out.println("equals");
        else System.out.println("not equals");

        String s3 = "Hello, " + "World!";
        String s4 = "Hello" + ", World!";

        if(s3 == s4) System.out.println("s3 == s4");
        else System.out.println("s3 != s4");

        byte bx =  -100;
        byte by = -0x3C;
        short sx = -3000;
        int ix = 20;
        long lx = 100L;
        float fx = 0.1f;
        float fy = (float)0.1;
        double dx = 1.5e-7;
        char C = 'A';
        boolean b = true;

        System.out.println();

        System.out.println(bx + " "+ "(byte)");
        System.out.println(by + " "+ "(byte)");
        System.out.println(sx + " "+ "(short)");
        System.out.println(ix + " "+ "(int)");
        System.out.println(lx + " "+ "(long)");
        System.out.println(fx + " "+ "(float)");
        System.out.println(fy + " "+ "(float)");
        System.out.println(dx + " "+ "(double)");
        System.out.println(C + " "+ "(char)");
        System.out.println(b + " "+ "(boolean)");
    }


}
