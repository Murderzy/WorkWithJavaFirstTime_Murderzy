package learn;

import java.sql.SQLOutput;
import java.util.*;

public class Complex {

    private void arraysDemo()
    {
        int[] arr1 = new int[4];
        int[] arr2 = new int[]{5,4,3,2,1};
        int[] arr3 = {5,4,3,2,1};

        for(int i = 0; i<4; ++i)
        {
            System.out.println(
                    String.format("arr1[%d] = %d",i,
                    arr1[i]));
        }

        System.out.println("_______________________________________");

        int j = 0;
        for(; j<arr2.length; j++)
        {
            System.out.println(arr2[j]);
        }

        System.out.println("________________________________");


        for(int a:arr3)
        {
            System.out.println(a);
        }

        System.out.println("==================");

        int[][] arr4 = {
                {1,2,3},
                {4,5,6,7},
                {8,9}
        };

        int[][] arr5 = new int[3][4];

        for (int i = 0; i < 3; i++) {

            for (int k = 0; k < 4; k++) {
                arr5[i][k] = (int)(Math.random()*100+1);
            }

        }

        for (int i = 0; i < 3; i++) {

            for (int k = 0; k < 4; k++) {
                System.out.print(arr5[i][k] + " ");
            }
            System.out.println();
        }

        System.out.println("____________________");

        for(int[] a: arr4)
        {
            for(int x : a)
            {
                System.out.print(x + " ");
            }
            System.out.println();
        }
     }

    private void collectionsDemo()
    {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(10);
        arr1.add(20);
        arr1.add(30);
        arr1.add(40);
        arr1.add(50);
        System.out.println("=============================");
        for(Integer x:arr1)
        {
            System.out.print(x + " ");
        }

        System.out.println();
        System.out.println("----------------------------");
        arr1.set(1,21);
        arr1.remove(3);
        for(int i = 0; i < arr1.size();i++)
        {
            System.out.printf("i = %d, x = %d %n",i,arr1.get(i));
        }

        System.out.println();
        System.out.println("----------------------------");

        Map<String, String> map = new HashMap<>();//diamond operator
        map.put("Hello","Привет");
        map.put("Bye","Пока");
        map.put("Hi","Здраствуйте");

        for(String key : map.keySet())
        {
            System.out.printf("%s -- %s\n",key,map.get(key));
        }

        System.out.println();
        System.out.println("----------------------------");

        Scanner kbScanner = new Scanner(System.in);
        String str = kbScanner.nextLine();
//        while(System.in.available())
//        {
//            int c = System.in.read();
//        }

        String translate = map.get(str);
        System.out.println(str + " - " + translate);

    }

    private void Dictionary()
    {
        Map<String, String> map = new HashMap<>();//diamond operator
        map.put("Hello","Привіт");
        map.put("Bye","До побачення");
        map.put("How are you?","Як ти?");

        boolean flag = true;


        while(flag) {
            System.out.printf("Англо-украинский словарь \n1.Показать все\n" +
                    "2.Перевод англ. слова\n" +
                    "3.Перевод укр. слова\n" +
                    "4.Добавить слово\n" +
                    "0.Выход");
            System.out.println();

            Scanner kbScanner = new Scanner(System.in);
            String digit = kbScanner.nextLine();

            switch (digit) {
                case "1":
                    for (String key : map.keySet()) {
                        System.out.printf("%s -- %s\n", key, map.get(key));
                    }
                    break;
                case "2":
                    System.out.println("Введите слово на англ: ");
                    String str = kbScanner.nextLine();
                    String translate = map.get(str);
                    System.out.println(str + " - " + translate);
                    break;
                case "3":
                    System.out.println("Введите слово на укр: ");
                    String str3 = kbScanner.nextLine();

                    String[] arr_val = new String[]{};
                    arr_val = map.values().toArray(new String[0]);
                    String[] arr_key = new String[]{};
                    arr_key = map.keySet().toArray(new String[0]);
                    //System.out.println(arr_val[1]);
                    //System.out.println(arr_key[1]);

                    for(int i = 0; i < arr_val.length;i++)
                    {
                        if(arr_val[i].contentEquals(str3))
                        {
                            System.out.println(arr_val[i] + " --- "+ arr_key[i]);
                        }
                    }
                    break;
                case "4":
                    System.out.println("Введите слово на англ: ");
                    String str1 = kbScanner.nextLine();
                    System.out.println("Введите слово на укр: ");
                    String str2 = kbScanner.nextLine();

                    if (str1 != null && str2 != null) {
                        map.put(str1, str2);
                    }

                    System.out.println("Add");
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    public void Run()
    {
        Dictionary();
    }
}
