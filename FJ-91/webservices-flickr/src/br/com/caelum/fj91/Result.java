package br.com.caelum.fj91;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("rsp")
public class Result {

	@XStreamAlias("stat")
	@XStreamAsAttribute
	private String status;

	private List<Photo> photos;

	public List<Photo> getPhotos() {
		return photos;
	}

	public String getStatus() {
		return status;
	}
}