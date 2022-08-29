package com.example.parametros.repository;

public interface IDao<T> {

   public T guardar(T t);
    public T buscar(Integer id);
   // void eliminar(Integer id);
   // List<T> buscarTodos();
   // T actualizar(T t);
}

