public class BSSCStudent extends Student implements Courses.BSSC {
    private long SSSNum;
    private long TINNum;
    private String status="Enrolled";

    public static class BSSCStudentBuilder extends Student.DataBuilder<BSSCStudentBuilder> {
        private long SSSNum;
        private long TINNum;
        private String status="Enrolled";

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

        public BSSCStudentBuilder withStatus(String status){
            this.status=status;
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
        this.status = data.status;
    }

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

    public double getTuition(){
        return tuition;
    }

    public float getUnits(){
        return units;
    }

    public String getStatus(){
        return status;
    }

    // SET METHODS
    public void setStatus(String status){
        this.status = status;
    }

    public void setSSSNum(long SSSNum) {
        this.SSSNum = SSSNum;
    }

    public void setTINNum(long TINNum) {
        this.TINNum = TINNum;
    }
}
