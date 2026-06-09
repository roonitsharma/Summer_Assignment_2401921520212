class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m > n) return result;

        int[] freqP = new int[26];
        int[] freqS = new int[26];

        for (int i = 0; i < m; i++) {
            freqP[p.charAt(i) - 'a']++;
            freqS[s.charAt(i) - 'a']++;
        }

        if (isEqual(freqP, freqS)) {
            result.add(0);
        }

        for (int i = m; i < n; i++) {
            freqS[s.charAt(i) - 'a']++;
            freqS[s.charAt(i - m) - 'a']--;

            if (isEqual(freqP, freqS)) {
                result.add(i - m + 1);
            }
        }

        return result;
    }

    private boolean isEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
