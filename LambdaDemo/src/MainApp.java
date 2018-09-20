
public class MainApp {

	
	/***new Runnable() {
			
			@Override
			public void run***/
	
	//one line. you can remove  {}
	
	public static void main(String[] args) {
		//Thread expects Runnable , Thread has only one runnable interface implemented 
		Thread thread = new Thread(
				() ->  System.out.println("thread is executed")
		);
		
				
		thread.start();
		System.out.println("threa is finished");

	}

}
