package controller;

import model.VacationDestination;
import model.VacationPackage;
import model.VacationPackage;
import service.UIService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class NewVacationPackageView extends JFrame {
    private static final long serialVersionUID = 1L;


    private JPanel MainPane = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    protected JButton addVacationPackageButton=new JButton("Add the vacation package.");

    JComboBox destinationsJComboBox;

    public NewVacationPackageView(String title){
        super(title);
    
        ArrayList<VacationDestination> VacationDestinationObjects= (ArrayList<VacationDestination>) UIService.getDestinations();
        int VacationPackageIndex=0;

        String[] destinations = new String[VacationDestinationObjects.size()];
        for( VacationDestination  vacationDestination: VacationDestinationObjects){
            String sb = vacationDestination.getLocation() +
                    ", " +
                    vacationDestination.getCountry().getName();
            destinations[VacationPackageIndex++]= sb;
        }
        destinationsJComboBox =new JComboBox(destinations);
        destinationsJComboBox.setSelectedIndex(0);

        JLabel destinationOfVacationPackageLabel=new JLabel("Select the destination of the package:");
        c.gridx=0;
        c.gridy=0;
        MainPane.add(destinationOfVacationPackageLabel,c);
        c.gridx=1;
        MainPane.add(destinationsJComboBox,c);

        JLabel PackageNameLabel =new JLabel("Package name:");
        c.gridx=0;
        c.gridy=1;
        MainPane.add(PackageNameLabel,c);
        JTextField PackageNameTF=new JTextField(15);
        c.gridx=1;
        MainPane.add(PackageNameTF,c);

        JLabel PackagePriceLabel =new JLabel("Package price:");
        c.gridx=0;
        c.gridy++;
        MainPane.add(PackagePriceLabel,c);
        JTextField PackagePriceTF=new JTextField(15);
        c.gridx=1;
        MainPane.add(PackagePriceTF,c);

        JLabel PackagePeriodLabel =new JLabel("Package period:");
        c.gridx=0;
        c.gridy++;
        MainPane.add(PackagePeriodLabel,c);

        String[] daysForComboBox=new String[31];
        String[] monthsForComboBox=new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
        String[] yearsForComboBox=new String[10];

        for(int i=1;i<=31;i++){
            daysForComboBox[i-1]=Integer.toString(i);
        }
        for(int i=0;i<=9;i++){
            yearsForComboBox[i]=Integer.toString(2022+i);
        }



        //from
        JLabel PackagePeriodLabelFromDay=new JLabel("From: Day:");
        c.gridx++;
        MainPane.add(PackagePeriodLabelFromDay,c);
        JComboBox PackagePeriodFromDayCB=new JComboBox(daysForComboBox);
        PackagePeriodFromDayCB.setSelectedIndex(0);
        c.gridx++;
        MainPane.add(PackagePeriodFromDayCB,c);

        JLabel PackagePeriodLabelMonth=new JLabel("Month:");
        c.gridx++;
        MainPane.add(PackagePeriodLabelMonth,c);
        JComboBox PackagePeriodFromMonthCB=new JComboBox(monthsForComboBox);
        PackagePeriodFromMonthCB.setSelectedIndex(0);
        c.gridx++;
        MainPane.add(PackagePeriodFromMonthCB,c);

        JLabel PackagePeriodLabelYear=new JLabel("Year:");
        c.gridx++;
        MainPane.add(PackagePeriodLabelYear,c);
        JComboBox PackagePeriodFromYearCB=new JComboBox(yearsForComboBox);
        PackagePeriodFromYearCB.setSelectedIndex(0);
        c.gridx++;
        MainPane.add(PackagePeriodFromYearCB,c);
        //
        c.gridx=0;

        //to
        JLabel PackagePeriodLabelToDay=new JLabel("To: Day:");
        c.gridy++;
        c.gridx++;
        MainPane.add(PackagePeriodLabelToDay,c);
        JComboBox PackagePeriodToDayCB=new JComboBox(daysForComboBox);
        PackagePeriodToDayCB.setSelectedIndex(0);
        c.gridx++;
        MainPane.add(PackagePeriodToDayCB,c);

        JLabel PackagePeriodLabelToMonth=new JLabel("Month:");
        c.gridx++;
        MainPane.add(PackagePeriodLabelToMonth,c);
        JComboBox PackagePeriodToMonthCB=new JComboBox(monthsForComboBox);
        PackagePeriodToMonthCB.setSelectedIndex(0);
        c.gridx++;
        MainPane.add(PackagePeriodToMonthCB,c);

        JLabel PackagePeriodLabelToYear=new JLabel("Year:");
        c.gridx++;
        MainPane.add(PackagePeriodLabelToYear,c);
        JComboBox PackagePeriodToYearCB=new JComboBox(yearsForComboBox);
        PackagePeriodToYearCB.setSelectedIndex(0);
        c.gridx++;
        MainPane.add(PackagePeriodToYearCB,c);

        //
         c.gridy++;
         c.gridx=0;
         JLabel PackageExtraDetailsLabel=new JLabel("Extra details");
        MainPane.add(PackageExtraDetailsLabel,c);
        c.gridx++;
         JTextField PackageExtraDetailsTF=new JTextField(20);
         MainPane.add(PackageExtraDetailsTF,c);
         c.gridy++;
         c.gridx=0;
         JLabel PackageMaxNumberOfBookingsLabel= new JLabel("How many people can book this package? :");
         MainPane.add(PackageMaxNumberOfBookingsLabel,c);
         c.gridx++;
         JTextField PackageMaxNumberOfBookingsTF=new JTextField(10);
         MainPane.add(PackageMaxNumberOfBookingsTF,c);


        c.gridy++;
        MainPane.add(addVacationPackageButton,c);
        addVacationPackageButton.addActionListener(e->{
       String response=UIService.createVacationPackage(PackageNameTF.getText(),
                destinationsJComboBox.getSelectedItem().toString(),
                VacationDestinationObjects,
                PackagePriceTF.getText(),
                UIService.makeDate(PackagePeriodFromDayCB.getSelectedItem().toString(),
                        PackagePeriodFromMonthCB.getSelectedItem().toString(),
                        PackagePeriodFromYearCB.getSelectedItem().toString()),
                UIService.makeDate(PackagePeriodToDayCB.getSelectedItem().toString(),
                        PackagePeriodToMonthCB.getSelectedItem().toString(),
                        PackagePeriodToYearCB.getSelectedItem().toString()),
                PackageExtraDetailsTF.getText(),
                PackageMaxNumberOfBookingsTF.getText());
       JOptionPane.showMessageDialog(this,response);
        });

        this.add(MainPane);

    }

    public static void main(String []args){
        JFrame frame = new NewVacationPackageView("Add a new destination.");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
