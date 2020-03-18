import java.net.*;
import java.io.*;

public class GlobalServer extends Thread
{
   private ServerSocket serverSocket;
   
   public GlobalServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
   }

   public void run()
   {
      
         try
         {
            System.out.println("Waiting for client on port " +serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            BufferedReader in =new BufferedReader(new InputStreamReader(server.getInputStream()));
            BufferedWriter out =new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));

            System.out.println("\nConnected to "+ server.getRemoteSocketAddress());
            while(true)
            {
             System.out.println("inside first loop"+in.readLine());
            String cstr="";
            while((cstr=in.readLine())!=null)
            {
            System.out.println("inside second loop");
            System.out.println("Client : "+cstr);
            if(cstr=="quit")
            {
            server.close();
            break;
            }
            }
            if(cstr=="quit")
            {break;}
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      
   }

   public static void main(String [] args)
   {
      int port = Integer.parseInt(args[0]);
      try
      {
         Thread t = new GlobalServer(port);
         t.start();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}