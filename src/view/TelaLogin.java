package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {

    private JTextField campoNome;
    private JTextField campoCpf;

    public TelaLogin(){

        setTitle("Sistema de Supermercado - Login");
        setSize(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5,1,10,10));

        JLabel titulo = new JLabel("SUPERMERCADO", SwingConstants.CENTER);

        campoNome = new JTextField();
        campoCpf = new JTextField();

        JButton botaoLogin = new JButton("Login");
        JButton botaoCadastrar = new JButton("Cadastrar Usuário");

        painel.add(titulo);
        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(new JLabel("CPF:"));
        painel.add(campoCpf);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoLogin);
        painelBotoes.add(botaoCadastrar);

        add(painel, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new TelaCadastro();
                dispose();

            }
        });

        setVisible(true);
    }

}