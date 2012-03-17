package br.com.caelum.fj91.rest.resources;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;

import br.com.caelum.fj91.rest.db.Repositorio;
import br.com.caelum.fj91.rest.model.Endereco;
import br.com.caelum.fj91.rest.model.Pedido;
import static br.com.caelum.fj91.rest.model.Pedido.Status.*;

import com.sun.jersey.core.hypermedia.Action;
import com.sun.jersey.core.hypermedia.ContextualActionSet;
import com.sun.jersey.core.hypermedia.HypermediaController;
import com.sun.jersey.core.hypermedia.HypermediaController.LinkType;

@Path("/pedido/{id}")
@HypermediaController(model = Pedido.class, linkType = LinkType.LINK_HEADERS)
public class PedidoResource {

	private Pedido pedido;

	public PedidoResource(@PathParam("id") String id) {
		pedido = Repositorio.pedidos.get(id);
		if (pedido == null) {
			throw new WebApplicationException(404); // se não foi encontrado, devolve 404
		}
	}

	@GET
	@Produces("application/xml")
	public Pedido getPedido(@PathParam("id") String id) {
		return pedido;
	}

	@PUT
	@Consumes("application/xml")
	public void putPedido(@PathParam("id") String id, Pedido pedido) {
		this.pedido = pedido;
		Repositorio.pedidos.put(id, pedido);
	}

	/*
	 * Método que possui transição, para buscar novamente o pedido
	 * e verificar se alguma informação mudou.
	 */
	@GET
	@Action("refresh")
	@Path("refresh")
	@Produces("application/xml")
	public Pedido refresh(@PathParam("id") String id) {
		return getPedido(id);
	}

	@PUT
	@Action("atualizar")
	@Path("atualizar")
	@Consumes("application/xml")
	public void atualizar(@PathParam("id") String id, Pedido p) {
		putPedido(id, p);
	}

	@POST
	@Action("revisar")
	@Path("revisar")
	public void revisar(@HeaderParam("observacao") String observacao) {
		pedido.setStatus(REVISADO);
	}

	@POST
	@Action("pagar")
	@Path("pagar")
	@Consumes("text/plain")
	public void pagar(@QueryParam("numeroCartao") String numeroCartao) {
		System.out.println("Pagando o pedido com o cartao: " + numeroCartao);
		pedido.setStatus(PAGO);
	}

	@PUT
	@Action("enviar")
	@Path("enviar")
	@Produces("application/xml")
	@Consumes("application/xml")
	public Pedido enviar(Endereco enderecoEnvio) {
		pedido.setEnderecoEnvio(enderecoEnvio);
		pedido.setStatus(ENVIADO);
		return pedido;
	}

	@POST
	@Action("cancelar")
	@Path("cancelar")
	public void can(@QueryParam("observacao") String observacao) {
		pedido.setObservacao(observacao);
		pedido.setStatus(CANCELADO);
	}

	@ContextualActionSet
	public Set<String> getContextualActionSet() {
		Set<String> result = new HashSet<String>();
		result.add("refresh");
		switch (pedido.getStatus()) {
		case RECEBIDO:
			result.add("revisar"); 
			result.add("cancelar"); 
			result.add("atualizar"); 
			break;
		case REVISADO:
			result.add("cancelar"); 
			result.add("pagar"); 
			result.add("atualizar"); 
			break;
		case CANCELADO:
			break;
		case PAGO:
			result.add("enviar"); 
			result.add("atualizar"); 
			break;
		case ENVIADO:
			break;
		}
		return result;
	}
}
