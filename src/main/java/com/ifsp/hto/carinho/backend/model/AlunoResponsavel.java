package com.ifsp.hto.carinho.backend.model;

import java.awt.print.Book;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AlunoResponsavel {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 
	    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	    @JoinColumn(name = "nome", referencedColumnName = "id", nullable = false)
	    private Aluno aluno;

	    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	    @JoinColumn(name = "nome_resp", referencedColumnName = "id", nullable = false)
	    private Responsavel responsavel;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Aluno getAluno() {
			return aluno;
		}

		public void setAluno(Aluno aluno) {
			this.aluno = aluno;
		}

		public Responsavel getResponsavel() {
			return responsavel;
		}

		public void setResponsavel(Responsavel responsavel) {
			this.responsavel = responsavel;
		}
	    
	    

	
	    
	


}



