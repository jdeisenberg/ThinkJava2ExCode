/*
 * Find smallest factor of a number n > 2
 *
 * J D Eisenberg, 30 Sep 2019
 */

import java.util.Scanner;

public class FindFactorCompound {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a number greater than 2: ");
		int n = input.nextInt();
		
		int factor = 2;
		while (factor <= n && (n % factor != 0)) {
			factor++;
		}
		System.out.printf("The smallest factor of %d is %d.\n",
			n, factor);

		input.close();
	}
}
