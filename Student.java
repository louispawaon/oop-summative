import java.util.*;
import java.time.*;
import java.text.*;

public class Student {
    private int studentNum=0;
    private String name;
    private String birthDate;
    private char sex;
    private Period age;
    private String educationalAttainment;
    private int yearGraduated;
    private String cpNum;
    private String email;
    private long SSSNum;
    private long TINNum;
    private String SGLicense;
    private String expiryDate; 
    private long SBRNum;

/*
    //PLTC
    Student(int studentNum,
    String name,
    String birthDate,
    char sex,
    Period age,
    String educationalAttainment,
    int yearGraduated,
    String cpNum,
    String email)
    {
        this.studentNum=studentNum;
        this.name = name;
        this.birthDate=birthDate;
        this.sex=sex;
        this.age=age;
        this.educationalAttainment=educationalAttainment;
        this.yearGraduated=yearGraduated;
        this.cpNum=cpNum;
        this.email=email;
        
    }

    //RTC
    Student(int studentNum,
    String name,
    String birthDate,
    char sex,
    Period age,
    String educationalAttainment,
    int yearGraduated,
    String cpNum,
    String email,
    long SSSNum,
    long TINNum,
    String SGLicense,
    String expiryDate,
    long SBRNum)
    {
        this.studentNum=studentNum;
        this.name = name;
        this.birthDate=birthDate;
        this.sex=sex;
        this.age=age;
        this.educationalAttainment=educationalAttainment;
        this.yearGraduated=yearGraduated;
        this.cpNum=cpNum;
        this.email=email;
        this.SSSNum=SSSNum;
        this.TINNum=TINNum;
        this.SGLicense=SGLicense;
        this.expiryDate=expiryDate;
        this.SBRNum=SBRNum;  
    }

    //BSSC
    Student(int studentNum,
    String name,
    String birthDate,
    char sex,
    Period age,
    String educationalAttainment,
    int yearGraduated,
    String cpNum,
    String email,
    long SSSNum,
    long TINNum
    )
    {
        this.studentNum=studentNum;
        this.name = name;
        this.birthDate=birthDate;
        this.sex=sex;
        this.age=age;
        this.educationalAttainment=educationalAttainment;
        this.yearGraduated=yearGraduated;
        this.cpNum=cpNum;
        this.email=email;
        this.SSSNum=SSSNum;
        this.TINNum=TINNum;    
    }

*/
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

    public long getSSSNum(){
        return SSSNum;
    }

    public long getTINNum(){
        return TINNum;
    }

    public String getSGLicense(){
        return SGLicense;
    }

    public String getExpiryDate(){
        return expiryDate;
    }

    public long getSBRNum(){
        return SBRNum;
    }

}
