package jpa.member.repository;

import jpa.member.dto.Member;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface memberRepository extends JpaRepository<Member, String> {

    @Override
    List<Member> findAll(Sort sort);

    @Override
    List<Member> findAllById(Iterable<String> strings);

    @Override
    <S extends Member> S save(S entity);

    @Override
    <S extends Member> List<S> saveAll(Iterable<S> entities);

    @Override
    <S extends Member> long count(Example<S> example);

    @Override
    void delete(Member entity);

    @Override
    void deleteById(String s);

    @Query(value = "select * from member where id = ?1 and pw = ?2 and name = ?3", nativeQuery = true)
    List<Member> query(String id, String pw, String name);

    @Query(value = "select * from member where id = :id and pw = :pw and name = :name", nativeQuery = true)
    List<Member> query_param(@Param(value = "id") String id, @Param(value = "pw") String pw, @Param(value = "name") String name);

    @Query(value = "select * from member where id = :#{#member.id} and pw = :#{#member.pw} and name = :#{#member.name}", nativeQuery = true)
    List<Member> query_object(@Param(value = "member") Member member);
}
