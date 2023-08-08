package ThreadEx;
/*
 * 프로세스 : 실행 중인 프로그램 == 카카오톡 
 * 스레드 : 프로세스 내 흐름 단위 == 카카오톡 내 각각의 대화
 * 스레드는 한 프로세스 내에 동작되는 흐름으로, 
 * stack(지역변수) 영역만 별도로 할당받고, 부모 프로세스의code(프로그램), data(정적변수, 전역변수), heap영역(동적으로 할당 한 것들)은 공유한
 * 하나의 프로세스는 하나 이상의 스레드를 가질 수 있다
 * 
 * 우리가 메인 메서드를 정의해서 
 * main{
 *   } 여기 사이에 작성해놓은 것을 실행한다면
 * 이 메인메서드 코드가 메모리 위에 올라가 있을 거고,
 * cpu가 그 코드를 하나씩 읽어서 실행하는데 그 동작을 할 때
 * 이 스레드라고 하는 개념으로 시작점부터 끝점까지 하나의 작업 흐름을 형성한다.
 * main이 시작한다 끝났다
 * 이 스레드의 내용을 처리하는 것 
 * 
 * 멀티 스레드라는 것도 있음
 * 스레드가 여러개라는 것인데, 여러개의 프로세스가 동작하면
 * 멀티 테스킹 == 작업이 여러개 
 *  
 * 스레드가 여러개가 있을 때, 이 프로그램 하나를 프로세스로 동작시킨다면
 * cpu는 이렇게 동작한다.
 * ThreadA ThreadB ThreadC 왔다갔다하면서
 * 구덩이를 판다 생각하면 된다! 이걸 굉장히 빠르게 한다고 생각하면?
 * 거의 3개를 시에 하는 것처럼 보임 => 절대 동시에 하는 게 아님
 * 하나의 cpu는 한번에 하나의 명령(스레드)만 처리 할 수 있음 
 * 
 * 어떤 프로그램은 스레드 1개 어떤 프로그램은 3개 
 * 그런 건 cpu 입장에서는 아무 의미가 없음(프로그램 다르다는 거 인식은 중요하지 않음) 그냥 해야할 일 중 하나일뿐 
 * 
 * 
 * 정리하면cpu가 어떤 프로세스를 동작할때, 스레드가 여러개 일 수 있고 
 * 그 여러개의 스레드를 cpu 여가저기 돌아다니면서 처리를 한다
 * 그래서 우리의 컴퓨터에서는 멀티테스킹이 가능한 것
 * 
 * 예를 들면 우리가 System.out.println();이런 함수를 하나를 사용할 때
 * 우리는 한 이지만 1,0으로만 표기할 수 있는 컴퓨터에선 꽤나 복잡한 명령들로 이루어져 있음
 * 그리고 이러한 명령들이 스레드 단위로 처리가 되고 있다 
 * 물을 먹는다 -> 일어나서 방문을 열고 컵을 들고 정수기를 동작시킨다 이런 느낌
 *
 *그리고 스레드랑 자바는 관련이 없음
 *그냥 자바 코드 cpu가 스레드 단위로 처리할 수 있게 프로그램을 작성하기 위해서
 *제공하는 클래스들이 있는 것 (관련은 운영체제와 있다)
 *
 *그러면 이제 스레드를 만들어보자!
 *그리고 멀티스레드는 어떻게 동작하는 것인지 코드로 보자!
 */

public class MainThread {

	public static void main(String[] args) {
		ThreadA th = new ThreadA();
		Thread th2 = new Thread(new ThreadB());
		th2.start();
		
		/*애는 스레들를 상속받은 게 아님
		 * 얘는 스레드를 구현한게 아니기 때문에 start 사용불가 
		 * 그래서 new thread를 생성해!
		 * 그리고 생성자에 runnable을 구현한 객체 == new ThreadB()
		 * 해주면 정의된 정의된 runnable이 동작할 수 있음 
		 * 
		 * 이게 자바에서 스레드를 구현하는 방법
		 * 1. 스레드 클래스를 상속하여서 run() 을 정의하거나
		 * 2. Runnable 인터페이스를 구현 후
		 * 스래드 객체를 생성해서 스레드 클래스에 정의된 start()호출해서 사용 
		 */
				
		
	    th.start(); // 새로운 스레드(run메서드 시작)
		//ThreadA를 new해서 생성, 해당 스레드에 run을 호출하는 것이 아닌 start()를 호출 
	    //또 다른 쓰레드를 만들어보자! ThreadB로 이동 
		for(int i=0;i<1000;i++) {
			System.out.println("main : " + i);
		}
		
/*
 * 스레드로 1000번 사이에 뭔가 다른 작업도 끼워 넣어보자
 * class ThreadA를 만들어보자 
 * 
 */
	}

}

