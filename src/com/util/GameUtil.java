package com.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {

	//私有化工具类的构造方法
	private GameUtil(){}
	
	/**
	 * 指定路径的图片对象
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
