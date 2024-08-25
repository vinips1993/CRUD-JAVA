package org.fiap.crud.view;

import java.sql.*;

public class TestecCrudEstatico {

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                    "RM550907",
                    "220493");

            Statement stmt = conexao.createStatement();
            String sql = "INSERT INTO T_PRODUTO (CD_PRODUTO, NM_PRODUTO, DT_VALIDADE, VL_PRODUTO) " +
                    "VALUES (seq_id_produto.NEXTVAL, 'UVA', TO_DATE('18/08/2024', 'dd/mm/yyyy'), 12.80 )";
            stmt.executeUpdate(sql);

            ResultSet result = stmt.executeQuery("SELECT * FROM T_PRODUTO");

            while (result.next()) {
                System.out.println( result.getInt("CD_PRODUTO") + " " +
                                    result.getString("NM_PRODUTO") + " " +
                                    result.getDate("DT_VALIDADE") + " " +
                                    result.getDouble("VL_PRODUTO"));
            }

            String sqlDelete = "DELETE FROM T_PRODUTO WHERE CD_PRODUTO =1";
            stmt.executeUpdate(sqlDelete);

            conexao.close();
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao Oracle");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("O Driver JDBC não foi encontrado");
            e.printStackTrace();
        }
    }
}
