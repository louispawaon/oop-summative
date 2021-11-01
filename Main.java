import java.util.*;
import java.io.*;
/*
    TODO:
        (By Priority)
        - CRU implementation - Update nalang kulang
        - Further Testing Needed
        - Validation
        - Update name variables on Figma
*/
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static final int MAX = 30; // SET MAXIMUM NUMBER OF STUDENTS HERE
    private static int[] idList = new int[MAX];
    public static PLTCStudent[] pltcClass = new PLTCStudent[10];
    public static RTCStudent[] rtcClass = new RTCStudent[10];
    public static BSSCStudent[] bsscClass = new BSSCStudent[10];
    private static WriteReadFile wr = new WriteReadFile();

    private static void ModePrompt() {
        int mode = 0;
        
        // CHOOSE MODE PROMPT
        System.out.println("\n- - - MODES - - -" +
        "\n1 - Check Records" +
        "\n2 - Update Records" +
        "\n3 - Add Student" +
        "\n4 - [EXIT]");

        // INPUT MODE
        do {
            try {
                System.out.print("Choose your mode (1-4): ");
                mode = scanner.nextInt();
                if (mode < 1 || mode > 4)
                    System.out.println("\nEnter a valid choice. Try again!");
            }
            catch (Exception e) {
                mode = -1;
            }
        } while (mode < 1 || mode > 4);

        // SWITCH MODE
        switch (mode) {
            case 1:
                CheckRecords();
                break;
            case 2:
                UpdateRecords();
                break;
            case 3:
                if (idList[idList.length-1] != MAX)
                    AddStudent();
                else
                    System.out.println("\nNO AVAILABLE SLOTS FOR A NEW STUDENT");
                break;
            case 4:
                System.out.println("Thank you for using Security Trainee Information System!");
                System.exit(0);
        }

        ModePrompt();
    }
    
    private static void StudentForm(String courseName, int course) {
        String surname, name, middleName, birthDate, educationalAttainment, cpNum, email, expiryDate;
        char sex;
        int yearGraduated, id;
        long SSSNum, TINNum, SGLicense, SBRNum;

        // SET ID
        id = GetStudentID();
        idList[id-1] = id;

        // PROMPT & INPUT GENERAL DATA REQUIREMENTS
        // surname, name, middleName, birthdate, sex, educationalAttainment, yearGraduated, cpNum, email [9 data]
        System.out.println("- - - STUDENT FORM FOR " + courseName + " - - -");
        System.out.println("> Name ");
        System.out.print("Surname: ");
        surname = scanner.nextLine();
        System.out.print("\nName: ");
        name = scanner.nextLine();
        System.out.print("\nMiddle Name: ");
        middleName = scanner.nextLine();
        System.out.print("\n> Birthdate (YYYY-MM-DD): ");
        birthDate = scanner.nextLine(); // TODO: VERIFY BIRTHDATE
        do {
            System.out.print("\n> Sex (M, F, X (Non-Binary)): ");
            sex = scanner.nextLine().toUpperCase().charAt(0);
        } while (!(sex == 'M' || sex == 'F' || sex == 'X'));
        System.out.print("\n> Educational Attainment: ");
        educationalAttainment = scanner.nextLine();
        System.out.print("\n> Year Graduated: ");
        yearGraduated = scanner.nextInt(); // TODO: VERIFY YEAR GRADUATED
        System.out.print("\n> Cellphone Number: ");
        scanner.nextLine();
        cpNum = scanner.nextLine(); // TODO: VERIFY NUMBER
        System.out.print("\n> E-mail Address: ");
        email = scanner.nextLine(); // TODO: VERIFY EMAIL

        // ADDITIONAL DATA FOR RTC or BSSC
        if (course == 2) { // RTC
            System.out.print("\n- - - REQUIRED DATA FIELDS FOR " + courseName + " - - -");
            System.out.print("\n> SSS Number: "); // TODO: VERIFY SSS
            SSSNum = scanner.nextLong();
            System.out.print("\n> TIN Number: "); // TODO: VERIFY TIN
            TINNum = scanner.nextLong();
            System.out.print("\n> SG License Number: "); // TODO: VERIFY SG
            SGLicense = scanner.nextLong();
            System.out.print("\n> SG License Expiry Date (YYYY-MM-DD): "); // TODO: VERIFY DATE
            scanner.nextLine();
            expiryDate = scanner.nextLine();
            System.out.print("\n> SBR Number: "); // TODO: VERIFY SBR
            SBRNum = scanner.nextLong();

            // CREATE RTC OBJECT
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
            .build();

            for(int i=0;i<rtcClass.length;i++){
                if(rtcClass[i]==null){
                    rtcClass[i]=refresher;
                    break;
                }
            }

            // TODO: (TEST) REMOVE AFTER
            System.out.println("ID: " + refresher.getStudentNum());
            System.out.println("Status: " + refresher.getStatus());
            System.out.println("Surname: " + refresher.getSurname());
            System.out.println("SBR Number: "+ refresher.getSBRNum());
            System.out.println("Course: "+ refresher.getCourse());
        }
        else if (course == 3) { // BSSC
            System.out.print("\n- - - REQUIRED DATA FIELDS FOR " + courseName + " - - -");
            System.out.print("\n> SSS Number: "); // TODO: VERIFY SBR
            SSSNum = scanner.nextLong();
            System.out.print("\n> TIN Number: "); // TODO: VERIFY SBR
            TINNum = scanner.nextLong();

            id = GetStudentID();
            //CREATE BSSC OBJECT
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
            .build();

            for(int i=0;i<bsscClass.length;i++){
                if(bsscClass[i]==null){
                    bsscClass[i]=basic;
                    break;
                }
            }

            // TODO: (TEST) REMOVE AFTER
            System.out.println("ID: " + basic.getStudentNum());
            System.out.println("Status: "+ basic.getStatus());
            System.out.println("Surname: "+ basic.getSurname());
            System.out.println("SSS Number: "+ basic.getSSSNum());
        }
        else { // PLTC
            // CREATE PLTC OBJECT
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
            .build();

            for(int i=0;i<pltcClass.length;i++){
                if(pltcClass[i]==null){
                    pltcClass[i]=prelicense;
                    break;
                }
            }

            // TODO: (TEST) REMOVE AFTER
            System.out.println("ID: " + prelicense.getStudentNum());
            System.out.println("Status: " + prelicense.getStatus());
            System.out.println("Surname: " + prelicense.getSurname());
        }

        // TODO: (Test) Remove later
        for (int i: idList)
            System.out.print(i + ", ");
    }

    private static void CheckRecords() {
        
    }

    private static void UpdateRecords() {

    }

    private static void AddStudent() {
        int course = -1;
        
        // CHOOSE COURSE PROMPT
        System.out.println("\n- - - COURSES OFFERED - - -" +
        "\n1 - Pre-Licensing Training Course (PLTC)" +
        "\n2 - Refresher Training Course (RTC)" +
        "\n3 - Basic Security Supervisory Course (BSSC)" +
        "\n4 - [BACK]");

        // INPUT COURSE
        do {
            try {
                System.out.print("Course (1-4): ");
                course = scanner.nextInt();
                if (course < 1 || course > 4)
                    System.out.println("\nEnter a valid choice. Try again!");
            }
            catch (Exception e) {
                course = -1;
            }
        } while (course < 1 || course > 4);

        scanner.nextLine();

        // SWITCH COURSE DATA REQUIREMENTS
        switch (course) {
            case 1:
                StudentForm("Pre-Licensing Training Course (PLTC)", course);
                wr.writePLTC(pltcClass);
                break;
            case 2:
                StudentForm("Refresher Training Course (RTC)", course);
                wr.writeRTC(rtcClass);
                break;
            case 3:
                StudentForm("Basic Security Supervisory Course (BSSC)", course);
                wr.writeBSSC(bsscClass);
                break;
            case 4:
                ModePrompt();
                break;
        }
    }

    private static int GetStudentID() {
        for (int i = 0; i < idList.length; i++) {
            if (idList[i] == 0) {
                return i + 1;
            }
        }
        return 30;
    }
    public static void main(String[] args) {

        //INITIALIZATION - READING CSV FILES
        wr.readPLTC();
        wr.readRTC();
        wr.readBSSC();

        // WELCOME MESSAGE
        System.out.println("Welcome to the Security Trainee Information System!");
        
        // ASK FOR MODE
        ModePrompt();

        scanner.close();
    }
}

/*Contents sa Security Trainee Information System
- 3 Courses to Apply (PLTC, RTC, BSSC) 
    - PLTC (Pre-Licensing Training Course) for aspiring guards 
    - RTC (Refresher Training Course) for renewing guards
    - BSSC (Basic Security Supervisory Course) for security officers (Lahi ang Security Guard ug Security Officer)
- Name
- Age
- Gender
- Highest Educational Attainment
    - Year of Graduation
- Contact Number
- Email Address

IF COURSE CHOICE = RTC OR BSSC:
    - SSS Number
    - TIN Number
    - SG License Number (For RTC Trainees Only)
        - Expiry Date of SG License Number
    - SBR Number (For RTC Trainees Only)
*/