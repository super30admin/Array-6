class Solution {
    public int maxProfit(int[] prices) {
        // Tc: O(n) Sc: O(1)
        int sell = Integer.MIN_VALUE;
        int pause = Integer.MIN_VALUE;
        int back = 0;

        for (int i : prices) {
            int sold = sell;
            sell = pause + i;
            pause = Math.max(pause, back - i);
            back = Math.max(back, sold);
        }
        return Math.max(sell, back);
    }
}