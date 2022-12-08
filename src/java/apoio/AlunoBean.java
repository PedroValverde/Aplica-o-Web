/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelos.Aluno;


@ManagedBean
@SessionScoped
public class AlunoBean {

    private Aluno aluno = new Aluno();
    private List<Aluno> alunos;

    public AlunoBean() {
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getAlunos() {
        if (this.alunos == null) {
            EntityManager em = JPAUtil.getEntityManager();
            Query a = em.createQuery("select a from Aluno a",
                    Aluno.class);
            this.alunos = a.getResultList();
            em.close();
        }

        return alunos;
    }

    public String salva() {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            em.getTransaction().begin();
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (aluno.getMatricula() != null) {
                //Atualiza os dados da pessoa.
                aluno = em.merge(aluno);
            } else {
                //Salva os dados da pessoa.
                em.persist(aluno);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        this.alunos = null;
        return "ListarAlunos";
    }

    public void excluir(Aluno aluno) {

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        aluno = em.merge(aluno);
        em.remove(aluno);
        em.getTransaction().commit();
        em.close();

        this.alunos = null;

    }

    public String alterar(Aluno a) {
        this.aluno = a;
        return "CadastrarAluno";
    }

    public String cadastrarNovo() {
        aluno = new Aluno();
        return "/aluno/CadastrarAluno";
    }
}
