// TC: O(n)
// SC: O(1)

public class LC121 {
    public int maxProfit(int[] prices) {
        int j=0, ans=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[j]){
                j=i;
            } else {
                ans = Math.max(ans, prices[i]-prices[j]);
            }
        }
        return ans;
    }
}
