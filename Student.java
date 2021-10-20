import java.util.*;
import java.time.*;
import java.text.*;

public class Student {
    private int studentNum=0;
    private String name;
    private String birthDate;//dle pa sure
    private char sex;
    private Period age;
    private String educationalAttainment;
    private int yearGraduated;
    private String cpNum;
    private String email;
    private String SSSNum;
    private String TINNum;
    private String SGLicense;
    private Date expiryDate; //dle pa sure
    private String SBRNum;

    public int getStudentNum(){
        return studentNum;
    }

    public void setStudentNum(){
        studentNum+=1; //test 
    }

    public String getName(){
        return name;
    }

    public Period getAge(){
        return age;
    }

    public void setAge(String bday)throws ParseException{ //test 
        LocalDate today = LocalDate.now();
        SimpleDateFormat format = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
        Date date = format.parse(bday);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH)+1;
        int day=cal.get(Calendar.DATE);
        LocalDate birthday = LocalDate.of(year,month,day);
        age = Period.between(birthday, today);
    }

    public char getSex(){
        return sex;
    }

    public String getEducationalAttainment(){
        return educationalAttainment;
    }

    public int getYearGraduated(){
        return yearGraduated;
    }

    public String getCPNum(){
        return cpNum;
    }

    public String getEmail(){
        return email;
    }

}
