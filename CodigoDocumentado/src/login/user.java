package login;

import java.sql.Connection; //importa a interface que faz a conexão com o banco de dados
import java.sql.DriverManager; //importa a inteface que permite usar drivers do banco de dados
import java.sql.ResultSet; //importa uma interface que acessa os resultados da consulta no banco de dados
import java.sql.Statement; //importa uma interface que executa uma instrução sql

public class user {
	
	//método que faz a conexão com o banco de dados
	public Connection conectarBd() {
		Connection conn = null;
		try {
			//carrega o driver JDBC
			Class.forName("com.mysql.Driver.Manager").newInstance();
			//URL de conexão com o banco de dados, usuário e senha
			String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
			//estabelece a conexão com o banco
			conn = DriverManager.getConnection(url);
			//trata uma exceção
		} catch (Exception e) {
		}
		return conn;
	}

	//variáveis de instância
	public String nome = "";
	public boolean result = false;
	
	//método para verificar o usuário no banco de dados
	Public boolean verificarUsuario(String login, String senha) {
					String sql = "";
					Connection conn = conectarBD();
					
					//INSTRUÇÃO SQL
					sql += "select nome from usuarios ";
					sql +="where login = " + "'" + login + "'";
					sql +=" and senha = " + "'" + senha + "';";
				try {
					
					//criação de uma declaração sql
					Statement st = conn.createStatement (
					//faz a consulta sql e obtém o resultado
					Resultset rs = st.executequery(sql);
					
					//verifica se houve algum retorno
					if(rs.next()) {

					result = true;
					nome = rs.getString("nome");}
					//trata uma exceção
					} catch (Exception e) {  }
					return result; }
}

//fim da class