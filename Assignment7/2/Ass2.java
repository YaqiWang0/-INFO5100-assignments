package Assignment7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ass2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File test=new File("/Users/apple/eclipse-workspace/FindFirstLargerValue/src/Assignment6/Account.java");
		parse(test);
		// TODO Auto-generated method stub

	}
	public static void parse(File file) throws IOException,FileNotFoundException {
		   RandomAccessFile input = null;
		   String line = null;
		   try {
		       input = new RandomAccessFile(file, "r");
		       while ((line = input.readLine()) != null) {
		           System.out.println(line);
		       }
		       return;
		   } 
		   
		   finally {
		       if (input != null) {
		           input.close();
		       }
		   }
		}

}
