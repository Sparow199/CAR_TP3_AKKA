import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Graph class of question 5
 */
public class Graph {

	private final ActorSystem system = ActorSystem.create("GraphPigeon");
	private HashMap<String, ActorRef> nodes;

	/**
	 * Creation of the graph
	 */
	public Graph() {
		ArrayList<ActorRef> parent = new ArrayList<ActorRef>();
		ArrayList<ActorRef> gauche = new ArrayList<ActorRef>();
		ArrayList<ActorRef> droit = new ArrayList<ActorRef>();
		ArrayList<ActorRef> arc = new ArrayList<ActorRef>();
		ArrayList<ActorRef> arc2 = new ArrayList<ActorRef>();

		ActorRef noeud1 = system.actorOf(Props.create(Node.class, "Node1", parent));
		ActorRef noeud2 = system.actorOf(Props.create(Node.class, "Node2", gauche));
		ActorRef noeud3 = system.actorOf(Props.create(Node.class, "Node3", new ArrayList<ActorRef>()));
		ActorRef noeud4 = system.actorOf(Props.create(Node.class, "Node4", arc2));
		ActorRef noeud5 = system.actorOf(Props.create(Node.class, "Node5", droit));
		ActorRef noeud6 = system.actorOf(Props.create(Node.class, "Node6", arc));

		arc.add(noeud4);
		arc2.add(noeud6);

		gauche.add(noeud3);
		gauche.add(noeud4);

		droit.add(noeud6);

		parent.add(noeud2);
		parent.add(noeud5);

		nodes = new HashMap<String, ActorRef>();
		nodes.put("Node1", noeud1);
		nodes.put("Node2", noeud2);
		nodes.put("Node3", noeud3);
		nodes.put("Node4", noeud4);
		nodes.put("Node5", noeud5);
		nodes.put("Node6", noeud6);
	}

	public void send(String message) {
		this.send("Node1", message);
	}

	public void send(String id, String message) {
		System.out.println("Message : " + message + ", sended by : " + id);
		nodes.get(id).tell(message, ActorRef.noSender());
	}

}
