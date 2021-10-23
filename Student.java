import java.util.*;
import java.time.*;
import java.text.*;

public class Student {
    private int studentNum=0;
    private String surname;
    private String name;
    private String middleName;
    private String birthDate;
    private char sex;
    private Period age;
    private String educationalAttainment;
    private int yearGraduated;
    private String cpNum;
    private String email;
    private long SSSNum;
    private long TINNum;
    private long SGLicense;
    private String expiryDate; 
    private long SBRNum;
    private String status;

    public Student(
    List<Object> data)
    {
        this.surname = data.get(0).toString();
        this.name = data.get(1).toString();
        this.middleName = data.get(2).toString();
        this.birthDate = data.get(3).toString();
        this.sex = data.get(4).toString().charAt(0);
        this.educationalAttainment = data.get(5).toString();
        this.yearGraduated = Integer.parseInt(data.get(6).toString());
        this.cpNum = data.get(7).toString();
        this.email = data.get(8).toString();

        if (data.size() >  9) {
            this.SSSNum = Long.valueOf(data.get(9).toString());
            this.TINNum = Long.valueOf(data.get(10).toString());
        }

        if (data.size() > 11) {
            this.SGLicense = Long.valueOf(data.get(11).toString());
            this.expiryDate =data.get(12).toString();
            this.SBRNum = Long.valueOf(data.get(13).toString());  
        }
    }

    public int getStudentNum(){
        return studentNum;
    }

    public void setStudentNum(){
        studentNum+=1; //test 
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getMiddleName(){
        return this.middleName;
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
        return this.sex;
    }

    public String getEducationalAttainment(){
        return this.educationalAttainment;
    }

    public int getYearGraduated(){
        return this.yearGraduated;
    }

    public String getCPNum(){
        return this.cpNum;
    }

    public String getEmail(){
        return this.email;
    }

    public long getSSSNum(){
        return this.SSSNum;
    }

    public long getTINNum(){
        return this.TINNum;
    }

    public long getSGLicense(){
        return this.SGLicense;
    }

    public String getExpiryDate(){
        return this.expiryDate;
    }

    public long getSBRNum(){
        return this.SBRNum;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }

}
