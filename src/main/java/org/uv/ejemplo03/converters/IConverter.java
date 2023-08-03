/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.ejemplo03.converters;

import java.util.List;

/**
 *
 * @author juan
 */
public interface IConverter <E, S> {
    public S entity(E e);
    
    public E dto(S s);
    
    public List<S> listentities(List<E> resourcelist);
    
    public List<E> listdtos(List<S> resourcelist);
}
