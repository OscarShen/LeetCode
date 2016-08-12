package hashtable.h_index;

public class Demo01 {
	public static void main(String[] args) {
		int a[] = { 3, 5, 3, 2, 4 };
		System.out.println(hIndex(a));
	}

	public static int hIndex(int[] citations) {
		quickSort(citations, 0, citations.length-1);
		int h=0;
		for(int i=0;i<citations.length;i++){
			if(citations[i]>=i+1)
				h=i+1;
		}
		return h;
	}

	public static void quickSort(int[] a, int low, int high) {
		if (low >= high) {
			return;
		}
		
		int pivot = a[low];
		int i = low;
		int j = high;
		
		while (i < j) {
			while (i < j && a[j] <= pivot)
				j--;
			a[i] = a[j];
			while (i < j && a[i] >= pivot)
				i++;
			a[j] = a[i];
		}
		a[i] = pivot;
		quickSort(a, low, i - 1);
		quickSort(a, i + 1, high);
	}
}
