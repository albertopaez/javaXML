//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.09 a las 12:13:34 PM CEST 
//


package com.w3schools;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Profesor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Profesor"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoprofesor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nombreprofesor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Profesor", propOrder = {
    "codigoprofesor",
    "nombreprofesor"
})
public class Profesor {

    @XmlElement(required = true)
    protected String codigoprofesor;
    @XmlElement(required = true)
    protected String nombreprofesor;

    /**
     * Obtiene el valor de la propiedad codigoprofesor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoprofesor() {
        return codigoprofesor;
    }

    /**
     * Define el valor de la propiedad codigoprofesor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoprofesor(String value) {
        this.codigoprofesor = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreprofesor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreprofesor() {
        return nombreprofesor;
    }

    /**
     * Define el valor de la propiedad nombreprofesor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreprofesor(String value) {
        this.nombreprofesor = value;
    }

}
