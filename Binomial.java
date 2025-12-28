/** Computes the binomial(n,k) function. */
public class Binomial {	
    public static void main(String[] args) {
        if (args.length < 2) return;
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(binomial(n, k));
    }

    // הפעולה הבסיסית (לפי דרישת המטלה בדרך כלל)
    public static int binomial1(int n, int k) {
        if (k > n || k < 0) return 0;
        if (k == 0 || k == n) return 1;
        return binomial1(n - 1, k) + binomial1(n - 1, k - 1);
    }

    // הפעולה היעילה עם Memoization
    public static long binomial(int n, int k) {
        if (k > n || k < 0) return 0;
        long[][] memo = new long[n + 1][k + 1];
        // אתחול המערך ב-1-
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }
        return binomial(n, k, memo);
    }

    // פעולת עזר רקורסיבית עם זיכרון
    private static long binomial(int n, int k, long[][] memo) {
        if (k > n || k < 0) return 0;
        if (k == 0 || k == n) return 1;
        
        // אם כבר חישבנו, נחזיר מהזיכרון
        if (memo[n][k] != -1) {
            return memo[n][k];
        }

        // חישוב ושמירה בזיכרון
        memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
        return memo[n][k];
    }
}