package chars_from_image;

import java.util.Scanner;

public class Main {
	static public void main(String args[]) throws Exception {
		Scanner scn = new Scanner(System.in);
		String command = "";
		String temp = "";
		ImageSystem imgsys = new ImageSystem();
		
		while(command != "exit") {
			System.out.println("Commands;");
			System.out.println("+open (Open with file chooser)");
			System.out.println("+paste (Paste file path)");
			System.out.println("+path (Control selected image path)");
			System.out.println("+draw (Draw selected image)");
			System.out.println("+char (Selected image char)");
			System.out.println("+exit (Exit)");
			System.out.print("Command: ");
			command = scn.next();

			if(command.contains("open")) {
				imgsys.selectImage();
				
			}
			else if(command.contains("paste")) {
				System.out.println("Image path: ");
				temp = scn.next();
				imgsys.setSelectedImage(temp);
			}
			else if(command.contains("char")) {
				System.out.println("Selected char: ");
				temp = scn.next();
				imgsys.setSelectedChar(temp.charAt(0));
			}
			else if(command.contains("draw")) {
				imgsys.drawImage();
			}
			else if(command.contains("path")) {
				System.out.println(imgsys.getSelectedImage());
			}
			
			System.out.println("");
		}
	}
}