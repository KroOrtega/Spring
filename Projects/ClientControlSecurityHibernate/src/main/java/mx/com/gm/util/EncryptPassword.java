package mx.com.gm.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {
    
    public static void main(String[] args) {
        var password = "123";
        System.out.println("password = " + password);
        System.out.println("password encrypted = " + encryptPassword(password));   
    }
    
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    
}
