package com.example.parkshark.service;

class MemberServiceTest {
//
//    private MemberService memberService;
//    private MemberRepository memberRepository;
//    private MemberMapper memberMapper;
//    private PersonRepository personRepository;
//    private Person person;
//    private CreateMemberWithPersonIdDto createMemberDto;
//
//    @BeforeEach
//    void setup() {
//
//        memberRepository = Mockito.mock(MemberRepository.class);
//        memberMapper = Mockito.mock(MemberMapper.class);
//        personRepository = Mockito.mock(PersonRepository.class);
//        memberService = new MemberService(memberRepository, personRepository, memberMapper);
//        person = new Person.Builder()
//                .withId(10)
//                .withAddress(new Address.Builder()
//                        .withId(1)
//                        .withStreetName("sinterklaaslaan")
//                        .with
//                        .withPostalCode(3000)
//                        .withRegion("Leuven"));
//        createMemberDto = new CreateMemberWithPersonIdDto(10, new CreateLicensePlateDto(), LocalDateTime.now(), Membership.BRONZE);
//
//    }
//
//    @DisplayName("registering a member")
//    @Nested
//    class registerAMember {
//        @DisplayName("when person exist -> save method is called in repo")
//        @Test
//        void whenMemberIsRegistered_ThenInTheMemberRepoTheSavedMethodIsCalledOnce() {
//            //GIVEN
//            //WHEN
//            memberService.createMember(createMemberDto);
//            //THEN
//            Mockito.verify(memberRepository, Mockito.times(1)).save(Mockito.any());
//        }
//
//        @DisplayName("when person does not exist --> fails")
//        @org.junit.Test(expected = PersonDoesNotExistException.class)
//        void whenRegisteringAMemberWithoutExistingPerson_ThenItThrowAnException() {
//            //GIVEN
//
//            //WHEN
//            memberService.createMember(createMemberDto);
//            //THEN
//        }
//    }


}