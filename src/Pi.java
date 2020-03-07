
public class Pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		int within = 0;
//		long ti = System.nanoTime();
		for (int i=0; i<n; i++) {
			double x = Math.random();
			double y = Math.random();
			double test = Math.pow(x,2) + Math.pow(y,2);
			if (test <= 1)
				within++;	
		}
//		long tf = System.nanoTime();
		double pi = ((double)within/n) * 4;
		
//		System.out.println((tf-ti)/1000000 + "ms");
		System.out.println("Total Number of points: " + n);
		System.out.println("Points within circle: " + within);
		System.out.println("Pi estimation: " + pi);
	}
}
