import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class ReceiveInfo extends Thread {

    private Socket socket;
    ReceiveInfo(Socket socket)
    {
        this.socket = socket;

    }
    public void run()
    {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            while (true)
            {
                try {

                    System.out.println((String)in.readObject());

                } catch (ClassNotFoundException e) {
                    //e.printStackTrace();
                }
            }


        } catch (IOException e) {
            //e.printStackTrace();
        }

    }

}
