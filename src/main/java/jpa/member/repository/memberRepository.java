package jpa.member.repository;

import jpa.member.dto.member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface memberRepository extends JpaRepository<member, String> {

    public List<member> findAll();

    public List<member> findAllById(Iterable<String> ids);



}
