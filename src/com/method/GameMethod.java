package com.method;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.entity.GameElement;

/**
 * �ṩ��Ϸ����Ļ�������
 * @author Administrator
 *
 */
public class GameMethod {

	/**
	 * ������Ϸͼ����
	 * @param graphics
	 * @param gameElement
	 */
	public void drawSelf(Graphics graphics,GameElement gameElement){
		graphics.drawImage(gameElement.getImage(), gameElement.getCoordinateX().intValue(), 
				gameElement.getCoordinateY().intValue(),null);
	}
	
	/**
	 * �����������ڵľ��Ρ����ں�������ײ���
	 * @param gameElement
	 * @return
	 */
	public Rectangle getRectangle(GameElement gameElement){
		return new Rectangle(gameElement.getCoordinateX().intValue(), gameElement.getCoordinateY().intValue(),
				gameElement.getWidth(), gameElement.getHeight());
	}
}
