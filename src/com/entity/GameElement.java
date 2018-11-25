package com.entity;

import java.awt.Image;

/**
 * 游戏物体实体类
 * @author Administrator
 *
 */
public class GameElement{

	public Image image;//图片路径
	
	public Double coordinateX;//X坐标
	
	public Double coordinateY;//Y坐标
	
	public Integer speed;//速度
	
	public Integer width;//长度
	
	public Integer height;//高度
	
	public GameElement(Image image, Double coordinateX, Double coordinateY) {
		
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.image = image;
	}
	
	public GameElement() {
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(Double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public Double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(Double coordinateY) {
		this.coordinateY = coordinateY;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	
}
