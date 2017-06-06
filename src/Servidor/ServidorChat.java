/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author android
 */
public class ServidorChat {
    private static List<Cliente> clientes = new ArrayList();
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(12345);
        
        do{
            Cliente cli = new Cliente( servidor.accept());
            clientes.add(cli);
            new Thread(new AtenderCliente(cli)).start();
        }while(true);
    }
    
    public static void distribuirMensagem(String mensagem) {
        for(Socket c : clientes){
            PrintWriter pw;
            try {
                pw = new PrintWriter(c.getOutputStream(), true);
                pw.println(mensagem);
            } catch (IOException ex) {
                Logger.getLogger(ServidorChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void mensagemPrivada(){
        
    }
    public static void removerCliente(Socket cli){
        clientes.remove(cli);
        try {
            cli.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
