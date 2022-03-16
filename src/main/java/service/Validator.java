package service;

import service.AccountDataStatus;

public class Validator {
    public static AccountDataStatus validateData(String username,String password,String email) {
        if (username == null || username.equals("")) {
            return AccountDataStatus.EMPTY_USERNAME;
        }
        else{if (password == null || password.equals("")) {
            return AccountDataStatus.EMPTY_PASSWORD;
        }
        else{
            if (email == null || email.equals("")) {
                return AccountDataStatus.EMPTY_EMAIL;
            }
            else{
                if (!email.contains("@")) {
                    return AccountDataStatus.NO_AT_ADDRESS_IN_EMAIL;
                }
                else return AccountDataStatus.VALID;
            }
        }
        }
    }
    public static String validateNameOfDestination(String nameOfDestination){
        if(nameOfDestination==null||nameOfDestination.equals("")){
            return "Please provide a name for the destination.";
        }
        else return "OK";
    }

}
