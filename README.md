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
> MemberDAO에서 객체 조회 요청을 하고 결과를 리턴 받는 과정까지의 아키텍쳐

- MemberDAO 클래스를 통해 find(id)를 실행하면, JPA는 SELECT SQL을 생성한다.
- JDBC API를 사용하여 생성된 SELECT SQL을 보낸다.
- DB에서 반환된 정보를 ResultSet 매핑을 통해 객체로 변환해 준다.
- 이 과정에서도 패러다임 불일치 문제를 해결해 준다.

<br/>

<h3>4. JPA에서의 테이블 연관 관계 매핑 방법</h3>

<br/>

<h4>4-1. join column 사용(외래 키)</h4>

![image](https://github.com/user-attachments/assets/b3d463f3-f971-40a7-93d7-9e335e0706fa)
> 테이블 간에 조인 컬럼을 따로 만들어서 관계를 맺는 방법(외래 키 컬럼 사용)

<br/>

<h5>@JoinColumn</h5>

- 사용하는 이유
  - 기본적으로 외래키를 저장할 column name을 지정할 수 있다.
  - referencedColumnName 값을 이용해 외래 키로 참조할 대상 테이블의 컬럼을 설정할 수 있다.
  - insertable, updatable 등의 옵션을 사용할 수 있다.
    - ex) @JoinColumn(insertable = false, updatable = false)
    - insertable
      - 엔티티 저장 시 이 필드도 같이 저장한다.
      - false 로 설정하면 데이터베이스에 저장하지 않는다.
      - 읽기 전용일 때 사용한다.
    - updatable
      - 엔티티 수정 시 이 필드도 같이 저장한다.
      - false 로 설정하면 데이터베이스에 수정하지 않는다.
      - 읽기 전용일 때 사용한다. 
- name 속성
  - 매핑할 외래 키의 이름을 지정하는 속성
  - FK를 누가 가지는가 -> 연관관계의 주인이 누구인가? 외래키 관리자가 누구인가? 
- referencedColumnName
  - 조인할 대상 테이블의 컬럼을 의미한다. (Join 절의 ON에 해당하는 대상)
<br/>

<h4>4-2. join table 사용(테이블 사용)</h4>

![image](https://github.com/user-attachments/assets/c92a596d-8a2e-4cc6-afa4-a6bd521033e8)
> 조인 테이블이라는 별도의 테이블을 사용해서 연관관계를 관리하는 방법

<br/>

<h5>@JoinTable</h5>

- 데이터 베이스 설계에 따라 필요한 경우에는 별도의 테이블을 만들어서 각 테이블의 외래키를 통해 연관 관계를 설정한다
- name 속성
  - 매핑할 조인 테이블의 테이블 명을 지정하는 속성
- joinColumns
  - 현재 Entity에서 참조할 외래키(FK)를 설정
- inverseJoinColumns 
  - 외래키가 참조하는 대상 테이블의 컬럼명을 지정해 주는 역할
  - default값은 참조하는 테이블의 기본키(pk)의 컬럼명이 됨
 
<h4>4-3. 연관관계별 어노테이션</h4>

- @OneToOne: JoinColumn을 사용하는 Entity가 연관관계의 주인, 즉 FK를 가진다.(1:1)
- @ManyToOne: JoinColumn을 사용하는 Entity가 연관관계의 주인, 즉 FK를 가진다.(N:1)
- @OneToMany: JoinColumn을 사용하는 Entity의 반대 Entity가 연관관계의 주인, 즉 FK를 가진다.(1:N)
- @ManyToMany: JoinColumn을 사용하는 Join Table(Entity)가 연관관계의 주인, 즉 FK를 가진다.(N:N)

어노테이션의 옵션
- mappedBy: 연관 관계의 주인을 지정하는 옵션

JoinColumn과 mappedBy의 차이점
- JoinColumn은 연관 관계를 맺고 있는 '테이블'에서 외래 키를 매핑할 때 사용 
- mappedBy는 연관 관계의 주인이 아닌 '엔티티'에서 관계를 매핑할 때 사용(보통 양방향 연관관계에서 사용)
