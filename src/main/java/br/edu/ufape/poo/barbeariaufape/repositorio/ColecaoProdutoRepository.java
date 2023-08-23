package br.edu.ufape.poo.barbeariaufape.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.barbeariaufape.entidade.basica.Produto;

@Repository
public interface ColecaoProdutoRepository extends JpaRepository<Produto, Long> {

	public Produto findByNome(String nome);
}