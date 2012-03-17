package br.com.caelum.fj91.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/mensagem")
public class MensagemResource {

	@GET
	@Produces("text/plain")
	public String getMensagem() {
		return "Tudo está funcionando!";
	}
}