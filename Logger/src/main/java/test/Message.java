package test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Message {
	
	String user;
	String content;
	String timestamp;
	
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	public Message(String user, String content, String timestamp) {
		super();
		this.user = user;
		this.content = content;
		this.timestamp = timestamp;
	}
	public Message(String user, String content) {
		// TODO Auto-generated constructor stub
		this.user = user;
		this.content = content;
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(System.currentTimeMillis()));
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "[" + user + ", " + timestamp + "]: "+content;
	}
	
	public static Message getRandom() {
		Random r = new Random();
		String receiver = "user_"+r.nextInt(10);
		String content = "Hi, I'm "+receiver+". How are you?";
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(System.currentTimeMillis()));
		return new Message(receiver, content, time);
	}
	
	
	

}
