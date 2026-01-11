package hmAgro.service;


import hmAgro.dto.ProdutoDTO;
import hmAgro.model.Produto;
import hmAgro.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setValor(dto.getValor());
        produto.setDescricao(dto.getDescricao());
        produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        produto.setCategoria(dto.getCategoria());

        return produtoRepository.save(produto);
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + id));
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public void delete(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado: " + id);
        }
        produtoRepository.deleteById(id);
    }

    public Produto update(Long id, @Valid ProdutoDTO dto) {

        // 1. Buscar o produto existente
        Produto produto = findById(id);

        // 2. Atualizar os campos com os valores do DTO
        produto.setNome(dto.getNome());
        produto.setValor(dto.getValor());
        produto.setDescricao(dto.getDescricao());
        produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        produto.setCategoria(dto.getCategoria());

        // 3. Salvar
        return produtoRepository.save(produto);
    }

}
