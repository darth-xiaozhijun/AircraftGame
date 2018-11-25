package com.entity;

import java.awt.Image;

/**
 * 飞机实体
 * @author Administrator
 *
 */
public class Plane extends GameElement {

	boolean left;//向左
	
	boolean right;//向右
	
	boolean up;//向上
	
	boolean down;//向下
	
	boolean live = true;//是否生存
	
	public Plane(Image image,Double coordinateX,Double coordinateY) {
		
		this.image = image;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
	}

	public Boolean getLeft() {
		return left;
	}

	public void setLeft(Boolean left) {
		this.left = left;
	}

	public Boolean getRight() {
		return right;
	}

	public void setRight(Boolean right) {
		this.right = right;
	}

	public Boolean getUp() {
		return up;
	}

	public void setUp(Boolean up) {
		this.up = up;
	}

	public Boolean getDown() {
		return down;
	}

	public void setDown(Boolean down) {
		this.down = down;
	}

	public Boolean getLive() {
		return live;
	}

	public void setLive(Boolean live) {
		this.live = live;
	}
	
	

}
