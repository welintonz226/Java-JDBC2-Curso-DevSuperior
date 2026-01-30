package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();//Cria uma conexão com o DB
			
			st = conn.createStatement(); //Cria um Statement do sql
			rs = st.executeQuery("select * from department"); //Atribui uma query ao resultSet 
			
			while(rs.next()) {
				/*Imprimi os dados da tabela do DB, pegando o tipo de dados 
				*(int, String) e passando o nome do campo da tabela como argumento
				*/
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatment(st); //Fecha o statement
			DB.closeResultSet(rs);//Fecha o ResultSet
			DB.closeConnection();//Fecha a conexão com DB
		}

	}

}
