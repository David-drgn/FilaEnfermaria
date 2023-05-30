package Model;

public class Cliente {
	
	enum Prioridade {
	    NORMAL,
	    Prioritario
	  }
	
	private int idPaciente, idSenha, idadePaciente;
	private String nomePaciente, especialidade;
	
	public int getIdPaciente() {
		return idPaciente;
	}
	
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	public int getIdSenha() {
		return idSenha;
	}
	
	public void setIdSenha(int idSenha) {
		this.idSenha = idSenha;
	}
	
	public int getIdadePaciente() {
		return idadePaciente;
	}
	
	public void setIdadePaciente(int idadePaciente) {
		this.idadePaciente = idadePaciente;
	}
	
	public String getNomePaciente() {
		return nomePaciente;
	}
	
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
}
