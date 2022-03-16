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

public class EditExistingPackageView extends JFrame {
    private static final long serialVersionUID = 1L;


    private JPanel MainPane = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    private JButton editVacationPackageButton=new JButton("Edit the vacation package.");
    private JButton deleteVacationPackageButton=new JButton("Delete the vacation package.");

    JComboBox destinationsJComboBox;

    private void openEditingWindow(VacationPackage vp){
        ArrayList<VacationDestination> VacationDestinationObjects= (ArrayList<VacationDestination>) UIService.getDestinations();
        int VacationPackageIndex=0,defaultDestinationsCBIndex=0;

        String[] destinations = new String[VacationDestinationObjects.size()];
        for( VacationDestination  vacationDestination: VacationDestinationObjects){
            String sb = vacationDestination.getLocation() +
                    ", " +
                    vacationDestination.getCountry().getName();
            destinations[VacationPackageIndex++]= sb;
        }
        destinationsJComboBox =new JComboBox(destinations);
        for(int i=0;i<VacationDestinationObjects.size();i++){
//            if(UIService.getVacationDestinationObjectFromName(destinationsJComboBox.getItemAt(i).toString(),VacationDestinationObjects).equals(vp.getVacationDestination())){
//                    defaultDestinationsCBIndex=i;
//                    break;
//            }
            if(VacationDestinationObjects.get(i).getLocation().equals(vp.getVacationDestination().getLocation())){
                defaultDestinationsCBIndex=i;
                break;
            }

        }

        destinationsJComboBox.setSelectedIndex(defaultDestinationsCBIndex);

        JLabel destinationOfVacationPackageLabel=new JLabel("Select the destination of the package:");
        c.gridx=0;
        c.gridy=5;
        MainPane.add(destinationOfVacationPackageLabel,c);
        c.gridx=1;
        MainPane.add(destinationsJComboBox,c);

        JLabel PackageNameLabel =new JLabel("Package name:");
        c.gridx=0;
        c.gridy=6;
        MainPane.add(PackageNameLabel,c);
        JTextField PackageNameTF=new JTextField(vp.getName());
        c.gridx=1;
        MainPane.add(PackageNameTF,c);

        JLabel PackagePriceLabel =new JLabel("Package price:");
        c.gridx=0;
        c.gridy++;
        MainPane.add(PackagePriceLabel,c);
        JTextField PackagePriceTF=new JTextField(vp.getPrice());
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

        //date parameters of selected vacation package
        String startDay,startMonth,startYear,endDay,endMonth,endYear;
        String[] startParameters=UIService.makeDataParameters(vp.getStartDate());
        startDay=startParameters[0];
        startMonth=startParameters[1];
        startYear=startParameters[2];
        String[] endParameters=UIService.makeDataParameters(vp.getEndDate());
        endDay=endParameters[0];
        endMonth=endParameters[1];
        endYear=endParameters[2];

        int startDayIndex=0,startMonthIndex=0,startYearIndex=0,endDayIndex=0,endMonthIndex=0,endYearIndex=0;

        for(int i=0;i<31;i++){
            if(daysForComboBox[i].equals(startDay)){
                startDayIndex=i;
            }
            if(daysForComboBox[i].equals(endDay)){
                endDayIndex=i;
            }
        }
        for(int i=0;i<12;i++){
            if(monthsForComboBox[i].equals(startMonth)){
                startMonthIndex=i;
            }
            if(monthsForComboBox[i].equals(endMonth)){
                endMonthIndex=i;
            }
        }
        for(int i=0;i<10;i++){
            if(yearsForComboBox[i].equals(startYear)){
                startYearIndex=i;
            }
            if(yearsForComboBox[i].equals(endYear)){
                endYearIndex=i;
            }
        }


        //from
        JLabel PackagePeriodLabelFromDay=new JLabel("From: Day:");
        c.gridx++;
        MainPane.add(PackagePeriodLabelFromDay,c);
        JComboBox PackagePeriodFromDayCB=new JComboBox(daysForComboBox);
        PackagePeriodFromDayCB.setSelectedIndex(startDayIndex);
        c.gridx++;
        MainPane.add(PackagePeriodFromDayCB,c);

        JLabel PackagePeriodLabelMonth=new JLabel("Month:");
        c.gridx++;
        MainPane.add(PackagePeriodLabelMonth,c);
        JComboBox PackagePeriodFromMonthCB=new JComboBox(monthsForComboBox);
        PackagePeriodFromMonthCB.setSelectedIndex(startMonthIndex);
        c.gridx++;
        MainPane.add(PackagePeriodFromMonthCB,c);

        JLabel PackagePeriodLabelYear=new JLabel("Year:");
        c.gridx++;
        MainPane.add(PackagePeriodLabelYear,c);
        JComboBox PackagePeriodFromYearCB=new JComboBox(yearsForComboBox);
        PackagePeriodFromYearCB.setSelectedIndex(startYearIndex);
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
        PackagePeriodToDayCB.setSelectedIndex(endDayIndex);
        c.gridx++;
        MainPane.add(PackagePeriodToDayCB,c);

        JLabel PackagePeriodLabelToMonth=new JLabel("Month:");
        c.gridx++;
        MainPane.add(PackagePeriodLabelToMonth,c);
        JComboBox PackagePeriodToMonthCB=new JComboBox(monthsForComboBox);
        PackagePeriodToMonthCB.setSelectedIndex(endMonthIndex);
        c.gridx++;
        MainPane.add(PackagePeriodToMonthCB,c);

        JLabel PackagePeriodLabelToYear=new JLabel("Year:");
        c.gridx++;
        MainPane.add(PackagePeriodLabelToYear,c);
        JComboBox PackagePeriodToYearCB=new JComboBox(yearsForComboBox);
        PackagePeriodToYearCB.setSelectedIndex(endYearIndex);
        c.gridx++;
        MainPane.add(PackagePeriodToYearCB,c);

        //
        c.gridy++;
        c.gridx=0;
        JLabel PackageExtraDetailsLabel=new JLabel("Extra details");
        MainPane.add(PackageExtraDetailsLabel,c);
        c.gridx++;
        JTextField PackageExtraDetailsTF=new JTextField(vp.getExtraDetails());
        MainPane.add(PackageExtraDetailsTF,c);
        c.gridy++;
        c.gridx=0;
        JLabel PackageMaxNumberOfBookingsLabel= new JLabel("How many people can book this package? :");
        MainPane.add(PackageMaxNumberOfBookingsLabel,c);
        c.gridx++;
        JTextField PackageMaxNumberOfBookingsTF=new JTextField(String.valueOf(vp.getAvailableTickets()));
        MainPane.add(PackageMaxNumberOfBookingsTF,c);


        c.gridy++;
        MainPane.add(editVacationPackageButton,c);
        editVacationPackageButton.addActionListener(e->{
            String response=UIService.editVacationPackage(PackageNameTF.getText(),
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
                    PackageMaxNumberOfBookingsTF.getText()
                    ,vp);
            JOptionPane.showMessageDialog(this,response);
        });
        c.gridx++;
        MainPane.add(deleteVacationPackageButton,c);
        deleteVacationPackageButton.addActionListener(e->{
                   JOptionPane.showMessageDialog(this,UIService.deleteVacationPackage(vp));
                   this.dispose();
        });

        this.add(MainPane);
        this.pack();

    }
    public EditExistingPackageView(String title){
        super(title);

        ArrayList<VacationPackage>vacationPackages= (ArrayList<VacationPackage>) UIService.getVacationPackages();
        String[] namesOfVacationPackages=new String[vacationPackages.size()];
        int indexInString=0;
        for(VacationPackage vacationPackage:vacationPackages){
            namesOfVacationPackages[indexInString++]=vacationPackage.getName();
        }

        JLabel ExistingVacationPackageLabel=new JLabel("Choose an existing vacation package:");
        c.gridx=0;
        c.gridy=0;
        MainPane.add(ExistingVacationPackageLabel,c);
        c.gridx++;
        JComboBox existingVacationPackagesCB=new JComboBox(namesOfVacationPackages);
        existingVacationPackagesCB.setSelectedIndex(0);
        MainPane.add(existingVacationPackagesCB,c);
        c.gridy++;
        JButton editButton=new JButton("Edit/Delete");
        editButton.addActionListener(e-> {
            openEditingWindow(UIService.getVacationPackageObjectFromName(existingVacationPackagesCB.getSelectedItem().toString(),vacationPackages));
            editButton.setVisible(false);
        });
        MainPane.add(editButton,c);
        this.add(MainPane);



    }

    public static void main(String []args){
        JFrame frame = new EditExistingPackageView("Edit/delete a destination.");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
