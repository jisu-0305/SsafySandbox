# SSAFY SANDBOX 백엔드 프르젝트

## 1주차 CRUD

### [프론트](https://ssafysandbox.vercel.app/)에 맞춰서 Spring을 활용하여 백엔드 서버 만들어보기

- Workflow

  - 후술할 repository 세팅을 마친후 각자 마감 기한(화요일 오전)까지 1차 작업
  - 작업 후에 기한 전에 자기 repo `main` brandch에 대한 pull request 하고 review 받기 (수요일 밤)
  - review 후 금요일 모임 전까지 리팩토링 후 2차 pr
  - 금요일 아침에 보면서 review + merge

- 프로젝트 세팅

1. https://start.spring.io/
   1. SpringBoot를 사용할 거라면 해당 사이트 활용
      ![start](/assets/img/01.start_spring.png)
   2. 이미지 참고해서 세팅해보기
   3. DB 관련 의존성 build.gradle에 명시 (DB 관련 의존성 미리 넣으면 관련 세팅 전까지 에러 발생 주의 JPA, JDBC)
   - DB 의존성 관련 설정은 application.properties 나 yml 쪽 찾아볼 것
   - 사용할 RDBMS Driver 잊지 말고 등록할 것
   4. Generate 누르면 zip 다운 -> 프로젝트 생성
2. Maven, xml 사용해서 수업 때와 같은 방식으로 짜기

- repository 세팅

  - [시작 레포](https://github.com/T0nixx/SsafySandbox)에서 fork
  - `main` branch는 두고 `이름-n주차` branch를 하나 만들어서 작업

- ERD

  - ![ERD_IMG](/assets/img/01.erd_img.png) 

- CRUD

  - 링크 참고해서 명세에 맞게 백엔드 짜보기
    - [노션](https://h0ber0.notion.site/SSAFY-Sandbox-11136ff0eb9480ccbec0e1e07a6b53b3)
    - [POSTMAN](https://documenter.getpostman.com/view/17268285/2sA3s7kUzi#ac248086-bad6-4704-af02-5e1235112c92)

- 참고
  - 공부한 게 오래 남기 위해서는 발생한 에러에 대해 에러 메시지와 해결법을 정리해두면 좋다.
  - @RestController 와 @Controller의 차이
  - ResponseEntity
  - @ControllerAdvice 와 @RestControllerAdvice
  - 코드 리뷰를 할 때는 궁금한 점 자유롭게 묻고 상대방에게 그렇게 짠 이유를 묻기(나도 항상 왜 이렇게 짰는 지 생각하면서 코딩하기)
  - commit convention [노션](https://bow-snail-89d.notion.site/Convention-8763cd0df1174421be5fcaae6090444e)
  - formatter 세팅 [레포](https://github.com/naver/hackday-conventions-java/tree/master) 저장 시 포맷 할거면 바뀐 부분만 적용 할 수 있음 참고(Intellij 유료 버전만 가능...)
  - CORS
