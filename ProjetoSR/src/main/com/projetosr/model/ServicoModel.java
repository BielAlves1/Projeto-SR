package com.projetosr.model;

import java.sql.Date;

public class ServicoModel {
	private int idServico;
	private int idFuncionario;
	private int idObra;
	private Date horaInicio;
	private Date horaPrevista;
	private double totalDiaria;
	
	public int getIdServico() {
		return idServico;
	}
	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public int getIdObra() {
		return idObra;
	}
	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getHoraPrevista() {
		return horaPrevista;
	}
	public void setHoraPrevista(Date horaPrevista) {
		this.horaPrevista = horaPrevista;
	}
	public double getTotalDiaria() {
		return totalDiaria;
	}
	public void setTotalDiaria(double totalDiaria) {
		this.totalDiaria = totalDiaria;
	}

	
}
