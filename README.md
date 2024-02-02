- 폼 데이터와 <form> 태그 -
폼데이터는 <form> 태그에 실려 전송되는 데이터를 말합니다.<form> 태그에는 어디로 전송할지를 action 속성으로 다루고 ,어떻게 보낼지는 method 속성을 통해 설정합니다.

- DTO(Data Transfer Object) - 
폼 데이터가 실어보낸 데이터를 서버의 컨트롤러가 객체에 담아 받는데, 이 객체를 DTO(Data Transfer Object)라고 합니다.
DTO로 받은 데이터는 최종적으로 데이터베이스에 저장됩니다.

- JPA - 
자바 언어로 DB에 명령을 내리는 도구로, 데이터를 객체 지향적으로 관리하도록 도와줍니다.
JPA의 핵심도구로는 엔티티(Entity)와 리파지터리(Repository)가 있습니다.
엔티티: 자바 객체를 DB가 이해할 수 있게 만든 것으로, 이를 기반으로 테이블이 만들어집니다.
리파지터리: 엔티티가 DB속 테이블에 저장 및 관리될 수 있게 하는 인터페이스입니다.

- DTO를 DB에 저장하는 과정 -
DTO를 엔티티로 변환 후 리파지터리를 이용해 엔티티를 DB에 저장합니다.

- 의존성 주입 -
외부에서 만들어진 객체를 필요한 곳으로 가져오는 기법을 의존성 주입(Dependency Injection)이라고 합니다.
스프링부트는 @Autowired 어노테이션으로 의존성 주입을 할 수 있습니다.
ArticleController에 CrudRepository를 상속받은 ArticleRepository 타입의 변수를 필드로 선언하여 @Autowired 애너테이션을 통해 의존성 주입을 받았습니다.
즉, CrudRepository 인터페이스로부터 상속 방았기에 CrudRepository의 추상 메서드 기능들을 실제로 구현하여 사용하지 않고도 스프링 부트가 필요한 객체(구현체)를 가져와 주입해줍니다.

-  SQL -
SQL(Structured Query Language)은 데이터를 관리하기 우해 고안된 DB용 언어입니다.DB 데이터를 생성(Create),조회(Read),수정(Update),삭제(Delete)하는 CRUD 조작을 수행합니다.

- SELECT문 -
SELECT 속성명 FROM 테이블명; 

- INSERT문 -
INSERT INTO 테이블명(속성명1,속성명2,속성명3) VALUES (값1,값2,값3);

