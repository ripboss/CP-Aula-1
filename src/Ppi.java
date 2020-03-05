
public class Ppi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		int cores;
		if (args.length == 2)
			cores = Integer.parseInt(args[1]);
		else
			cores = 1;
		int withinCircle = 0;
		Thread[] threads = new Thread[cores];
		for (int i=0; i<cores; i++) {
			threads[i] = new ThreadHelper(n/cores);
			threads[i].start();
		}
		
		for (int i=0; i<cores; i++) {
			try {
				threads[i].join();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
		
		for (int i=0; i<cores; i++)
			withinCircle += ((ThreadHelper)threads[i]).getPointsWithin();
		
		double pi = ((double)withinCircle/n) * 4;
		System.out.println("Total Number of points: " + n);
		System.out.println("Points within circle: " + withinCircle);
		System.out.println("Pi estimation: " + pi);
	}

}

class ThreadHelper extends Thread {

	private int n;
	private int withinCircle;
	
	ThreadHelper(int n) {
		this.n = n;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i=0; i<this.n; i++) {
			double x = Math.random();
			double y = Math.random();
			double test = Math.pow(x,2) + Math.pow(y,2);
			if (test <= 1)
				withinCircle++;	
		}
	}
	
	int getPointsWithin(){
		return this.withinCircle;
	}
	
}