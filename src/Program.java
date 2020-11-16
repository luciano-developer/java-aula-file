import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com o caminho da pasta: ");
		String pathname = sc.next();
		
		File file = new File(pathname);
		
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getPath());

		sc.close();
	}

}
