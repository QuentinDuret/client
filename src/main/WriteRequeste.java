package main;

import java.util.Scanner;

import static main.EnumCommands.ListIdea;
import static main.EnumCommands.PostIdea;

/**
 * Created by Quentin on 02/05/2017.
 */
public class WriteRequeste {

    final static String[] elements  = {"Command: ","Titre: ","Description: ","Mail: ","Nom: ","Tecnologies: "};

    public String write(){
        String response="";
        Scanner sc = new Scanner(System.in);
        System.out.println(elements[0]);
        String str = sc.nextLine();
        response += str+"$";
        if (str.equals(PostIdea.toString())){
            for(int i=1; i<elements.length;i++){
                System.out.println(elements[i]);
                str = sc.nextLine();
                response += str+"$";
            }
        }

        return response;
    }

}
