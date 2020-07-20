// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        if(A.length==1){
            return A[0];
        }
        
        int maxB=0;
        
        for(int i=0;i<A.length;i++){
            if(maxB<=A[i]){
                maxB=A[i];
            }
        }

        int maxSumR=A.length*maxB;
        int maxSumL=A.length*maxB;
        int maxSumHere;
        int maxS=1;
        for(int i=0;i<A.length;i++){
            if(A[i]>=maxS&&A[i]<maxB){
                maxS=A[i];
                maxSumHere=maxS*(i+1)+maxB*(A.length-1-i);
                maxSumR=Math.min(maxSumR,maxSumHere);
        
            }
            if(A[i]<maxS){
                 maxSumHere=maxS*(i+1)+maxB*(A.length-1-i);
                maxSumR=Math.min(maxSumR,maxSumHere);
            }
            if(A[i]==maxB){
                break;
            }
        }
        maxSumHere=0;
        maxS=1;
        int j=0;
        for(int i=A.length-1;i>=0;i--){
            if(A[i]>=maxS&&A[i]<maxB){
                maxS=A[i];
                maxSumHere=maxS*(j+1)+maxB*(i);
                maxSumL=Math.min(maxSumL,maxSumHere);
            }
            if(A[i]<maxS){
                 maxSumHere=maxS*(j+1)+maxB*(i);
                maxSumL=Math.min(maxSumL,maxSumHere);
            }
            if(A[i]==maxB){
                break;
            }
    
            j++;
        }
        return Math.min(maxSumR,maxSumL);
        
    }
}