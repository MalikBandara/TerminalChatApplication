package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args)  {




        Scanner scanner = new Scanner(System.in);

             //server socket
        try {
            ServerSocket serverSocket = new ServerSocket(9806);
            //local socket
            System.out.println("Client connected");
            Socket socket = serverSocket.accept();

            //data reading option
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //Sout
            String message = dataInputStream.readUTF();
            System.out.println(message);
            //close




            System.out.println("input server Message:");
            String s = scanner.nextLine();
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            //send the data
            out.writeUTF(message);
            out.flush();
            // close



        }catch (IOException e){
            e.printStackTrace();
        }





    }
}