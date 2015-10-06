package com.test.manager;

import javax.servlet.http.*;
import java.io.*;

/**
 * Created by user on 22.09.2015.
 */
public class ImageManager {
	private static ImageManager instance = new ImageManager();

	private ImageManager() {
	}

	public static ImageManager getInstance() {
		return instance;
	}

	//TODO create enum for coinsSide

	public void saveCoinsImage(int idCoin, String coinsSide, String imageString, HttpServletRequest request){
		try {
			byte[] bytesImage = org.apache.commons.codec.binary.Base64.decodeBase64(imageString.split(",")[1]);
			// Create the file on server
			String path = request.getSession().getServletContext().getRealPath("/img/");
			File serverFile = new File(path + idCoin + coinsSide + ".jpg");
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytesImage);
			stream.close();
		} catch (Exception e) {
			System.out.println("You failed to upload " + " => " + e.getMessage());
		}
	}

	public void editCoinsImage(int idCoin, String coinsSide, String imageString, HttpServletRequest request) {
		if (deleteCoinsImage(idCoin, coinsSide, request)) {
			saveCoinsImage(idCoin, coinsSide, imageString, request);
		}
	}

	public boolean deleteCoinsImage(int idCoin, String coinsSide, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/img/");
		File serverFile = new File(path + idCoin + coinsSide + ".jpg");
		return serverFile.delete();
	}
}
