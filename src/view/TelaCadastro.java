package view;

import javax.swing.*;
import controller.UsuarioController;

public class TelaCadastro extends JFrame {

    public TelaCadastro(){

        setTitle("Cadastro");
        setSize(300,200);
        setLayout(null);

        JTextField nome = new JTextField();
        nome.setBounds(50,30,200,25);

        JTextField cpf = new JTextField();
        cpf.setBounds(50,60,200,25);

        JCheckBox admin = new JCheckBox("Admin");
        admin.setBounds(50,90,100,25);

        JButton salvar = new JButton("Salvar");
        salvar.setBounds(50,120,100,25);

        add(nome); add(cpf); add(admin); add(salvar);

        UsuarioController controller = new UsuarioController();

        salvar.addActionListener(e -> {
            controller.cadastrar(nome.getText(), cpf.getText(), admin.isSelected());
            JOptionPane.showMessageDialog(null,"Cadastrado!");
            new TelaLogin();
            dispose();
        });

        setVisible(true);
    }
}