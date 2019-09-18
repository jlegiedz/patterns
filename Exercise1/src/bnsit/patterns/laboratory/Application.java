package bnsit.patterns.laboratory;

import java.io.IOException;
import java.util.Scanner;

import bnsit.patterns.laboratory.model.ApplicationModel;


public class Application {

	private static final String HELLO_MESSAGE = "Welcome to Equipment Evidence System.";
	private boolean running = false;
	private ApplicationModel model = new ApplicationModel();
	
	public void run() {
		running = true;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(HELLO_MESSAGE);
		
		while (running) {
			System.out.print("ees> ");
			String command = scanner.nextLine();
			
			if (command.equals("hello")) {
				System.out.println(HELLO_MESSAGE);
			} else if (command.startsWith("save")) {
				String filename = command.split(" ")[1]; 
				try {
					model.save(filename);
				} catch (IOException e) {
					System.out.println("Model saving failure.");
				}
			} else if (command.startsWith("load")) {
				String filename = command.split(" ")[1]; 
				try {
					model.load(filename);
				} catch (IOException e) {
					System.out.println("Model loading failure.");
				}
			} else if (command.equals("exit")) {
				running = false;
			}
		}
		

	}
	
	public void stop() {
		running = false;
	}	
	
	public static void main(String[] args) {
		Application app = new Application();
		app.run();
	}
}
