public class BSSCStudent extends Student implements Courses.BSSC {
    private long SSSNum;
    private long TINNum;

    public static class BSSCStudentBuilder extends Student.DataBuilder<BSSCStudentBuilder> {
        private long SSSNum;
        private long TINNum;

        @Override
        public BSSCStudentBuilder getThis() {
            return this;
        };

        public BSSCStudentBuilder withSSSNum(long SSSNum) {
            this.SSSNum = SSSNum;
            return this;
        }

        public BSSCStudentBuilder withTINNum(long TINNum) {
            this.TINNum = TINNum;
            return this;
        }

        public BSSCStudent build() {
            return new BSSCStudent(this);
        }
    }

    private BSSCStudent(BSSCStudentBuilder data) {
        super(data);
        this.SSSNum = data.SSSNum;
        this.TINNum = data.TINNum;
    }
    
    // private final String[] curriculum; //same rag curriculum sa isa ka course
    // private LinkedHashMap<String, Integer> schedule = new LinkedHashMap<String, Integer>(); //not final dle ko sure 
    
    private String status="Enrolled";

    public String getCourse(){
        return courseName;
    }

    public String getTeacher(){
        return teacher;
    }

    public long getSSSNum() {
        return SSSNum;
    }

    public long getTINNum() {
        return TINNum;
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
