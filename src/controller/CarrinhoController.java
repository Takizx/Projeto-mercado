package controller;

import model.Carrinho;
import model.Produto;

public class CarrinhoController {

    private Carrinho carrinho = new Carrinho();

    public void adicionar(Produto p){
        carrinho.adicionar(p);
    }

    public double total(){
        return carrinho.getTotal();
    }

    public Carrinho getCarrinho(){
        return carrinho;
    }
}