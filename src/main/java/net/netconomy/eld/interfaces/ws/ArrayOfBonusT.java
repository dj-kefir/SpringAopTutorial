
package net.netconomy.eld.interfaces.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfBonusT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBonusT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ArrayOfBonusTEl" type="{url:eldorado.ru:HBRS.INT_PI01_73_10.Bonuses}BonusT" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBonusT", propOrder = {
    "arrayOfBonusTEl"
})
public class ArrayOfBonusT {

    @XmlElement(name = "ArrayOfBonusTEl")
    protected List<BonusT> arrayOfBonusTEl;

    /**
     * Gets the value of the arrayOfBonusTEl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arrayOfBonusTEl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrayOfBonusTEl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BonusT }
     * 
     * 
     */
    public List<BonusT> getArrayOfBonusTEl() {
        if (arrayOfBonusTEl == null) {
            arrayOfBonusTEl = new ArrayList<BonusT>();
        }
        return this.arrayOfBonusTEl;
    }

}
