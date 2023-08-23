package br.edu.ufape.poo.barbeariaufape.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.barbeariaufape.modelos.basica.Produto;

@Repository
public interface InterfaceColecaoProduto
	extends JpaRepository<Produto, Long>{
	
	
	public Produto findByNome(String nome);
}