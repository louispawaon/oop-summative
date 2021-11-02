public class PLTCStudent extends Student implements Courses.PLTC {
    private String status="Enrolled";
    public static class PLTCStudentBuilder extends Student.DataBuilder<PLTCStudentBuilder> {
        private String status="Enrolled";
        
        @Override
        public PLTCStudentBuilder getThis() {
            return this;
        };

        public PLTCStudent build() {
            return new PLTCStudent(this);
        }

        public PLTCStudentBuilder withStatus(String status){
            this.status=status;
            return this;
        }
    }

    private PLTCStudent(PLTCStudentBuilder data) {
        super(data);
        this.status = data.status;
    }

    public String getCourse(){
        return courseName;
    }

    public String getTeacher(){
        return teacher;
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
    public void setStatus(String status) {
        this.status = status;
    }
}
