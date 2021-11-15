
package gt.gob.banguat.variables.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechainit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechafin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fechainit",
    "fechafin"
})
@XmlRootElement(name = "TipoCambioRango")
public class TipoCambioRango {

    protected String fechainit;
    protected String fechafin;

    /**
     * Obtient la valeur de la propriété fechainit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechainit() {
        return fechainit;
    }

    /**
     * Définit la valeur de la propriété fechainit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechainit(String value) {
        this.fechainit = value;
    }

    /**
     * Obtient la valeur de la propriété fechafin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechafin() {
        return fechafin;
    }

    /**
     * Définit la valeur de la propriété fechafin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechafin(String value) {
        this.fechafin = value;
    }

}
