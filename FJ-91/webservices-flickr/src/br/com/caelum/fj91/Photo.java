package br.com.caelum.fj91;

import java.net.MalformedURLException;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Baseado em:
 * 
 * <photo id="1332244715" owner="41848473@N00" secret="a6e8177ba8" server="1215"
 * farm="2" title="Back to school" ispublic="1" isfriend="0" isfamily="0" />
 * 
 */
@XStreamAlias("photo")
public class Photo {

	@XStreamAsAttribute
	private long id;

	@XStreamAsAttribute
	private String owner;

	@XStreamAsAttribute
	private String secret;

	@XStreamAsAttribute
	private String title;

	@XStreamAsAttribute
	private int server;

	@XStreamAsAttribute
	private int farm;

	@XStreamAsAttribute
	@XStreamAlias("ispublic")
	private boolean open;

	@XStreamAsAttribute
	@XStreamAlias("isfriend")
	private boolean friend;

	@XStreamAsAttribute
	@XStreamAlias("isfamily")
	private boolean family;

	public boolean isFamily() {
		return family;
	}

	public int getFarm() {
		return farm;
	}

	public boolean isFriend() {
		return friend;
	}

	public long getId() {
		return id;
	}

	public boolean isOpen() {
		return open;
	}

	public String getOwner() {
		return owner;
	}

	public String getSecret() {
		return secret;
	}

	public int getServer() {
		return server;
	}

	public String getTitle() {
		return title;
	}

	public String toURL() throws MalformedURLException {
		return String.format("http://farm%s.static.flickr.com/%s/%s_%s.jpg", farm, server, id, secret);
	}

}