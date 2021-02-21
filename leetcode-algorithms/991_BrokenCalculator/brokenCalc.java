class Solution {
    public int brokenCalc(int X, int Y) {
        int result = 0;
        while (Y > X) {
            Y = Y % 2 != 0 ? Y + 1 : Y / 2;
            result++;
        }

        return result + (X - Y);
    }
}
