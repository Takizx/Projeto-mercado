package view;

import javax.swing.*;
import controller.ProdutoController;

public class TelaProdutos extends JFrame {

    public TelaProdutos(){

        setTitle("Produtos (Admin)");
        setSize(350, 250);
        setLayout(null);

        JLabel labelNome = new JLabel("Produto:");
        labelNome.setBounds(20, 30, 80, 25);
        JTextField nome = new JTextField();
        nome.setBounds(100, 30, 200, 25);

        JLabel labelPreco = new JLabel("Valor (R$):");
        labelPreco.setBounds(20, 60, 80, 25);
        JTextField preco = new JTextField();
        preco.setBounds(100, 60, 200, 25);

        JLabel labelQtd = new JLabel("Estoque:");
        labelQtd.setBounds(20, 90, 80, 25);
        JTextField qtd = new JTextField();
        qtd.setBounds(100, 90, 200, 25);

        JButton salvar = new JButton("Cadastrar");
        salvar.setBounds(100, 130, 100, 25);

        JButton voltar = new JButton("Sair");
        voltar.setBounds(210, 130, 90, 25);

        add(labelNome); add(nome); 
        add(labelPreco); add(preco); 
        add(labelQtd); add(qtd); 
        add(salvar); add(voltar);

        ProdutoController controller = new ProdutoController();

        salvar.addActionListener(e -> {
            controller.cadastrar(nome.getText(),
                Double.parseDouble(preco.getText()),
                Integer.parseInt(qtd.getText()));

            JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");
            nome.setText("");
            preco.setText("");
            qtd.setText("");
        });

        voltar.addActionListener(e -> {
            new TelaLogin(); 
            dispose();
        });

        setVisible(true);
    }
}