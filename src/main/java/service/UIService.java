package service;

import model.Country;
import model.VacationDestination;
import model.VacationPackage;
import repository.DatabaseOperation;

import java.util.ArrayList;
import java.util.List;

public class UIService {
    private static final DatabaseOperation dbo=new DatabaseOperation();
    public static List<Country> getCountries(){
        return dbo.getCountriesFromDatabase();
    }
    public static List<VacationDestination> getDestinations(){
        return dbo.getDestinationsFromDatabase();
    }
    public static List<VacationPackage> getVacationPackages(){
        return dbo.getVacationPackagesFromDatabase();
    }
    public static Country getCountryObjectFromName(String nameOfCountry,ArrayList<Country> countries){
        for (Country country:countries
             ) {
            if(country.getName().equals(nameOfCountry)){return country;}
        }
     return null;
    }
    public static VacationPackage getVacationPackageObjectFromName(String nameOfVacationPackage,ArrayList<VacationPackage> vp){
        for ( VacationPackage v:vp
        ) {
            if(v.getName().equals(nameOfVacationPackage)){return v;}
        }
        return null;
    }
    public static VacationDestination getVacationDestinationObjectFromName(String nameOfDestination,ArrayList<VacationDestination> vacationDestinations){
        String[] nameToCompare=nameOfDestination.split(",");
        for (VacationDestination vacationDestination:vacationDestinations
        ) {

            if(vacationDestination.getLocation().equals(nameToCompare[0])){return vacationDestination;}
        }
        return null;
    }
    public static String createDestination(String nameOfDestination,String nameOfCountry,ArrayList<Country> countries){
        Country destinationCountry=getCountryObjectFromName(nameOfCountry,countries);
        if(destinationCountry!=null){
            String validationResult=Validator.validateNameOfDestination(nameOfDestination);
            if(validationResult.equals("OK")) {
                dbo.insertDestination(new VacationDestination(nameOfDestination, destinationCountry));
            }
            else{
                return validationResult;
            }
        }
        else{return "There is no country with this name. Contact support!";}
        return "You have successfully added the destination.";
    }
    public static String makeDate(String day, String month, String year){
           return day+ " " + month + " " + year;
    }
    public static String[] makeDataParameters(String date){
        return date.split(" ");
    }
    public static String createVacationPackage(String name,String nameOfVacationDestination,ArrayList<VacationDestination> vacationDestinations,String price, String startDate,String endDate,String extraDetails,String maxBookings){
        VacationDestination vacationDestination=getVacationDestinationObjectFromName(nameOfVacationDestination,vacationDestinations);
        if(vacationDestination!=null) {
            String validationResult = Validator.validateNameOfDestination(name);
            if (validationResult.equals("OK")) {
                dbo.insertVacationPackage(new VacationPackage(name, vacationDestination, price, startDate, endDate, extraDetails, Integer.parseInt(maxBookings)));
            } else {
                return validationResult;
            }
        }else{return "There is no destination with this name. Contact support!";}
        return "You have successfully added the vacation package.";
    }
    public static String editVacationPackage(String name,String nameOfVacationDestination,ArrayList<VacationDestination> vacationDestinations,String price, String startDate,String endDate,String extraDetails,String maxBookings,VacationPackage vp){
        VacationDestination vacationDestination=getVacationDestinationObjectFromName(nameOfVacationDestination,vacationDestinations);
        if(vacationDestination!=null) {
            String validationResult = Validator.validateNameOfDestination(name);
            if (validationResult.equals("OK")) {
                vp.setName(name);
                vp.setVacationDestination(vacationDestination);
                vp.setPrice(price);
                vp.setStartDate(startDate);
                vp.setEndDate(endDate);
                vp.setExtraDetails(extraDetails);
                vp.setAvailableTickets(Integer.parseInt(maxBookings));
                dbo.editVacationPackage(vp);
            } else {
                return validationResult;
            }
        }else{return "There is no destination with this name. Contact support!";}
        return "You have successfully edited the vacation package.";
    }



}
