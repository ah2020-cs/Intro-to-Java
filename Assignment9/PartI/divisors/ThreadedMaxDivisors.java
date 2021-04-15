package divisors;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ThreadedMaxDivisors implements Runnable {
	
	private long min;
	private long max;
	private Entry<Long, Long> result;
	
	public ThreadedMaxDivisors(long min, long max) {
		this.min = min;
		this.max = max;
	}

	@Override
    public void run() {
        result = CountDivisors.maxDivisors(min, max);
    }
	

	public static void main(String[] args) {
		
		long min = 100_000;
		long max = 200_000;
		
		Set<Thread> threadSet = new HashSet<Thread>();
		Set<ThreadedMaxDivisors> divisorsSet = new HashSet<ThreadedMaxDivisors>();
		long startTime = System.currentTimeMillis();

		ThreadedMaxDivisors td1 = new ThreadedMaxDivisors(100_000, 125_000);
        ThreadedMaxDivisors td2 = new ThreadedMaxDivisors(125_001, 150_000);
        ThreadedMaxDivisors td3 = new ThreadedMaxDivisors(150_001, 175_000);
        ThreadedMaxDivisors td4 = new ThreadedMaxDivisors(175_001, 200_000);

        Thread t1 = new Thread(td1);
        Thread t2 = new Thread(td2);
        Thread t3 = new Thread(td3);
        Thread t4 = new Thread(td4);

        divisorsSet.add(td1);
        divisorsSet.add(td2);
        divisorsSet.add(td3);
        divisorsSet.add(td4);


        threadSet.add(t1);
        threadSet.add(t2);
        threadSet.add(t3);
        threadSet.add(t4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
		
		/* join() tells a thread to wait until it's complete before the rest of the code and proceed.
		 * if we do that for all the threads, then then we can get the results of the threads once
		 * all of them are done
		 */
		for (Thread t: threadSet) {
			try {
				t.join();
				System.out.print("Done");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// at this point, all threads have been completed, since we
		// called the "join()" method on all the threads we created,
		// which forces the code to wait until the thread is finished
		// before we continue
		
		long key = 0;
        long divider = 0;
		
		for (ThreadedMaxDivisors tmd : divisorsSet) {
			// presumably you've recorded the results of
			// each ThreadedMaxDivisors run. Pick
			// the largest number with the largest number of
			// divisors
			if(tmd.result.getValue() >= divider){
                key = tmd.result.getKey();
                divider = tmd.result.getValue();
            }
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("\n" + key + ": " + divider);
		
		System.out.println("Threaded elapsed time: " + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		Entry<Long,Long> e = CountDivisors.maxDivisors(min, max);
		
		long number = e.getKey();
		long numDivisors = e.getValue();
		
		System.out.println("\n" + number + ": " + numDivisors);
		endTime = System.currentTimeMillis();
		
		System.out.println("Non-threaded elapsed time: " + (endTime - startTime));
		
			
	}
}
