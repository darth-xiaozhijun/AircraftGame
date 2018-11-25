package com.method;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.entity.Plane;

/**
 * 提供飞机的基本方法
 * @author Administrator
 *
 */
public class PlaneMethod extends GameMethod{

	/**
	 * 按下某个键，增加相应的方向
	 * @param keyEvent
	 * @param plane
	 */
	public void addDirection(KeyEvent keyEvent,Plane plane){
		
		//如果飞机生存
		if(plane.getLive()){
			switch (keyEvent.getKeyCode()) {
			
			case KeyEvent.VK_LEFT:
				plane.setLeft(true);
				break;
				
			case KeyEvent.VK_RIGHT:
				plane.setRight(true);
				break;
				
			case KeyEvent.VK_UP:
				plane.setUp(true);;
				break;
				
			case KeyEvent.VK_DOWN:
				plane.setDown(true);;
				break;
			}
		}
	}
	
	/**
	 * 释放某个键，取消相应的方向
	 * @param keyEvent
	 * @param plane
	 */
	public void minusDirection(KeyEvent keyEvent,Plane plane){
		
		switch (keyEvent.getKeyCode()) {
		
		case KeyEvent.VK_LEFT:
			plane.setLeft(false);
			break;
			
		case KeyEvent.VK_RIGHT:
			plane.setRight(false);
			break;
			
		case KeyEvent.VK_UP:
			plane.setUp(false);;
			break;
			
		case KeyEvent.VK_DOWN:
			plane.setDown(false);;
			break;
		}
	}
	
	/**
	 * 控制飞机的移动方向
	 * @param graphics
	 * @param plane
	 * @param speed
	 */
	public void controlDirection(Graphics graphics,Plane plane,Integer speed){
		
		Integer coordinateX = plane.getCoordinateX().intValue();//X坐标
		Integer coordinateY = plane.getCoordinateY().intValue();//Y坐标
		
		if(plane.getLive()){

			graphics.drawImage(plane.getImage(), coordinateX, coordinateY, null);
			
			if(plane.getLeft()){
				coordinateX -= speed;
				plane.setCoordinateX(coordinateX.doubleValue());
				
			}else if(plane.getRight()){
				coordinateX += speed;
				plane.setCoordinateX(coordinateX.doubleValue());
				
			}else if(plane.getUp()){
				coordinateY -= speed;
				plane.setCoordinateY(coordinateY.doubleValue());
				
			}else if(plane.getDown()){
				coordinateY += speed;
				plane.setCoordinateY(coordinateY.doubleValue());
			}
			
		}
	}
}
