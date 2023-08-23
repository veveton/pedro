package br.edu.ufape.poo.barbeariaufape.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.barbeariaufape.entidade.basica.Produto;
import br.edu.ufape.poo.barbeariaufape.exception.ProdutoDuplicadoException;
import br.edu.ufape.poo.barbeariaufape.exception.ProdutoNaoExisteException;


public interface ICadastroProdutoService {

	Produto procurarProdutoNome(String nome) throws ProdutoNaoExisteException;

	Produto salvarProduto(Produto entity) throws ProdutoDuplicadoException;

	List<Produto> listarProdutos();

	boolean verificarExistenciaProdutoId(Long id);

	Produto localizarProdutoId(Long id);

	void removerProdutoNome(String nome) throws ProdutoNaoExisteException;

}