import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket; 
import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String args[]) throws IOException {
        System.out.println("Cliente iniciado...");
        Socket socket = new Socket("localhost",5000);

        PrintWriter         out = new PrintWriter(socket.getOutputStream(), true);
        BufferedInputStream  in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        EscutaThread escuta = new EscutaThread(in);
        escuta.star();
        String entrada="";

        while(true){
            entrada = JOptionPane.showInputDialog(null, "Mensagem para o servidor", "Cliente", JOptionPane.INFORMATION_MESSAGE);
            out.println(entrada);
            System.out.println("Cliente: "+ entrada);
        }
     }
 }

