package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import hello.hellospring.domain.Member;

public interface MemberRepository {
	Member save(Member member);   // 회원을 저장하면 저장된 회원이 반환됨
	Optional<Member> findById(Long id);  	// id로 회원을 찾기 
	Optional<Member> findByName(String name);   
	List<Member> findAll();  	// 현재 저장된 모든 회원
	

}
