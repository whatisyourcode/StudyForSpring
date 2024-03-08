<h2>2강</h2>
1. <strong>뷰 템플릿</strong><br>
<p>웹 페이지를 하나의 틀로 만들고 여기에 변수를 삽입해 서로 다른 페이지로 보여주는 기술이다.</p>

2. <strong>MVC 패턴</strong><br>
<p>웹 페이지를 화면에 보여주고(View), 클라이언트 요청을 받아 처리하고(Controller), 데이터를 관리하는(Model) 역할을 영역별로 나누어 하는 기법을 말한다.</p>

3. <strong>뷰 템플릿 생성 위치</strong><br>
<p>뷰 템플릿은 <code>src > main > resource > template</code> 디렉토리에 만든다. 이 프로젝트에서 뷰 템플릿 확장자는 <code>.mustache</code>를 사용하였다.</p>

4. <strong>컨트롤러 생성 위치</strong><br>
<p>컨트롤러는 <code>src > main > java > 기본 패키지</code> 안에 컨트롤러 패키지를 만든 후 자바 클래스 파일을 생성하는 방식으로 만든다. 확장자는 <code>.java</code>이다.</p>

5. <strong>모델을 통해 변수 등록하는 방법</strong><br>
<p>모델은 컨트롤러의 메서드에서 매개변수로 받아온다. 모델에서 변수를 등록할 때는 <code>addAttribue()</code> 메서드를 사용한다.</p>
<p>ex) <code>model.addAttribute("변수명", 변수값);</code></p>

6. <strong>헤더-푸터 레이아웃</strong><br>
<p>헤더-푸터 레이아웃은 가장 기본이 되는 레이아웃이다. 샌드위치 같은 구조로 상단의 헤더(header) 영역에는 사이트 안내를 위한 네비게이션을 넣고, 하단의 푸터(footer) 영역에는 사이트 정보를 넣는다. 두 영역 사이에는 사용자가 볼 핵심 내용인 콘텐트(content)를 배치한다.</p>

7. <strong>레이아웃 템플릿 생성과 적용</strong><br>
<p>레이아웃 템플릿 파일은 <code>src > main > resources > templates</code> 디렉토리에 만든다. (프로젝트에서는 파일 관리를 편리하기 위해 <code>layouts</code> 디렉토리를 추가한 후 만들었다).<br>
레이아웃 템플릿을 삽입할 때는 원하는 위치에서 <code>{{> 파일경로/파일명}}</code> 형식으로 작성한다.</p>


<h2>3강</h2>

<h2>1. 폼 데이터와 <code>&lt;form&gt;</code> 태그</h2>
<p>폼 데이터는 <code>&lt;form&gt;&lt;/form&gt;</code> 태그에 실려 전송되는 데이터를 말합니다. <code>&lt;form&gt;</code> 태그에는 전송할 데이터를 어디에 어떻게 보낼지도 설정하는데, 어디에 보낼지는 <code>action</code> 속성으로, 어떻게 보낼지는 <code>method</code> 속성으로 설정합니다.</p>

<h2>2. DTO</h2>
<p>폼 데이터에 실어 보낸 데이터는 서버의 컨트롤러가 객체를 담아 받는데, 이 객체를 DTO(Data Transfer Object)라고 합니다. DTO로 받은 데이터는 최종적으로 데이터베이스(Data Base)에 저장됩니다.</p>

<h2>3. 폼 데이터를 DTO로 받는 과정</h2>
<img src="https://github.com/whatisyourcode/StudyForSpring/assets/87058844/de864f71-69be-44ba-a16b-da335195c87a.png" alt="이미지 설명">

<h2>4. 데이터베이스</h2>
<p>데이터를 관리하는 창고로, 줄여서 DB라고 합니다. DB의 모든 데이터는 행과 열로 구성된 테이블에 저장되고 관리됩니다.</p>

<h2>5. JPA</h2>
<p>자바 언어로 DB에 명령을 내리게 하는 도구로 데이터를 객체 지향적으로 관리하도록 도와줍니다. JPA의 핵심도구로는 엔티티(entity)와 리파지터리(repository)가 있습니다.
- 엔티티: 자바 객체를 DB가 이해할 수 있게 만든 것으로, 이를 기반으로 테이블이 만들어집니다.
- 리파지터리: 엔티티가 DB 속 테이블에 저장 및 관리될 수 있게 하는 인터페이스입니다.</p>

<h2>6. DTO를 DB에 저장하는 과정</h2>

<h2>7. 의존성 주입</h2>
<p>외부에서 만들어진 객체를 필요한 곳으로 가져오는 기법을 의존성 주입(DI, Dependency Injection)이라고 합니다. 스프링 부트는 <code>@Autowired</code> 어노테이션으로 의존성 주입을 할 수 있습니다.</p>

<h2>8. SQL</h2>
<p>SQL(Structured Query Language)은 데이터를 관리하기 위해 고안된 DB용 언어입니다. DB에 데이터를 생성(create), 조회(read), 수정(update), 삭제(delete)하는 CRUD 조작을 수행합니다.</p>

--------------------------------------------------------------------------------------------------------------------------------------------<br>
출처: https://www.gilbut.co.kr/book/view?bookcode=BN003778
