class Solution {
    public int distributeCandies(int[] candyType) {
//         Set<Integer> distinct_candy = new HashSet<Integer>();

//         for (int candy : candyType) {
//             distinct_candy.add(candy);
//         }
        Set<Integer> distinct_candy = Arrays.stream(candyType).boxed().collect(Collectors.toSet());
        return Math.min(candyType.length / 2, distinct_candy.size());
    }
}
