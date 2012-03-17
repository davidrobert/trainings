package br.com.caelum.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "traduzResponse", namespace = "http://ws.caelum.com.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "traduzResponse", namespace = "http://ws.caelum.com.br/")
public class TraduzResponse {

    @XmlElement(name = "traducao", namespace = "")
    private String traducao;

    /**
     * 
     * @return
     *     returns String
     */
    public String getTraducao() {
        return this.traducao;
    }

    /**
     * 
     * @param traducao
     *     the value for the traducao property
     */
    public void setTraducao(String traducao) {
        this.traducao = traducao;
    }

}