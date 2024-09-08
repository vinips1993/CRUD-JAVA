package org.fiap.crud.view;

import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestecCrud {

    private static final Logger logger = LoggerFactory.getLogger(TestecCrud.class);
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "RM550907";
    private static final String PASSWORD = "220493";

    private static final String SQL_INSERT =
            "INSERT INTO T_PRODUTO (CD_PRODUTO, NM_PRODUTO, DT_VALIDADE, VL_PRODUTO) " +
                    "VALUES (seq_id_produto.NEXTVAL, ?, TO_DATE(?, 'dd/mm/yyyy'), ?)";

    private static final String SQL_SELECT = "SELECT * FROM T_PRODUTO";

    private static final String SQL_DELETE = "DELETE FROM T_PRODUTO WHERE CD_PRODUTO = ?";

    public static void main(String[] args) {
        TestecCrud dao = new TestecCrud();
        try {
            dao.inserirProduto("UVA", "18/08/2024", 12.80);
            dao.listarProdutos();
            dao.deletarProduto(1);
        } catch (SQLException e) {
            logger.error("Erro ao executar operações no banco de dados", e);
        }
    }

    public void inserirProduto(String nome, String validade, double valor) throws SQLException {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }

        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conexao.prepareStatement(SQL_INSERT)) {

            conexao.setAutoCommit(false);  // Desativa o auto-commit

            pstmt.setString(1, nome);
            pstmt.setString(2, validade);
            pstmt.setDouble(3, valor);

            pstmt.executeUpdate();
            conexao.commit();  // Confirma a transação
            logger.info("Produto inserido com sucesso.");

        } catch (SQLException e) {
            logger.error("Erro ao inserir produto", e);
            throw e;
        }
    }

    public void listarProdutos() throws SQLException {
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conexao.prepareStatement(SQL_SELECT);
             ResultSet result = pstmt.executeQuery()) {

            logger.info("Listando produtos:");
            while (result.next()) {
                System.out.println(result.getInt("CD_PRODUTO") + " " +
                        result.getString("NM_PRODUTO") + " " +
                        result.getDate("DT_VALIDADE") + " " +
                        result.getDouble("VL_PRODUTO"));
            }

        } catch (SQLException e) {
            logger.error("Erro ao listar produtos", e);
            throw e;
        }
    }

    public void deletarProduto(int id) throws SQLException {
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conexao.prepareStatement(SQL_DELETE)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            logger.info("Produto com CD_PRODUTO = {} foi deletado.", id);

        } catch (SQLException e) {
            logger.error("Erro ao deletar produto", e);
            throw e;
        }
    }
}
