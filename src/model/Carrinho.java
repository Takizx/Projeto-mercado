package model;

import java.util.ArrayList;

public class Carrinho {
    
    private ArrayList<ItemCarrinho> itens = new ArrayList<>();

    public void adicionar(Produto p, int quantidade){
        itens.add(new ItemCarrinho(p, quantidade));
    }

    public double getTotal(){
        double total = 0;
        for(ItemCarrinho i : itens){
            total += i.getSubtotal();
        }
        return total;
    }

    public ArrayList<ItemCarrinho> getItens(){
        return itens;
    }
}