/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.valemobi.model.dao;

import com.br.valemobi.model.Mercadoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asu
 */
public class MercadoriaDAO implements GenericDAO<Mercadoria> {

    private Connection conn;

    public MercadoriaDAO() {
        conn = ConnectionDB.getInstance();
    }

    @Override
    public boolean insert(Mercadoria m) {
        boolean resp = false;
        String sql = "INSERT INTO Mercadoria(preco, nome_Mercadoria, cod_TipoMercadoria, cod_Negocio) values (?,?,?,?)";

        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, m.getPreco());
            ps.setString(2, m.getNome_Mercadoria());
            ps.setInt(3, m.getCod_TipoMercadoria());
            ps.setInt(4, m.getCod_Negocio());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Erro: Não foi possível inserir a Mercadoria.");
            } else {
                System.out.println("Mercadoria inserida com sucesso!");
                resp = true;
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MercadoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    @Override
    public List<Mercadoria> read() {
        List<Mercadoria> m = new ArrayList<>();

        String sql = "SELECT * FROM Mercadoria";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Mercadoria merc = new Mercadoria();
                merc.setCod_Mercadoria(rs.getInt("cod_Mercadoria"));
                merc.setPreco(rs.getDouble("preco"));
                merc.setNome_Mercadoria(rs.getString("nome_Mercadoria"));
                merc.setCod_TipoMercadoria(rs.getInt("cod_TipoMercadoria"));
                merc.setCod_Negocio(rs.getInt("cod_Negocio"));
                m.add(merc);

            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(MercadoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    @Override
    public boolean update(Mercadoria m) {
        boolean resp = false;
        String sql = "UPDATE Mercadoria SET preco=?, nome_Mercadoria=? WHERE cod_Mercadoria=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, m.getPreco());
            ps.setString(2, m.getNome_Mercadoria());

            int resposta = ps.executeUpdate();
            if (resposta == 0) {
                System.out.println("Erro: Não foi possível atualizar.");
            } else {
                System.out.println("Atualizado com sucesso!");
                resp = true;
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(MercadoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resp;
    }

    @Override
    public boolean delete(Mercadoria m) {
        boolean resp = false;

        String sql = "DELETE FROM Mercadoria WHERE cod_Mercadoria=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, m.getCod_Mercadoria());

            int resposta = ps.executeUpdate();
            if (resposta == 0) {
                System.out.println("Erro: Não foi possível deletar a Mercadoria!");
            } else {
                System.out.println("Mercadoria deletada com sucesso!");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MercadoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

}
