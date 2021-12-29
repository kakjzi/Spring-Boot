package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //저장
          /*  Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            em.persist(member);*/

            //수정
           /* Member findMember = em.find(Member.class, 1L);
            findMember.setName("sdgdf");     -> JPA 가 관리해주므로 persist 를 따로 하지 않아도됨*/

            //삭제
            Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);

            //조회
            System.out.println("findMember.getId = " + findMember.getId());
            System.out.println("findMember.getName = " + findMember.getName());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
