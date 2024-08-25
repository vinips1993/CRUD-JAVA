package org.fiap.crud.dao;
import org.fiap.crud.models.Produto;

import java.util.List;

public interface ProdutoDao {
    void gravar (Produto produto);
    List<Produto> buscarTodos();
    Produto buscarTodosPorCodigo(int codigo);
    void atualizar(Produto produto);
    void remover(int codigo);
}
