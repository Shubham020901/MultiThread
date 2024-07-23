package WebServer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiThreadWebServer server = new MultiThreadWebServer(5); 
        server.start(); 

        try {
            Thread.sleep(10000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        server.shutdown(); 
	}

}
