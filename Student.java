import java.util.*;
import java.time.*;
import java.text.*;

public class Student {

    // NOT INPUTS
    private Period age;
    private String status;

    // ARGUMENTS
    private int id;
    private String surname;
    private String name;
    private String middleName;
    private String birthDate;
    private char sex;
    private String educationalAttainment;
    private int yearGraduated;
    private String cpNum;
    private String email;

    public abstract static class DataBuilder<T extends DataBuilder<T>> {
        private int id;
        private String surname;
        private String name;
        private String middleName;
        private String birthDate;
        private char sex;
        private String educationalAttainment;
        private int yearGraduated;
        private String cpNum;
        private String email;

        public abstract T getThis();

        public DataBuilder() {}

        public T withID(int id) {
            this.id = id;
            return getThis();
        }

        public T withSurname(String surname) {
            this.surname = surname;
            return getThis();
        }

        public T withName(String name) {
            this.name = name;
            return getThis();
        }

        public T withMiddleName(String middleName) {
            this.middleName = middleName;
            return getThis();
        }

        public T withBirthdate(String birthDate) {
            this.birthDate = birthDate;
            return getThis();
        }

        public T withSex(char sex) {
            this.sex = sex;
            return getThis();
        }

        public T withEducationalAttainment(String educationalAttainment) {
            this.educationalAttainment = educationalAttainment;
            return getThis();
        }

        public T withYearGraduated(int yearGraduated) {
            this.yearGraduated = yearGraduated;
            return getThis();
        }

        public T withCPNum(String cpNum) {
            this.cpNum = cpNum;
            return getThis();
        }

        public T withEmail(String email) {
            this.email = email;
            return getThis();
        }
        
        public Student build() {
            return new Student(this);
        }
    }

    public Student(DataBuilder<?> data) {
        this.id = data.id;
        this.surname = data.surname;
        this.name = data.name;
        this.middleName = data.middleName;
        this.birthDate = data.birthDate;
        this.sex = data.sex;
        this.educationalAttainment = data.educationalAttainment;
        this.yearGraduated = data.yearGraduated;
        this.cpNum = data.cpNum;
        this.email = data.email;
    }

    public int getStudentNum(){
        return id;
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

    public String getBirthdate(){
        return this.birthDate;
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

    //TODO: CHANGE TO WORDS
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

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }

    @Override
    public String toString() {
        return surname.toUpperCase() + ", " + name.toUpperCase() + " " + middleName.toUpperCase();
    }

    // SET METHODS
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setBirthdate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setEducationalAttainment(String educationalAttainment) {
        this.educationalAttainment = educationalAttainment;
    }

    public void setYearGraduated(int yearGraduated) {
        this.yearGraduated = yearGraduated;
    }

    public void setCPNum(String cpNum) {
        this.cpNum = cpNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
