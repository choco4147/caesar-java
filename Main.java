import java.util.*;
import java.io.*; 
public class Main
{
    public static void main(String[] args) {
        
        int key;
        String input;
        char c;
        Scanner scan = new Scanner(System.in);
        int enOrDe;

        // Getting message and key
        System.out.print("Message:");
        input = scan.nextLine();
        System.out.println("");
        System.out.print("Key:");
        key = scan.nextInt();
        System.out.println("");
        // Asking users if they want to encrypt or decrypt
        System.out.println("Encrypt (1) or Decrypt (0)?");
        enOrDe = scan.nextInt();
        System.out.println("");
        
        // Ensure a valid input for enOrDe 
        while (enOrDe != 1 && enOrDe != 0) {
            System.out.println("Encrypt (1) or Decrypt (0)?");
            enOrDe = scan.nextInt();
        }
       
       // Ensure key isn't >25 or <-25
       key = fixKey(key);
       
        // Encrypt
        if (enOrDe == 1) {
            for (int i = 0; i < input.length(); i++) {
                c = input.charAt(i);
                c = caesarEn(key, c);
                System.out.print(c);
            }
        }
        // Decrypt 
        else {
            for (int i = 0; i < input.length(); i++) {
                c = input.charAt(i);
                c = caesarDe(key, c);
                System.out.print(c);
            }
        }
    }
    
    // Caesar encryption 
    public static char caesarEn(int key, char c) {
        int tempkey = key; // Temporary value to hold a modified key number 
        // upper case letter
        if (65 <= c && c <= 90) {
            while (tempkey > 90 - c) {
                // Adjusts key for specific char
                tempkey = tempkey - 26;
            }
            c = (char)(c + tempkey);
        }
        // lower case letter
        else if (97 <= c && c <= 122) {
            while (tempkey > 122 - c) {
                tempkey = tempkey - 26;
            }
            c = (char)(c + tempkey);
        }
        return c;
    }
    
    // Caesar decryption
    public static char caesarDe(int key, char c) {
        int tempkey = key;
        // upper case letter
        if (65 <= c && c <= 90) {
            while (tempkey > c - 65) {
                tempkey = tempkey - 26;
            }
            c = (char)(c - tempkey);
        }
        // lower case letter
        else if (97 <= c && c <= 122) {
            while (tempkey > c - 97) {
                tempkey = tempkey - 26;
            }
            c = (char)(c - tempkey);
        }
        return c;
    }
    
    public static int fixKey(int key) {
        // Changes key so it doesn't mess up the code
        if (key >= 26 || key <= -26) {
            key = key % 26;
        }
        // Makes key value positive without changing shift amount
        while (key < 0) {
            key = 26 + key;
        }
        return key;
    }
    
}
