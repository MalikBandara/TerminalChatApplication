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

            while (true) {
//                System.out.println("Client Start");
                Socket socket = new Socket("localhost", 9806);

                System.out.print("input Message from client : ");
                String message = sc.nextLine();

                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();
                System.out.println("Message sent");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String s = dataInputStream.readUTF();
                System.out.println(s);
                System.out.println("message received ");
                System.out.println("Message from Server : " + s);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
