package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro extends JFrame {

    public TelaCadastro(){

        setTitle("Cadastro de Usuário");
        setSize(400,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4,2,10,10));

        JTextField campoNome = new JTextField();
        JTextField campoCpf = new JTextField();

        JCheckBox administrador = new JCheckBox("Administrador");

        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoVoltar = new JButton("Voltar");

        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);

        painel.add(new JLabel("CPF:"));
        painel.add(campoCpf);

        painel.add(new JLabel(""));
        painel.add(administrador);

        painel.add(botaoCadastrar);
        painel.add(botaoVoltar);

        add(painel);

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new TelaLogin();
                dispose();

            }
        });

        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso!");

                new TelaLogin();
                dispose();

            }
        });

        setVisible(true);
    }

}