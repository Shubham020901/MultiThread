package WebServer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class MultiThreadWebServer {

	private ExecutorService threadPool ;
	private final int threadPoolSize;
	private AtomicBoolean  isRunning ;
	
	public MultiThreadWebServer(int threadPoolSize) {
		super();
		this.threadPool = Executors.newFixedThreadPool(threadPoolSize);
		this.threadPoolSize = threadPoolSize;
	}

	public ExecutorService getThreadPool() {
		return threadPool;
	}

	public void setThreadPool(ExecutorService threadPool) {
		this.threadPool = threadPool;
	}

	public AtomicBoolean getIsRunning() {
		return isRunning;
	}

	public void setIsRunning(AtomicBoolean isRunning) {
		this.isRunning = isRunning;
	}

	public int getThreadPoolSize() {
		return threadPoolSize;
	}

	public void start() {
       AtomicBoolean isRunning= new AtomicBoolean(false);
		if (isRunning.compareAndSet(false, true)) {
            System.out.println("Web server started with thread pool of size: " + threadPoolSize);
            
            for (int i = 0; i < 10; i++) { 
                threadPool.submit(new ClientRequestHandler(i));
            }
        }
    }

	public void shutdown() {
	 AtomicBoolean isRunning= new AtomicBoolean(false);
		if (isRunning.compareAndSet(true, false)) {
            System.out.println("Web server is shutting down");
            threadPool.shutdown(); 
            while (!threadPool.isTerminated()) {
                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Web server has been shut down");
        }
    }

	@Override
	public String toString() {
		return "MultiThreadWebServer [threadPool=" + threadPool + ", threadPoolSize=" + threadPoolSize + ", isRunning="
				+ isRunning + "]";
	}

 }

