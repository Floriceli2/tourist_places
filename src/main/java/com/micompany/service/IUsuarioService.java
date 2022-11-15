/*
 Universidad de la Sierra Sur 
 Licenciatura en Informática
 Equipo: workboot
 Proyecto: Tourist Places: Mostrar la belleza de Oaxaca 
 */
package com.micompany.service;

import com.mycompany.entity.Usuario;
import java.util.List;

public interface IUsuarioService {
    public void insertarRegistro(Usuario usuario);
    public List<Usuario> obtenerRegistro();
    
}
