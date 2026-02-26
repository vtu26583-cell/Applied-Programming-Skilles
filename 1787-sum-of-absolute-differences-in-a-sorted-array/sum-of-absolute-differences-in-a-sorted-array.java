class Solution{
public int[] getSumAbsoluteDifferences(int[] nums){
int n=nums.length;
int[] res=new int[n];
int total=0;
for(int x:nums)total+=x;
int prefix=0;
for(int i=0;i<n;i++){
res[i]=nums[i]*i-prefix+(total-prefix-nums[i])-nums[i]*(n-i-1);
prefix+=nums[i];
}
return res;
}
}