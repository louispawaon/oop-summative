import java.util.Scanner;
/*
    TODO:
        (By Priority)
        - bago kay i run sa ang "rm *.class" sa terminal para mawala tanan class files
        - test bssc, rtc, pltc kay katulugon na ko wala pa nako natarong ug test (hanapa sa todo ang (TEST) na keyword)
        - Complete functions on courses class kay ang pag pass lang sa data akong gi fix. wala ko kabalo if 
            kulang ba ang method na naka declare each courses na class
        - ID implementation
        - Find Polymorphism kay wala ko kabalo kung naka implement ba ang polymorphism sa bago na code
        - CRU implementation
        - Validation
        - Update name variables on Figma
*/
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static void ModePrompt() {
        int mode = 0;
        
        // CHOOSE MODE PROMPT
        System.out.println("\n- - - MODES - - -" +
        "\n1 - Check Records" +
        "\n2 - Update Records" +
        "\n3 - Add Student");

        // INPUT MODE
        do {
            try {
                System.out.print("Choose your mode (1-3): ");
                mode = scanner.nextInt();
                if (mode < 1 || mode > 3)
                    System.out.println("\nEnter a valid choice. Try again!");
            }
            catch (Exception e) {
                mode = -1;
            }
        } while (mode < 1 || mode > 3);

        // SWITCH MODE
        switch (mode) {
            case 1:
                CheckRecords();
                break;
            case 2:
                UpdateRecords();
                break;
            case 3:
                AddStudent();
                break;
        }
    }
    
    private static void StudentForm(String courseName, int course) {
        String surname, name, middleName, birthDate, educationalAttainment, cpNum, email, expiryDate;
        char sex;
        int yearGraduated;
        long SSSNum, TINNum, SGLicense, SBRNum;

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

            // TODO: (TEST) REMOVE AFTER
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

            //CREATE BSSC OBJECT
            BSSCStudent basic = new BSSCStudent.BSSCStudentBuilder()
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

            // TODO: (TEST) REMOVE AFTER
            System.out.println("Status: "+ basic.getStatus());
            System.out.println("Surname: "+ basic.getSurname());
            System.out.println("SSS Number: "+ basic.getSSSNum());
        }
        else { // PLTC
            // CREATE PLTC OBJECT
            PLTCStudent prelicense = new PLTCStudent.PLTCStudentBuilder()
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

            // TODO: (TEST) REMOVE AFTER
            System.out.println("Status: " + prelicense.getStatus());
            System.out.println("Surname: " + prelicense.getSurname());
        }
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
                break;
            case 2:
                StudentForm("Refresher Training Course (RTC)", course);
                break;
            case 3:
                StudentForm("Basic Security Supervisory Course (BSSC)", course);
                break;
            case 4:
                ModePrompt();
                break;
        }
    }

    public static void main(String[] args) {
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