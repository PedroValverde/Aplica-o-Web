/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import apoio.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelos.Aluno;
import modelos.Professor;


public class Orientacao {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
               
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Aluno a1 = em.find(Aluno.class, 9L);
        Aluno a2 = em.find(Aluno.class, 11L);
        Aluno a3 = em.find(Aluno.class, 10L);
        
        Professor prof = em.find(Professor.class, 5L);
        
        prof.adicionaAluno(a1);
        prof.adicionaAluno(a2);
        prof.adicionaAluno(a3);
        
        em.merge(prof);
        tx.commit();
        
        em.close();
        
    }
}
