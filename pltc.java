public class pltc {
    private static String courseName; //fixed courseName
    private static String teacher; //fixed teacher - kay isa ra ka instructor sa amo kada course
    private static String[] curriculum; //same rag curriculum sa isa ka course
    //wala pa schedule
    private static double tuition; //fixed na daan ang tuition
    private static float units; //fixed units 
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
