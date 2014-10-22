package fr.sedara.CasseBrique;

public class Balle {
	
	private Brique actualBrique;
	private Brique destination;
	
	public Balle(){
		this.actualBrique = null;
		this.destination = null;
	}

	public Brique getBrique() {
		return actualBrique;
	}

	public void setBrique(Brique brique) {
		this.actualBrique = brique;
	}

	public Brique getDestination() {
		return destination;
	}

	public void setDestination(Brique destination) {
		this.destination = destination;
	}
	
	

}
