package view;

import javax.swing.*;
import controller.ProdutoController;
import controller.CarrinhoController;
import model.Produto;

public class TelaCompra extends JFrame {

    public TelaCompra(){

        setTitle("Compra");
        setSize(300,300);
        setLayout(null);

        ProdutoController pController = new ProdutoController();
        CarrinhoController cController = new CarrinhoController();

        JComboBox<String> lista = new JComboBox<>();
        lista.setBounds(50,30,200,25);

        for(Produto p : pController.listar()){
            lista.addItem(p.getNome());
        }

        JButton add = new JButton("Adicionar");
        add.setBounds(50,70,100,25);

        JButton total = new JButton("Total");
        total.setBounds(50,110,100,25);

        add(lista); add(add); add(total);

        add.addActionListener(e -> {
            int i = lista.getSelectedIndex();
            Produto p = pController.listar().get(i);
            cController.adicionar(p);
        });

        total.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                "Total: R$ " + cController.total());
        });

        setVisible(true);
    }
}