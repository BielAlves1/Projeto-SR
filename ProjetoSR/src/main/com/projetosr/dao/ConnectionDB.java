package com.projetosr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.projetosr.controller.Mensagem;

public class ConnectionDB {
	//Atributos para a conexão com o Banco de dados
		private static String dns = "jdbc:mysql://localhost:3306/SR";
		private static String usuario = "root";
		private static String senha = "";
		private static Connection con;
		
		//Método que faz a conexão efetivamente
		public static Connection getConnection() {
			try {
				if(con == null || con.isClosed()) {
					DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					con = DriverManager.getConnection(dns, usuario, senha);
				}
				return con;
			} catch (SQLException e) {
				Mensagem.addMensagem("Erro ao conectar ao BD: "+ e);
				return null;
			}
		}
}
