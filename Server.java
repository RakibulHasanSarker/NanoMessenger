import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public  class Server {

    public static HashMap<String ,ObjectOutputStream> outs = new HashMap<>();

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(6666);

        while (true)
        {
            Socket socket = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            String userName = null;
            try {
                userName = (String)in.readObject();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }

            outs.put(userName,out);

            ServeClient serveClient = new ServeClient(in,userName);
            serveClient.start();
        }

    }
}
