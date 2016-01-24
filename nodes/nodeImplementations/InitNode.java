package projects.inondation.nodes.nodeImplementations;

import java.awt.Color;

import projects.inondation.nodes.messages.InondationMessage;
import projects.inondation.nodes.timers.InitTimer;
import sinalgo.nodes.Node;
import sinalgo.nodes.edges.Edge;

/** the initiator node sends the message (the walker) */
public class InitNode extends InondationNode {

	/* InitNode() { ... } */
	public void init() {
		super.init(); 
		setColor(Color.GREEN);
		(new InitTimer(this)).startRelative(InitTimer.timerRefresh, this); 		
	}

	public void initiate() {
		InondationMessage walker = new InondationMessage();
		System.out.println(this + " is sending now message " + walker);
		this.setColor(Color.PINK); 
		for(Edge edg : outgoingConnections)
		{
			if(this.equals(edg.startNode)){
				Node temp=edg.endNode;
				send(walker, temp);
				if(!temp.getColor().equals(Color.PINK)){
				System.out.println(this + " received message " + walker + 
								   " and sends it now to " + temp);
				}			
			
			}
		}
	}

	public String toString() {
		return super.toString() + "(init)";
	}
}
