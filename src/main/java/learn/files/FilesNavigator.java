package learn.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FilesNavigator {
    public void list()  //  вывод содержимого директории вначале работы
    {
        File currentDirectory = new File(new File(".").getAbsolutePath());
        try {
            System.out.println(currentDirectory.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        File[] files = currentDirectory.listFiles();

        for (File f: files) {
            System.out.println(f.getName());
        }
    }

    private void cat(String str)
    {
        str = str.replaceFirst("cat ", "");  //  преобразуем строку и достаем имя файла
        //System.out.println(str);
        File file = new File(str);  //  текущая директория

        if(file.isFile())
        {
            String fileContent;
            StringBuilder sb = new StringBuilder();

            try(InputStream reader = new FileInputStream(str))
            {
                int symbol;
                while((symbol = reader.read())!=-1)
                {
                    //fileContent += (char)symbol;

                    sb.append((char)symbol);
                }
                // reader.read();
            }catch(IOException ex)
            {
                System.out.println(ex.getMessage());
                return;
            }
            fileContent = new String(sb.toString().getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
            System.out.println(fileContent);
        }
        else
        {
            System.out.printf("%c isn't a file", str);
            System.out.println();
        }
    }

    private void cd(String str)
    {
        str = str.replaceFirst("cd ", "");  //  преобразуем строку и достаем имя директории
        //System.out.println(str);
        File file = new File(str);  //  текущая директория

        if (file.isDirectory()) {
            System.out.println(file.getName() + " - is existing directory");

            String[] list = file.list();
            if (list != null) {
                for (String itemName : list) {
                    System.out.println(itemName);
                }
            } else {
                System.out.println("List request error");
            }
        }
        else
        {
            System.out.printf("%c isn't a directory", str);
            System.out.println();
        }
    }

    public void start()    //  меню
    {
        list();
        boolean flag = true;

        while (flag == true)
        {


            System.out.println();

            Scanner kbScanner = new Scanner(System.in);
            String str = kbScanner.nextLine();

            if(str.startsWith("cat ")){
                cat(str);

            }
            else if(str.startsWith("cd ")) {
                cd(str);
            }
            else if(str.contentEquals("exit"))
            {
                flag = false;
                System.out.println("Exit");
            }
            else
            {
                System.out.println("Command unknown");
            }
        }


    }

    public void run()
    {
        start();
    }
}
