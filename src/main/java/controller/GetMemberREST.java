package controller;
/**/

import java.util.logging.Logger;
/*import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
*/
public class GetMemberREST {

	/*private static final Logger gmrlogger = Logger.getLogger(MemberController.class.getName());
*/

	/*   use Member RESTful service to get member details   */
	public String getMember()
	{
		String mbrdetails = "default";
	/*	Client client = ClientBuilder.newClient();
		Response res = client.target("http://localhost:8080/bbWebApp/rest/members/0").request("JSON").get();
	*/
     /*   if (res.getStatus() != 200) {
            throw new RuntimeException("Failed request with HTTP status: " + res.getStatus());
        }
		*/
      /*  mbrdetails = res.readEntity(String.class);
		gmrlogger.info("Member details received" + mbrdetails);
        */
      	return mbrdetails;
    }	
	

}
	


