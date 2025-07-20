class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        
        if (len1 + len2 != len3) {
            return false;
        }
        
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[len1][len2];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isInterleave("aabcc", "dbbca", "aadbbcbcac")); // Output: true
        System.out.println(sol.isInterleave("aabcc", "dbbca", "aadbbbaccc")); // Output: false
        System.out.println(sol.isInterleave("", "", "")); // Output: true
    }
}
