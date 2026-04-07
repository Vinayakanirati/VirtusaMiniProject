import java.io.BufferedReader;
import java.io.InputStreamReader;

class InvalidPassword extends Exception{
    InvalidPassword(String s){
        super(s);
    }
}
public class PasswordValidator {
    public static boolean validatePassword(String password) throws InvalidPassword {
        if (password.length() < 8) {
            throw new InvalidPassword("Password must be at least 8 characters long");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPassword("Password must contain at least one uppercase letter");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPassword("Password must contain at least one lowercase letter");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new InvalidPassword("Password must contain at least one digit");
        }
        if(!password.matches(".*[!@#$%^&*()].*")){
            throw new InvalidPassword("Password must contain at least one special character");
        }
        return true;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your password : ");
        while(true){
            try {
                String password = br.readLine();
                if (validatePassword(password)) {
                    System.out.println("Password is valid");
                    break;
                }
            } catch (InvalidPassword e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter your password again : ");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                break;
            }
        }
    }
}
