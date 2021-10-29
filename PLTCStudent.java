public class PLTCStudent extends Student implements Courses.PLTC {
    public static class PLTCStudentBuilder extends Student.DataBuilder<PLTCStudentBuilder> {
        @Override
        public PLTCStudentBuilder getThis() {
            return this;
        };

        public PLTCStudent build() {
            return new PLTCStudent(this);
        }
    }

    private PLTCStudent(PLTCStudentBuilder data) {
        super(data);
    }

    // private static String[] curriculum; //same rag curriculum sa isa ka course
    // private LinkedHashMap<String, Integer> schedule = new LinkedHashMap<String, Integer>(); //not final dle ko sure 
    
    private String status="Enrolled";

    public String getCourse(){
        return courseName;
    }

    public String getTeacher(){
        return teacher;
    }

    // public String[] getCurriculum(){
    //     return curriculum;
    // }

    // public LinkedHashMap<String, Integer> getSchedule(){
    //     return schedule;
    // }

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
