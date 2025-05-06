import java.util.Scanner;

public class Operate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 2 values for arithmetic operations");
		int n1 = scanner.nextInt();
		int n2 = scanner.nextInt();
		
		System.out.println("Enter a value for trigonometric operation");
		int n3 = scanner.nextInt();
		
		ArithmeticOp arithmeticOp = new ArithmeticOp(n1, n2);
		arithmeticOp.start();
		
		TrigonometricOp trigonometricOp = new TrigonometricOp(n3);
		Thread t1 = new Thread(trigonometricOp);
		t1.start();
		
	}

}
