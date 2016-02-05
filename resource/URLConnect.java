import java.net.*;
import java.io.*;

public class URLConnect {
    public static void main(String[] args) throws Exception {
        URL url1 = new URL("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy");
        URLConnection yc = url1.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}
