/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.valemobi.model.dao;

import com.br.valemobi.model.Negocio;
import com.br.valemobi.model.TipoMercadoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asu
 */
public class TipoMercadoriaDAO implements GenericDAO<TipoMercadoria> {

    private Connection conn;

    public TipoMercadoriaDAO() {
        conn = ConnectionDB.getInstance();
    }

    @Override
    public boolean insert(TipoMercadoria t) {
        boolean resp = false;

        String sql = "INSERT INTO TipoMercadoria(des_TipoMercadoria) VALUES (?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, t.getDes_TipoMercadoria());

            int resposta = ps.executeUpdate();
            if (resposta == 0) {
                System.out.println("Não foi possível inserir a descrição do Tipo da Mercadoria!");
            } else {
                System.out.println("Descrição do Tipo da Mercadoria inserida com sucesso!");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoMercadoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resp;
    }

    @Override
    public List<TipoMercadoria> read() {
        List<TipoMercadoria> t = new ArrayList<>();

        String sql = "SELECT * FROM Negocio";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TipoMercadoria tm = new TipoMercadoria();
                tm.setCod_TipoMercadoria(rs.getInt("cod_TipoMercadoria"));
                tm.setDes_TipoMercadoria(rs.getString("des_TipoMercadoria"));

                t.add(tm);
            }

            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(NegocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public boolean update(TipoMercadoria t) {
        boolean resp = false;

        String sql = "UPDATE TipoMercadoria SET des_TipoMercadoria=? WHERE cod_TipoMercadoria =?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, t.getDes_TipoMercadoria());

            int resposta = ps.executeUpdate();
            if (resposta == 0) {
                System.out.println("Erro: Não foi possível atualizar a descrição.");
            } else {
                System.out.println("Descrição atualizada com sucesso!");
                resp = true;
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(NegocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    @Override
    public boolean delete(TipoMercadoria t) {
       boolean resp = false;
        
        String sql = "DELETE FROM TipoMercadoria WHERE cod_TipoMercadoria=?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, t.getCod_TipoMercadoria());
            
            int resposta = ps.executeUpdate();
            if(resposta == 0){
                System.out.println("Não foi possível deletar!");
            }else{
                System.out.println("Tipo de Mercadoria deletado com sucesso!");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(NegocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

}
