package br.com.caelum.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "traduz", namespace = "http://ws.caelum.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "traduz", namespace = "http://ws.caelum.com.br/")
public class Traduz {

    @XmlElement(name = "palavra", namespace = "")
    private String palavra;

    /**
     * 
     * @return
     *     returns String
     */
    public String getPalavra() {
        return this.palavra;
    }

    /**
     * 
     * @param palavra
     *     the value for the palavra property
     */
    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

}