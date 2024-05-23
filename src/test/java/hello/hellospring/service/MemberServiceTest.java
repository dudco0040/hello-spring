package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

class MemberServiceTest {
	
	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	
	@BeforeEach
	public void beforeEach() {
		memberRepository =  new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}  //테스트 실행하기 전에 실행 
	
	
	@AfterEach
	public void afterEach(){
		memberRepository.clearStore();
	}
	
	
	@Test
	void 회원가입() {
		
		//given: 가정(data 기반)
		Member member = new Member();  // 회원 생성
		member.setName("sprinㅎ");
		
		//when: ~때 (검증하려는 것?)
		Long saveId = memberService.join(member);
		
		//then: ~한 결과
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
		
	}
	
	@Test
	public void 중복_회원_예외() {
		//given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		//when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		// memberService.join(member2)를 실행했을 때, 예외 발생
		
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");  // 예외 메세지가 같은 경우, 예외 처리를 잘 해준 것으로 true 
		
		//		try {
//			memberService.join(member2);
//			fail();
//		} catch (IllegalStateException e) {
//			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//		}
		
	}
	
	@Test
	void findMembers() {
		
	}
	
	@Test
	void findOne() {
		
	}

}
