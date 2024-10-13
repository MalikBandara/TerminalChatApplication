package lk.ijse.New;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class NewServer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        try {
            System.out.println("waiting for the Client ");
            ServerSocket serverSocket = new ServerSocket(9806);
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String s = dataInputStream.readUTF();
            System.out.println("Message from Client : " + s);


            System.out.print("Message from Server : ");
            String s1 = sc.nextLine();
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(s1);
            dataOutputStream.flush();
            System.out.println("Message send  from server Successfully");



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}
