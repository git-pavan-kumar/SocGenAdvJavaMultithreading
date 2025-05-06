
public class TrigonometricOp extends Thread {

	int num;
	
	public TrigonometricOp(int num) {
		this.num = num;
	}
	
	public void run() {
		System.out.println("Trigonometric operations thread");
		System.out.println("SIN OF" + this.num + " " + Math.sin(this.num));
		System.out.println("CoSINE OF" + this.num + " " + Math.cos(this.num));
		System.out.println("TAN OF" + this.num + " " + Math.tan(this.num));
		System.out.println("SQ ROOT OF" + this.num + " " + Math.sqrt(this.num));
		System.out.println("End of Trigonometric operations thread");
	}
}
