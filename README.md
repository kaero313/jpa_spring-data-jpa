<h1>jpa/spring data jpa 기본 사용법 정리</h1>

<h3>1. JPA(Java Persistence API)란?</h3>

- Java 진영에서 ORM(Object-Relational Mapping) 기술 표준으로 사용하는 인터페이스 모음
- 자바 어플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스
- 실제로 동작하는 것이 아닌, 인터페이스 이기 때문에 Hibernate, EclipseLink 등이 JPA를 구현함

<br/>

![image](https://github.com/user-attachments/assets/9607619c-fdfd-4be3-aea8-4dd025b5fe19)
> JPA 표준 명세를 구현하여 사용함(Hibernate 등은 JPA를 미리 구현해놓은 구현체이자 클래스임)

<br/>

<h3>2. JPA를 쓰는 이유</h3>

- 반복적인 CRUD SQL 처리를 쉽게 해준다.

![image](https://github.com/user-attachments/assets/697db7f0-587f-40a1-b067-df200461e356)
> 기존의 쿼리를 한줄로 간단하게 사용할 수 있음(select 쿼리문)
