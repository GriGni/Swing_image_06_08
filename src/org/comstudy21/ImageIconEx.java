package org.comstudy21;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ImageIconEx extends JFrame {
	JRadioButton[] radio = new JRadioButton[3];
	String[] text = {"�౸", "��", "�߱�"};
	ImageIcon[] image = {
			new ImageIcon("D:/hesu_20200421/2_java_work/swing_proj/image/image1.png"),
			new ImageIcon("D:/hesu_20200421/2_java_work/swing_proj/image/image2.png"),
			new ImageIcon("D:/hesu_20200421/2_java_work/swing_proj/image/image3.png"),
	};
	JPanel content;
	JLabel imageLabel = new JLabel();
	JTextField txtField = new JTextField(12);
	JButton okBtn = new JButton();
	
	//2
	public ImageIconEx() {
		setTitle("�̹��� �󺧰� ���� ��ư ����");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		content = (JPanel) getContentPane();
		content.setLayout(new BorderLayout());
		
		// ���
		JPanel radioPanel = new JPanel();
		radioPanel.setBackground(Color.DARK_GRAY);
		//���� ��ư �׷츸��Ѥ���
		ButtonGroup btnGroup = new ButtonGroup();
		for(int i = 0; i<radio.length;i++) {
			radio[i] = new JRadioButton(text[i]);
			btnGroup.add(radio[i]);
			radioPanel.add(radio[i]);
			radio[i].addItemListener(new MyItemListener());
		}
		
		radio[0].setSelected(true);
		content.add(radioPanel, BorderLayout.NORTH);

		imageLabel.setIcon(image[0]);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		content.add(imageLabel);
		
		JPanel txtFieldPane = new JPanel();
		txtFieldPane.add(txtField);
		txtFieldPane.add(okBtn);
		
		content.add(txtFieldPane, BorderLayout.SOUTH);
		setSize(640, 480);
	}
	
	//���� ��ư �̺�Ʈ ��鷯 Ŭ���� ����
	
	class MyItemListener implements ItemListener{
		// ���̵� ��ư�� �̺�Ʈ�� �߻��ϸ� ����Ǵ� �޼ҵ�
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange()==ItemEvent.DESELECTED) {
				return;
			}
			if(radio[0].isSelected()) imageLabel.setIcon(image[0]);
			else if(radio[1].isSelected()) imageLabel.setIcon(image[1]);
			else if(radio[2].isSelected()) imageLabel.setIcon(image[2]);
			else imageLabel.setIcon(image[0]);
		}
	
	}
	
	//1
	public static void main(String[] args) {
		new ImageIconEx().setVisible(true);
	}
}
