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
    private String des_TipoNegocio;

    public Negocio(int cod_Negocio, String des_TipoNegocio) {
        this.cod_Negocio = cod_Negocio;
        this.des_TipoNegocio = des_TipoNegocio;
    }

    public int getCod_Negocio() {
        return cod_Negocio;
    }

    public void setCod_Negocio(int cod_Negocio) {
        this.cod_Negocio = cod_Negocio;
    }

    public String getDes_TipoNegocio() {
        return des_TipoNegocio;
    }

    public void setDes_TipoNegocio(String des_TipoNegocio) {
        this.des_TipoNegocio = des_TipoNegocio;
    }
        
    
    
}
