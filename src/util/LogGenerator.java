package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogGenerator {
	
	public static void generateLog(String message) throws IOException {
            
                Date data = new Date();
                String padrao = "dd/MM/yyyy HH:mm:ss";
                SimpleDateFormat formatar = new SimpleDateFormat(padrao);
		
		Path path = Paths.get("C:/logs/");
		
		if(!Files.exists(path)) {
			
			Files.createDirectory(path);
			
		}
		
		File log = new File("C:/logs/logs.txt");
		
		if(!log.exists()) {
			
			log.createNewFile();
		
		}
		
		FileWriter fw = new FileWriter(log, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(formatar.format(data));
                bw.write(" - ");
		bw.write(message);
		bw.newLine();

		bw.close();
		fw.close();
		
	}
}