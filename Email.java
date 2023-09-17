import java.util.*;
import java.security.*;
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String email;

    //constructor
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        SecureRandom random = new SecureRandom();
        int randomSuffix = 1000 + random.nextInt(9000); // Generates a 4-digit random number
        String emailSuffix = "@novatech.com"; //Set Email domain
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + randomSuffix + emailSuffix;
        System.out.println("Email Created " + this.email);


        //Set Department
        this.department = setDepartment();
        System.out.println("Department is  " + this.department);

        //call a method to generate a random password
        int passwordLength = 8;
        this.password = generateRandomPassword(passwordLength);
        System.out.println("Random Password: " + this.password);

    }


    //Method to Set DepartmentScanner input =new Scanner(System.in);
    private String setDepartment() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Department\n 1. Sales\n 2. Development\n 3. Accounting\n");
        int n = input.nextInt();
        return switch (n) {
            case 1 -> ("Sales");
            case 2 -> ("Development");
            case 3 -> ("Accounting");
            default -> ("Invalid input");
        };
    }


//Generate Random Password
    private String generateRandomPassword(int length) {
            String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String LOWER = "abcdefghijklmnopqrstuvwxyz";
            String DIGITS = "0123456789";
            String SPECIAL_CHARS = "!@#$%^&*()_-+=<>?";
            SecureRandom random = new SecureRandom();
            StringBuilder password = new StringBuilder();

            String allCharacters = UPPER + LOWER + DIGITS + SPECIAL_CHARS;

            for (int i = 0; i < length; i++) {
                int randomIndex = random.nextInt(allCharacters.length());
                password.append(allCharacters.charAt(randomIndex));
            }

            return password.toString();
        }


    }
