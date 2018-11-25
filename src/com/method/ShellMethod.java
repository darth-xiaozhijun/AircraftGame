package com.method;

import java.awt.Color;
import java.awt.Graphics;

import com.constant.Constant;
import com.entity.Shell;

/**
 * 提供炮弹的基本方法
 * @author Administrator
 *
 */
public class ShellMethod extends GameMethod {

	public void drawSelf(Shell shell,Graphics graphics){
		
		Color oldColor = graphics.getColor();
		
		Double coordinateX = shell.getCoordinateX();
		Double coordinateY = shell.getCoordinateY();
		
		graphics.setColor(Color.YELLOW);
		graphics.fillOval(coordinateX.intValue(), coordinateY.intValue(), shell.width, shell.height);
		
		//炮弹沿着任意角度飞去
		coordinateX += shell.getSpeed() * Math.cos(shell.getDegree());
		shell.setCoordinateX(coordinateX);
		
		coordinateY += shell.getSpeed() * Math.sin(shell.getDegree());
		shell.setCoordinateY(coordinateY);
		
		if(shell.getCoordinateX()<0 || shell.getCoordinateX() > Constant.GAME_FRAME_WIDTH - Constant.SHELL_WIDTH ){
			shell.setDegree(Math.PI - shell.getDegree());
		}
		
		if(shell.getCoordinateY()<Constant.GAME_FRAME_UPPER_BOUNDARY || shell.getCoordinateY() > Constant.GAME_FRAME_HEIGHT - Constant.SHELL_HEIGHT ){
			shell.setDegree( - shell.getDegree());
		}
		
		graphics.setColor(oldColor);
	}
}
