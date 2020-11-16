import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com o caminho do arquivo a ser lido: ");
		String pathname = sc.next();
		
		File firstFile = new File(pathname);
		String dirParent = firstFile.getParent();
				
		boolean createdSubDir = new File(dirParent.concat("\\out")).mkdir();

		String secondFile = dirParent.concat("\\out\\"+firstFile.getName());
		boolean createdFile = new File(secondFile).createNewFile();
//		System.out.println(createdFile ? "arquivo novo criado" : "nao foi possível criar arquivo");
		
		try (BufferedReader br = new BufferedReader(new FileReader(firstFile))) {
			String line = br.readLine();

			while (line != null) {
				String[] array = line.split(",");

				int qtd = Integer.parseInt(array[2].toString().trim());
				double preco = Double.parseDouble(array[1].toString().trim());
				String produto = array[0].toString().trim();

				System.out.println(produto.toUpperCase() + " - " + preco * qtd);

				if (createdSubDir) {					
					if (createdFile) {
						try (BufferedWriter bw = new BufferedWriter(new FileWriter(secondFile,true))) {

							bw.write(produto + " - " + (preco * qtd));
							bw.newLine();

						} catch (IOException e) {
							// TODO: handle exception
						}
					}
				}

				line = br.readLine();
			}

		} catch (IOException e) {
			// TODO: handle exception
		}

		sc.close();
	}

}
