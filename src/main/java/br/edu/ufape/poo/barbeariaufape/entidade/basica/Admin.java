package br.edu.ufape.poo.barbeariaufape.entidade.basica;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Pessoa {

    private String cargo;

    public Admin() {
        
    }

    public Admin(String nome, String cpf, String telefone, Endereco endereco, String cargo) {
        super(nome, cpf, telefone, endereco);
        this.cargo = cargo;
    }

    // Getters e setters
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
