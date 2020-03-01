import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

public class ServeClient extends Thread {


    private ObjectInputStream in;
    private String userName;

    ServeClient(ObjectInputStream in,String userName)
    {
        this.in = in;
        this.userName = userName;
    }

    public void run()
    {
            try {
                while (true) {

                    Info info = (Info)in.readObject();

                    Server.outs.get(info.receiver).writeObject(userName + " : " +info.msg);
                }
            }
            catch (Exception e)
            {
               // e.printStackTrace();
            }

    }

}
