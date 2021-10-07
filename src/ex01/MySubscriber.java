package ex01;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

// 구독자 = 일반인 = 소비자
public class MySubscriber implements Subscriber<Integer>{

	private Subscription subscription;
	private Integer size;
	private Integer maxSize;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		System.out.println("2. 구독 응답 완료(구독 정보 - 데이터its, 구독자subscriber)");
		this.subscription = subscription;
		while(true) {
			size = 3;
			maxSize = size;
			subscription.request(size);
		}
	}

	@Override
	public void onNext(Integer item) {
		System.out.println("4. 신문 받음." + item);
		size--;
		if(size==0) {
			size = maxSize;
			subscription.request(size);
		}
	}

	@Override
	public void onError(Throwable throwable) {
		System.out.println("신문 전달 실패");
	}

	@Override
	public void onComplete() {
		System.out.println("더 이상 줄 신문이 없다");
	}
	
}
