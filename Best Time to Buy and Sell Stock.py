#time: O(n)
#space :O(1)

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if(prices==None or len(prices)==0):
            return 0
        mprofit=0
        mins=prices[0]
        for p in prices:
            mprofit=max(mprofit,p-mins)
            mins=min(mins,p)
        return mprofit