import java.util.*;
/*
    TODO:
        (By Priority)
        - Age not working
        - FURTHER TESTING bc i did not test it well sa update
        - Validation
        - Update name variables on Figma
*/
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static final int MAX = 30; // SET MAXIMUM NUMBER OF STUDENTS HERE
    public static int[] idList = new int[MAX];
    public static PLTCStudent[] pltcClass = new PLTCStudent[10];
    public static RTCStudent[] rtcClass = new RTCStudent[10];
    public static BSSCStudent[] bsscClass = new BSSCStudent[10];
    private static WriteReadFile wr = new WriteReadFile();
    private static int currentCourse, currentIndex; // KEYS

    private static void ModePrompt() {
        int mode = 0;
        int id = -1;
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
                mode = Integer.parseInt(scanner.nextLine());
                if (mode < 1 || mode > 4)
                    System.out.println("\nEnter a valid choice. Try again!");
            }
            catch (Exception e) {
                System.out.println("\nEnter a valid choice. Try again!");
                mode = -1;
            }
        } while (mode < 1 || mode > 4);

        // SWITCH MODE
        switch (mode) {
            case 1:
                DisplayStudents();
                System.out.print("\n> CHECK Student Records\nEnter ID: ");
                id = scanner.nextInt(); // TODO: VALIDATION
                scanner.nextLine();
                CheckRecords(id);
                break;
            case 2:
                DisplayStudents();
                System.out.print("\n> UPDATE Student Records\nEnter ID: ");
                id = scanner.nextInt(); // TODO: VALIDATION
                scanner.nextLine();
                UpdateRecords(id);
                break;
            case 3:
                if (idList[idList.length-1] != MAX)
                    AddStudent();
                else
                    System.out.println("\nNO AVAILABLE SLOTS FOR A NEW STUDENT");
                break;
            case 4:
                System.out.println("\nThank you for using Security Trainee Information System!");
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

    private static void DisplayStudents() {
        System.out.println("\n- - - Pre-Licensing Training Course Students - - -");
        for (PLTCStudent student: pltcClass) {
            if (student != null) {
                System.out.println("ID: " + student.getStudentNum() + " - " + student.toString());
            }
        }

        System.out.println("\n- - - Refresher Training Course - - -");
        for (RTCStudent student: rtcClass) {
            if (student != null) {
                System.out.println("ID: " + student.getStudentNum() + " - " + student.toString());
            }
        }

        System.out.println("\n- - - Basic Security Supervisory Course - - -");
        for (BSSCStudent student: bsscClass) {
            if (student != null) {
                System.out.println("ID: " + student.getStudentNum() + " - " + student.toString());
            }
        }
    }

    private static void CheckRecords(int id) {
        //LOCATE STUDENT BY ID
        for (int i = 0; i < pltcClass.length; i++) {
            if (pltcClass[i] != null) {
                if (pltcClass[i].getStudentNum() == id) {
                    System.out.println("\n- - - STUDENT DATA - - -" +
                    "\n> Status: " + pltcClass[i].getStatus() +
                    "\n> Student ID: " + id +
                    "\n> Name: " + pltcClass[i].toString() +
                    "\n> Birthday: " + pltcClass[i].getBirthdate() +
                    "\n> Age: " + pltcClass[i].getAge() +
                    "\n> Sex: " + pltcClass[i].getSex() +
                    "\n> Educational Attainment: " + pltcClass[i].getEducationalAttainment() +
                    "\n> Year Graduated: " + pltcClass[i].getYearGraduated() +
                    "\n> Cellphone Number: " + pltcClass[i].getCPNum() +
                    "\n> Email Address: " + pltcClass[i].getEmail() +
                    "\n\n- - - COURSE DATA - - -" +
                    "\n> Current Course: " + pltcClass[i].getCourse() +
                    "\n> Teacher: " + pltcClass[i].getTeacher() +
                    "\n> Units: " + pltcClass[i].getUnits() +
                    "\n> Tuition: " + pltcClass[i].getTuition()
                    );
                    currentCourse = 1;
                    currentIndex = i;
                    return;
                }
            }
        }

        for (int i = 0; i < rtcClass.length; i++) {
            if (rtcClass[i] != null) {
                if (rtcClass[i].getStudentNum() == id) {
                    System.out.println("\n- - - STUDENT DATA - - -" +
                    "\n> Status: " + rtcClass[i].getStatus() +
                    "\n> Student ID: " + id +
                    "\n> Name: " + rtcClass[i].toString() +
                    "\n> Birthday: " + rtcClass[i].getBirthdate() +
                    "\n> Age: " + rtcClass[i].getAge() +
                    "\n> Sex: " + rtcClass[i].getSex() +
                    "\n> Educational Attainment: " + rtcClass[i].getEducationalAttainment() +
                    "\n> Year Graduated: " + rtcClass[i].getYearGraduated() +
                    "\n> Cellphone Number: " + rtcClass[i].getCPNum() +
                    "\n> Email Address: " + rtcClass[i].getEmail() +
                    "\n> SSS Number: " + rtcClass[i].getSSSNum() +
                    "\n> TIN Number: " + rtcClass[i].getTINNum() + 
                    "\n> Security Guard License: " + rtcClass[i].getSGLicense() +
                    "\n   Expiry Date: " + rtcClass[i].getExpiryDate() +
                    "\n> SBR Number: " + rtcClass[i].getSBRNum() +
                    "\n\n- - - COURSE DATA - - -" +
                    "\n> Current Course: " + rtcClass[i].getCourse() +
                    "\n> Teacher: " + rtcClass[i].getTeacher() +
                    "\n> Units: " + rtcClass[i].getUnits() +
                    "\n> Tuition: " + rtcClass[i].getTuition()
                    );
                    currentCourse = 2;
                    currentIndex = i;
                    return;
                }
            }
        }

        for (int i = 0; i < bsscClass.length; i++) {
            if (bsscClass[i] != null) {
                if (bsscClass[i].getStudentNum() == id) {
                    System.out.println("\n> Status: " + bsscClass[i].getStatus() +
                    "\n> Student ID: " + id +
                    "\n> Name: " + bsscClass[i].toString() +
                    "\n> Birthday: " + bsscClass[i].getBirthdate() +
                    "\n> Age: " + bsscClass[i].getAge() +
                    "\n> Sex: " + bsscClass[i].getSex() +
                    "\n> Educational Attainment: " + bsscClass[i].getEducationalAttainment() +
                    "\n> Year Graduated: " + bsscClass[i].getYearGraduated() +
                    "\n> Cellphone Number: " + bsscClass[i].getCPNum() +
                    "\n> Email Address: " + bsscClass[i].getEmail() +
                    "\n> SSS Number: " + bsscClass[i].getSSSNum() +
                    "\n> TIN Number: " + bsscClass[i].getTINNum() +
                    "\n\n- - - COURSE DATA - - -" +
                    "\n> Current Course: " + bsscClass[i].getCourse() +
                    "\n> Teacher: " + bsscClass[i].getTeacher() +
                    "\n> Units: " + bsscClass[i].getUnits() +
                    "\n> Tuition: " + bsscClass[i].getTuition()
                    );
                    currentCourse = 3;
                    currentIndex = i;
                    return;
                }
            }
        }

        System.out.println("\nSTUDENT WITH ID " + id + " NOT FOUND.");
        currentCourse = -1;

    }

    private static void UpdateRecords(int id) {
        // CALL CHECK RECORDS
        CheckRecords(id);
        int dataField;
        switch(currentCourse) {
            case 1:
                System.out.println("\nUPDATE DATA: ");
                System.out.println("1 - Status" +
                "\n2 - Surname" +
                "\n3 - Name" +
                "\n4 - Middle Name" +
                "\n5 - Birthdate" +
                "\n6 - Sex" +
                "\n7 - Educational Attainment" +
                "\n8 - Year Graduated" +
                "\n9 - Cellphone Number" +
                "\n10 - Email" +
                "\n11 - [BACK]");
        
                do {
                    try {
                        System.out.print("Choose which data to update (1-11): ");
                        dataField = Integer.parseInt(scanner.nextLine());
                        if (dataField < 1 || dataField > 11)
                            System.out.println("\nEnter a valid choice. Try again!");
                        else if (dataField == 11) {
                            ModePrompt(); return;
                        }
                    }
                    catch (Exception e) {
                        System.out.println("\nEnter a valid choice. Try again!");
                        dataField = -1;
                    }
                } while (dataField < 1 || dataField > 11);

                UpdateDataField(dataField, pltcClass[currentIndex]);

                break;
            case 2:
                System.out.println("\nUPDATE DATA: ");
                System.out.println("1 - Status" +
                "\n2 - Surname" +
                "\n3 - Name" +
                "\n4 - Middle Name" +
                "\n5 - Birthdate" +
                "\n6 - Sex" +
                "\n7 - Educational Attainment" +
                "\n8 - Year Graduated" +
                "\n9 - Cellphone Number" +
                "\n10 - Email" +
                "\n11 - SSS Number" +
                "\n12 - TIN Number" +
                "\n13 - Security Guard License Number & Expiry" +
                "\n14 - SBR Number" +
                "\n15 - [BACK]");
        
                do {
                    try {
                        System.out.print("Choose which data to update (1-15): ");
                        dataField = Integer.parseInt(scanner.nextLine());
                        if (dataField < 1 || dataField > 15)
                            System.out.println("\nEnter a valid choice. Try again!");
                        else if (dataField == 15) {
                            ModePrompt(); 
                            return;
                        }
                    }
                    catch (Exception e) {
                        System.out.println("\nEnter a valid choice. Try again!");
                        dataField = -1;
                    }
                } while (dataField < 1 || dataField > 15);

                UpdateDataField(dataField, rtcClass[currentIndex]);

                break;
            case 3:
                System.out.println("\nUPDATE DATA: ");
                System.out.println("1 - Status" +
                "\n2 - Surname" +
                "\n3 - Name" +
                "\n4 - Middle Name" +
                "\n5 - Birthdate" +
                "\n6 - Sex" +
                "\n7 - Educational Attainment" +
                "\n8 - Year Graduated" +
                "\n9 - Cellphone Number" +
                "\n10 - Email" +
                "\n11 - SSS Number" +
                "\n12 - TIN Number" +
                "\n13 - [BACK]");
        
                do {
                    try {
                        System.out.print("Choose which data to update (1-13): ");
                        dataField = Integer.parseInt(scanner.nextLine());
                        if (dataField < 1 || dataField > 13)
                            System.out.println("\nEnter a valid choice. Try again!");
                        else if (dataField == 13) {
                            ModePrompt();
                            return;
                        }
                    }
                    catch (Exception e) {
                        System.out.println("\nEnter a valid choice. Try again!");
                        dataField = -1;
                    }
                } while (dataField < 1 || dataField > 13);
                UpdateDataField(dataField, bsscClass[currentIndex]);
                break;
            default:
                System.out.println("Nothing to update!");     
        }
    }

    private static void UpdateDataField(int dataField, PLTCStudent student) {
        System.out.println("");
        //TODO: ADD VALIDATION HERE
        switch (dataField) {
            case 1:
                System.out.print("Update Status: ");
                String status = scanner.nextLine();
                student.setStatus(status);
                System.out.println("\nUpdated Status to " + student.getStatus() + ".");
                break;
            case 2:
                System.out.print("Update Surname: ");
                String surname = scanner.nextLine();
                student.setSurname(surname);
                System.out.println("\nUpdated Surname to " + student.getSurname() + ".");
                break;
            case 3:
                System.out.print("Update Name: ");
                String name = scanner.nextLine();
                student.setName(name);
                System.out.println("\nUpdated Name to " + student.getName() + ".");
                break;
            case 4:
                System.out.print("Update Middle Name: ");
                String middleName = scanner.nextLine();
                student.setMiddleName(middleName);
                System.out.println("\nUpdated Middle Name to " + student.getMiddleName() + ".");
                break;
            case 5:
                System.out.print("Update Birthdate (YYYY-MM-DD): ");
                String birthDate = scanner.nextLine();
                student.setBirthdate(birthDate);
                System.out.println("\nUpdated Birthdate to " + student.getBirthdate() + ".");
                break;
            case 6:
                System.out.print("Update Sex: ");
                char sex = scanner.nextLine().charAt(0);
                student.setSex(sex);
                System.out.println("\nUpdated Sex to " + student.getSex() + ".");
                break;
            case 7:
                System.out.print("Update Educational Attainment: ");
                String educationalAttainment = scanner.nextLine();
                student.setEducationalAttainment(educationalAttainment);
                System.out.println("\nUpdated Educational Attainment to " + student.getEducationalAttainment() + ".");
                break;
            case 8:
                System.out.print("Update Year Graduated: ");
                int yearGraduated = Integer.parseInt(scanner.nextLine());
                student.setYearGraduated(yearGraduated);
                System.out.println("\nUpdated Year Graduated to " + student.getYearGraduated() + ".");
                break;
            case 9:
                System.out.print("Update Cellphone Number: ");
                String cpNum = scanner.nextLine();
                student.setCPNum(cpNum);
                System.out.println("\nUpdated Cellphone Number to " + student.getCPNum() + ".");
                break;
            case 10:
                System.out.print("Update Email Address: ");
                String email = scanner.nextLine();
                student.setEmail(email);
                System.out.println("\nUpdated Email Address to " + student.getEmail() + ".");
                break;
        }

        wr.writePLTC(pltcClass);
        wr.readPLTC();
    }

    private static void UpdateDataField(int dataField, RTCStudent student) {
        System.out.println("");
        //TODO: ADD VALIDATION HERE
        switch (dataField) {
            case 1:
                System.out.print("Update Status: ");
                String status = scanner.nextLine();
                student.setStatus(status);
                System.out.println("\nUpdated Status to " + student.getStatus());
                break;
            case 2:
                System.out.print("Update Surname: ");
                String surname = scanner.nextLine();
                student.setSurname(surname);
                System.out.println("\nUpdated Surname to " + student.getSurname());
                break;
            case 3:
                System.out.print("Update Name: ");
                String name = scanner.nextLine();
                student.setName(name);
                System.out.println("\nUpdated Name to " + student.getName() + ".");
                break;
            case 4:
                System.out.print("Update Middle Name: ");
                String middleName = scanner.nextLine();
                student.setMiddleName(middleName);
                System.out.println("\nUpdated Middle Name to " + student.getMiddleName() + ".");
                break;
            case 5:
                System.out.print("Update Birthdate (YYYY-MM-DD): ");
                String birthDate = scanner.nextLine();
                student.setBirthdate(birthDate);
                System.out.println("\nUpdated Birthdate to " + student.getBirthdate() + ".");
                break;
            case 6:
                System.out.print("Update Sex: ");
                char sex = scanner.nextLine().charAt(0);
                student.setSex(sex);
                System.out.println("\nUpdated Sex to " + student.getSex() + ".");
                break;
            case 7:
                System.out.print("Update Educational Attainment: ");
                String educationalAttainment = scanner.nextLine();
                student.setEducationalAttainment(educationalAttainment);
                System.out.println("\nUpdated Educational Attainment to " + student.getEducationalAttainment() + ".");
                break;
            case 8:
                System.out.print("Update Year Graduated: ");
                int yearGraduated = Integer.parseInt(scanner.nextLine());
                student.setYearGraduated(yearGraduated);
                System.out.println("\nUpdated Year Graduated to " + student.getYearGraduated() + ".");
                break;
            case 9:
                System.out.print("Update Cellphone Number: ");
                String cpNum = scanner.nextLine();
                student.setCPNum(cpNum);
                System.out.println("\nUpdated Cellphone Number to " + student.getCPNum() + ".");
                break;
            case 10:
                System.out.print("Update Email Address: ");
                String email = scanner.nextLine();
                student.setEmail(email);
                System.out.println("\nUpdated Email Address to " + student.getEmail() + ".");
                break;
            case 11:
                System.out.print("Update SSS Number: ");
                long SSSNum = Long.parseLong(scanner.nextLine());
                student.setSSSNum(SSSNum);
                System.out.println("\nUpdated SSS Number to " + student.getSSSNum() + ".");
                break;
            case 12:
                System.out.print("Update TIN Number: ");
                long TINNum = Long.parseLong(scanner.nextLine());
                student.setTINNum(TINNum);
                System.out.println("\nUpdated TIN Number to " + student.getTINNum() + ".");
                break;
            case 13:
                System.out.print("Update Security Guard License Number & Expiry: ");
                long SGLicense = Long.parseLong(scanner.nextLine());
                String expiryDate = scanner.nextLine();
                student.setSGLicenseAndExpiry(SGLicense, expiryDate);
                System.out.println("\nUpdated Security Guard License Number & Expiry to " + student.getSGLicense() + " & " + student.getExpiryDate() + ".");
            case 14:
                System.out.print("Update SBR Number: ");
                long SBRNum = Long.parseLong(scanner.nextLine());
                student.setSBRNum(SBRNum);
                System.out.println("\nUpdated SBR Number to " + student.getSBRNum() + ".");
                break;
        }

        wr.writeRTC(rtcClass);
        wr.readRTC();
    }
    
    private static void UpdateDataField(int dataField, BSSCStudent student) {
        System.out.println("");
        //TODO: ADD VALIDATION HERE
        switch (dataField) {
            case 1:
                System.out.print("Update Status: ");
                String status = scanner.nextLine();
                student.setStatus(status);
                System.out.println("\nUpdated Status to " + student.getStatus() + ".");
                break;
            case 2:
                System.out.print("Update Surname: ");
                String surname = scanner.nextLine();
                student.setSurname(surname);
                System.out.println("\nUpdated Surname to " + student.getSurname() + ".");
                break;
            case 3:
                System.out.print("Update Name: ");
                String name = scanner.nextLine();
                student.setName(name);
                System.out.println("\nUpdated Name to " + student.getName());
                break;
            case 4:
                System.out.print("Update Middle Name: ");
                String middleName = scanner.nextLine();
                student.setMiddleName(middleName);
                System.out.println("\nUpdated Middle Name to " + student.getMiddleName() + ".");
                break;
            case 5:
                System.out.print("Update Birthdate (YYYY-MM-DD): ");
                String birthDate = scanner.nextLine();
                student.setBirthdate(birthDate);
                System.out.println("\nUpdated Birthdate to " + student.getBirthdate() + ".");
                break;
            case 6:
                System.out.print("Update Sex: ");
                char sex = scanner.nextLine().charAt(0);
                student.setSex(sex);
                System.out.println("\nUpdated Sex to " + student.getSex() + ".");
                break;
            case 7:
                System.out.print("Update Educational Attainment: ");
                String educationalAttainment = scanner.nextLine();
                student.setEducationalAttainment(educationalAttainment);
                System.out.println("\nUpdated Educational Attainment to " + student.getEducationalAttainment() + ".");
                break;
            case 8:
                System.out.print("Update Year Graduated: ");
                int yearGraduated = Integer.parseInt(scanner.nextLine());
                student.setYearGraduated(yearGraduated);
                System.out.println("\nUpdated Year Graduated to " + student.getYearGraduated() + ".");
                break;
            case 9:
                System.out.print("Update Cellphone Number: ");
                String cpNum = scanner.nextLine();
                student.setCPNum(cpNum);
                System.out.println("\nUpdated Cellphone Number to " + student.getCPNum() + ".");
                break;
            case 10:
                System.out.print("Update Email Address: ");
                String email = scanner.nextLine();
                student.setEmail(email);
                System.out.println("\nUpdated Email Address to " + student.getEmail() + ".");
                break;
            case 11:
                System.out.print("Update SSS Number: ");
                long SSSNum = Long.parseLong(scanner.nextLine());
                student.setSSSNum(SSSNum);
                System.out.println("\nUpdated SSS Number to " + student.getSSSNum() + ".");
                break;
            case 12:
                System.out.print("Update TIN Number: ");
                long TINNum = Long.parseLong(scanner.nextLine());
                student.setTINNum(TINNum);
                System.out.println("\nUpdated TIN Number to " + student.getTINNum() + ".");
                break;
        }

        System.out.println("ID: " + student.getStudentNum());
        wr.writeBSSC(bsscClass);
        wr.readBSSC();

        for (BSSCStudent i: bsscClass) {
            if (i != null)
                System.out.print(i.getStudentNum() + ", ");
        }

        
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
                course = Integer.parseInt(scanner.nextLine());
                if (course < 1 || course > 4)
                    System.out.println("\nEnter a valid choice. Try again!");
            }
            catch (Exception e) {
                System.out.println("\nEnter a valid choice. Try again!");
                course = -1;
            }
        } while (course < 1 || course > 4);

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

        // TODO REMOVE
        for (int i: idList) {
            System.out.print(i + ", ");
        }
        System.out.println("");

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