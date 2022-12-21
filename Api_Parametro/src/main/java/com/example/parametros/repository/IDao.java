package com.example.parametros.repository;

import java.util.List;

public interface IDao<T> {

   public T guardar(T t);
    public T buscar(Integer id);

    public String guardarMDF(int i);


    // void eliminar(Integer id);
   // List<T> buscarTodos();
   // T actualizar(T t);
}

