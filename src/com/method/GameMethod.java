package com.method;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.entity.GameElement;

/**
 * 提供游戏物体的基本方法
 * @author Administrator
 *
 */
public class GameMethod {

	/**
	 * 画出游戏图像本身
	 * @param graphics
	 * @param gameElement
	 */
	public void drawSelf(Graphics graphics,GameElement gameElement){
		graphics.drawImage(gameElement.getImage(), gameElement.getCoordinateX().intValue(), 
				gameElement.getCoordinateY().intValue(),null);
	}
	
	/**
	 * 返回物体所在的矩形。便于后续的碰撞检测
	 * @param gameElement
	 * @return
	 */
	public Rectangle getRectangle(GameElement gameElement){
		return new Rectangle(gameElement.getCoordinateX().intValue(), gameElement.getCoordinateY().intValue(),
				gameElement.getWidth(), gameElement.getHeight());
	}
}
