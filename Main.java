import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
    TODO:
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
    
    private static void StudentForm(String courseName, int course, List<Object> data) {
        String birthdate;
        char sex;
        int yearGraduated;
        // PROMPT & INPUT GENERAL DATA REQUIREMENTS
        // surname, name, middleName, birthdate, sex, educationalAttainment, yearGraduated, cpNum, email [9 data]
        System.out.println("- - - STUDENT FORM FOR " + courseName + " - - -");
        System.out.println("> Name ");
        System.out.print("Surname: ");
        data.add(scanner.nextLine());
        System.out.print("\nName: ");
        data.add(scanner.nextLine());
        System.out.print("\nMiddle Name: ");
        data.add(scanner.nextLine());
        System.out.print("\n> Birthdate (YYYY-MM-DD): ");
        birthdate = scanner.nextLine(); // TODO: VERIFY BIRTHDATE
        data.add(birthdate);
        do {
            System.out.print("\n> Sex (M, F, X (Non-Binary)): ");
            sex = scanner.nextLine().toUpperCase().charAt(0);
        } while (!(sex == 'M' || sex == 'F' || sex == 'X'));
        data.add(sex);
        System.out.print("\n> Educational Attainment: ");
        data.add(scanner.nextLine());
        System.out.print("\n> Year Graduated: ");
        yearGraduated = scanner.nextInt(); // TODO: VERIFY YEAR GRADUATED
        data.add(yearGraduated);
        System.out.print("\n> Cellphone Number: ");
        scanner.nextLine();
        data.add(scanner.nextLine()); // TODO: VERIFY NUMBER
        System.out.print("\n> E-mail Address: ");
        data.add(scanner.nextLine()); // TODO: VERIFY EMAIL

        // ADDITIONAL DATA FOR RTC or BSSC
        if (course == 2) { // RTC
            System.out.print("\n- - - REQUIRED DATA FIELDS FOR " + courseName + " - - -");
            System.out.print("\n> SSS Number: "); // TODO: VERIFY SSS
            data.add(scanner.nextLong());
            System.out.print("\n> TIN Number: "); // TODO: VERIFY TIN
            data.add(scanner.nextLong());
            System.out.print("\n> SG License Number: "); // TODO: VERIFY SG
            data.add(scanner.nextLong());
            System.out.print("\n> SG License Expiry Date (YYYY-MM-DD): "); // TODO: VERIFY DATE
            scanner.nextLine();
            data.add(scanner.nextLine());
            System.out.print("\n> SBR Number: "); // TODO: VERIFY SBR
            data.add(scanner.nextLong());
        }
        else if (course == 3) { // BSSC
            System.out.print("\n- - - REQUIRED DATA FIELDS FOR " + courseName + " - - -");
            System.out.print("\n> SSS Number: "); // TODO: VERIFY SBR
            data.add(scanner.nextLong());
            System.out.print("\n> TIN Number: "); // TODO: VERIFY SBR
            data.add(scanner.nextLong());
            scanner.nextLine();
        }
    }

    private static void CheckRecords() {

    }

    private static void UpdateRecords() {

    }

    private static void AddStudent() {
        int course = -1;

        // I used Object class so I can store different data types into one list
        List<Object> data = new ArrayList<Object>();
        
        
        
        
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
                StudentForm("Pre-Licensing Training Course (PLTC)", course, data);
                Student prelicense = new pltc(data);
                System.out.println("Status: "+prelicense.getStatus());
                System.out.println("Surname: "+prelicense.getSurname());
                break;
            case 2:
                StudentForm("Refresher Training Course (RTC)", course, data);
                Student refresher = new rtc(data);
                System.out.println("Status: "+refresher.getStatus());
                System.out.println("Surname: "+refresher.getSurname());
                break;
            case 3:
                StudentForm("Basic Security Supervisory Course (BSSC)", course, data);
                Student basic = new bssc(data);
                System.out.println("Status: "+basic.getStatus());
                System.out.println("Surname: "+basic.getSurname());
                break;
            case 4:
                ModePrompt();
                break;
        }

        // CHECK IF data IS EMPTY
        if (data.isEmpty() == false) {
            // new STUDENT and add it to current student list
            // TODO: student list
            // TODO: REMOVE DISPLAY
            System.out.println("Size: " + data.size()); // FOR MY GUIDE ONLY
            String[] dataVariables = {"surname", "name", "middleName", "birthdate", "sex", "educationalAttainment", "yearGraduated", "cpNum", "email", "sssNum", "tinNum", "sgLicense", "sgLicenseExpiryDate", "sbrNum"};
            for (int i = 0; i < data.size(); i++) {
                System.out.println(i + " " + data.get(i).getClass() + " " + dataVariables[i] + ": " + data.get(i));
            }
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