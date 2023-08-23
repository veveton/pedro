package br.edu.ufape.poo.barbeariaufape.negocio.cadastro.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.barbeariaufape.entidade.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.exception.ProdutoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.exception.ProdutoNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.ICadastroProduto;
import br.edu.ufape.poo.barbeariaufape.repositorio.ColecaoProdutoRepository;

@Service
public class CadastroProdutoImpl implements ICadastroProduto {
	@Autowired
	private ColecaoProdutoRepository colecaoProduto;

	
	public Produto procurarProdutoNome(String nome)
			throws ProdutoNaoExisteException {
		Produto p = colecaoProduto.findByNome(nome);
		if(p == null) {
			throw new ProdutoNaoExisteException(nome);
		}
		return p;
	}
	
	public Produto salvarProduto(Produto entity)
				throws ProdutoDuplicadoException {
		try {
			procurarProdutoNome(entity.getNome());
			throw new ProdutoDuplicadoException(entity.getNome());
		} catch(ProdutoNaoExisteException err) {
			return colecaoProduto.save(entity);
		}
	}

	public List<Produto> listarProdutos() {
		return colecaoProduto.findAll();
	}

	public boolean verificarExistenciaProdutoId(Long id) {
		return colecaoProduto.existsById(id);
	}

	public Produto localizarProdutoId(Long id) {
		return colecaoProduto.findById(id).orElse(null);
	}
	
	public void removerProdutoNome(String nome) 
			throws ProdutoNaoExisteException {
		Produto p = procurarProdutoNome(nome);
		colecaoProduto.delete(p);
	}

   

	
}