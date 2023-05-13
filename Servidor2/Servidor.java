
import java.net.*;
import java.io.*;

public class Servidor implements Runnable
{
   
    Socket client;
    ServerSocket server;
    ObjectInputStream input;
    boolean activo=false;

    public Servidor()
    {
      
    }
   
    public void abrirConexion()
    {
        try{
            server = new ServerSocket(5555);
            client = server.accept();
            input = new ObjectInputStream(client.getInputStream());
            activo = (boolean)input.readObject();
            input.close();
            client.close();
            server.close();
            System.out.println("Mensaje enviado: "+activo);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void run()
    {
        while(true)
        {
            abrirConexion();
        }
    }
}