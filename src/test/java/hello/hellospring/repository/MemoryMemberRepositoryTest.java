package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();  // 테스트 할 클래스
	
	@AfterEach
	public void afterEach() {
		repository.clearStore();
		
	}  // 메서드 실행이 끝날 때마다 호출되어 동작하는 callback method
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("leeyc");
		
		repository.save(member);	// name에 저장 
		
		// 1. print로 확인하기
		Member result = repository.findById(member.getId()).get();  // get을 바로 사용하는 것은 좋은 것은 아니나 테스트 코드니 그냥 사용 
		// System.out.println("result = " + (result == member));   // 저장하고자 한 값과 저장한 값이 같은지 확인 (true/false)
		
		// 2. JUnit 사용하기 
		assertEquals(member, result);  // 출력되는 것은 없으나 true 일 경우, 실행이 완료된다.  org.assertj.core.api.Assertions;
		// assertThat(member).isEqualTo(result);  // org.junit.jupiter.api.Test;
		
	}
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		Member result = repository.findByName("spring1").get();	// 회원 찾기
		assertEquals(member1, result);
		
		
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		
//		System.out.println(result);
//		for (Member member:result) {
//			System.out.println(member);
//		}
		
		
		
		assertThat(result.size()).isEqualTo(2);
	}
	
}
