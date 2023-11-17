package test;

import javax.swing.JFrame;

import org.apache.hadoop.thirdparty.org.checkerframework.common.returnsreceiver.qual.This;

public class AppFrame extends JFrame{
	
	public static final int FRAME_WIDTH=600;
	public static final int FRAME_HEIGHT=400;
	
	private static AppFrame instance;
	
	private AppFrame() {
		// TODO Auto-generated constructor stub
		setLogin();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static AppFrame getInstance() {
		if(instance == null)
			instance = new AppFrame();
		return instance;
	}
	public void loginUser(String user) {
		// TODO Auto-generated method stub
		setContentPane(new UserPage(user));
		revalidate();
		
	}
	public void setLogin() {
		// TODO Auto-generated method stub
		setContentPane(new LoginPanel());
		revalidate();
	}
}
