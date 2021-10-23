import java.util.*;
public class bssc extends Student{
    public bssc(List<Object> data) {
        super(data);
        //TODO Auto-generated constructor stub
    }
    private static String courseName = "BSSC"; //fixed courseName
    private static String teacher = "Mr. Rommel Pawaon"; //fixed teacher - kay isa ra ka instructor sa amo kada course
    private static String[] curriculum; //same rag curriculum sa isa ka course
    private LinkedHashMap<String, Integer> schedule = new LinkedHashMap<String, Integer>(); //not final dle ko sure 
    private static double tuition = 6000.00; //fixed na daan ang tuition
    private static float units = 3; //fixed units 
    private String status="Enrolled";

    public String getCourse(){
        return courseName;
    }

    public String getTeacher(){
        return teacher;
    }

    public String[] getCurriculum(){
        return curriculum;
    }
    
    public LinkedHashMap<String, Integer> getSchedule(){
        return schedule;
    }

    public double getTuition(){
        return tuition;
    }

    public float getUnits(){
        return units;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }

}
