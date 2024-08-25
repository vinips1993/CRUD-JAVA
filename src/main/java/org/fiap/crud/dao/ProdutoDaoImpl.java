package org.fiap.crud.dao;

import org.fiap.crud.models.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ProdutoDaoImpl implements ProdutoDao{

    private Connection conexao;
    PreparedStatement pstmt =null;

    @Override
    public void gravar(Produto produto) {

    }

    @Override
    public List<Produto> buscarTodos() {
        return null;
    }

    @Override
    public Produto buscarTodosPorCodigo(int codigo) {
        return null;
    }

    @Override
    public void atualizar(Produto produto) {

    }

    @Override
    public void remover(int codigo) {

    }
}
