package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import hello.hellospring.domain.Member;

public class MemoryMemberRepository implements MemberRepository {
	
	private static Map<Long, Member> store = new HashMap<>();	// 회원 관리 
	private static long sequence = 0L;	 // for id
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member); 		// store: id, name을 Map 형태로 저장
		
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		
		return Optional.ofNullable(store.get(id));   // null이 반환될 가능성이 있는 경우 사용
	}

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream()
				.filter(member-> member.getName().equals(name))
				.findAny();
	}
	
	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}
	
	public void clearStore(){
		store.clear();
	}

}
