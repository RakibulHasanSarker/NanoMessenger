import java.io.Serializable;
import java.util.StringTokenizer;

public class Info implements Serializable {
    String msg;
    String receiver;
    Info(String s)
    {
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        receiver = stringTokenizer.nextToken();
        msg = "";
        while (stringTokenizer.hasMoreTokens())
        {
            msg  = msg + stringTokenizer.nextToken() + " ";
        }
    }
    public String toString()
    {
        return msg;
    }
}
