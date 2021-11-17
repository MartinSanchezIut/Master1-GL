package jeubidon;

import java.util.Stack;

import jeubidon.command.Command;

public class Lanceur {
	// Voir pour le redo
	private Stack<Command> commandes;
	
	public Lanceur() {
		commandes = new Stack<>();
	}
	
	public boolean canReverse() {
		return !commandes.isEmpty();
	}
	
	public void executeCommand(Command c) {
		commandes.push(c);
		c.execute();
	}
	public void reverseCommand() {
		Command c = commandes.pop();
		c.undo();
	}
	
	public String getHistory() {
		StringBuilder sb = new StringBuilder() ;
		sb.append("Solution : ") ;
		for (Command c : commandes) {
			sb.append(c.toString() + ", ");
		}
		
		return sb.toString();
	}
}
