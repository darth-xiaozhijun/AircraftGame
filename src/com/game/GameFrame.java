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
 * �ɻ���Ϸ��������
 * @author Administrator
 *
 */
public class GameFrame extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Image offScreenImage = null;
	
	Image bg = GameUtil.getImage(Constant.BG_URL);//����ͼƬ
	Image planeImage = GameUtil.getImage(Constant.PLANE_URL);//�ɻ�ͼƬ
	Integer speed = 3;//�ٶ�
	
	Plane plane = new Plane(planeImage, Constant.PLANE_COORDINATE_X, Constant.PLANE_COORDINATE_Y);
	GameElement gameElement = new GameElement(bg, Constant.GAME_ELEMENT_COORDINATE_X, Constant.GAME_ELEMENT_COORDINATE_Y);
	Shell shell = new Shell();
	Explode explode = null;
	
	PlaneMethod planeMethod = new PlaneMethod();
	GameMethod gameMethod = new GameMethod();
	ShellMethod shellMethod = new ShellMethod();
	
	Date startTime = new Date();
	int useTime = 0;
	
	//��ʼ���ڵ�����
	Shell[] shells = new Shell[Constant.SHELL_NUMBER];
	
	public static void main(String[] args) {
		
		GameFrame frame = new GameFrame();
		
		frame.launchGameFrame();
	}
	
	/**
	 * ��ʼ��������
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
		
		new PaintThread().start();//ִ���߳�
		
		addKeyListener(new KeyMonitor());//��Ӽ��̼����¼�
		
		for(int i=0; i<shells.length; i++){
			shells[i] = new Shell();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		
		//������
		gameMethod.drawSelf(g, gameElement);
		
		//���ɻ�
		planeMethod.controlDirection(g, plane, speed);
		
		//���ڵ�
		for(int i=0; i<shells.length; i++){
			shellMethod.drawSelf(shells[i], g);
			
			//�жϷɻ��Ƿ���ڵ���ײ
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
				Font font = new Font("����", Font.BOLD, 30);
				g.setFont(font);
				g.drawString("����ʱ�䣺"+useTime+"��", 150, 250);
			}
		}
		
	}
	
	/**
	 * �ػ�����
	 * @author Administrator
	 *
	 */
	class PaintThread extends Thread{
		
		@Override
		public void run() {
			
			while(true){
				
				repaint();//�ػ�
				//һ��ִ��25��
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * ������̼������ڲ���
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
	 * �����������������
	 */
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_FRAME_WIDTH,Constant.GAME_FRAME_HEIGHT);//������Ϸ���ڵĿ�Ⱥ͸߶�
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}
}
