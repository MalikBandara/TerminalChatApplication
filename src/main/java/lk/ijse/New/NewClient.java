package lk.ijse.New;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class NewClient {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost" , 9806);

            System.out.println("input Client Message : ");
            String message = sc.nextLine();

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(message);
            out.flush();

//            ====

            DataInputStream input = new DataInputStream(socket.getInputStream());
            String s = input.readUTF();
            System.out.println(s);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
