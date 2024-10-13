package lk.ijse.New;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class NewServer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServerSocket serverSocket;

        {
            try {
                serverSocket = new ServerSocket(9806);
                System.out.println("Accepted client connection");

                Socket accept = serverSocket.accept();

                DataInputStream input = new DataInputStream(accept.getInputStream());
                String message = input.readUTF();
                System.out.println(message);

                System.out.println("Server Message");
                String s = sc.nextLine();

                DataOutputStream outPut2 = new DataOutputStream(accept.getOutputStream());
                outPut2.writeUTF(s);
                outPut2.flush();


            } catch (IOException e) {
                throw new RuntimeException(e);

            }
        }
    }



}
