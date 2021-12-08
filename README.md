# :pushpin: SNS 클론 코딩
>인스타그램 클론 
>  

</br>

## 1. 제작 기간 & 참여 인원
- 2021년 8월 11일 ~ 8월 22일
- 개인 프로젝트

</br>

## 2. 사용 기술
#### `Back-end`
  - Java 11
  - Spring Boot 2.3
  - Maven
  - Spring Data JPA
  - QueryDSL
  - MariaDB
  - Spring Security
  - 
#### `Front-end`
  - JSP

</br>

## 3. ERD 설계
![](https://user-images.githubusercontent.com/62270305/144554055-7d044627-f2c9-49f5-84a9-4f159c296e5c.png)


## 4. 핵심 기능
인스타그램이라는 SNS를 클론코딩하여
게시글 등록/삭제/수정 기능과 구독 서비스 기능 그리고 스프링 시큐리티를 사용한 로그인 기능을 구현했습니다.
메시지 및 알림 기능은 추후 구현 예정입니다.

### 4.1. 전체 흐름
![](https://user-images.githubusercontent.com/62270305/145223241-79f3b5af-d5ce-48d9-a9ce-e407116e58f5.png)

### 4.2. 사용자 요청

### 4.3. Controller



### 4.4. Service



### 4.5. Repository

![](https://zuminternet.github.io/images/portal/post/2019-04-22-ZUM-Pilot-integer/flow_repo.png)

- **컨텐츠 저장** :pushpin: [코드 확인]()
  - URL 유효성 체크와 이미지, 제목 파싱이 끝난 컨텐츠는 DB에 저장합니다.
  - 저장된 컨텐츠는 다시 Repository - Service - Controller를 거쳐 화면단에 송출됩니다.

</div>
</details>

</br>

## 5. 핵심 트러블 슈팅
### 5.1. 컨텐츠 필터와 페이징 처리 문제


## 6. 그 외 트러블 슈팅


## 6. 회고 / 느낀점
>프로젝트 개발 회고 글: 
