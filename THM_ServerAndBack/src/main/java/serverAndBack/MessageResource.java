package serverAndBack;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import application.model.data.User;
import application.model.data.UserDAO;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    @GET
    @Path("/{username}")
    public Response printMessage(@PathParam("username") String username) {
        List<User> userList = new ArrayList<User>();
		try {
			userList = new UserDAO().getUserByName(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String result = userList.get(0).getPassword();
        return Response.status(200).entity(result).build();
    }
}
