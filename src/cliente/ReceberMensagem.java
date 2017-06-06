/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author android
 */
public class ReceberMensagem implements Runnable {
    
    Socket servidor;
    
    public ReceberMensagem(Socket servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try {
            Scanner ouvirServidor = new Scanner(servidor.getInputStream());
            do{
                String mensagem = ouvirServidor.nextLine();
                System.out.println(mensagem);
            }while(true);
        } catch (IOException ex) {
            Logger.getLogger(ReceberMensagem.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
}
