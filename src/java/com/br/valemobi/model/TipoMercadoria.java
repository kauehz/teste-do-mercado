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
public class TipoMercadoria implements Serializable {
    
    private int cod_TipoMercadoria;
    private String des_TipoMercadoria;

    public TipoMercadoria() {
        this.cod_TipoMercadoria = -1;
        this.des_TipoMercadoria = null;
    }

    public TipoMercadoria(int cod_TipoMercadoria, String des_TipoMercadoria) {
        this.cod_TipoMercadoria = cod_TipoMercadoria;
        this.des_TipoMercadoria = des_TipoMercadoria;
    }

    public int getCod_TipoMercadoria() {
        return cod_TipoMercadoria;
    }

    public void setCod_TipoMercadoria(int cod_TipoMercadoria) {
        this.cod_TipoMercadoria = cod_TipoMercadoria;
    }

    public String getDes_TipoMercadoria() {
        return des_TipoMercadoria;
    }

    public void setDes_TipoMercadoria(String des_TipoMercadoria) {
        this.des_TipoMercadoria = des_TipoMercadoria;
    }
    
    
    
}
