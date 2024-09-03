package jpa.member.repository;

import jpa.member.dto.member;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface memberRepository extends JpaRepository<member, String> {

    @Override
    List<member> findAll(Sort sort);

    @Override
    List<member> findAllById(Iterable<String> strings);

    @Override
    <S extends member> S save(S entity);

    @Override
    <S extends member> List<S> saveAll(Iterable<S> entities);

    @Override
    <S extends member> long count(Example<S> example);

    @Override
    void delete(member entity);

    @Override
    void deleteById(String s);

    @Query(value = "select * from member where id = ?1 and pw = ?2 and name = ?3", nativeQuery = true)
    List<member> query(String id, String pw, String name);

    @Query(value = "select * from member where id = :id and pw = :pw and name = :name", nativeQuery = true)
    List<member> query_param(@Param(value = "id") String id, @Param(value = "pw") String pw, @Param(value = "name") String name);

}
