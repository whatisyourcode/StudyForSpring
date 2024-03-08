<h2>2강</h2>
1.### 뷰 템플릿
<p>웹 페이지를 하나의 틀로 만들고 여기에 변수를 삽입해 서로 다른 페이지로 보여주는 기술이다.</p>
2.<strong>MVC 패턴</strong><br>
<p>웹 페이지를 화면에 보여주고(View), 클라이언트 요청을 받아 처리하고(Controller),데이터를 관리하는(Model) 역할을 영역별로 나누어 하는 기법을 말한다.</p>
3.<strong>뷰 템플릿 생성 위치</strong><br>
<p>뷰 템플릿은 src > main > resource > template 디렉토리에 만든다.이 프로젝트에서 뷰 템플릿 확장자는 .mustache를 사용하였다.</p>
4.<strong>컨트롤러 생성 위치</strong><br>
<p>컨트롤러는 src > main > java > 기본 패키지 안에 컨트롤러 패키지를 만든 후 자바 클래스 파일을 생성하는 방식으로 만든다.확장자는 .java이다.</p>
5.<strong>모델을 통해 변수 등록하는 방법</strong><br>
<p>모델은 컨트롤러의 메서드에서 매개변수로 받아 온다.모델에서 변수를 등록할 때는 addAttribue() 메서드를 사용한다.</p>
<p>ex) model.addAttribue("변수명", 변수값);</p>
6.<strong>헤더-푸터 레이아웃</strong><br>
<p>헤더-푸터 레이아웃은 가장 기본이 되는 레이아웃이다.샌드위치 같은 구조로 상단의 헤더(header) 영역에는 사이트 안내를 위한 네비게이션을 넣고, 하단의 푸터(footer) 영역에는 사이트 정보를 넣는다.두 영역 사이에는 사용자가 볼 핵심 내용인 콘텐트(content)를 배치한다.</p>
7.<strong>레이아웃 템플릿 생성과 적용</strong><br>
<p>레이아웃 템플릿 파일은 src > main > resources > templates 디렉토리에 만든다.(프로젝트에서는 파일 관리를 편리하기 하게 위해 layouts 디렉토리를 추가한 후 만들었다).<br>
레이아웃 템플릿을 삽일할 때는 원하는 위치에서 {{>파일경로/파일명}} 형식으로 작성한다.</p>

<h2>3강</h2>
1.폼 데이터와 <form>태그
폼 데이터는 <form></form> 태그에 실려 전송되는 데이터를 말한다. <form> 태그에는 전송할 데이터를 어디에 어떻게 보낼지도 설정하는데, 어디에 보낼지는 action 속성으로,  어떻게 보낼지는 method 속성으로 설정한다.
2.DTO
폼 데이터에 실어 보낸 데이터는 서버의 컨트롤러가 객체를 담아 받는데, 이 객체를 DTO(Data Trsnfer Object)라고 한다.DTO로 받은 데이터는 최종적으로 데이터베이스(Data Base)에 저장된다.
3.폼 데이터를 DTO로 받는 과정
--------------------------------------------------------------------------------------------------------------------------------------------<br>
출처: https://www.gilbut.co.kr/book/view?bookcode=BN003778
