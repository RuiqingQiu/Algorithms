class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> mapOfRomanToInt = new HashMap<Character, Integer>();
        mapOfRomanToInt.put('I', 1);
        mapOfRomanToInt.put('V', 5);
        mapOfRomanToInt.put('X', 10);
        mapOfRomanToInt.put('L', 50);
        mapOfRomanToInt.put('C', 100);
        mapOfRomanToInt.put('D', 500);
        mapOfRomanToInt.put('M', 1000);

        int n = s.length();
        int result = mapOfRomanToInt.get(s.charAt(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            int current = mapOfRomanToInt.get(s.charAt(i));
            int prev = mapOfRomanToInt.get(s.charAt(i + 1));
            if (current < prev) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}
