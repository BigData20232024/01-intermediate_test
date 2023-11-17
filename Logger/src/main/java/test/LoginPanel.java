package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements ActionListener{

	JTextField username;
	JButton loginBtn;
	
	boolean admin;
	
	public LoginPanel() {
		admin=true;
		setLayout(new BorderLayout());
		
		username = new JTextField();
		
		loginBtn = new JButton("LOGIN");
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(600,300));
		add(p,BorderLayout.NORTH);
		add(username,BorderLayout.CENTER);
		add(loginBtn,BorderLayout.SOUTH);
		
		loginBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(!existsUser(username.getText())) {
			int confirmDialog = JOptionPane.showConfirmDialog(null, "Do you want to register user?");
			if(confirmDialog == JOptionPane.OK_OPTION) {
				createNewUser(username.getText());
			}else return;
		}
		loginUser(username.getText());
		
	}

	private void createNewUser(String username) {
		// create user in the HDFS
		/*
		 * This method should create a folder for the new user named "username"
		 * containing a messages folder inside
		 * */
	}

	private void loginUser(String user) {
		// TODO Auto-generated method stub
		AppFrame.getInstance().loginUser(user);
	}

	private boolean existsUser(String user) {
		// This method returns true if the user directory exists in the HDFS, false otherwise
		return false;
	}
	
}
