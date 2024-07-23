package WebServer;

public class ClientRequestHandler implements Runnable {

	 private final int requestId;

	    public ClientRequestHandler(int requestId) {
	        this.requestId = requestId;
	    }
    	
	public int getRequestId() {
			return requestId;
		}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 Thread.currentThread().setPriority(Thread.NORM_PRIORITY); 
	        try {
	            
	            System.out.println("Handling request :" + requestId + " on thread " + Thread.currentThread().getName());
	            
	            Thread.sleep(2000); 
	            System.out.println("Request :" + requestId + " processed");
	        } catch (InterruptedException e) {
	            
	            System.out.println("Request :" + requestId + " was interrupted");
	        } catch (Exception e) {
	            
	            System.out.println("An error occurred while processing request :" + requestId);
	            e.printStackTrace();
	        }
	}

	@Override
	public String toString() {
		return "ClientRequestHandler [requestId=" + requestId + "]";
	}
	
	

}
