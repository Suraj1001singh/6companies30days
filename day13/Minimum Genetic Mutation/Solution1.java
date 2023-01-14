import java.util.*;

//BFS Solution like word ladder

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> q = new LinkedList<>();
        Set<String> validGene= new HashSet<>();
        Set<String> seen= new HashSet<>();
        for(String s : bank) validGene.add(s);

       
        q.add(start);
        seen.add(start);
        char[] alpha= {'A','C','G','T'};
        int moves=0;
        while(!q.isEmpty()){
            int n=q.size();
           
            while(n-->0){
                String s= q.poll();
                if(s.equals(end)) return moves;
                
                
                for(int i=0; i<8; i++){
                    for(char c : alpha){
                        char[] arr=s.toCharArray();
                        arr[i]=c;
                        String str= new String(arr);
                        if(validGene.contains(str) && !seen.contains(str)){
                            q.add(str);
                            seen.add(str);
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
        
    }
}