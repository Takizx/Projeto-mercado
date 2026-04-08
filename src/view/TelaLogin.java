package view;

import javax.swing.*;
import controller.LoginController;
import model.Usuario;

public class TelaLogin extends JFrame {

    public TelaLogin(){

        setTitle("Login");
        setSize(300,200);
        setLayout(null);

        JTextField nome = new JTextField();
        nome.setBounds(50,30,200,25);

        JTextField cpf = new JTextField();
        cpf.setBounds(50,60,200,25);

        JButton login = new JButton("Login");
        login.setBounds(50,100,90,25);

        JButton cadastro = new JButton("Cadastrar");
        cadastro.setBounds(150,100,100,25);

        add(nome); add(cpf); add(login); add(cadastro);

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
            new TelaCadastroUsuario();
            dispose();
        });

        setVisible(true);
    }
}