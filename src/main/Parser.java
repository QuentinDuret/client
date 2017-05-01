package main;

import static main.EnumCommands.*;

/**
 * Created by Quentin on 01/05/2017.
 */
public class Parser {

    private String response;

    public Parser(String response){
        this.response = response;
    }

    public void read(){
        String[] responseSplit = response.split("\\$");

        if(responseSplit[0].equals(PostIdeaResponse.toString())){
            System.out.println(responseSplit[1]);
        }

        else if(responseSplit[0].equals(ListIdeaResponse.toString())){
            responseSplit = response.split("\\$\\$");
            for (int i=1; i<responseSplit.length;i++){
                String[] ideas = responseSplit[i].split("\\$");
                System.out.println("$");
                for (int j=0; j<ideas.length;j++){
                    System.out.println(ideas[j]);
                }
                System.out.println("$\n\n");
            }
        }

    }

}
