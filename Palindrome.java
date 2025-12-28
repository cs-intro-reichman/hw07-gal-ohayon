/** Checks if a given string is a palindrome. */
public class Palindrome {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(isPalindrome(args[0]));
        }
    }

    public static boolean isPalindrome(String s) {
        // תנאי עצירה: מחרוזת ריקה או באורך 1 היא פלינדרום
        if (s == null || s.length() <= 1) {
            return true;
        }

        // בדיקה אם האות הראשונה והאחרונה שוות
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        // קריאה רקורסיבית על המחרוזת ללא האות הראשונה והאחרונה
        return isPalindrome(s.substring(1, s.length() - 1));
    }
}