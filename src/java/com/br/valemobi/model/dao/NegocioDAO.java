/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.valemobi.model.dao;

import com.br.valemobi.model.Negocio;
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
public class NegocioDAO implements GenericDAO<Negocio> {
    
    private Connection conn;
    
    public NegocioDAO(){
        conn = ConnectionDB.getInstance();
    }
    
    @Override
    public boolean insert(Negocio m) {
        boolean resp = false;
        
        String sql = "INSERT INTO Negocio(des_Negocio) VALUES (?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, m.getDes_Negocio());
            
            int resposta = ps.executeUpdate();
            if(resposta == 0){
                System.out.println("Erro: Não foi possível inserir a descrição!");
            }else{
                System.out.println("Descrição inserida com sucesso!");
                resp = true;
            }
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(NegocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    @Override
    public List<Negocio> read() {
        List<Negocio> n = new ArrayList<>();
        
        String sql = "SELECT * FROM Negocio";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Negocio neg = new Negocio();
                neg.setCod_Negocio(rs.getInt("cod_Negocio"));
                neg.setDes_Negocio(rs.getString("des_Negocio"));
                
                n.add(neg);
            }
            
            ps.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(NegocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    @Override
    public boolean update(Negocio n) {
        boolean resp = false;
        
        String sql = "UPDATE Negocio SET des_Negocio=? WHERE cod_Negocio =?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, n.getDes_Negocio());
            
            int resposta = ps.executeUpdate();
            if(resposta == 0){
                System.out.println("Erro: Não foi possível atualizar a descrição.");
            }else{
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
    public boolean delete(Negocio n) {
        boolean resp = false;
        
        String sql = "DELETE FROM Negocio WHERE cod_Negocio=?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, n.getCod_Negocio());
            
            int resposta = ps.executeUpdate();
            if(resposta == 0){
                System.out.println("Não foi possível deletar!");
            }else{
                System.out.println("Negócio deletado com sucesso!");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(NegocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
    
}
