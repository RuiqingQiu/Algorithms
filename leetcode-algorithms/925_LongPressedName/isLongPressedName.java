class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;

        while (i < name.length() && j < typed.length()) {
            int count = 0;

            if (name.charAt(i) != typed.charAt(j)) {
                return false;
            }

            while (i + 1 < name.length() && name.charAt(i) == name.charAt(i + 1)) {
                count += 1;
                i++;
            }

            int tCount = 0;

            while (j + 1 < typed.length() && typed.charAt(j) == typed.charAt(j + 1)) {
                tCount += 1;
                j++;
            }

            if (tCount < count) {
                return false;
            }

            i++;
            j++;
        }

        if (i != name.length() || j != typed.length()) {
            return false;
        }

        return true;
    }
}
