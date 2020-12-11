package com.projetosr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.projetosr.controller.Mensagem;
import com.projetosr.model.ObraModel;

public class ObraDAO {

	private ArrayList<ObraModel> obras;
	private Connection con;
	private PreparedStatement ps;
	private ObraModel obra;
	
	public boolean cadastrar(ObraModel o) {
		boolean sucesso = false;
		String query = "insert into obras values (default,?,?,?)";
		con = ConnectionDB.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, o.getNome());
			ps.setString(2, o.getDescricao());
			ps.setString(3, o.getEndereco());
			if (ps.executeUpdate() > 0) {
				sucesso = true;
			}
			con.close();
		} catch (SQLException e) {
			Mensagem.addMensagem("Erro ao tentar cadastrar: " + e);
		}
		return sucesso;
	}

	public ArrayList<ObraModel> readAll() {
		obras = new ArrayList<>(); // Cria uma lisa vazia
		String query = "Select * from obras";
		con = ConnectionDB.getConnection(); // Obtem conexão
		try {
			ps = con.prepareStatement(query); // Prepara a Query
			ResultSet rs = ps.executeQuery(); // Executa a Query
			while (rs.next()) {
				obra = new ObraModel();
				obra.setIdObra(rs.getInt("id_obra"));
				obra.setNome(rs.getString("nome"));
				obra.setDescricao(rs.getString("descricao"));
				obra.setEndereco(rs.getString("endereco"));
				obras.add(obra);
			}
			con.close();
		} catch (SQLException e) {
			Mensagem.addMensagem("Erro ao tentar listar todos: " + e);
		}
		return obras;
	}
	
	public boolean update(ObraModel o) {
		boolean sucesso = false;
		String quey = "update obras set nome = ?, descricao = ?, endereco = ? where id_obra = ?";
		con = ConnectionDB.getConnection();
		try {
			ps = con.prepareStatement(quey);
			ps.setString(1, o.getNome());
			ps.setString(2, o.getDescricao());
			ps.setString(3, o.getEndereco());
			ps.setInt(4, o.getIdObra());
			if (ps.executeUpdate() > 0) {
				sucesso = true;
			}
			con.close();
		} catch (SQLException e) {
			Mensagem.addMensagem("Erro, ao tentar alterar: " + e);
		}
		return sucesso;
	}
	
	public boolean delete(ObraModel o) {
		boolean sucesso = false;
		String query = "delete from obras where id_obra = ?";
		con = ConnectionDB.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, o.getIdObra());
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
