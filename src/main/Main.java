package main;


import static main.EnumCommands.Close;

public class Main {

    public static void main(String[] args) {

        String host = "127.0.0.1";
        int port = 2345;
        WriteRequeste writeRequeste = new WriteRequeste();

        String requeste = writeRequeste.write();
        while (!requeste.equals(Close.toString()+"$")) {
            ConnectionServer connectionServer = new ConnectionServer(host, port, requeste);
            connectionServer.connection();
            requeste = writeRequeste.write();
        }
       System.exit(0);

    }
}
