package main;

import main.parser.Parser;
import main.parser.WriteRequest;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by sebde on 20/05/2017.
 */
public class MainRMI {

    public static void main(String args[]){
        String host="localhost";
        int port=1234;

        Registry registry=null;
        String response="";
        boolean isRunning=true;

        try{
            registry= LocateRegistry.getRegistry(host,port);
        }catch (RemoteException e){}

        while(isRunning){
            String command=new WriteRequest().write();

            if(command.split("\\$")[0].equals("LISTIDEA")){
                try {
                    Commands stub = (Commands) registry.lookup("LISTIDEA");
                    response=stub.listIdea();
                }catch (Exception e){}
                new Parser(response).read();
            }

           else if(command.split("\\$")[0].equals("POSTIDEA")){
                try {
                    Commands stub = (Commands) registry.lookup("POSTIDEA");
                    response=stub.postIdea(command);
                }catch (Exception e){}
                new Parser(response).read();
            }
            else if(command.split("\\$")[0].equals("QUIT")){
                isRunning=false;
                System.out.println("Arret du client !");
            }

            else{
                System.out.println("commande non valide !");
            }

        }

    }
}
