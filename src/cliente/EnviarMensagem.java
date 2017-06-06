/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author android
 */
public class EnviarMensagem implements Runnable {
    Socket servidor;

    public EnviarMensagem(Socket servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        Scanner leitor = new Scanner(System.in);
        try {
            PrintWriter saidaServidor = new PrintWriter(this.servidor.getOutputStream(), true);
            do{
                String texto = leitor.nextLine();
                saidaServidor.println(texto);
            }while(true);
        } catch (IOException ex) {
            Logger.getLogger(EnviarMensagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
