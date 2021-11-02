import java.util.*;
public class Validation {

    private final String fullnamePattern = "^[\\p{L} .'-]+$";
    private final String yearPattern = "\\d{4}-\\d{2}-\\d{2}";
    private final String cpPattern = "^(09|\\+639)\\d{9}$";
    private final String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    int currentYr = Calendar.getInstance().get(Calendar.YEAR);

    public boolean validSurname(String surname){
        if(!surname.matches(fullnamePattern)){
            return false;
        }
        return true;
    }

    public boolean validName(String name){
        if(!name.matches(fullnamePattern)){
            return false;
        }
        return true;
    }

    public boolean validMidName(String middleName){
        if(!middleName.matches(fullnamePattern)){
            return false;
        }
        return true;
    }

    public boolean validBdate(String birthDate){
        if(!birthDate.matches(yearPattern)){
            return false;
        }
        return true;
    }

    public boolean validSex(char sex){
        if(!(sex == 'M' || sex == 'F' || sex == 'X')){
            return false;
        }
        return true;
    }

    public boolean validGraduate(String educationalAttainment){
        if(!(educationalAttainment=="College"||educationalAttainment=="High School")){
            return false;
        }
        return true;
    }

    public boolean validYearGrad(int yearGraduated){
        if(!(yearGraduated<currentYr)){
            return false;
        }
        return true;
    }

    public boolean validPhone(String cpNum){
        if(!(cpNum.matches(cpPattern))){
            return false;
        }
        return true;
    }

    public boolean validEmail(String email){
        if(!(email.matches(emailPattern))){
            return false;
        }
        return true;
    }

    public boolean validSSS(long SSSNum){
        if(!(String.valueOf(SSSNum).length()==10)){
            return false;
        }
        return true;
    }

    public boolean validTIN(long TINNum){
        if(!(String.valueOf(TINNum).length()==12)){
            return false;
        }
        return true;
    }
    
    public boolean validSG(long SGLicense){
        if(!(String.valueOf(SGLicense).length()==10)){
            return false;
        }
        return true;
    }

    public boolean validExpiry(String expiryDate){ 
        if(!expiryDate.matches(yearPattern)){
            return false;
        }
        return true;
    }

    public boolean validSBR(long SBRNum){
        if(!(String.valueOf(SBRNum).length()==12)){
            return false;
        }
        return true;
    }

}
