
package agenceservice.hotel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hotel package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetVilleResponse_QNAME = new QName("http://hotelservice/", "getVilleResponse");
    private final static QName _GetVille_QNAME = new QName("http://hotelservice/", "getVille");
    private final static QName _Lookup_QNAME = new QName("http://hotelservice/", "lookup");
    private final static QName _GetNomResponse_QNAME = new QName("http://hotelservice/", "getNomResponse");
    private final static QName _GetEtoilesResponse_QNAME = new QName("http://hotelservice/", "getEtoilesResponse");
    private final static QName _GetNom_QNAME = new QName("http://hotelservice/", "getNom");
    private final static QName _LookupResponse_QNAME = new QName("http://hotelservice/", "lookupResponse");
    private final static QName _GetEtoiles_QNAME = new QName("http://hotelservice/", "getEtoiles");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hotel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetNomResponse }
     * 
     */
    public GetNomResponse createGetNomResponse() {
        return new GetNomResponse();
    }

    /**
     * Create an instance of {@link GetVille }
     * 
     */
    public GetVille createGetVille() {
        return new GetVille();
    }

    /**
     * Create an instance of {@link Lookup }
     * 
     */
    public Lookup createLookup() {
        return new Lookup();
    }

    /**
     * Create an instance of {@link GetVilleResponse }
     * 
     */
    public GetVilleResponse createGetVilleResponse() {
        return new GetVilleResponse();
    }

    /**
     * Create an instance of {@link GetEtoiles }
     * 
     */
    public GetEtoiles createGetEtoiles() {
        return new GetEtoiles();
    }

    /**
     * Create an instance of {@link LookupResponse }
     * 
     */
    public LookupResponse createLookupResponse() {
        return new LookupResponse();
    }

    /**
     * Create an instance of {@link GetNom }
     * 
     */
    public GetNom createGetNom() {
        return new GetNom();
    }

    /**
     * Create an instance of {@link GetEtoilesResponse }
     * 
     */
    public GetEtoilesResponse createGetEtoilesResponse() {
        return new GetEtoilesResponse();
    }

    /**
     * Create an instance of {@link Chambre }
     * 
     */
    public Chambre createChambre() {
        return new Chambre();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVilleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelservice/", name = "getVilleResponse")
    public JAXBElement<GetVilleResponse> createGetVilleResponse(GetVilleResponse value) {
        return new JAXBElement<GetVilleResponse>(_GetVilleResponse_QNAME, GetVilleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVille }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelservice/", name = "getVille")
    public JAXBElement<GetVille> createGetVille(GetVille value) {
        return new JAXBElement<GetVille>(_GetVille_QNAME, GetVille.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lookup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelservice/", name = "lookup")
    public JAXBElement<Lookup> createLookup(Lookup value) {
        return new JAXBElement<Lookup>(_Lookup_QNAME, Lookup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNomResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelservice/", name = "getNomResponse")
    public JAXBElement<GetNomResponse> createGetNomResponse(GetNomResponse value) {
        return new JAXBElement<GetNomResponse>(_GetNomResponse_QNAME, GetNomResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEtoilesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelservice/", name = "getEtoilesResponse")
    public JAXBElement<GetEtoilesResponse> createGetEtoilesResponse(GetEtoilesResponse value) {
        return new JAXBElement<GetEtoilesResponse>(_GetEtoilesResponse_QNAME, GetEtoilesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelservice/", name = "getNom")
    public JAXBElement<GetNom> createGetNom(GetNom value) {
        return new JAXBElement<GetNom>(_GetNom_QNAME, GetNom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LookupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelservice/", name = "lookupResponse")
    public JAXBElement<LookupResponse> createLookupResponse(LookupResponse value) {
        return new JAXBElement<LookupResponse>(_LookupResponse_QNAME, LookupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEtoiles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelservice/", name = "getEtoiles")
    public JAXBElement<GetEtoiles> createGetEtoiles(GetEtoiles value) {
        return new JAXBElement<GetEtoiles>(_GetEtoiles_QNAME, GetEtoiles.class, null, value);
    }

}
