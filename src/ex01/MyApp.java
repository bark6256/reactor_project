package ex01;

public class MyApp {
	public static void main(String[] args) {
		MyPublisher pub = new MyPublisher();
		MySubscriber sub = new MySubscriber(); // 구독하는 사람. 여러명이 구독한다면 sub가 더 필요하다.
		
		pub.subscribe(sub); // 구독 시작 - 리퀘스트
	}
}
