package chars_from_image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.*;  

public class ImageSystem {
	private File file;
	private BufferedImage image;
	private char selectedChar;
	private String selectedImage;
	private LinkedList<Pixel> imageMap;
	
	public ImageSystem() throws IOException {
		this.selectedChar = '*';
	}
	
	public void setSelectedChar(char c) {
		this.selectedChar = c;
	}
	
	public void selectImage() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);
		this.selectedImage = fileChooser.getSelectedFile().getAbsolutePath();
	}
	
	public void drawImage() throws IOException {
		if(selectedImage == null) {
			System.out.println("Image is not selected.");
			return;
		}
		
		try {
			file = new File(selectedImage);
		} 
		catch (Exception e) {
			System.out.println("Image not opened");
			return;
		}
		image = ImageIO.read(file);
		
		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				if((new Color(image.getRGB(j, i)).getRed()) == 0 && (new Color(image.getRGB(j, i))).getGreen() == 0 && (new Color(image.getRGB(j, i))).getBlue() == 0) {
					System.out.print(String.valueOf(selectedChar) + String.valueOf(selectedChar));
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.print("\n");
		}
	}
	
	public void setSelectedImage(String selectedImage) {
		this.selectedImage = selectedImage;
	}
	
	public String getSelectedImage() {
		return selectedImage;
	}
}