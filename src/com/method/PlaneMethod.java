package com.method;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.entity.Plane;

/**
 * �ṩ�ɻ��Ļ�������
 * @author Administrator
 *
 */
public class PlaneMethod extends GameMethod{

	/**
	 * ����ĳ������������Ӧ�ķ���
	 * @param keyEvent
	 * @param plane
	 */
	public void addDirection(KeyEvent keyEvent,Plane plane){
		
		//����ɻ�����
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
	 * �ͷ�ĳ������ȡ����Ӧ�ķ���
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
	 * ���Ʒɻ����ƶ�����
	 * @param graphics
	 * @param plane
	 * @param speed
	 */
	public void controlDirection(Graphics graphics,Plane plane,Integer speed){
		
		Integer coordinateX = plane.getCoordinateX().intValue();//X����
		Integer coordinateY = plane.getCoordinateY().intValue();//Y����
		
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
