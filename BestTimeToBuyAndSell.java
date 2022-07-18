class Solution {

    //Time Complexity: o(n) where n is the elements in the prices array
    //Space Complexity: 0(1)

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int min = Integer.MAX_VALUE;    //Initially setting my min to max value. It captures the minimum price when I traverse the prices array
        int max = Integer.MIN_VALUE;    //It captures the difference between the current price and the min. And if it is greater than the prev max, I update my max to current difference

        for(int i = 0; i < prices.length; i++){ //going over the prices array
            min = Math.min(min, prices[i]); //comparing the prev min and the current price and storing the least of 2
            max = Math.max(max, prices[i] - min);   //comparing prev max and current difference between price and min and storing max of the 2
        }

        return max; //returning max at the end
    }
}