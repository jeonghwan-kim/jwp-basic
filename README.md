#### 1. Tomcat 서버를 시작할 때 웹 애플리케이션이 초기화하는 과정을 설명하라.

ContextLoaderListener

* contenxtInitialezed 메소드 실행
* JDBC의 ResourceDatabasePopulator 객체 생성 
* jwp.sql 파일로딩, 쿼리 로딩 
* DatabasePopulatorUtils.excute: 로딩한 쿼리를 디비에서 실행

DispatcherServlet

* init()
* RequestMapping() 객체 생성후 initMapping() 메소드 실행 
* 경로와 커트롤러을  맵으로 구성 
* 컨트롤러는 execute() 메서드를 구현해야함 
* 컨트롤러의 service() 메서드에서 경로로 컨트롤러를 찾아 execute() 실행 

#### 2. Tomcat 서버를 시작한 후 http://localhost:8080으로 접근시 호출 순서 및 흐름을 설명하라.

* 루트 경로 요청 
* DispatcherServlet의 service 메소드 실행
* RequestMapping에서 루트 경로를 키로 가지고 있는 컨트롤러 객체 검색
* HomeController 찾음 
* HomeController의 execute() 메서드 실행 
* home.jsp에 questions 데이터를 병합
* 뷰를 만들어 응답  

### 3. 질문하기 기능 구현 

* 질문 목록은 정상적으로 동작하지만 질문하기 기능은 정상적으로 동작하지 않는다. 
* 질문하기 기능을 구현한다. 
* 질문 추가 로직은 QuestionDao 클래스의 insert method 활용 가능하다. 
* HttpServletRequest에서 값을 추출할 때는 ServletRequestUtils 클래스를 활용 가능하다. 
* 질문하기를 성공한 후 질문 목록 페이지(“/”)로 이동해야 한다.


#### 4. 로그인 사용자만 질문하기 기능 구현 

* 로그인하지 않은 사용자도 질문하기가 가능하다. 
* 로그인한 사용자만 질문이 가능하도록 수정한다. 
* 또한 질문할 때 글쓴이를 입력하지 않고 로그인한 사용자 정보를 가져와 글쓴이 이름으로 등록한다.
* (힌트 : session.getAttribute("user")와 같이 Session에서 로그인 정보를 가져올 수 있다.)

#### 7. next.web.qna package의 ShowController는 멀티 쓰레드 상황에서 문제가 발생하는 이유에 대해 설명하라.

* 
