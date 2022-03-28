package it.polito.tdp.corsi.model;

public class Divisione {
private String CDS;
private Integer numero;
public Divisione(String cDS, Integer numero) {
	super();
	CDS = cDS;
	this.numero = numero;
}
public String getCDS() {
	return CDS;
}
public void setCDS(String cDS) {
	CDS = cDS;
}
public Integer getNumero() {
	return numero;
}
public void setNumero(Integer numero) {
	this.numero = numero;
}
@Override
public String toString() {
	return "Divisione [CDS=" + CDS + ", numero=" + numero + "]";
}


}
