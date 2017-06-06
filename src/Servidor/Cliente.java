/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.net.Socket;

/**
 *
 * @author android
 */
public class Cliente extends Socket{
    private String nome;
    private Socket conection;
    
    public Cliente(Socket soc){
        this.conection = soc;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public boolean nomeVazio(){
        return nome == null ||nome.isEmpty();
    }
    public Socket getSocket(){
        return this.conection;
    }
    public String getNome(){
        return nome;
    }
}
