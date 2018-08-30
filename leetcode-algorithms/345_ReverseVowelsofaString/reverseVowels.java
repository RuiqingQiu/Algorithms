class Solution {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        HashSet<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        char [] arr = s.toCharArray();

        while (i < j) {
            while (i < j && !vowels.contains(Character.toLowerCase(arr[i]))) {
                i++;
            }

            while (i < j && !vowels.contains(Character.toLowerCase(arr[j]))) {
                j--;
            }


            Character tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;

            i++;
            j--;
        }

        return String.valueOf(arr);
    }
}
