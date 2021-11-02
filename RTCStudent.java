public class RTCStudent extends Student implements Courses.RTC {
    private long SSSNum;
    private long TINNum;
    private long SGLicense;
    private String expiryDate; 
    private long SBRNum;
    private String status="Enrolled";

    public static class RTCStudentBuilder extends Student.DataBuilder<RTCStudentBuilder> {
        private long SSSNum;
        private long TINNum;
        private long SGLicense;
        private String expiryDate; 
        private long SBRNum;
        private String status="Enrolled";

        @Override
        public RTCStudentBuilder getThis() {
            return this;
        };

        public RTCStudentBuilder withSSSNum(long SSSNum) {
            this.SSSNum = SSSNum;
            return this;
        }

        public RTCStudentBuilder withTINNum(long TINNum) {
            this.TINNum = TINNum;
            return this;
        }

        public RTCStudentBuilder withSGLicenseAndExpiry(long SGLicense, String expiryDate) {
            this.SGLicense = SGLicense;
            this.expiryDate = expiryDate;
            return this;
        }

        public RTCStudentBuilder withSBRNum(long SBRNum) {
            this.SBRNum = SBRNum;
            return this;
        }

        public RTCStudentBuilder withStatus(String status){
            this.status=status;
            return this;
        }

        public RTCStudent build() {
            return new RTCStudent(this);
        }
    }

    private RTCStudent(RTCStudentBuilder data) {
        super(data);
        this.SSSNum = data.SSSNum;
        this.TINNum = data.TINNum;
        this.SGLicense = data.SGLicense;
        this.expiryDate = data.expiryDate;
        this.SBRNum = data.SBRNum;
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

    public long getSGLicense() {
        return SGLicense;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public long getSBRNum() {
        return SBRNum;
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

    public void setSGLicenseAndExpiry(long SGLicense, String expiryDate) {
        this.SGLicense = SGLicense;
        this.expiryDate = expiryDate;
    }

    public void setSBRNum(long SBRNum) {
        this.SBRNum = SBRNum;
    }
}
