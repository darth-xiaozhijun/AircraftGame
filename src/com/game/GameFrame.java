package com.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import com.constant.Constant;
import com.entity.Explode;
import com.entity.GameElement;
import com.entity.Plane;
import com.entity.Shell;
import com.method.GameMethod;
import com.method.PlaneMethod;
import com.method.ShellMethod;
import com.util.GameUtil;

/**
 * 飞机游戏的主窗口
 * @author Administrator
 *
 */
public class GameFrame extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Image offScreenImage = null;
	
	Image bg = GameUtil.getImage(Constant.BG_URL);//背景图片
	Image planeImage = GameUtil.getImage(Constant.PLANE_URL);//飞机图片
	Integer speed = 3;//速度
	
	Plane plane = new Plane(planeImage, Constant.PLANE_COORDINATE_X, Constant.PLANE_COORDINATE_Y);
	GameElement gameElement = new GameElement(bg, Constant.GAME_ELEMENT_COORDINATE_X, Constant.GAME_ELEMENT_COORDINATE_Y);
	Shell shell = new Shell();
	Explode explode = null;
	
	PlaneMethod planeMethod = new PlaneMethod();
	GameMethod gameMethod = new GameMethod();
	ShellMethod shellMethod = new ShellMethod();
	
	Date startTime = new Date();
	int useTime = 0;
	
	//初始化炮弹数量
	Shell[] shells = new Shell[Constant.SHELL_NUMBER];
	
	public static void main(String[] args) {
		
		GameFrame frame = new GameFrame();
		
		frame.launchGameFrame();
	}
	
	/**
	 * 初始化主窗口
	 */
	public void launchGameFrame(){
		
		this.setTitle(Constant.GAME_NAME);
		this.setVisible(true);
		this.setSize(Constant.GAME_FRAME_WIDTH, Constant.GAME_FRAME_HEIGHT);
		this.setLocation(Constant.GAME_FRAME_COORDINATE_X, Constant.GAME_FRAME_COORDINATE_Y);
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent event){
				System.exit(0);
			}
		});
		
		new PaintThread().start();//执行线程
		
		addKeyListener(new KeyMonitor());//添加键盘监听事件
		
		for(int i=0; i<shells.length; i++){
			shells[i] = new Shell();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		
		//画背景
		gameMethod.drawSelf(g, gameElement);
		
		//画飞机
		planeMethod.controlDirection(g, plane, speed);
		
		//画炮弹
		for(int i=0; i<shells.length; i++){
			shellMethod.drawSelf(shells[i], g);
			
			//判断飞机是否和炮弹相撞
			boolean isCollide = shellMethod.getRectangle(shells[i]).intersects(planeMethod.getRectangle(plane));
			
			if(isCollide){
				plane.setLive(false);
				
				if(explode == null){
					explode = new Explode(plane.coordinateX, plane.coordinateY);
					
					Date endTime = new Date();
					useTime = (int) ((endTime.getTime() - startTime.getTime())/1000);
				}
				
				explode.draw(g);
			}
			
			if(!plane.getLive()){
				
				g.setColor(Color.RED);
				Font font = new Font("宋体", Font.BOLD, 30);
				g.setFont(font);
				g.drawString("生存时间："+useTime+"秒", 150, 250);
			}
		}
		
	}
	
	/**
	 * 重画窗口
	 * @author Administrator
	 *
	 */
	class PaintThread extends Thread{
		
		@Override
		public void run() {
			
			while(true){
				
				repaint();//重画
				//一秒执行25次
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 定义键盘监听的内部类
	 * @author Administrator
	 *
	 */
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent arg0) {
			planeMethod.addDirection(arg0, plane);
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
			planeMethod.minusDirection(arg0, plane);
		}
		
	}
	
	/**
	 * 解决窗口闪动的问题
	 */
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_FRAME_WIDTH,Constant.GAME_FRAME_HEIGHT);//这是游戏窗口的宽度和高度
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}
}
