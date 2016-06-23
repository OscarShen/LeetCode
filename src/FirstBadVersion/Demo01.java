package firstBadVersion;
//package FirstBadVersion;
//
//public class Demo01 {
//	    public int firstBadVersion(int n) {
//	        int[] versions = new int[n];
//	        for(int i=0;i<n;i++){
//	            versions[i]=i+1;
//	        }
//	        if(isBadVersion(1)){
//	            return 1;
//	        }
//	        int first = 1 ;
//	        int end = n;
//	        
//	        while(first<end){
//	            int mid = (first + end)/2;
//	            if(isBadVersion(mid)){
//	                end=mid-1;
//	            }else{
//	                first = mid +1;
//	            }
//	        }
//	        return first;
//	    }
//	}
