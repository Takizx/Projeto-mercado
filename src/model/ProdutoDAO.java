package dao;

import model.Produto;
import java.util.ArrayList;

public class ProdutoDAO {

    public void salvar(Produto p){
        Conexao.produtos.add(p);
    }

    public ArrayList<Produto> listar(){
        return Conexao.produtos;
    }
}