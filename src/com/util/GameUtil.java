package com.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {

	//˽�л�������Ĺ��췽��
	private GameUtil(){}
	
	/**
	 * ָ��·����ͼƬ����
	 * @param path
	 * @return
	 */
	public static Image getImage(String path){
		
		BufferedImage image = null;
		
		try {	
			URL url = GameUtil.class.getClassLoader().getResource(path);
			image = ImageIO.read(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return image;
	}
}
