package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.ProdutoController;
import controller.CarrinhoController;
import model.Produto;
import model.ItemCarrinho;
import java.util.ArrayList;

public class TelaCompra extends JFrame {

    public TelaCompra(){

        setTitle("Tela de Compra");
        setSize(500, 450);
        setLayout(null);

        ProdutoController pController = new ProdutoController();
        CarrinhoController cController = new CarrinhoController();

        JLabel labelSelecione = new JLabel("Selecione o Produto na tabela abaixo:");
        labelSelecione.setBounds(20, 10, 250, 25);
        add(labelSelecione);

        String[] colunas = {"ID", "Nome do Produto", "Preço (R$)", "Estoque"};
        
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        JTable tabelaProdutos = new JTable(modeloTabela);
        
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        scrollPane.setBounds(20, 40, 440, 150);
        add(scrollPane);

        ArrayList<Produto> produtosDb = pController.listar();
        for(Produto p : produtosDb){
            modeloTabela.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getPreco(),
                p.getQuantidade()
            });
        }

        JLabel labelQtd = new JLabel("Quantidade:");
        labelQtd.setBounds(20, 200, 80, 25);
        add(labelQtd);

        JTextField campoQtd = new JTextField("1");
        campoQtd.setBounds(100, 200, 60, 25);
        add(campoQtd);

        JButton addBtn = new JButton("Adicionar ao Carrinho");
        addBtn.setBounds(180, 200, 280, 25);
        add(addBtn);

        JButton verTotalBtn = new JButton("Ver Total do Carrinho");
        verTotalBtn.setBounds(20, 240, 440, 25);
        add(verTotalBtn);

        JButton finalizarBtn = new JButton("Finalizar Compra / Nota Fiscal");
        finalizarBtn.setBounds(20, 280, 440, 30);
        add(finalizarBtn);

        JButton sairBtn = new JButton("Sair (Deslogar)");
        sairBtn.setBounds(170, 330, 140, 25);
        add(sairBtn);

        addBtn.addActionListener(e -> {
            int linhaSelecionada = tabelaProdutos.getSelectedRow();
            
            if (linhaSelecionada >= 0) {
                Produto p = produtosDb.get(linhaSelecionada);
                
                try {
                    int qtdDesejada = Integer.parseInt(campoQtd.getText());
                    
                    if (qtdDesejada <= 0) {
                        JOptionPane.showMessageDialog(null, "A quantidade deve ser maior que zero!");
                    } else if (qtdDesejada > p.getQuantidade()) {
                        JOptionPane.showMessageDialog(null, "Estoque insuficiente! Temos apenas " + p.getQuantidade() + " unidades.");
                    } else {
                        cController.adicionar(p, qtdDesejada);
                        JOptionPane.showMessageDialog(null, qtdDesejada + "x " + p.getNome() + " adicionado ao carrinho!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Quantidade inválida! Por favor, digite apenas números inteiros.");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, clique em um produto na tabela primeiro!");
            }
        });

        verTotalBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Total atual do Carrinho: R$ " + cController.total());
        });

        finalizarBtn.addActionListener(e -> {
            if (cController.getCarrinho().getItens().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O carrinho está vazio!");
                return;
            }

            StringBuilder notaFiscal = new StringBuilder("--- NOTA FISCAL ---\n");
            
            for (ItemCarrinho item : cController.getCarrinho().getItens()) {
                pController.atualizarEstoque(item.getProduto().getId(), item.getQuantidade());
                
                notaFiscal.append(item.getQuantidade()).append("x ")
                          .append(item.getProduto().getNome())
                          .append(" - R$ ").append(item.getSubtotal()).append("\n");
            }
            notaFiscal.append("-------------------\n");
            notaFiscal.append("TOTAL PAGO: R$ ").append(cController.total());

            JOptionPane.showMessageDialog(null, "Compra finalizada com sucesso!\n\n" + notaFiscal.toString());
            
            new TelaCompra();
            dispose();
        });

        sairBtn.addActionListener(e -> {
            new TelaLogin();
            dispose();
        });

        setVisible(true);
    }
}