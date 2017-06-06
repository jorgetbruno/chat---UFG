/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author android
 */
public class AtenderCliente implements Runnable{
    private Cliente cli;
    
    public AtenderCliente(Cliente cli) {
        this.cli = cli;
    }

    @Override
    public void run() {
        try {
            Scanner escutador = new Scanner(cli.getInputStream());
            do{
                String mensagem = escutador.nextLine();
                if(cli.nomeVazio()){
                    cli.setNome(mensagem);
                    System.out.println(cli.getNome());
                }
                if(mensagem.charAt(0) == '@')
                    mensagemPrivada(mensagem);
                ServidorChat.distribuirMensagem(mensagem);
            }while(true);
        } catch (IOException |NoSuchElementException ex) {
            ServidorChat.removerCliente(cli);
        }
    }
    
    private void mensagemPrivada(String line){
        String pattern = "(@)([a-z]+)";
        LinkedList<String> receivers = new LinkedList();
        
        Pattern r = Pattern.compile(pattern);
        
        Matcher m = r.matcher(line);
        System.out.println("entrou privado");
        if(m.find( )){
        for(int i = 0; i < m.groupCount(); i++){
            System.out.println(m.groupCount());
            receivers.add(m.group(i).substring(1));
            System.out.println(m.group(i).substring(1));
            }
        }
        line = m.replaceAll("");
        pattern = "PrivateMessageFor:";
        r = Pattern.compile(pattern);
        m = r.matcher(line);
        
        String conteudo = m.replaceAll("");
        
        System.out.println(conteudo);
    }
    
}
