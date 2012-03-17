package br.com.caelum.fj91.rest.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ProduceMime;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import br.com.caelum.fj91.rest.modelo.User;

@Path("/users")
public class UserResource {

	private Map<Integer, User> repo;
		
	public UserResource() {
		User luiz = new User(1,"luiz","luizo");
    	User pedro = new User(2,"pedro","pedroo");
    	
    	this.repo = new HashMap<Integer, User>();
    	this.repo.put(luiz.getId(),luiz);
    	this.repo.put(pedro.getId(),pedro);
	}

	@GET 
    @ProduceMime({"application/json"})
    @Path("{id}")
    public JSONObject getUser(@PathParam("id") String id) throws JSONException {
		User user = this.repo.get(Integer.valueOf(id));
        return new JSONObject().put("nome", user.getNome()).put("login", user.getLogin());
    }

	
	@GET 
    @ProduceMime({"application/json"})
    public JSONObject getUsers() throws JSONException {

		JSONObject object = new JSONObject();
		
		for (Integer id : this.repo.keySet()) {
			User user = this.repo.get(id);
			object.put("user" + id, new JSONObject().put("nome", user.getNome()).put("login", user.getLogin()));
		}
		
		return object;
    }
}