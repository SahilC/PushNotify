import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;

public class server {
	
	public static void main(String Args[])
	{
		try{
			Sender s1=new Sender("AIzaSyCZN3EnKuIQaSEd7dMOSIVtkIuLapnwlZY");
			Message m1=new Message.Builder()
					.collapseKey("1")
					.timeToLive(3)
					.delayWhileIdle(true)
					.addData("message", "This is a push notification from the GCM server")
					.build();
			s1.send(m1,"APA91bE6suEy-tAoOdOjBmpYrHVMD9WGn7m407IDsmX9ZiN4T4R65v3VOiQI4Fn1ysknzyGL05OnpqHLvTGsr8TKl0OYkMKi9oexQnFA7Lls60voPFNekijb9m9BnBu180xH19_fdC_9mfiQBDzpEVmx9hMjtPJGIQ",1);
			}catch(Exception e){
			e.printStackTrace();
	}
		
	}

}
