import akka.actor.ActorRef;
import akka.actor.UntypedActor;

import java.util.ArrayList;
import java.util.List;

/**
 * Node class
 */
public class Node extends UntypedActor {

	private String name;
	private List<ActorRef> childs;
	private List<Integer> messages;

	public Node(String name, List<ActorRef> childs) {
		this.name = name;
		this.childs = childs;
		this.messages = new ArrayList<Integer>();
	}

	public String getNom() {
		return this.name;
	}

	/**
	 * diffuse le message a tous ses enfant
	 */
	@Override
	public void onReceive(Object message) throws Exception {
		Message msg = null;
		boolean send = false;

		if (message instanceof Message) {
			// Recuperation du message
			msg = (Message) message;

			// visualisation de la diffusion
			System.out.println("Message : " + msg.getText() + ", received by : " + this.name);

			if (!messages.contains(msg.getId())) {
				messages.add(msg.getId());
				send = true;
			}
		} else if (message instanceof String) {
			String text = (String) message;
			msg = new Message(text, this.name, 1);

			if (!messages.contains(msg.getId())) {
				messages.add(msg.getId());
				send = true;
			}
		}

		if (send) {
			for (ActorRef noeud : childs) {
				// transfer du message
				noeud.forward(msg, getContext());
			}
		}
	}

}
