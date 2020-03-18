import java.net.*;
import java.io.*;

public class GlobalClient
{
   public static void main(String [] args)
   {
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      try
      {
         System.out.println("\nServer : " + serverName+ "\nPort   : " + port+"\n\nConnecting...");
         Socket client = new Socket(serverName, port);
         System.out.println("\nConnection Success\nServer : "+ client.getRemoteSocketAddress());

         BufferedReader in =new BufferedReader(new InputStreamReader(client.getInputStream()));
         BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
         BufferedReader kin=new BufferedReader(new InputStreamReader(System.in));  
out.write("hsi");
         out.write(kin.readLine());
         System.out.println("Sent");
         System.out.println("Reply from Server :\n " + in.readLine());
         client.close();
      }catch(Exception e)
      {
         e.printStackTrace();
      }
   }
}