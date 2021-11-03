import java.util.*;

public class Validation {

    private final String fullnamePattern = "^[\\p{L} .'-]+$";
    private final String yearPattern =  "\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])*";
    private final String leapYrPattern = "^(?:\\d{4}-(?:(?:(?:(?:0[13578]|1[02])-(?:0[1-9]|[1-2][0-9]|3[01]))|(?:(?:0[469]|11)\\/(?:0[1-9]|[1-2][0-9]|30))|(?:02-(?:0[1-9]|1[0-9]|2[0-8]))))|(?:(?:\\d{2}(?:0[48]|[2468][048]|[13579][26]))|(?:(?:[02468][048])|[13579][26])00)-02-29)$";
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

    public boolean validLeap(String birthDate){
        if(!birthDate.matches(leapYrPattern)){
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
        if(!(educationalAttainment.equals("College")||educationalAttainment.equals("High School"))){
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

    public boolean validStatus(String status){
        if(!(status.equals("Enrolled")||status.equals("Graduated")||status.equals("Dropped"))){
            return false;
        }
        return true;
    }

}
