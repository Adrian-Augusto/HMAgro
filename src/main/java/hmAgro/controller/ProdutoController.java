package hmAgro.controller;

import hmAgro.dto.ProdutoDTO;
import hmAgro.model.Produto;
import hmAgro.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "https://agronomia-front-end-4qh79ebjc-adrian-augustos-projects.vercel.app")

@RestController
@RequestMapping("/products")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto criar(@Valid @RequestBody ProdutoDTO dto) {
        return produtoService.save(dto);
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoService.findAll();
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id,
                             @Valid @RequestBody ProdutoDTO dto) {
        return produtoService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        produtoService.delete(id);
        return "Produto deletado com sucesso";
    }
}
