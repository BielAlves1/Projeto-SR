package com.projetosr.model;

public class FuncionarioModel {

	private int idFuncionario;
	private int idFuncao;
	private String nome;
	private double valorHora;
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public int getIdFuncao() {
		return idFuncao;
	}
	public void setIdFuncao(int idFuncao) {
		this.idFuncao = idFuncao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValorHora() {
		return valorHora;
	}
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
}
