package controller;

import model.Country;
import model.VacaySeeker;
import service.AccountOperation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;


public class Login extends JFrame {

    private static final long serialVersionUID = 1L;


    private JPanel MainPane = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    private JPanel radioButtonPane = new JPanel(new GridBagLayout());

    ButtonGroup radioButtonGroup= new ButtonGroup();
    JRadioButton regularUserModeRB=new JRadioButton("Vacay Seeker");
    JRadioButton travellingAgencyModeRB=new JRadioButton("Travelling Agency");

    JTextField usernameTF=new JTextField(15);
    JTextField passwordTF=new JTextField(15);
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    JLabel usernameLabel=new JLabel("Username:");
    JLabel passwordLabel=new JLabel("Password:");




    public Login(String name){
        super(name);
         c.gridx=0;
         c.gridy=0;

         regularUserModeRB.doClick();
        radioButtonGroup.add(regularUserModeRB);
        radioButtonGroup.add(travellingAgencyModeRB);
        radioButtonPane.add(regularUserModeRB,c);
        c.gridy=1;
        radioButtonPane.add(travellingAgencyModeRB,c);

        c.gridy=0;
        c.gridx=0;
        MainPane.add(usernameLabel,c);
        c.gridy=1;
        MainPane.add(passwordLabel,c);
        c.gridy=0;
        c.gridx=1;
        MainPane.add(usernameTF,c);
        c.gridy=1;
        MainPane.add(passwordTF,c);
        c.gridy=2;
        c.gridx=0;
        MainPane.add(loginButton,c);
        c.gridx++;
        MainPane.add(registerButton,c);
        c.gridx=5;
        c.gridy=0;
        MainPane.add(radioButtonPane,c);
        loginButton.addActionListener(e->{
            if(travellingAgencyModeRB.isSelected()){
                   JOptionPane.showMessageDialog(this,AccountOperation.loginTravelAgency(usernameTF.getText(),passwordTF.getText()));
                    TravellingAgencyView.main(new String[]{});}
            else{ JOptionPane.showMessageDialog(this,AccountOperation.loginUser(usernameTF.getText(),passwordTF.getText()));}
        });
        this.add(MainPane);


    }


    public static void main(String []args){
        JFrame frame = new Login("Las Vericus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


}
