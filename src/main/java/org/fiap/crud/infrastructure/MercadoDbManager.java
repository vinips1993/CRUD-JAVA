package org.fiap.crud.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;

public class MercadoDbManager {

    public static Connection obterConexao () {
        Connection conexao = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                    "RM550907",
                    "220493");
        } catch (Exception e) {
            e.printStackTrace();
        } return conexao;
    }

}
