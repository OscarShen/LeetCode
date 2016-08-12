package hashtable.countPrimes;

public class Demo01 {
	public static void main(String[] args) {
		int count;
		count=countPrimes(10000);
		System.out.println(count);
	}
	
	public static int countPrimes(int n) {
        boolean[] flags = new boolean[n];
        int count = 0;
        for(int i=2;i<n;i++){
        	flags[i]=true;
        }
        
        for(int i=2;i*i<n;i++){
        	if(flags[i]){
	        	for(int j=2;i*j<n;j++){
	        		flags[i*j]=false;
	        	}
        	}
        }
        
        for(boolean b:flags){
        	if(b){
        		count++;
        	}
        }
        return count;
    }
}
