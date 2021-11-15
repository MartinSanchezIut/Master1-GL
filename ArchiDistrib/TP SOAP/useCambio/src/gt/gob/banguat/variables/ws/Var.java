
package gt.gob.banguat.variables.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Var complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Var">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="moneda" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="venta" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="compra" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Var", propOrder = {
    "moneda",
    "fecha",
    "venta",
    "compra"
})
public class Var {

    protected int moneda;
    protected String fecha;
    protected float venta;
    protected float compra;

    /**
     * Obtient la valeur de la propriété moneda.
     * 
     */
    public int getMoneda() {
        return moneda;
    }

    /**
     * Définit la valeur de la propriété moneda.
     * 
     */
    public void setMoneda(int value) {
        this.moneda = value;
    }

    /**
     * Obtient la valeur de la propriété fecha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Définit la valeur de la propriété fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Obtient la valeur de la propriété venta.
     * 
     */
    public float getVenta() {
        return venta;
    }

    /**
     * Définit la valeur de la propriété venta.
     * 
     */
    public void setVenta(float value) {
        this.venta = value;
    }

    /**
     * Obtient la valeur de la propriété compra.
     * 
     */
    public float getCompra() {
        return compra;
    }

    /**
     * Définit la valeur de la propriété compra.
     * 
     */
    public void setCompra(float value) {
        this.compra = value;
    }

}
