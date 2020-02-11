import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class Server{
    public static final int SERVER_SOCKET = 8989;

    public static void main(String[] args) {

        try{

            SSLServerSocketFactory serverSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(SERVER_SOCKET);
            


            System.out.println("Server is awaiting a connection");
            while(true){
                Socket clientSocket = serverSocket.accept();
                ServerConnection serverConnection = new ServerConnection(clientSocket);
            }
        } catch(IOException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
        

        
    }
}

class ServerConnection extends Thread{
    Socket clientSocket;
    DataInputStream in;
    DataOutputStream out;

    public ServerConnection(Socket clientSocket){
        try{
            this.clientSocket = clientSocket;
            in = new DataInputStream(this.clientSocket.getInputStream());
            out = new DataOutputStream(this.clientSocket.getOutputStream());
            this.start();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        System.out.println("CONNECTION ACTIVATED");
    }
}