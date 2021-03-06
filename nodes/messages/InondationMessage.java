package projects.inondation.nodes.messages;

import sinalgo.nodes.messages.Message;

public class InondationMessage extends Message {

	private static int msgCounter = 0;
	private int msgId;
	public InondationMessage() {
		super();
		msgId = msgCounter;
		msgCounter++;
	}

	public Message clone() {
		return this;
	}
	
	public String toString() {
		return "walker" + msgId;
	}
}