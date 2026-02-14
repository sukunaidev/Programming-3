import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

class App{

public static void main(String[] args) {
    
try{
    File studentFile = new File("students.txt");
    Scanner scanner = new Scanner(studentFile);

    PrintWriter pw =new PrintWriter("grades_report.txt");




    int value =0;
    String name = "";
    String[] eachLine = new String[5];
    int i =0;
    String[] sepratedStrings = new String[5];


    while(scanner.hasNextLine())
    {
        eachLine[i] = scanner.nextLine();
        //System.out.println(scanner.nextLine());
        System.out.println(eachLine[i] + "dis be da array");
        i++;
    }


    for (int b= 0; b < eachLine.length; b++)
    {
        sepratedStrings = eachLine[b].split(" ");
       
        for(int c =0; c <=3; c++)
        {
            if(c == 0)
            {
                 name = sepratedStrings[c];
            }
            else if(c > 0 )
            {
                if(sepratedStrings[c].length() <=2)
                {
                    System.out.println("are we");
                    Integer.parseInt(sepratedStrings[c]);
                }
                
                else if( sepratedStrings[c].length()> 2 && sepratedStrings[c] instanceof String)
                {
                    System.out.println("WEHERE");
                    sepratedStrings[c] = "0";
                }


                if(c == 3)
                {
                      System.out.println("WE MADE IT HERE:" + sepratedStrings[1] +"" + sepratedStrings[2] + " " +sepratedStrings[3] );
                      value = Integer.parseInt(sepratedStrings[1]) + Integer.parseInt(sepratedStrings[2]) + Integer.parseInt(sepratedStrings[3]);
                      System.out.println(value);
                      value = value/ 3;
                 }
            }
           
            
        }

        pw.println("Name: " + name + " Average: " + value);
    }


scanner.close();
pw.close();

}
catch(IOException e){
e.printStackTrace();

}


}


}