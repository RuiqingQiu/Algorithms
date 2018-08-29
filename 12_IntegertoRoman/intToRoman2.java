class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> mapOfIntToRoman = new HashMap<Integer, String>();

        mapOfIntToRoman.put(1, "I");
        mapOfIntToRoman.put(4, "IV");
        mapOfIntToRoman.put(5, "V");
        mapOfIntToRoman.put(9, "IX");
        mapOfIntToRoman.put(10, "X");
        mapOfIntToRoman.put(40, "XL");
        mapOfIntToRoman.put(50, "L");
        mapOfIntToRoman.put(90, "XC");
        mapOfIntToRoman.put(100, "C");
        mapOfIntToRoman.put(400, "CD");
        mapOfIntToRoman.put(500, "D");
        mapOfIntToRoman.put(900, "CM");
        mapOfIntToRoman.put(1000, "M");

        int [] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String result = "";

        for (int i : nums) {
            while (num >= i) {
                result = result + mapOfIntToRoman.get(i);
                num = num - i;
            }
        }

        return result;
    }
}
