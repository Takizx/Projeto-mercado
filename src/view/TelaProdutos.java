package view;

import javax.swing.*;
import controller.ProdutoController;

public class TelaProdutos extends JFrame {

    public TelaProdutos(){

        setTitle("Produtos (Admin)");
        setSize(300,200);
        setLayout(null);

        JTextField nome = new JTextField();
        nome.setBounds(50,30,200,25);

        JTextField preco = new JTextField();
        preco.setBounds(50,60,200,25);

        JTextField qtd = new JTextField();
        qtd.setBounds(50,90,200,25);

        JButton salvar = new JButton("Cadastrar");
        salvar.setBounds(50,120,100,25);

        add(nome); add(preco); add(qtd); add(salvar);

        ProdutoController controller = new ProdutoController();

        salvar.addActionListener(e -> {
            controller.cadastrar(nome.getText(),
                Double.parseDouble(preco.getText()),
                Integer.parseInt(qtd.getText()));

            JOptionPane.showMessageDialog(null,"Produto cadastrado!");
        });

        setVisible(true);
    }
}