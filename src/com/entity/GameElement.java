package com.entity;

import java.awt.Image;

/**
 * ��Ϸ����ʵ����
 * @author Administrator
 *
 */
public class GameElement{

	public Image image;//ͼƬ·��
	
	public Double coordinateX;//X����
	
	public Double coordinateY;//Y����
	
	public Integer speed;//�ٶ�
	
	public Integer width;//����
	
	public Integer height;//�߶�
	
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
