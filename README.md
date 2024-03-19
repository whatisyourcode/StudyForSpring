<h2>2강</h2>
<strong>1. 뷰 템플릿</strong><br>
<p>웹 페이지를 하나의 틀로 만들고 여기에 변수를 삽입해 서로 다른 페이지로 보여주는 기술이다.</p>

<strong>2. MVC 패턴</strong><br>
<p>웹 페이지를 화면에 보여주고(View), 클라이언트 요청을 받아 처리하고(Controller), 데이터를 관리하는(Model) 역할을 영역별로 나누어 하는 기법을 말한다.</p>

<strong>3. 뷰 템플릿 생성 위치</strong><br>
<p>뷰 템플릿은 <code>src > main > resource > template</code> 디렉토리에 만든다. 이 프로젝트에서 뷰 템플릿 확장자는 <code>.mustache</code>를 사용하였다.</p>

<strong>4. 컨트롤러 생성 위치</strong><br>
<p>컨트롤러는 <code>src > main > java > 기본 패키지</code> 안에 컨트롤러 패키지를 만든 후 자바 클래스 파일을 생성하는 방식으로 만든다. 확장자는 <code>.java</code>이다.</p>

<strong>5. 모델을 통해 변수 등록하는 방법</strong><br>
<p>모델은 컨트롤러의 메서드에서 매개변수로 받아온다. 모델에서 변수를 등록할 때는 <code>addAttribue()</code> 메서드를 사용한다.</p>
<p>ex) <code>model.addAttribute("변수명", 변수값);</code></p>

<strong>6. 헤더-푸터 레이아웃</strong><br>
<p>헤더-푸터 레이아웃은 가장 기본이 되는 레이아웃이다. 샌드위치 같은 구조로 상단의 헤더(header) 영역에는 사이트 안내를 위한 네비게이션을 넣고, 하단의 푸터(footer) 영역에는 사이트 정보를 넣는다. 두 영역 사이에는 사용자가 볼 핵심 내용인 콘텐트(content)를 배치한다.</p>

<strong>7. 레이아웃 템플릿 생성과 적용</strong><br>
<p>레이아웃 템플릿 파일은 <code>src > main > resources > templates</code> 디렉토리에 만든다. (프로젝트에서는 파일 관리를 편리하기 위해 <code>layouts</code> 디렉토리를 추가한 후 만들었다).<br>
레이아웃 템플릿을 삽입할 때는 원하는 위치에서 <code>{{> 파일경로/파일명}}</code> 형식으로 작성한다.</p>

<h2>3강</h2>

<strong>1. 폼 데이터와 <code>&lt;form&gt;</code> 태그</strong>
<p>폼 데이터는 <code>&lt;form&gt;&lt;/form&gt;</code> 태그에 실려 전송되는 데이터를 말합니다. <code>&lt;form&gt;</code> 태그에는 전송할 데이터를 어디에 어떻게 보낼지도 설정하는데, 어디에 보낼지는 <code>action</code> 속성으로, 어떻게 보낼지는 <code>method</code> 속성으로 설정합니다.</p>

<strong>2. DTO</strong>
<p>폼 데이터에 실어 보낸 데이터는 서버의 컨트롤러가 객체를 담아 받는데, 이 객체를 DTO(Data Transfer Object)라고 합니다. DTO로 받은 데이터는 최종적으로 데이터베이스(Data Base)에 저장됩니다.</p>

<strong>3. 폼 데이터를 DTO로 받는 과정</strong>
<img src="https://github.com/whatisyourcode/StudyForSpring/assets/87058844/de864f71-69be-44ba-a16b-da335195c87a.png" alt="이미지 설명">

<strong>4. 데이터베이스</strong>
<p>데이터를 관리하는 창고로, 줄여서 DB라고 합니다. DB의 모든 데이터는 행과 열로 구성된 테이블에 저장되고 관리됩니다.</p>

<strong>5. JPA</strong>
<p>자바 언어로 DB에 명령을 내리게 하는 도구로 데이터를 객체 지향적으로 관리하도록 도와줍니다. JPA의 핵심도구로는 엔티티(entity)와 리파지터리(repository)가 있습니다.</p>
<p>- 엔티티: 자바 객체를 DB가 이해할 수 있게 만든 것으로, 이를 기반으로 테이블이 만들어집니다.</p>
<p>- 리파지터리: 엔티티가 DB 속 테이블에 저장 및 관리될 수 있게 하는 인터페이스입니다.</p>

<strong>6. DTO를 DB에 저장하는 과정</strong>
<img src="https://github.com/whatisyourcode/StudyForSpring/assets/87058844/97233979-8cdc-460d-9805-e7764f0ba9c1">

<strong>7. 의존성 주입</strong>
<p>외부에서 만들어진 객체를 필요한 곳으로 가져오는 기법을 의존성 주입(DI, Dependency Injection)이라고 합니다. 스프링 부트는 <code>@Autowired</code> 어노테이션으로 의존성 주입을 할 수 있습니다.</p>

<strong>8. SQL</strong>
<p>SQL(Structured Query Language)은 데이터를 관리하기 위해 고안된 DB용 언어입니다. DB에 데이터를 생성(create), 조회(read), 수정(update), 삭제(delete)하는 CRUD 조작을 수행합니다.</p>

<h2>4강</h2>

<strong>1. 롬복</strong>
<p>코드를 간소화해주는 라이브러리입니다. 롬복을 사용하면 여러 필수 코드가 반복되는 것을 최소화할 수 있고 println() 문을 로깅 기능으로 대체할 수 있습니다.</p>

<strong>2. 로깅</strong>
<p>프로그램의 수행 과정을 기록으로 남기는 것을 말합니다. 일종의 자동차 블랙박스와 같습니다. println()은 사용시 서버에 악 영향을 줄 수 있고, 데이터 검증기록도 남지 않습니다.</p>

<strong>3. 리팩터링</strong>
<p>코드의 기능에는 변함이 없이 코드의 구조 또는 성능을 개선하는 작업을 말합니다. 리팩터링하면 코드의 가독성이 좋아지고 길이도 짧아져서 개발 시간을 단축할 수 있습니다.</p>

<strong>4. @AllArgsConstructor</strong>
<p>클래스의 안쪽의 모든 필드를 매개변수로 하는 생성자를 만드는 어노테이션으로, 이를 사용하면 클래스 내에 별도의 생성자를 만들지 않아도 됩니다.</p>

<strong>5. @ToString</strong>
<p>toString() 메서드를 사용하는 것과 똑같은 효과를 냅니다. 별도의 toString() 메서드를 사용하지 않아도 됩니다.</p>

<strong>6. Slf4j</strong>
<p>Simple Logging Facade for Java의 약자로, 로깅할 때 사용합니다. 로깅 기능으로 로그를 찍으면 나중에라도 그동안 찍힌 로그를 찾아볼 수 있습니다. 로그를 찍을 때는 log.info()문을 사용합니다.</p>

<h2>5강</h2>

<strong>1. 데이터 조회 과정</strong>
<p>웹 페이지에서 게시글을 등록하면 서버를 통해 DB에 저장됩니다. DB에 저장된 데이터는 다음과 같은 과정을 거쳐 웹 페이지에서 조회할 수 있습니다.</p>
![다운로드](https://github.com/whatisyourcode/StudyForSpring/assets/87058844/bfb1d89e-a416-40fe-a098-9fb14470ce95)
<ol>
  <li>사용자가 웹 페이지에서 데이터를 조회해 달라고 URL 요청을 보냅니다.</li>
  <li>서버의 컨트롤러가 이 요청을 받아 해당 URL에서 찾으려는 데이터 정보(여기서는 id)를 리파지터리에 전달합니다.</li>
  <li>리파지터리는 정보(id)를 가지고 DB에 데이터 조회를 요청합니다.</li>
  <li>DB는 해당 데이터를 찾아 이를 엔티티로 반환합니다.</li>
  <li>반환된 엔티티는 모델을 통해 뷰 템플릿으로 전달됩니다.</li>
  <li>최종적으로 결과 뷰 페이지가 완성돼 사용자 화면에 출력됩니다.</li>
</ol>

<strong>8. @PathVariable</strong>
<p>URL 요청으로 들어온 전달값을 컨트롤러의 매개변수로 가져오는 어노테이션입니다.</p>

<strong>10. findById()</strong>
<p>JPA의 CrudRepository가 제공하는 메서드로, 특정 엔티티의 id값을 기준으로 데이터를 찾아 Optional 타입으로 반환합니다. (orElse(null)로 해결)</p>

<strong>12. findAll()</strong>
<p>JPA의 CrudRepository가 제공하는 메서드로, 특정 엔티티를 모두 가져와 Iterable 타입으로 반환합니다.</p>

<strong>14. {{#article}}{{/article}}</strong>
<p>뷰 페이지에서 모델에 등록된 article의 사용 범위를 지정할 때 사용하는 머스테치 문법입니다.</p>

<strong>16. 반환 데이터 타입 불일치 문제 해결 방법</strong>

------------------------------------------------------------------------------------------------------------------------------------------------<br>
출처: https://www.gilbut.co.kr/book/view?bookcode=BN003778
