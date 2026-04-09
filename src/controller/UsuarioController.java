package controller;

import model.UsuarioDAO; 
import model.Usuario;

public class UsuarioController {

    UsuarioDAO dao = new UsuarioDAO();

    public void cadastrar(String nome, String cpf, boolean admin){
        dao.salvar(new Usuario(nome, cpf, admin));
    }
}