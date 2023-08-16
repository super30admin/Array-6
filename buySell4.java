class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length+5][2][k+5];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                for(int p = 0 ; p <= k+3 ; p++){
                    dp[i][j][p] = -1;
                }
            }
        }
        return f(prices , 0 , 1 , dp , k);
    }

    public int f(int[] arr , int ind , int buy , int[][][] dp , int cap){
        if(ind == arr.length) return 0;
        if(cap == 0) return 0;
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        if(buy == 1){
            int tar = Math.max(-arr[ind]+f(arr , ind+1 , 0, dp , cap) , f(arr , ind+1 , 1 ,dp ,cap));
            return dp[ind][buy][cap] = tar;
        }
        else{
            int tar = Math.max(arr[ind] + f(arr , ind+1 , 1 ,dp ,cap - 1) , f(arr , ind+1 , 0 ,dp , cap));
            return dp[ind][buy][cap] = tar;
        }
    }
}
