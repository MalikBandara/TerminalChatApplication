package lk.ijse;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        try {
            //    remote socket
            Socket socket = new Socket("localhost" , 9806);

            //    request to the server
            System.out.print("Input Message : ");
            String message = sc.nextLine();

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            //send the data
            out.writeUTF(message);
            out.flush();
            // close



            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //Sout
            String message2 = dataInputStream.readUTF();
            System.out.println(message2);
            //close











        }catch (Exception e){
            e.printStackTrace();
        }



    }

}
