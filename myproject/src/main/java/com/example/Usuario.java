package com.example;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Usuario {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	    private String nome;
	    private String username;
	    private String password;
	    private String foto;
	    private String endereco;
	    private String email;
	    private Date dataNascimento;
	    private String sexo;
	    private String tipo;
	    private String cpfCnpj;

    // Construtores, getters e setters aqui
    
	 public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }
	    
	    public String getNome() {
	        return nome;
	    }
	    
	    public void setNome(String nome) {
	        this.nome = nome;
	    }
	    
	    public String getUsername() {
	        return username;
	    }
	    
	    public void setUsername(String username) {
	        this.username = username;
	    }
	    
	    public String getPassword() {
	        return password;
	    }
	    
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    
	    public String getFoto() {
	        return foto;
	    }
	    
	    public void setFoto(String foto) {
	        this.foto = foto;
	    }
	    
	    public String getEndereco() {
	        return endereco;
	    }
	    
	    public void setEndereco(String endereco) {
	        this.endereco = endereco;
	    }
	    
	    public String getEmail() {
	        return email;
	    }
	    
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    public Date getDataNascimento() {
	        return dataNascimento;
	    }
	    
	    public void setDataNascimento(Date dataNascimento) {
	        this.dataNascimento = dataNascimento;
	    }
	    
	    public String getSexo() {
	        return sexo;
	    }
	    
	    public void setSexo(String sexo) {
	        this.sexo = sexo;
	    }
	    
	    public String getTipo() {
	        return tipo;
	    }
	    
	    public void setTipo(String tipo) {
	        this.tipo = tipo;
	    }
	    
	    public String getCpfCnpj() {
	        return cpfCnpj;
	    }
	    
	    public void setCpfCnpj(String cpfCnpj) {
	        this.cpfCnpj = cpfCnpj;
	    }
	    
	    // Outros métodos
	}