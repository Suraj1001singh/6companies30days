class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res= new ArrayList<>();
        f(1,k,0,n,new ArrayList<>());
        return res;
    }
    public void f(int num , int k, int sum,int target, List<Integer> list){
        if(k==0){
            if(sum==target) res.add(new ArrayList<>(list));
            return;
        }
        if(num>9) return;
        list.add(num);
        f(num+1,k-1,sum+num,target,list);
        list.remove(list.size()-1);
        f(num+1,k,sum,target,list);
    }
}
//Time complexity : exponential (2^10)