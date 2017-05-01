package main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {

        ConnectionServer connectionServer = new ConnectionServer("127.0.0.1",2345,"LISTIDEA");
        connectionServer.connection();

    }
}
