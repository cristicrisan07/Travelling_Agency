package service;

import model.User;
import model.VacaySeeker;
import org.hibernate.boot.model.relational.Database;
import repository.DatabaseOperation;
import service.AccountDataStatus;

import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountOperation  {

    private static final DatabaseOperation dbo=new DatabaseOperation();
    public static String newRegularUser(String username,String password,String email){
                if(Validator.validateData(username,password,email).equals(AccountDataStatus.VALID)){

                    dbo.insertUserAccount(new VacaySeeker(username,email,password));
                    return "Your account has been created.";
                }

                else{return "Invalid input. Please double check your data.";}
    }
    public static String loginUser(String usernameOrEmail,String password){
             if(dbo.findUserByCredentials(usernameOrEmail, password) != null) {
                 return "You have successfully logged in.";
             }
             else return "Invalid credentials. Please try again.\n You can log in with either your username and email.";
    }
    public static String loginTravelAgency(String usernameOrEmail,String password){
        if(dbo.findTravellingAgencyByCredentials(usernameOrEmail,password).equals(AccountDataStatus.VALID)){
            return "You have successfully logged in.";
        }
        else return "Invalid credentials. Please try again.\n You can log in with either your username and email.";
    }



}
