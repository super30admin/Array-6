/*Time Complexity : O(N)
Space Complexity : O(1)
Did it run on LeetCode : Yes
Any Problems? : No
*/

class Solution{
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int price : prices)
        {
            if(price < min)
            {
                min = price;
            }
            else 
            {
                if((price - min) > maxProfit)
                    maxProfit = Math.max(maxProfit,(price-min));
            }
            
            
        }
        return maxProfit;
        
    }
}

