package controller;

import org.jboss.jandex.Main;

import javax.swing.*;
import java.awt.*;

public class TravellingAgencyView extends JFrame {

    private static final long serialVersionUID = 1L;


    private JPanel MainPane = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    JButton addDestinationButton=new JButton("Add new destination.");
    JButton addVacationPackage=new JButton("Add new vacation package.");
    JButton editExistingPackage=new JButton("Edit/delete an existing package.");

    public TravellingAgencyView(String name)  {
        super(name);
        c.gridy=0;c.gridx=0;
        MainPane.add(addDestinationButton,c);
        c.gridx++;
        MainPane.add(addVacationPackage,c);
        c.gridx++;
        MainPane.add(editExistingPackage,c);
        addDestinationButton.addActionListener(e-> NewDestinationView.main(new String[]{}));
        addVacationPackage.addActionListener(e->NewVacationPackageView.main(new String[]{}));
        editExistingPackage.addActionListener(e->EditExistingPackageView.main(new String[]{}));
        this.add(MainPane);
    }
    public static void main(String []args){
        JFrame frame = new TravellingAgencyView("Travelling Agency Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

