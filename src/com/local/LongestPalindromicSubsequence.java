package com.local;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String seq = "BBABCBCAB";
        System.out.println(LPS(seq) + "");
    }

    private static int LPS(String s) {
        int l = s.length();
        int[][] lp = new int[l][l];
        for (int i = 0; i < l; i++) {
            lp[i][i] = 1;
        }
        for(int c = 2;c<=l;c++){
            for (int i = 0; i < l - c + 1; i++) {
                int j = i + c - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (c == 2) {
                        lp[i][j] = 2;
                    } else {
                        lp[i][j] = lp[i + 1][j - 1] + 2;
                    }
                } else {
                    lp[i][j] = Utils.max(lp[i][j - 1], lp[i + 1][j]);
                }
            }
        }

        return lp[0][l-1];
    }
    static int lps1(String seq)
    {
        int n = seq.length();
        int i, j, cl;
        int L[][] = new int[n][n];  // Create a table to store results of subproblems

        // Strings of length 1 are palindrome of lentgh 1
        for (i = 0; i < n; i++)
            L[i][i] = 1;

        // Build the table. Note that the lower diagonal values of table are
        // useless and not filled in the process. The values are filled in a
        // manner similar to Matrix Chain Multiplication DP solution (See
        // http://www.geeksforgeeks.org/archives/15553). cl is length of
        // substring
        for (cl=2; cl<=n; cl++)
        {
            for (i=0; i<n-cl+1; i++)
            {
                j = i+cl-1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    L[i][j] = L[i+1][j-1] + 2;
                else
                    L[i][j] = Utils.max(L[i][j-1], L[i+1][j]);
            }
        }

        return L[0][n-1];
    }
}
