package io.eunhae.jpa;

import io.eunhae.jpa.entity.Diary;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DiaryJpa {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("diary-book");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        //
        try{
 //           em.persist(Diary.sample());
            Diary foundDiary = em.find(Diary.class, "0001");
            foundDiary.setLocation("Vichy");
 //         em.remove(foundDiary);
            System.out.println(foundDiary.toString());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
