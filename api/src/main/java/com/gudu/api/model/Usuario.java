/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gudu.api.model;

/**
 *
 * @author guduc
 */
public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private String mensagem;
    
    public Usuario(){
        
    }
    public Usuario(Integer id, String nome, String email, String msg){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.mensagem = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    
}
