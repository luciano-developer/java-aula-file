import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com o caminho da pasta: ");
		String pathname = sc.next();
		
		File path = new File(pathname);
		
		File[] folders = path.listFiles(File::isDirectory);
		for (File folder : folders) {
			System.out.println(folder);
		}	
	
		File[] files = path.listFiles(File::isFile);
		for (File file : files) {
			System.out.println(file);
		}
		
		boolean success = new File(path + "\\subdir").mkdir();
		System.out.println("DIRETORIO CRIADO COM SUCESSO:" + success);
		
		sc.close();
	}

}
