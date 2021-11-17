package jeubidon.command;

import jeubidon.Bidon;

public class DeplacerVolume extends CommandBidon{

	private Bidon a;
	private Bidon b;
	public DeplacerVolume(Bidon a, Bidon b) {
		this.a = a;
		this.b = b;
	}
	
	// DEPLACER DE A -> B
	@Override
	public void execute() {
		int resteDansB = b.getCapacite() - b.getContenu();
		if (a.getContenu() <= resteDansB) {  // Le cas ou on peut vider a dans b
			volDeplace = a.getContenu();
			b.setContenu(b.getContenu() + a.getContenu());
			a.setContenu(0);
					
		}else {  // Si il y en a trop dans a
			volDeplace = resteDansB;
			b.setContenu(b.getContenu() + volDeplace);
			
			a.setContenu(a.getContenu() - volDeplace);
		}
	}

	@Override
	public void undo() {
		a.setContenu(a.getContenu() + volDeplace) ;
		b.setContenu(b.getContenu() - volDeplace);
	}
	
	public String toString() {
		return a.getId() + " -> " + b.getId() ;
	}
}
