import java.util.*;
import java.time.*;
import java.text.*;

public class Validation {

    private final String fullnamePattern = "^[\\p{L} .'-]+$";
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
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);

        try {
          sdf.parse(birthDate);

          int currentYear = Year.now().getValue();
          String str[] = birthDate.split("-");
          int year = Integer.parseInt(str[0]);

          if(year > currentYear || year < currentYear-100){
            return false; 
          }

        } catch (NumberFormatException | ParseException ex){
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
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);

        try {
          sdf.parse(expiryDate);

          int currentYear = Year.now().getValue();
          String str[] = expiryDate.split("-");
          int year = Integer.parseInt(str[0]);

          if(year < currentYear-100){
            return false; 
          }

        } catch (NumberFormatException | ParseException ex){
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
