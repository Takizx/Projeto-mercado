package view;

import javax.swing.*;
import controller.LoginController;
import model.Usuario;

public class TelaLogin extends JFrame {

    public TelaLogin(){

        setTitle("Login");
        setSize(300, 200);
        setLayout(null);

        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(20, 30, 40, 25);
        JTextField nome = new JTextField();
        nome.setBounds(60, 30, 190, 25);

        JLabel labelCpf = new JLabel("CPF:");
        labelCpf.setBounds(20, 60, 40, 25);
        JTextField cpf = new JTextField();
        cpf.setBounds(60, 60, 190, 25);

        JButton login = new JButton("Login");
        login.setBounds(45, 100, 90, 25);

        JButton cadastro = new JButton("Cadastrar");
        cadastro.setBounds(145, 100, 105, 25);

        add(labelNome); add(nome); 
        add(labelCpf); add(cpf); 
        add(login); add(cadastro);

        LoginController controller = new LoginController();

        login.addActionListener(e -> {
            Usuario u = controller.login(nome.getText(), cpf.getText());

            if(u == null){
                JOptionPane.showMessageDialog(null,"Usuário não encontrado");
            } else if(u.isAdmin()){
                new TelaProdutos();
                dispose();
            } else {
                new TelaCompra();
                dispose();
            }
        });

        cadastro.addActionListener(e -> {
            new TelaCadastro(); 
            dispose();
        });

        setVisible(true);
    }
}