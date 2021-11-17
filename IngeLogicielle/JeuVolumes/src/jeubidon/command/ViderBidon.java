package jeubidon.command;

import jeubidon.Bidon;

public class ViderBidon extends CommandBidon{

	private Bidon b;
	public ViderBidon(Bidon b) {
		this.b = b;
	}
	
	@Override
	public void execute() {
		volDeplace = b.getContenu();
		b.setContenu(0) ;
	}

	@Override
	public void undo() {
		b.setContenu(volDeplace);
	}
	
	public String toString() {
		return "Vider " + b.getId() ;
	}
}
