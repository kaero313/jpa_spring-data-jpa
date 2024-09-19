package jpa;

import jpa.member.dto.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;
/*

@Component
public class HibernateTest implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @RequestMapping(value = "hiber", method = {RequestMethod.POST})
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Unit Name을 넣어서 생성 EntityManagerFactory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 한 트랜잭션에서 실행되는 작업을 시작할 때마다 EntityManager를 반드시 만들어서 사용해줘야함
        EntityManager em = emf.createEntityManager();
        // EntityManager로 부터 트랜잭션을 받아와 사용할 수 있다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
                // 조회
                member member = em.find(member.class, "id55");
                System.out.println("memeber.id:" + member.getId());
                System.out.println("member.name: " + member.getName());

                // 수정
                member.setName("vvvvvvvvv");

                //삭제
                em.remove(member);
                tx.commit();
        } catch (Exception e) {
                tx.rollback();
        } finally {
                em.close();
        }

        emf.close();
    }

}*/
