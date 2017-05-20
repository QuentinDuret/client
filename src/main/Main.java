package main;


import main.connection.ConnectionServer;
import main.parser.WriteRequest;

import static main.enums.EnumCommands.Close;

public class Main {

    public static void main(String[] args) {

        String host = "10.212.117.245";
        int port = 1234;
        WriteRequest writeRequest = new WriteRequest();

        String request = writeRequest.write();
        while (!request.equals(Close.toString())) {
            ConnectionServer connectionServer = new ConnectionServer(host, port, request);
            connectionServer.connection();
            request = writeRequest.write();

        }
       System.exit(0);

    }
}
