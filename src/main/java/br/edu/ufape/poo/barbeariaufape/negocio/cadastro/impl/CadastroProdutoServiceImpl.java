package br.edu.ufape.poo.barbeariaufape.negocio.cadastro.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.barbeariaufape.entidade.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.exception.ProdutoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.exception.ProdutoNaoExisteException;
import br.edu.ufape.poo.barbeariaufape.negocio.cadastro.ICadastroProdutoService;
import br.edu.ufape.poo.barbeariaufape.repositorio.ColecaoProdutoRepository;

@Service
public class CadastroProdutoServiceImpl implements ICadastroProdutoService {
	@Autowired
	private ColecaoProdutoRepository colecaoProduto;

	@Override
	public Produto procurarProdutoNome(String nome) throws ProdutoNaoExisteException {
		Produto p = colecaoProduto.findByNome(nome);
		if (p == null) {
			throw new ProdutoNaoExisteException(nome);
		}
		return p;
	}

	@Override
	public Produto salvarProduto(Produto entity) throws ProdutoDuplicadoException {
		try {
			procurarProdutoNome(entity.getNome());
			throw new ProdutoDuplicadoException(entity.getNome());
		} catch (ProdutoNaoExisteException err) {
			return colecaoProduto.save(entity);
		}
	}

	@Override
	public List<Produto> listarProdutos() {
		return colecaoProduto.findAll();
	}

	@Override
	public boolean verificarExistenciaProdutoId(Long id) {
		return colecaoProduto.existsById(id);
	}

	@Override
	public Produto localizarProdutoId(Long id) {
		return colecaoProduto.findById(id).orElse(null);
	}

	@Override
	public void removerProdutoNome(String nome) throws ProdutoNaoExisteException {
		Produto p = procurarProdutoNome(nome);
		colecaoProduto.delete(p);
	}

}