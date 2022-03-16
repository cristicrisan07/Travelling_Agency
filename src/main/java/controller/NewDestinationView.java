package controller;

import model.Country;
import service.UIService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class NewDestinationView extends JFrame {

    private static final long serialVersionUID = 1L;


    private JPanel MainPane = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    JButton addDestinationButton=new JButton("Add new destination.");
    
    JComboBox countriesJComboBox;

    public NewDestinationView(String title){
        super(title);

        ArrayList<Country> countryObjects= (ArrayList<Country>) UIService.getCountries();
        int countryIndex=0;

        String[] countries = new String[countryObjects.size()];
        for(Country country : countryObjects){
            countries[countryIndex++]=country.getName();
        }
        countriesJComboBox =new JComboBox(countries);
        countriesJComboBox.setSelectedIndex(0);

        JLabel destinationCountryLabel=new JLabel("Select the country of destination.");
        c.gridx=0;
        c.gridy=0;
        MainPane.add(destinationCountryLabel,c);
        c.gridx=1;
        MainPane.add(countriesJComboBox,c);

        JLabel destinationNameLabel =new JLabel("Destination name:");
        c.gridx=0;
        c.gridy=1;
        MainPane.add(destinationNameLabel,c);
        JTextField destinationNameTF=new JTextField(15);
        c.gridx=1;
        MainPane.add(destinationNameTF,c);

        c.gridy=4;
        MainPane.add(addDestinationButton,c);
        addDestinationButton.addActionListener(e->{
            String response=UIService.createDestination(destinationNameTF.getText(), Objects.requireNonNull(countriesJComboBox.getSelectedItem()).toString(),countryObjects);
            JOptionPane.showMessageDialog(this,response);
        });

        this.add(MainPane);

    }

    public static void main(String []args){
        JFrame frame = new NewDestinationView("Add a new destination.");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
