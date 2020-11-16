import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {

		String[] lines = new String[] { "primeira linha", "segunda linha" };
       
		String path = "C:\\Users\\minha\\workspace-java-completo\\out.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
