package it.polito.tdp.corsi.model;

import java.util.List;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.StudenteDAO;

public class Model {
	private CorsoDAO corsodao;
	private StudenteDAO studentedao;
	public Model() {
		corsodao= new CorsoDAO();
		studentedao=new StudenteDAO();
	}
	public List<Corso> getCorsiByPeriodo(int periodo){
		return this.corsodao.getCorsoByPeriodo(periodo);
	}
	public List<Corso> getStudentiPerCorsoPerPeriodo(int periodo){
		return this.corsodao.getStudentiPerCorsoPerPeriodo(periodo);
	}
	public List<Studente> getStudentiPerCorso(String Codins){
		return this.studentedao.getStudentiPerCorso(Codins);
	}
	public List<Divisione> getDivisioneStudenti(String codins){
		return studentedao.getDivisioneStudenti(codins);
	}
}
