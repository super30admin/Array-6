// Time Complexity : O(nk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// DP: to maintain the repeated sub-problem: we first set the value for index 0 and 1, by setting b0 = -p0; s0 = 0; b1 = max(b0, s0-p1); s1 = max(s0, b0-p1); main formular: bi = max(bi-1, si-2-pi); si = max(si-1, bi-1+pi);
// Your code here along with comments explaining your approach
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [] b = new int [n];
        int [] s = new int [n];
        if(n < 2) return 0;
        b[0] = -prices[0];
        s[0] = 0;
        b[1] = Math.max(b[0], s[0]-prices[1]);
        s[1] = Math.max(s[0], b[0]+prices[1]);
        for(int i = 2; i < n; i++){
            b[i] = Math.max(b[i-1], s[i-2]-prices[i]);
            s[i] = Math.max(s[i-1], b[i-1]+prices[i]);
        }
        return s[n-1];
    }
}