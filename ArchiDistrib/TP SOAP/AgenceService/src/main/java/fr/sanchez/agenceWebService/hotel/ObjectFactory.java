
package fr.sanchez.agenceWebService.hotel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.sanchez.agenceWebService.hotel package. 
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

    private final static QName _GetNomResponse_QNAME = new QName("http://hotelWebService.sanchez.fr/", "getNomResponse");
    private final static QName _GetReduction_QNAME = new QName("http://hotelWebService.sanchez.fr/", "getReduction");
    private final static QName _GetAddresse_QNAME = new QName("http://hotelWebService.sanchez.fr/", "getAddresse");
    private final static QName _ReserverResponse_QNAME = new QName("http://hotelWebService.sanchez.fr/", "reserverResponse");
    private final static QName _Reserver_QNAME = new QName("http://hotelWebService.sanchez.fr/", "reserver");
    private final static QName _GetAddresseResponse_QNAME = new QName("http://hotelWebService.sanchez.fr/", "getAddresseResponse");
    private final static QName _Rechercher_QNAME = new QName("http://hotelWebService.sanchez.fr/", "rechercher");
    private final static QName _RechercherResponse_QNAME = new QName("http://hotelWebService.sanchez.fr/", "rechercherResponse");
    private final static QName _GetEtoiles_QNAME = new QName("http://hotelWebService.sanchez.fr/", "getEtoiles");
    private final static QName _GetNom_QNAME = new QName("http://hotelWebService.sanchez.fr/", "getNom");
    private final static QName _GetEtoilesResponse_QNAME = new QName("http://hotelWebService.sanchez.fr/", "getEtoilesResponse");
    private final static QName _GetReductionResponse_QNAME = new QName("http://hotelWebService.sanchez.fr/", "getReductionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.sanchez.agenceWebService.hotel
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
     * Create an instance of {@link GetReduction }
     * 
     */
    public GetReduction createGetReduction() {
        return new GetReduction();
    }

    /**
     * Create an instance of {@link GetAddresse }
     * 
     */
    public GetAddresse createGetAddresse() {
        return new GetAddresse();
    }

    /**
     * Create an instance of {@link ReserverResponse }
     * 
     */
    public ReserverResponse createReserverResponse() {
        return new ReserverResponse();
    }

    /**
     * Create an instance of {@link GetAddresseResponse }
     * 
     */
    public GetAddresseResponse createGetAddresseResponse() {
        return new GetAddresseResponse();
    }

    /**
     * Create an instance of {@link Rechercher }
     * 
     */
    public Rechercher createRechercher() {
        return new Rechercher();
    }

    /**
     * Create an instance of {@link RechercherResponse }
     * 
     */
    public RechercherResponse createRechercherResponse() {
        return new RechercherResponse();
    }

    /**
     * Create an instance of {@link GetEtoiles }
     * 
     */
    public GetEtoiles createGetEtoiles() {
        return new GetEtoiles();
    }

    /**
     * Create an instance of {@link Reserver }
     * 
     */
    public Reserver createReserver() {
        return new Reserver();
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
     * Create an instance of {@link GetReductionResponse }
     * 
     */
    public GetReductionResponse createGetReductionResponse() {
        return new GetReductionResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNomResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWebService.sanchez.fr/", name = "getNomResponse")
    public JAXBElement<GetNomResponse> createGetNomResponse(GetNomResponse value) {
        return new JAXBElement<GetNomResponse>(_GetNomResponse_QNAME, GetNomResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReduction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWebService.sanchez.fr/", name = "getReduction")
    public JAXBElement<GetReduction> createGetReduction(GetReduction value) {
        return new JAXBElement<GetReduction>(_GetReduction_QNAME, GetReduction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAddresse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWebService.sanchez.fr/", name = "getAddresse")
    public JAXBElement<GetAddresse> createGetAddresse(GetAddresse value) {
        return new JAXBElement<GetAddresse>(_GetAddresse_QNAME, GetAddresse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserverResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWebService.sanchez.fr/", name = "reserverResponse")
    public JAXBElement<ReserverResponse> createReserverResponse(ReserverResponse value) {
        return new JAXBElement<ReserverResponse>(_ReserverResponse_QNAME, ReserverResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reserver }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWebService.sanchez.fr/", name = "reserver")
    public JAXBElement<Reserver> createReserver(Reserver value) {
        return new JAXBElement<Reserver>(_Reserver_QNAME, Reserver.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAddresseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWebService.sanchez.fr/", name = "getAddresseResponse")
    public JAXBElement<GetAddresseResponse> createGetAddresseResponse(GetAddresseResponse value) {
        return new JAXBElement<GetAddresseResponse>(_GetAddresseResponse_QNAME, GetAddresseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rechercher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWebService.sanchez.fr/", name = "rechercher")
    public JAXBElement<Rechercher> createRechercher(Rechercher value) {
        return new JAXBElement<Rechercher>(_Rechercher_QNAME, Rechercher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercherResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWebService.sanchez.fr/", name = "rechercherResponse")
    public JAXBElement<RechercherResponse> createRechercherResponse(RechercherResponse value) {
        return new JAXBElement<RechercherResponse>(_RechercherResponse_QNAME, RechercherResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEtoiles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWebService.sanchez.fr/", name = "getEtoiles")
    public JAXBElement<GetEtoiles> createGetEtoiles(GetEtoiles value) {
        return new JAXBElement<GetEtoiles>(_GetEtoiles_QNAME, GetEtoiles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWebService.sanchez.fr/", name = "getNom")
    public JAXBElement<GetNom> createGetNom(GetNom value) {
        return new JAXBElement<GetNom>(_GetNom_QNAME, GetNom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEtoilesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWebService.sanchez.fr/", name = "getEtoilesResponse")
    public JAXBElement<GetEtoilesResponse> createGetEtoilesResponse(GetEtoilesResponse value) {
        return new JAXBElement<GetEtoilesResponse>(_GetEtoilesResponse_QNAME, GetEtoilesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReductionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotelWebService.sanchez.fr/", name = "getReductionResponse")
    public JAXBElement<GetReductionResponse> createGetReductionResponse(GetReductionResponse value) {
        return new JAXBElement<GetReductionResponse>(_GetReductionResponse_QNAME, GetReductionResponse.class, null, value);
    }

}
