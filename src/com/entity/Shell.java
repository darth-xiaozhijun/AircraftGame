package com.entity;

/**
 * 炮弹实体类
 * @author Administrator
 *
 */
public class Shell extends GameElement{

	double degree;//角度
	
	public Shell(){
		
		coordinateX = 200.0;
		coordinateY = 200.0;
		width = 10;
		height = 10;
		speed = 3;
		degree = Math.random() * Math.PI * 2;
	}

	public double getDegree() {
		return degree;
	}

	public void setDegree(double degree) {
		this.degree = degree;
	}
	
}
