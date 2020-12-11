package com.projetosr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.projetosr.controller.Mensagem;
import com.projetosr.model.FuncaoModel;

public class FuncaoDAO {

	private ArrayList<FuncaoModel> funcoes;
	private Connection con;
	private PreparedStatement ps;
	private FuncaoModel funcao;

	public boolean cadastrar(FuncaoModel f) {
		boolean sucesso = false;
		String query = "insert into funcoes values (default,?)";
		con = ConnectionDB.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, f.getFuncao());
			if (ps.executeUpdate() > 0) {
				sucesso = true;
			}
			con.close();
		} catch (SQLException e) {
			Mensagem.addMensagem("Erro ao tentar cadastrar: " + e);
		}
		return sucesso;
	}
	
	public ArrayList<FuncaoModel> readAll() {
		funcoes = new ArrayList<>(); // Cria uma lisa vazia
		String query = "Select * from funcoes";
		con = ConnectionDB.getConnection(); // Obtem conexão
		try {
			ps = con.prepareStatement(query); // Prepara a Query
			ResultSet rs = ps.executeQuery(); // Executa a Query
			while (rs.next()) {
				funcao = new FuncaoModel();
				funcao.setIdFuncao(rs.getInt("id_funcao"));
				funcao.setFuncao(rs.getString("funcao"));
				funcoes.add(funcao);
			}
			con.close();
		} catch (SQLException e) {
			Mensagem.addMensagem("Erro ao tentar listar todas: " + e);
		}
		return funcoes;
	}
	
	public boolean alterar(FuncaoModel f) {
		boolean sucesso = false;
		String query = "update funcoes set nome = ? where id_funcao = ?";
		con = ConnectionDB.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, f.getFuncao());
			ps.setInt(2, f.getIdFuncao());
			if (ps.executeUpdate() > 0) {
				sucesso = true;
			}
			con.close();
			}catch (SQLException e) {
				Mensagem.addMensagem("Erro, ao tentar alterar: " + e);
			}
			return sucesso;
 	}

	public boolean excluir(FuncaoModel f) {
		boolean sucesso = false;
		String query = "delete from funcoes where id_funcao = ?";
		con = ConnectionDB.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, f.getIdFuncao());
			if (ps.executeUpdate() > 0) {
				sucesso = true;
			}
			con.close();
		} catch (SQLException e) {
			Mensagem.addMensagem("Erro, ao tentar excluir: " + e);
		}
		return sucesso;
	}
}
