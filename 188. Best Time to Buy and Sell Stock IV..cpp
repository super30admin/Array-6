class Solution {
public:
    vector<int> v;
    int len, lim, dp[205][1005];

    int call(int k, int pos){
        if(pos==len || k==lim*2){
            return 0;
        }
        if(dp[k][pos]!=-1)  return dp[k][pos];

        int op1 = call(k, pos+1); //skip this item -> no transaction
        int op2 = (k%2==0) ? -v[pos] + call(k+1,pos+1) : v[pos] + call(k+1,pos+1); //if k is even, buy stock; sell otherwise

        return dp[k][pos] = max(op1,op2);
    }

    int maxProfit(int k, vector<int>& prices) {
        for(int i=0;i<201;i++){
            for(int j=0;j<1001;j++)  dp[i][j] = -1;
        }

        v = prices;
        len = prices.size();
        lim = k;

        return call(0,0);
    }
};
