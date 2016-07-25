import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

public class Example {

    public static void main(String[] args) {
        System.out.println("Hello, World");

		//File file = new File("C:/Users/nviso/Desktop/sdks_paul/java/examples/file.txt");
		try{
			File file = new File("C:\\Users\\nviso\\Desktop\\sdks_paul\\java\\examples\\file.txt");
			PrintWriter writer = new PrintWriter(file);
			writer.println("The first line");
			writer.println("The second line");
			writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		//FileOutputStream out = new FileOutputStream("C:/Users/nviso/Desktop/sdks_paul/java/examples/file.txt");
    }{}
}