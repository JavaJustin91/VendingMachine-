package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Log {

	public void logAudit(String message) throws IOException {

		
		File auditLog = new File("Log.txt");
		

		try (PrintWriter writer = new PrintWriter(new FileOutputStream(auditLog, true))) {
			
			LocalDateTime timeStamp = LocalDateTime.now();

			writer.println(timeStamp + " " + message);

		}
	}

}
