
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class G2Api {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Response response = client.target("https://data.g2crowd.com/api/v1/products/96c38c37")
		  .request(MediaType.TEXT_PLAIN_TYPE)
		  .header("Authorization", "Token token=secret")
		  .get();

		System.out.println("status: " + response.getStatus());
		System.out.println("headers: " + response.getHeaders());
		System.out.println("body:" + response.readEntity(String.class));

	}

}
