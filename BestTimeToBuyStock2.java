
/*

Time complexity: O(N)
Space complexiy:O(1)
worked on LC : YES
*/

class Solution {
    public int maxProfit(int[] prices) {
        
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;
        int i =0;
        while(i < prices.length-1) {
            
            // find valley
            while(i < prices.length-1 && prices[i] >= prices[i+1]) {
                i++;
            }
            valley = prices[i];
            System.out.println(" valley "+valley);
            // find peak
            
            while(i < prices.length-1 && prices[i] <= prices[i+1]) {
                i++;
            }
            
            peak = prices[i];
            
            System.out.println(" peak "+peak);
            System.out.println(" profit " +(peak-valley));
            // peak-vallye will be profit add profit and move on
            maxProfit +=peak-valley;
            
        }
        
        return maxProfit;
        
    }
    
    public int maxProfit2(int[] prices) {
        
        
        int maxProfit = 0;
        
        
        for(int i=1;i< prices.length;i++) {
            
            if(prices[i] >= prices[i-1]) {
                maxProfit += prices[i]-prices[i-1];
            }
        }
        
        return maxProfit;
    }
}
