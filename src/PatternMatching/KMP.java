package PatternMatching;

// KMP (Knuth-Morris-Pratt) Algorithms
public class KMP {
    public static void main(String[] args) {
        String origin = "ABABABAC";
        String pattern = "ABAC";

        kmpMatch(origin, pattern);
    }

    // get Longest Common Suffix
    static int[] getLcs(String pattern) {
        int len = pattern.length();
        int[] lcs = new int[len];

        for (int i = 1, pIdx = 0; i < len; i++) {
            while (pIdx > 0 && pattern.charAt(i) != pattern.charAt(pIdx)) {
                pIdx = lcs[pIdx -1];
            }
            if (pattern.charAt(i) == pattern.charAt(pIdx)) {
                lcs[i] = ++pIdx;
            }
        }

        return lcs;
    }

    static void kmpMatch(String origin, String pattern) {
        int[] lcs = getLcs(pattern);
        for (int i = 0, j = 0; i < origin.length(); i++) {
            while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = lcs[j -1];
            }
            if (origin.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    j = lcs[j];
                    System.out.println("Found pattern at index " + (i - j));
                } else {
                    j++;
                }
            }
        }
    }
}
