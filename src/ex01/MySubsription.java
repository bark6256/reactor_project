package ex01;

import java.util.Iterator;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

// 구독 정보
// 연결 된 사용자 마다 생성됨
public class MySubsription implements Subscription{

	private Iterator<Integer> it;
	private Subscriber subscriber;
	
	public MySubsription(Iterable<Integer> its, Subscriber subscriber) {
		System.out.println(" - 구독 정보 만들어짐");
		this.it = its.iterator();
		this.subscriber = subscriber;
	}

	@Override
	public void request(long n) {
		System.out.println("3. 신문 " + n + "개씩 받는다.");	// 백프레셔 조정을 해야한다.
		while(n-- > 0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(it.hasNext()) {
				subscriber.onNext(it.next());
			} else {
				subscriber.onComplete();
			}
		}
	}

	@Override
	public void cancel() {
		System.out.println("구독 취소됨");
	}
	
	
}
