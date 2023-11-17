package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UserPage extends JPanel{

	String user;
	JTextArea txt;
	
	public UserPage(String user) {
		this.user=user;
		
		txt = new JTextArea();
		setLayout(new BorderLayout());
		
		add(txt,BorderLayout.CENTER);
		
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout());
		
		JButton sendMessage=new JButton("Send");
		sendMessage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sendMessage();
			}
		});
		JButton readMessages=new JButton("Read");
		readMessages.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				readMessages();
			}
		});
		
		JButton logout=new JButton("Exit");
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AppFrame.getInstance().setLogin();
			}
		});
		add(logout,BorderLayout.NORTH);
		buttons.add(readMessages,BorderLayout.WEST);
		buttons.add(sendMessage,BorderLayout.EAST);
		
		this.add(buttons,BorderLayout.SOUTH);
	}

	
	protected void readMessages() {
		// TODO Auto-generated method stub
		
		List<Message> messages = getMessages();
		txt.setText("");
		for(Message m : messages) {
			txt.append(m.toString()+System.lineSeparator());
		}
	}

	private List<Message> getMessages() {
		// TODO Auto-generated method stub
		/*
		 * Implement this method for reading message in "username"/messages/
		 * 
		 * Messages are stored in different files for each sender user
		 * Return the list of messages 
		 * 		Each message stores:
		 * 			Timestamp
		 * 			SenderUser
		 * 			Content
		 * Clean up messages folder
		 * */
		return results;
	}


	protected void sendMessage() {
		// TODO Auto-generated method stub
		String receiver = new JOptionPane().showInputDialog("Who is the receiver?");
		if(receiver == null || receiver.equals("")) {
			new JOptionPane().showMessageDialog(null, "Empty receiver");
			return;
		}
		
		String content = txt.getText();
		
		Message m = new Message(user,content);
		if(send(m,receiver)) {
			new JOptionPane().showMessageDialog(null, "Message sent correctly");
			txt.setText("");
		}
		else new JOptionPane().showMessageDialog(null, "Error sending ("+m+")");
		
		
		
	}


	private boolean send(Message message, String receiver) {
		/*
		 * Implement message sending procedure
		 * 
		 * The Receiver stores messages in the file "receiver_user"/messages/"sender_user".msg
		 * 
		 * If no previous messages from the current user exist then the message has to be stored in a new file
		 * Otherwise the message should be appended to the previous one
		 * 
		 * If there is any failure (receiver does not exist or write operation fails) this method returns false
		 * In all the other cases the current method returns true
		 * 
		 * */
		return false;
	}

	


}
