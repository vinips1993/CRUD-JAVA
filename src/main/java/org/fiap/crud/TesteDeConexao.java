package org.fiap.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteDeConexao {

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM550907",
                    "220493");
            System.out.println("Conectou!");
            conexao.close();
        } catch (SQLException e) {
            System.err.println("Não foi Possível conectar ao Oracle");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("O Driver JDBC não foi encontrado");
            e.printStackTrace();
        }
    }
}
