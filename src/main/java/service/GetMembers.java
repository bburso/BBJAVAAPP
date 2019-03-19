package service;
import com.sun.security.ntlm.Client;
import javax.inject.Inject;
//import javax.ws.rs.client.Client;
import java.util.logging.Logger;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;

public class GetMembers {
	
	 @Inject
	    private Logger log;



	/*   use Member RESTful service to get member details */
	public void getMember()
	{
		String memberdetails="default";

	//	Client client = ClientBuilder.newClient();
	//	Client client = new Client();
//		Response res = client.getDomain("http://localhost:8080/bbWebApp/rest/members/0").request("JSON").get();
		

 //       if (res.getStatus() != 200) {
 //           throw new RuntimeException("Failed request with HTTP status: " + res.getStatus());
  //      }

  //     memberdetails = res.readEntity(String.class);
        log.info("Member details received" + memberdetails);
  //      return memberdetails;
    }	
	

}
	


