## Problem4: Buy and Sell Stock with cooldown https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

Bruteforce: In this for every index there are two posiblities if we want to buy or we want to sell it.
if we dont hold then we can buy or we cannot buy and if we have then we can sell or we cannot sell
so we will go recursively

Time Complexity : Exponential
Space Complexity : O(n)

class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        return recurse(prices,0,-1,0);
    }
    private int recurse(int[] prices, int index,int prevBuy,int profit){
        //base condition
        if(index >= prices.length){
            return profit;
        }

        //recursion
        if(prevBuy==-1){
            //buy state
            return Math.max(recurse(prices,index+1,prevBuy,profit),recurse(prices,index+1,prices[index],profit));
        }else{
            //sell state
            return Math.max(recurse(prices,index+1,prevBuy,profit),recurse(prices,index+2,-1,profit+prevBuy));
        }
    }
}


//Read4 premium problem
T.c = O(n)
S.c = O(1)
public class Solution extends Reader4{
    char[] mybuffer = new char[4];
    int buffersize;
    int index;
    public int read(char[] buf, int n){
        if(buffsize==0){
            buffsize = read4(mybuffer);
        }
        int i=0;
        while(i<n && buffsize > 0){
            buf[i++] = mybuffer[index++];
            if(index==bufsize){
                buffsize = read4(mybuffer);
                index = 0;
            }
        }
        return i;
    } 
}
