import java.io.*;
public class WriteReadFile {
    /*TODO:
        - Further Testing for the three classes   
    */

    //VARIABLE DECLARATION
    private String surname, name, middleName, birthDate, educationalAttainment, cpNum, email, expiryDate,status;
    private char sex;
    private int yearGraduated, id;
    private long SSSNum, TINNum, SGLicense, SBRNum;

    //PLTC STUDENT WRITER
    public void writePLTC(PLTCStudent[] pltcClass){
        try {
            BufferedWriter preLi = new BufferedWriter(new FileWriter("PLTC.csv", false));
            StringBuilder sb = new StringBuilder();
            for(int x=0;x<pltcClass.length;x++){
                if(pltcClass[x]!=null){
                    sb.append(pltcClass[x].getStudentNum());
                    sb.append(",");
                    sb.append(pltcClass[x].getSurname());
                    sb.append(",");
                    sb.append(pltcClass[x].getName());
                    sb.append(",");
                    sb.append(pltcClass[x].getMiddleName());
                    sb.append(",");
                    sb.append(pltcClass[x].getBirthdate());
                    sb.append(",");
                    sb.append(pltcClass[x].getSex());
                    sb.append(",");
                    sb.append(pltcClass[x].getEducationalAttainment());
                    sb.append(",");
                    sb.append(pltcClass[x].getYearGraduated());
                    sb.append(",");
                    sb.append(pltcClass[x].getCPNum());
                    sb.append(",");
                    sb.append(pltcClass[x].getEmail());
                    sb.append(",");
                    sb.append(pltcClass[x].getStatus());
                    sb.append("\n");
                }
                
            }
            preLi.write(sb.toString());
            preLi.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //PLTC STUDENT READER
    public void readPLTC(){
        String[] fromfile={};
        try{
            BufferedReader br = new BufferedReader(new FileReader("PLTC.csv"));
            String line;
            while((line=br.readLine())!=null){
                fromfile = line.split(",");

                //VARIABLE ASSIGNMENT
                id = Integer.parseInt(fromfile[0]);
                surname = fromfile[1];
                name = fromfile[2];
                middleName = fromfile[3];
                birthDate = fromfile[4];
                sex = fromfile[5].charAt(0);
                educationalAttainment = fromfile[6];
                yearGraduated = Integer.parseInt(fromfile[7]);
                cpNum = fromfile[8];
                email = fromfile[9];
                status = fromfile[10];
                

                //BUILDER TIME
                PLTCStudent prelicense = new PLTCStudent.PLTCStudentBuilder()
                .withID(id)
                .withSurname(surname)
                .withName(name)
                .withMiddleName(middleName)
                .withBirthdate(birthDate)
                .withSex(sex)
                .withEducationalAttainment(educationalAttainment)
                .withYearGraduated(yearGraduated)
                .withCPNum(cpNum)
                .withEmail(email)
                .withStatus(status)
                .build();

                for(int i=0;i<Main.pltcClass.length;i++){
                    if (Main.pltcClass[i] != null && prelicense.getStudentNum() == Main.pltcClass[i].getStudentNum()) {
                        Main.pltcClass[i] = prelicense;
                        break;
                    }
                    if(Main.pltcClass[i]==null){
                        Main.pltcClass[i]=prelicense;
                        break;
                    }
                }

                // ADD TO idList
                id = prelicense.getStudentNum();
                Main.idList[id-1] = id;
            }
            br.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    //RTC STUDENT WRITER
    public void writeRTC(RTCStudent[] rtcClass){
        try {
            BufferedWriter retrain = new BufferedWriter(new FileWriter("RTC.csv", false));
            StringBuilder sb = new StringBuilder();
            for(int x=0;x<rtcClass.length;x++){
                if(rtcClass[x]!=null){
                    sb.append(rtcClass[x].getStudentNum());
                    sb.append(",");
                    sb.append(rtcClass[x].getSurname());
                    sb.append(",");
                    sb.append(rtcClass[x].getName());
                    sb.append(",");
                    sb.append(rtcClass[x].getMiddleName());
                    sb.append(",");
                    sb.append(rtcClass[x].getBirthdate());
                    sb.append(",");
                    sb.append(rtcClass[x].getSex());
                    sb.append(",");
                    sb.append(rtcClass[x].getEducationalAttainment());
                    sb.append(",");
                    sb.append(rtcClass[x].getYearGraduated());
                    sb.append(",");
                    sb.append(rtcClass[x].getCPNum());
                    sb.append(",");
                    sb.append(rtcClass[x].getEmail());
                    sb.append(",");
                    sb.append(rtcClass[x].getSSSNum());
                    sb.append(",");
                    sb.append(rtcClass[x].getTINNum());
                    sb.append(",");
                    sb.append(rtcClass[x].getSGLicense());
                    sb.append(",");
                    sb.append(rtcClass[x].getExpiryDate());
                    sb.append(",");
                    sb.append(rtcClass[x].getSBRNum());
                    sb.append(",");
                    sb.append(rtcClass[x].getStatus());
                    sb.append("\n");
                }
                
            }
            retrain.write(sb.toString());
            retrain.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //RTC STUDENT READER
    public void readRTC(){
        String[] fromfile={};
        try{
            BufferedReader br = new BufferedReader(new FileReader("RTC.csv"));
            String line;
            while((line=br.readLine())!=null){
                fromfile = line.split(",");

                //VARIABLE ASSIGNMENT
                id = Integer.parseInt(fromfile[0]);
                surname = fromfile[1];
                name = fromfile[2];
                middleName = fromfile[3];
                birthDate = fromfile[4];
                sex = fromfile[5].charAt(0);
                educationalAttainment = fromfile[6];
                yearGraduated = Integer.parseInt(fromfile[7]);
                cpNum = fromfile[8];
                email = fromfile[9];
                SSSNum = Long.parseLong(fromfile[10]);
                TINNum = Long.parseLong(fromfile[11]);
                SGLicense = Long.parseLong(fromfile[12]);
                expiryDate = fromfile[13];
                SBRNum = Long.parseLong(fromfile[14]);
                status = fromfile[15];

                //BUILDER TIME
                RTCStudent refresher = new RTCStudent.RTCStudentBuilder()
                .withID(id)
                .withSurname(surname)
                .withName(name)
                .withMiddleName(middleName)
                .withBirthdate(birthDate)
                .withSex(sex)
                .withEducationalAttainment(educationalAttainment)
                .withYearGraduated(yearGraduated)
                .withCPNum(cpNum)
                .withEmail(email)
                .withSSSNum(SSSNum)
                .withTINNum(TINNum)
                .withSGLicenseAndExpiry(SGLicense, expiryDate)
                .withSBRNum(SBRNum)
                .withStatus(status)
                .build();

                for(int i=0;i<Main.rtcClass.length;i++){
                    if (Main.rtcClass[i] != null && refresher.getStudentNum() == Main.rtcClass[i].getStudentNum()) {
                        Main.rtcClass[i] = refresher;
                        break;
                    }
                    else if(Main.rtcClass[i]==null){
                        Main.rtcClass[i]=refresher;
                        break;
                    }
                }

                // ADD TO idList
                id = refresher.getStudentNum();
                Main.idList[id-1] = id;
            }
            br.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    //BSSC STUDENT WRITER
    public void writeBSSC(BSSCStudent[] bsscClass){
        try {
            BufferedWriter retrain = new BufferedWriter(new FileWriter("BSSC.csv", false));
            StringBuilder sb = new StringBuilder();
            for(int x=0;x<bsscClass.length;x++){
                if(bsscClass[x]!=null){
                    sb.append(bsscClass[x].getStudentNum());
                    sb.append(",");
                    sb.append(bsscClass[x].getSurname());
                    sb.append(",");
                    sb.append(bsscClass[x].getName());
                    sb.append(",");
                    sb.append(bsscClass[x].getMiddleName());
                    sb.append(",");
                    sb.append(bsscClass[x].getBirthdate());
                    sb.append(",");
                    sb.append(bsscClass[x].getSex());
                    sb.append(",");
                    sb.append(bsscClass[x].getEducationalAttainment());
                    sb.append(",");
                    sb.append(bsscClass[x].getYearGraduated());
                    sb.append(",");
                    sb.append(bsscClass[x].getCPNum());
                    sb.append(",");
                    sb.append(bsscClass[x].getEmail());
                    sb.append(",");
                    sb.append(bsscClass[x].getSSSNum());
                    sb.append(",");
                    sb.append(bsscClass[x].getTINNum());
                    sb.append(",");
                    sb.append(bsscClass[x].getStatus());
                    sb.append("\n");
                }  
            }
            retrain.write(sb.toString());
            retrain.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //BSSC STUDENT READER
    public void readBSSC(){
        String[] fromfile={};
        try{
            BufferedReader br = new BufferedReader(new FileReader("BSSC.csv"));
            String line;
            while((line=br.readLine())!=null){
                fromfile = line.split(",");

                //VARIABLE ASSIGNMENT
                id = Integer.parseInt(fromfile[0]);
                surname = fromfile[1];
                name = fromfile[2];
                middleName = fromfile[3];
                birthDate = fromfile[4];
                sex = fromfile[5].charAt(0);
                educationalAttainment = fromfile[6];
                yearGraduated = Integer.parseInt(fromfile[7]);
                cpNum = fromfile[8];
                email = fromfile[9];
                SSSNum = Long.parseLong(fromfile[10]);
                TINNum = Long.parseLong(fromfile[11]);
                status = fromfile[12];

                //BUILDER TIME
                BSSCStudent basic = new BSSCStudent.BSSCStudentBuilder()
                .withID(id)
                .withSurname(surname)
                .withName(name)
                .withMiddleName(middleName)
                .withBirthdate(birthDate)
                .withSex(sex)
                .withEducationalAttainment(educationalAttainment)
                .withYearGraduated(yearGraduated)
                .withCPNum(cpNum)
                .withEmail(email)
                .withSSSNum(SSSNum)
                .withTINNum(TINNum)
                .withStatus(status)
                .build();

                for(int i=0;i<Main.bsscClass.length;i++){
                    if (Main.bsscClass[i] != null && basic.getStudentNum() == Main.bsscClass[i].getStudentNum()) {
                        Main.bsscClass[i] = basic;
                        break;
                    }
                    else if(Main.bsscClass[i]==null){
                        Main.bsscClass[i]=basic;
                        break;
                    }
                }

                // ADD TO idList
                id = basic.getStudentNum();
                Main.idList[id-1] = id;
            }
            br.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
