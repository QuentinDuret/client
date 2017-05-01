package main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Quentin on 01/05/2017.
 */
public class ConnectionServer {

    private PrintWriter writer = null;
    private BufferedInputStream reader = null;
    private Socket soc = null;
    private String request;

    public ConnectionServer(String host, int port,String request){
        this.request = request;
        try {
            this.soc = new Socket(host, port);
            System.out.println("Le port : " + port + " est ouvert");

        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connection(){
        try {


            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(soc.getOutputStream());
            bufferedOutputStream.write(request.getBytes());
            bufferedOutputStream.flush();

            reader = new BufferedInputStream(soc.getInputStream());
            String response = read();
            Parser parser = new Parser(response);
            parser.read();
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String read() throws IOException{
        String response;
        int stream;
        byte[] b = new byte[1000];
        stream = reader.read(b);
        response = new String(b, 0, stream);
        return response;
    }
}


