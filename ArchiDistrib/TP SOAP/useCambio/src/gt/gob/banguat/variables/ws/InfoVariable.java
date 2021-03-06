
package gt.gob.banguat.variables.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour InfoVariable complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="InfoVariable">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Variables" type="{http://www.banguat.gob.gt/variables/ws/}ArrayOfVariable" minOccurs="0"/>
 *         &lt;element name="CambioDia" type="{http://www.banguat.gob.gt/variables/ws/}ArrayOfVar" minOccurs="0"/>
 *         &lt;element name="CambioDolar" type="{http://www.banguat.gob.gt/variables/ws/}ArrayOfVarDolar" minOccurs="0"/>
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
@XmlType(name = "InfoVariable", propOrder = {
    "variables",
    "cambioDia",
    "cambioDolar",
    "totalItems"
})
public class InfoVariable {

    @XmlElement(name = "Variables")
    protected ArrayOfVariable variables;
    @XmlElement(name = "CambioDia")
    protected ArrayOfVar cambioDia;
    @XmlElement(name = "CambioDolar")
    protected ArrayOfVarDolar cambioDolar;
    @XmlElement(name = "TotalItems")
    protected int totalItems;

    /**
     * Obtient la valeur de la propriété variables.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVariable }
     *     
     */
    public ArrayOfVariable getVariables() {
        return variables;
    }

    /**
     * Définit la valeur de la propriété variables.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVariable }
     *     
     */
    public void setVariables(ArrayOfVariable value) {
        this.variables = value;
    }

    /**
     * Obtient la valeur de la propriété cambioDia.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVar }
     *     
     */
    public ArrayOfVar getCambioDia() {
        return cambioDia;
    }

    /**
     * Définit la valeur de la propriété cambioDia.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVar }
     *     
     */
    public void setCambioDia(ArrayOfVar value) {
        this.cambioDia = value;
    }

    /**
     * Obtient la valeur de la propriété cambioDolar.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVarDolar }
     *     
     */
    public ArrayOfVarDolar getCambioDolar() {
        return cambioDolar;
    }

    /**
     * Définit la valeur de la propriété cambioDolar.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVarDolar }
     *     
     */
    public void setCambioDolar(ArrayOfVarDolar value) {
        this.cambioDolar = value;
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
