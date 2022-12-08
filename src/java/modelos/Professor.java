/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class Professor extends Pessoa {

    private String titulacao;
    private Integer anoContratacao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Professor_Orienta_Aluno", joinColumns = {
        @JoinColumn(name = "PROFESSOR_ID", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "ALUNO_ID", referencedColumnName = "id")})
    private final List<Aluno> alunos;

    public Professor() {
        this.alunos = new ArrayList<>();
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public Integer getAnocontratacao() {
        return anoContratacao;
    }

    public void setAnocontratacao(Integer anoContratacao) {
        this.anoContratacao = anoContratacao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionaAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void removeAluno(Aluno aluno) {
        this.alunos.remove(aluno);
    }

}
