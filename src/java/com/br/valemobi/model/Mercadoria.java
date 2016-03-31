/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.valemobi.model;

import java.io.Serializable;

/**
 *
 * @author Asu
 */
public class Mercadoria implements Serializable {
    
    private int cod_Mercadoria, cod_TipoMercadoria, cod_Negocio, qtd;
    private String nome_Mercadoria;
    private double preco;

    public Mercadoria(){
        this.cod_Mercadoria = -1;
        this.nome_Mercadoria = null;
        this.preco = 0.0;
        this.cod_Negocio = -1;
        this.cod_TipoMercadoria = -1;        
    }
        
    public Mercadoria(int cod_Mercadoria, int qtd, String nome_Mercadoria, double preco) {
        this.cod_Mercadoria = cod_Mercadoria;
        this.qtd = qtd;
        this.nome_Mercadoria = nome_Mercadoria;
        this.preco = preco;
    }

    public int getCod_Mercadoria() {
        return cod_Mercadoria;
    }

    public void setCod_Mercadoria(int cod_Mercadoria) {
        this.cod_Mercadoria = cod_Mercadoria;
    }

    public int getCod_TipoMercadoria() {
        return cod_TipoMercadoria;
    }

    public void setCod_TipoMercadoria(int cod_TipoMercadoria) {
        this.cod_TipoMercadoria = cod_TipoMercadoria;
    }

    public int getCod_Negocio() {
        return cod_Negocio;
    }

    public void setCod_Negocio(int cod_Negocio) {
        this.cod_Negocio = cod_Negocio;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getNome_Mercadoria() {
        return nome_Mercadoria;
    }

    public void setNome_Mercadoria(String nome_Mercadoria) {
        this.nome_Mercadoria = nome_Mercadoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Mercadoria{" + "cod_Mercadoria=" + cod_Mercadoria + ", cod_TipoMercadoria=" + cod_TipoMercadoria + ", cod_Negocio=" + cod_Negocio + ", qtd=" + qtd + ", nome_Mercadoria=" + nome_Mercadoria + ", preco=" + preco + '}';
    }   
        
    
}
