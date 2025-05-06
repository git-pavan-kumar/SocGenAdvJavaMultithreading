
public class ArithmeticOp extends Thread {

	int num1, num2;
	
	public ArithmeticOp(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public void run() {
		System.out.println("Arithmetic operations thread");
		System.out.println("SUM: " + this.num1 + this.num2);
		System.out.println("DIFF: " + (this.num1 - this.num2));
		System.out.println("PRODUCT: " + this.num1 * this.num2);
		System.out.println("RATIO: " + this.num1 / this.num2);
		System.out.println("POWER: " + Math.pow(this.num1,this.num2));
		System.out.println("End of Arithmetic operations thread");
	}
}
