package controller;

import dao.ProdutoDAO;
import model.Produto;
import java.util.ArrayList;

public class ProdutoController {

    ProdutoDAO dao = new ProdutoDAO();

    public void cadastrar(String nome, double preco, int qtd){
        dao.salvar(new Produto(0,nome,preco,qtd));
    }

    public ArrayList<Produto> listar(){
        return dao.listar();
    }
}