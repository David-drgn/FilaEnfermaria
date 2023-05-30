package Model;

public class Atendimento {
	private int idAtendimento, idMedico, numeroConsultorrio;
	private double dataAtendimento, horaAtendimento;
	
	public double getDataAtendimento() {
		return dataAtendimento;
	}
	
	public void setDataAtendimento(double dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}
	
	public double getHoraAtendimento() {
		return horaAtendimento;
	}
	
	public void setHoraAtendimento(double horaAtendimento) {
		this.horaAtendimento = horaAtendimento;
	}
	
}
