import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException{

        Scanner scanner = new Scanner(System.in);

        Socket socket = new Socket("localhost",6666);

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(scanner.nextLine());

        ReceiveInfo receiveInfo = new ReceiveInfo(socket);
        receiveInfo.start();



        while(true)
        {
             out.writeObject(new Info(scanner.nextLine()));
        }

    }
}
