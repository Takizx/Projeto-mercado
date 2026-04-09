package view;

import javax.swing.*;
import controller.UsuarioController;

public class TelaCadastro extends JFrame {

    public TelaCadastro(){

        setTitle("Cadastro");
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

        JCheckBox admin = new JCheckBox("Admin");
        admin.setBounds(60, 90, 100, 25);

        JButton salvar = new JButton("Salvar");
        salvar.setBounds(90, 120, 100, 25);

        add(labelNome); add(nome); 
        add(labelCpf); add(cpf); 
        add(admin); add(salvar);

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