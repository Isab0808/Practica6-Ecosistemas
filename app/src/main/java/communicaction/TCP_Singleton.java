package communicaction;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCP_Singleton extends Thread {

    private static  TCP_Singleton instance;
    private OnMessageListener observer;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private BufferedWriter writer;
    private BufferedReader reader;
    private  TCP_Singleton(){

    }

    public void SetObserver(OnMessageListener observer){

        this.observer=observer;

    }

    public static TCP_Singleton getInstance(){

        if(instance==null){

            instance= new TCP_Singleton();
            instance.start();
        }
        return  instance;
    }

    public void run(){

        try {
            Log.e("TAG", "probando" );
            socket = new Socket("192.168.100.199",5000);
            Log.e("TAG", "conectado" );
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            reader = new BufferedReader(inputStreamReader);
            writer = new BufferedWriter(outputStreamWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void SendMessage(String message){

        new Thread(
                ()->{
                    try {
                        writer.write(message+"\n");
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();

    }
}
