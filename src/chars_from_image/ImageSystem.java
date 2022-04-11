package chars_from_image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;  

public class ImageSystem {
	private File file;
	private BufferedImage image;
	private String selectedImage;
	
	public ImageSystem() throws IOException {
		
	}
	
	public void selectImage() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);
		this.selectedImage = fileChooser.getSelectedFile().getAbsolutePath();
	}
	
	public void drawImage() throws IOException {
		file = new File(selectedImage);
		image = ImageIO.read(file);
		
		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				if((new Color(image.getRGB(j, i)).getRed()) == 0 && (new Color(image.getRGB(j, i))).getGreen() == 0 && (new Color(image.getRGB(j, i))).getBlue() == 0) {
					System.out.print("**");
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