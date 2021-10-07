package ex01;

import java.util.Arrays;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

// 출판사 = 신문사
public class MyPublisher implements Publisher<Integer>{

	// 출판 할 데이터
	Iterable<Integer> its = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	
	@Override
	public void subscribe(Subscriber<? super Integer> subscriber) {
		System.out.println("1. 구독 요청");
		subscriber.onSubscribe(new MySubsription(its, subscriber));
	}

}
