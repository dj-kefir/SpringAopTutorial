
package net.netconomy.eld.interfaces.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReturnT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReturnT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="EsReturn" type="{url:eldorado.ru:HBRS.INT_PI01_73_10.Bonuses}CLVServiceReturn" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnT", propOrder = {
    "orderId",
    "esReturn"
})
public class ReturnT {

    @XmlElement(name = "OrderId")
    protected String orderId;
    @XmlElement(name = "EsReturn")
    protected CLVServiceReturn esReturn;

    /**
     * Gets the value of the orderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the orderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderId(String value) {
        this.orderId = value;
    }

    /**
     * Gets the value of the esReturn property.
     * 
     * @return
     *     possible object is
     *     {@link CLVServiceReturn }
     *     
     */
    public CLVServiceReturn getEsReturn() {
        return esReturn;
    }

    /**
     * Sets the value of the esReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link CLVServiceReturn }
     *     
     */
    public void setEsReturn(CLVServiceReturn value) {
        this.esReturn = value;
    }

}
