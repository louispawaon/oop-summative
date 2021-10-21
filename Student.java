import java.util.*;
import java.time.*;
import java.text.*;


//If ma decide na i long ang SSSNUm -> SBRNum isntead na string i change lang 

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
    private String expiryDate; 
    private String SBRNum;

    //PLTC
    Student(int studentNum,
    String name,
    String birthDate,
    char sex,
    Period age,
    String educationalAttainment,
    int yearGraduate,
    String cpNum,
    String email)
    {
        
        
    }

    //RTC
    Student(int studentNum,
    String name,
    String birthDate,
    char sex,
    Period age,
    String educationalAttainment,
    int yearGraduate,
    String cpNum,
    String email,
    String SSSNum,
    String TINNum,
    String SGLicense,
    String expiryDat,
    String SBRNum)
    {
        
        
    }

    //BSSC
    Student(int studentNum,
    String name,
    String birthDate,
    char sex,
    Period age,
    String educationalAttainment,
    int yearGraduate,
    String cpNum,
    String email,
    String SSSNum,
    String TINNum
    )
    {
        
        
    }


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

    public void setAge()throws ParseException{ //test 
        LocalDate today = LocalDate.now();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse(birthDate);
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

    public String getSSSNum(){
        return SSSNum;
    }

    public String getTINNum(){
        return TINNum;
    }

    public String getSGLicense(){
        return SGLicense;
    }

    public String getExpiryDate(){
        return expiryDate;
    }

    public String getSBRNum(){
        return SBRNum;
    }

}
