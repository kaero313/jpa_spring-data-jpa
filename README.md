<h1>jpa/spring data jpa 기본 사용법 정리</h1>

<h3>1. JPA(Java Persistence API)란?</h3>

- Java 진영에서 ORM(Object-Relational Mapping) 기술 표준으로 사용하는 인터페이스 모음
- 자바 어플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스
- 실제로 동작하는 것이 아닌, 인터페이스 이기 때문에 Hibernate, EclipseLink 등이 JPA를 구현함

<br/>

![image](https://github.com/user-attachments/assets/9607619c-fdfd-4be3-aea8-4dd025b5fe19)
> JPA 표준 명세를 구현하여 사용함(Hibernate 등은 JPA를 미리 구현해놓은 구현체이자 클래스임)

<br/>

<h3>2. JPA의 특징</h3>

- 반복적인 CRUD SQL 처리를 쉽게 해준다.

![image](https://github.com/user-attachments/assets/697db7f0-587f-40a1-b067-df200461e356)
> 기존의 쿼리를 한줄로 간단하게 사용할 수 있음(select 쿼리문)

- DB 구조에 대한 강한 의존성 제거(테이블에 하나의 컬럼 추가시 모든 SQL문 변경 필요 등)
- 자바 객체가 테이블에 자동으로 영속화 되서 객체 지향의 장점을 살릴 수 있음

- JPA의 단점
  - 난이도가 있다. 장점을 더 극대화 하기 위해서 알아야 할게 많음
  - 잘 이해하고 사용하지 않으면 데이터 손실 및 성능 이슈가 있을 수 있음 (persistence context)

<br/>

<h3>3. JPA 동작 과정</h3>

![image](https://github.com/user-attachments/assets/b9acc7e5-a19b-45d5-ab0d-5b730f31a508)
> JPA는 애플리케이션과 JDBC 사이에서 동작함

- JPA를 사용하면, JPA내부에서 JDBC API를 사용하여 SQL을 호출하고 DB와 통신을 한다.(사용자가 직접 JDBC API를 사용하지 않음)

<br/>

<h4>3-1. JPA 저장 과정</h4>

![image](https://github.com/user-attachments/assets/e1e9397c-3be5-458a-900a-e936365444bb)
> MemberDAO에서 객체를 저장하는 과정까지의 아키텍쳐

- MemberDAO 클래스를 통해 persist()를 실행하면, JPA가 Entity 객체를 분석하여 SQL문을 생성한다.
- JDBC API를 사용하여 DB에 생성된 INSERT SQL을 보내게 된다.
- 이 과정에서 JPA는 객체와 데이터베이스 테이블의 패러다임 불일치를 해결한다.

<br/>

<h4>3-2. JPA 조회 과정</h4>

![image](https://github.com/user-attachments/assets/a5a9d809-918a-4e6f-922b-05a7cb54eac7)

