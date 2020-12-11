package com.projetosr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.projetosr.controller.Mensagem;
import com.projetosr.model.FuncionarioModel;

public class FuncionarioDAO {

	private ArrayList<FuncionarioModel> funcionarios;
	private Connection con;
	private PreparedStatement ps;
	private FuncionarioModel funcionario;
	
	public boolean cadastrar(FuncionarioModel f) {
		boolean sucesso = false;
		String query = "insert into funcionarios values (default,default,?,?)";
		con = ConnectionDB.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, f.getNome());
			ps.setDouble(2, f.getValorHora());
			if (ps.executeUpdate() > 0) {
				sucesso = true;
			}
			con.close();
		} catch (SQLException e) {
			Mensagem.addMensagem("Erro ao tentar cadastrar: " + e);
		}
		return sucesso;
	}

	public ArrayList<FuncionarioModel> readAll() {
		funcionarios = new ArrayList<>(); // Cria uma lisa vazia
		String query = "Select * from funcionarios";
		con = ConnectionDB.getConnection(); // Obtem conexão
		try {
			ps = con.prepareStatement(query); // Prepara a Query
			ResultSet rs = ps.executeQuery(); // Executa a Query
			while (rs.next()) {
				funcionario = new FuncionarioModel();
				funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
				funcionario.setIdFuncao(rs.getInt("id_funcao"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setValorHora(rs.getDouble("valorHora"));
				funcionarios.add(funcionario);
			}
			con.close();
		} catch (SQLException e) {
			Mensagem.addMensagem("Erro ao tentar listar todos: " + e);
		}
		return funcionarios;
	}
	
	public boolean update(FuncionarioModel f) {
		boolean sucesso = false;
		String quey = "update funcionarios set nome = ?, valorHora = ? where id_funcionario = ?, id_funcao = ?";
		con = ConnectionDB.getConnection();
		try {
			ps = con.prepareStatement(quey);
			ps.setString(1, f.getNome());
			ps.setDouble(2, f.getValorHora());
			ps.setInt(3, f.getIdFuncionario());
			ps.setInt(4, f.getIdFuncionario());
			if (ps.executeUpdate() > 0) {
				sucesso = true;
			}
			con.close();
		} catch (SQLException e) {
			Mensagem.addMensagem("Erro, ao tentar alterar: " + e);
		}
		return sucesso;
	}
	
	public boolean delete(FuncionarioModel f) {
		boolean sucesso = false;
		String query = "delete from funcionarios where id_funcionario = ?, id_funcao = ?";
		con = ConnectionDB.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, f.getIdFuncionario());
			ps.setInt(2, f.getIdFuncao());
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
