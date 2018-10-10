package zadanka;

public class zadania29092018 {

	public static void main(String[] args) {
		
		System.out.println(isTeen(20, 17));
		System.out.println(sum(13,5,4));
		int[] a = {13,3,2,1,23,44,12,1,3,45,2,77,3};
		System.out.println(sequence123(a));
	}
	
	public static boolean isTeen (int a, int b) {
			if ((a >= 13 && a <= 19) && (b < 13 || b > 19)){
				return true;
			}
			if ((b >= 13 && b <= 19) && (a < 13 || a > 19)){
				return true;
			}
			return false;
	}
	
	public static int sum(int a, int b, int c) {
		if (a == 13) {
			return 0;
		}
		if (b == 13) {
			return a;
		}
		if (c == 13) {
			return a+b;
		}
		return a+b+c;
	}
	
	public static boolean sequence123(int [] a) {
		for (int i = 0;i < a.length; i++) {
			if (a[i] == 1) {
				if(a[i+1] == 2) {
					if (a[i+2] == 3) 
						return true;
				}
			}
		}
		
		return false;
	}
	
}
