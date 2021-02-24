package operaciones;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.w3schools.Centro;
import com.w3schools.Datoscentro;
import com.w3schools.Profesor;
import com.w3schools.Profesores;




public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		visualizarxml();
		
		   }
	
	public static void visualizarxml() {

			System.out.println("------------------------------ ");
			System.out.println("-------VISUALIZAR XML--------- ");
			System.out.println("------------------------------ ");
			try {
				// JAXBContext jaxbContext = JAXBContext.newInstance("datosclases");
				JAXBContext jaxbContext = JAXBContext.newInstance(com.w3schools.ObjectFactory.class);

				// Crear un objeto de tipo Unmarshaller para convertir datos XML en
				// un árbol de objetos Java
				Unmarshaller u = jaxbContext.createUnmarshaller();

				// La clase JAXBElement representa a un elemento de un documento XML
				// en este caso a un elemento del documento ventasarticulos.xml
				JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("./src/micentro.xml"));

				// Visualizo el documento
				Marshaller m = jaxbContext.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

				m.marshal(jaxbElement, System.out);

				// Si queremos operar con el documento obtenemos los
				// objetos del jaxbElement
				// El método getValue() retorna el modelo de contenido (content
				// model) y el valor de los atributos del elemento

				Datoscentro instituto = (Datoscentro) jaxbElement.getValue();

				// Obtenemos una instancia para obtener los profesores
			    Centro vent = instituto.getCentro();
			    com.w3schools.Profesores profs = instituto.getProfesores();

				// Guardamos las ventas en la lista
				List profesorlista = new ArrayList();
				profesorlista = profs.getProfesor();


			} catch (JAXBException je) {
				System.out.println(je.getCause());
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}

		}
		
		}
	

