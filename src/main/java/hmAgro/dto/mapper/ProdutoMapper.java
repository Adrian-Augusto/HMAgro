package hmAgro.dto.mapper;

import hmAgro.dto.ProdutoDTO;
import hmAgro.model.Produto;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoDTO dto) {
        Produto p = new Produto();
        p.setNome(dto.getNome());
        p.setValor(dto.getValor());
        p.setDescricao(dto.getDescricao());
        p.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        p.setCategoria(dto.getCategoria());
        return p;
    }

    public static void updateEntity(Produto produto, ProdutoDTO dto) {
        produto.setNome(dto.getNome());
        produto.setValor(dto.getValor());
        produto.setDescricao(dto.getDescricao());
        produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        produto.setCategoria(dto.getCategoria());
    }
}
