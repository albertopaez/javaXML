//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.09 a las 12:13:34 PM CEST 
//


package com.w3schools;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.w3schools package. 
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

    private final static QName _Datoscentro_QNAME = new QName("http://www.w3schools.com", "datoscentro");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.w3schools
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Datoscentro }
     * 
     */
    public Datoscentro createDatoscentro() {
        return new Datoscentro();
    }

    /**
     * Create an instance of {@link Profesor }
     * 
     */
    public Profesor createProfesor() {
        return new Profesor();
    }

    /**
     * Create an instance of {@link Profesores }
     * 
     */
    public Profesores createProfesores() {
        return new Profesores();
    }

    /**
     * Create an instance of {@link Centro }
     * 
     */
    public Centro createCentro() {
        return new Centro();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Datoscentro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.w3schools.com", name = "datoscentro")
    public JAXBElement<Datoscentro> createDatoscentro(Datoscentro value) {
        return new JAXBElement<Datoscentro>(_Datoscentro_QNAME, Datoscentro.class, null, value);
    }

}
