package jeubidon.command;

import jeubidon.Bidon;

public class RemplirBidon extends CommandBidon{

	private Bidon b;
	public RemplirBidon(Bidon b) {
		this.b = b;
	}
	
	@Override
	public void execute() {
		volDeplace = b.getCapacite() - b.getContenu();
		b.setContenu(b.getCapacite());
	}

	@Override
	public void undo() {
		b.setContenu(b.getCapacite() - volDeplace);
	}
	
	public String toString() {
		return "Remplir " + b.getId() ;
	}
}
