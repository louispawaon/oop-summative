public class rtc {
    private static String courseName = "RTC"; //fixed courseName
    private static String teacher = "Mrs. Delapacojama Pawaon"; //fixed teacher - kay isa ra ka instructor sa amo kada course
    private static String[] curriculum; //same rag curriculum sa isa ka course
    //wala pa schedule
    private static double tuition = 6000.00; //fixed na daan ang tuition
    private static float units = 3; //fixed units 
    private String[] classmates;

    private String getCourse(){
        return courseName;
    }

    private String getTeacher(){
        return teacher;
    }

    private String[] getCurriculum(){
        return curriculum;
    }

    private double getTuition(){
        return tuition;
    }

    private float getUnits(){
        return units;
    }

    private String[] getClassmates(){
        return classmates;
    }

    
}