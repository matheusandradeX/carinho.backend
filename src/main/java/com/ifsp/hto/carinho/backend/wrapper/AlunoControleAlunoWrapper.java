package com.ifsp.hto.carinho.backend.wrapper;

import com.ifsp.hto.carinho.backend.model.Aluno;
import com.ifsp.hto.carinho.backend.model.ControleAluno;

public class AlunoControleAlunoWrapper {
	
	Aluno aluno;
	ControleAluno controleAluno;
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public ControleAluno getControleAluno() {
		return controleAluno;
	}
	public void setControleAluno(ControleAluno controleAluno) {
		this.controleAluno = controleAluno;
	}
	public AlunoControleAlunoWrapper(Aluno aluno, ControleAluno controleAluno) {
		this.aluno = aluno;
		this.controleAluno = controleAluno;
	}
	
}
