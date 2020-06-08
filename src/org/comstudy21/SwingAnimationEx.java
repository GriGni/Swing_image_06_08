package org.comstudy21;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingAnimationEx extends JFrame implements Runnable{  // 쓰레드를 사용하기 위해 runnable을 사용.
	int x = 10, y = 10, w =50, h = 50;
	int stepSize = 10;
	int width = 640, height = 480;
	JLabel label = new JLabel("참새");
	Container contentPane;
	
	
	public SwingAnimationEx() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		contentPane = getContentPane();
		
		contentPane.setLayout(null);
		contentPane.add(label);
		label.setBounds(x, y, w, h);
		
		setSize(width, height);
		
		Thread thread = new Thread(this);
		thread.start();	
	}

	
	@Override
	public void run() {
		while(true) {
			x += stepSize;
//			label.setBounds(x, y, w, h);
			label.setLocation(x, y);
			if(x >= 600 || x<=0) {
				stepSize *= -1;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	
	public static void main(String[] args) {
		new SwingAnimationEx().setVisible(true);
		
	}
}
