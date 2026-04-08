package controller;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginController {

    UsuarioDAO dao = new UsuarioDAO();

    public Usuario login(String nome, String cpf){
        return dao.buscar(nome, cpf);
    }
}