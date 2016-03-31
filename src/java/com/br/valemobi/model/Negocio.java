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
public class Negocio implements Serializable{
    
    private int cod_Negocio;
    private String des_Negocio;

    public Negocio() {
        this.cod_Negocio = -1;
        this.des_Negocio = null;
    }
    
    public Negocio(int cod_Negocio, String des_Negocio) {
        this.cod_Negocio = cod_Negocio;
        this.des_Negocio = des_Negocio;
    }

    public int getCod_Negocio() {
        return cod_Negocio;
    }

    public void setCod_Negocio(int cod_Negocio) {
        this.cod_Negocio = cod_Negocio;
    }

    public String getDes_Negocio() {
        return des_Negocio;
    }

    public void setDes_Negocio(String des_Negocio) {
        this.des_Negocio = des_Negocio;
    }
        
    
    
}
