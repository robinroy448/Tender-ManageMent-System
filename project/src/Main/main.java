package Main;

import java.util.Scanner;

import com.project.useCase.AdminLoginUseCases;
import com.project.useCase.RegisterVendorUseCase;
import com.project.useCase.VendorLoginUseCase;

public class main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("1 : Login as admin");
		System.out.println("2 : Login as Vendor");
		System.out.println("3 : Register as Vendor");
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n==1) {
			AdminLoginUseCases.main(args);
		}
		else if(n==2) {
			VendorLoginUseCase.main(args);
		}
		else if(n==3) {
			RegisterVendorUseCase.main(args);
		}
		else {
			System.out.println("Wrong Input");
		}
		
	}
}
