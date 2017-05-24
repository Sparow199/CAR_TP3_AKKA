/**
 * Message class
 */

public class Message {
	private int id;
	private String text;

	public Message(String msg, String sender, int id) {
		this.id = id;
		this.text = msg;
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}
}
