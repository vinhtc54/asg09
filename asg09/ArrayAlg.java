package asg09;


public class ArrayAlg {
Exception Exception = null;

	public <T> void printArray(T[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println("");
	}

	public <T> void printArray(T[] a, int start, int end) throws Exception {

		for (int i = start; i < end; i++) {
			if (start < 0 || start >= end || end > a.length) 
				throw Exception;
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}

	public static <T extends Comparable> Pair<T> maxTwo(T[] a) {
		if (a == null || a.length == 0)
			return null;
		T max1 = a[0];
		T max2 = a[0];
		try {
			for (int i = 1; i < a.length; i++){
				if (max1.compareTo(a[i]) < 0){
				if(a[i].compareTo(max2) > 0){
						max1 = max2;
						max2 = a[i];
				}
				else	max1 = a[i];
			}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return new Pair<T>(max1, max2);
	}

	public static void main(String[] args) {
		ArrayAlg a = new ArrayAlg();
		Integer[] number = { 1, 2, 3, 4, 5, 6 };
		String[] words = { "a", "b", "c", "d", "e" };
		a.<Integer> printArray(number);
		
		try {
			a.<Integer> printArray(number, 1, 5);
			a.<String> printArray(words, 1,3);
		} catch ( Exception e) {
			System.out.println("Eror");
		}
		
		Pair<Integer> mt = ArrayAlg.maxTwo(number);
		System.out.println("max1 = " + mt.getFirst());
		System.out.println("max2 = " + mt.getSecond());
	}
}
