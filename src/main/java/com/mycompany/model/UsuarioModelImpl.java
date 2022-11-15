/*
 Universidad de la Sierra Sur 
 Licenciatura en Informática
 Equipo: workboot
 Proyecto: Tourist Places: Mostrar la belleza de Oaxaca 
 */
package com.mycompany.model;

import com.mycompany.entity.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Alex Ram
 */
public class UsuarioModelImpl implements IUsuarioModel {

    private SessionFactory sf;
    private Session sesion;

    @Override
    public void insertarRegistro(Usuario usuario) {
        try {
            sf = new Configuration().configure().buildSessionFactory();
            sesion = sf.openSession();
            sesion.beginTransaction();
            sesion.save(usuario);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        IUsuarioModel modelo = new UsuarioModelImpl();
        Usuario user = new Usuario();
        user.setNombre("Juan");
        user.setCorreo("jn23@gmail.com");
        user.setUsuario("Admin");
        user.setContrasena("12der");
        modelo.insertarRegistro(user);
        System.out.println("Ingresado correctamente");
    }

    @Override
    public List<Usuario> obtenerRegistro() {
        List<Usuario> listaRol = null;
        try {
            sf = new Configuration().configure().buildSessionFactory();
            sesion = sf.openSession();
            listaRol = sesion.createCriteria(Usuario.class).list();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println("Error" + e.getMessage());
        }
        return listaRol;
    }
}
