
package gt.gob.banguat.variables.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour DataVariable complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="DataVariable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Vars" type="{http://www.banguat.gob.gt/variables/ws/}ArrayOfVar" minOccurs="0"/>
 *         &lt;element name="TotalItems" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataVariable", propOrder = {
    "vars",
    "totalItems"
})
public class DataVariable {

    @XmlElement(name = "Vars")
    protected ArrayOfVar vars;
    @XmlElement(name = "TotalItems")
    protected int totalItems;

    /**
     * Obtient la valeur de la propriété vars.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVar }
     *     
     */
    public ArrayOfVar getVars() {
        return vars;
    }

    /**
     * Définit la valeur de la propriété vars.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVar }
     *     
     */
    public void setVars(ArrayOfVar value) {
        this.vars = value;
    }

    /**
     * Obtient la valeur de la propriété totalItems.
     * 
     */
    public int getTotalItems() {
        return totalItems;
    }

    /**
     * Définit la valeur de la propriété totalItems.
     * 
     */
    public void setTotalItems(int value) {
        this.totalItems = value;
    }

}
