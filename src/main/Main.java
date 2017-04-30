package main;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args){
        try {
            Socket soc = new Socket("127.0.0.1", 2345);
            System.out.println("Le port : " + 2345 + "est ouvert");

            String request = "test";

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(soc.getOutputStream());
            bufferedOutputStream.write(request.getBytes());
            bufferedOutputStream.flush();

        }

        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
