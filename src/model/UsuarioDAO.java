package dao;

import model.Usuario;

public class UsuarioDAO {

    public void salvar(Usuario u){
        Conexao.usuarios.add(u);
    }

    public Usuario buscar(String nome, String cpf){
        for(Usuario u : Conexao.usuarios){
            if(u.getNome().equals(nome) && u.getCpf().equals(cpf)){
                return u;
            }
        }
        return null;
    }
}