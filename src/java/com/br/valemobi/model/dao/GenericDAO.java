/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.valemobi.model.dao;

import java.util.List;

/**
 *
 * @author Asu
 */
public interface GenericDAO<E> {

    public boolean insert(E e);

    public List<E> read();

    public boolean update(E e);

    public boolean delete(E e);

}
