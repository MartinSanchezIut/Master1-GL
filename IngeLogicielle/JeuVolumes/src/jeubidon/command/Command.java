package jeubidon.command;

public interface Command {

	// Executer la commande
	void execute();
	// Executer l'inverse de la commande
	void undo();

}
