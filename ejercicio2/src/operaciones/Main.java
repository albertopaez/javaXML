package operaciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import clasesdatos.Ventas.Venta;
import clasesdatos.*;

public class Main {

	private static final int Ventas = 0;

	public static void main(String[] args) throws FileNotFoundException, JAXBException {

		visualizarxml();
		// M�todo para a�adir una venta, recibe el n�mero de venta,
		// las unidades
		// el nombre cliente, la fecha
		// Comprobar que el nm�mero de venta no exista
		insertarVenta(30, "Cliente 2", 10, "16-12-2015");
		// visualizarxml();
		Scanner sc=new Scanner(System.in);
		int opc=0;
		while (opc!=5) {
		System.out.println("Elige opcion");
		System.out.println("1-A�adir");
		System.out.println("2-Eliminar");
		System.out.println("3-Sumar");
		System.out.println("4-Modificar");
		System.out.println("5-Salir");
		opc=sc.nextInt();
		switch (opc) {
		case 1:
			System.out.println("Escribe los datos");
			System.out.println("Numero de venta");
			
				int cod =sc.nextInt();
				System.out.println("Nombre del cliente");
				String nomcli=sc.nextLine();
				System.out.println("Unidades");
				int uni=sc.nextInt();
				System.out.println("Fecha");
				String fechas=sc.nextLine();
			
			insertarVenta(cod, nomcli, uni, fechas);
			break;
        case 2:
        	System.out.println("Introduzca el codigo el cual desea eliminar");
        	BigInteger eli=sc.nextBigInteger();
			eliminar(eli);
			break;
        case 3:
			System.out.println("introduzca el codigo");
			BigInteger codi=sc.nextBigInteger();
			System.out.println("Numero a sumar");
			int sum=sc.nextInt();
			a�adir(codi, sum);
			break;
        case 4:
        	System.out.println("Selecciona el codigo de la venta a modificar");
			   BigInteger code =sc.nextBigInteger();
				System.out.println("Unidades");
				int unid=sc.nextInt();
				System.out.println("Fecha");
				String fechass=sc.nextLine();
				mod(code, unid, fechass);
			break;
        case 5:
			System.out.println("Que pase un buen dia");
			break;
		default:
			
			System.out.println("Solo numeros del 1 al 5");
			break;
		}
		}
	}

	////////////////////////////////////////
	public static void visualizarxml() {

		System.out.println("------------------------------ ");
		System.out.println("-------VISUALIZAR XML--------- ");
		System.out.println("------------------------------ ");
		try {
			// JAXBContext jaxbContext = JAXBContext.newInstance("datosclases");
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);

			// Crear un objeto de tipo Unmarshaller para convertir datos XML en
			// un �rbol de objetos Java
			Unmarshaller u = jaxbContext.createUnmarshaller();

			// La clase JAXBElement representa a un elemento de un documento XML
			// en este caso a un elemento del documento ventasarticulos.xml
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("./ventasarticulos.xml"));

			// Visualizo el documento
			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(jaxbElement, System.out);

			// Si queremos operar con el documento obtenemos los
			// objetos del jaxbElement
			// El m�todo getValue() retorna el modelo de contenido (content
			// model) y el valor de los atributos del elemento

			VentasType miventa = (VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();

			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			System.out.println("---------------------------- ");
			System.out.println("---VISUALIZAR LOS OBJETOS--- ");
			System.out.println("---------------------------- ");
			// Datos del art�culo
			DatosArtic miartic = (DatosArtic) miventa.getArticulo();

			System.out.println("Nombre art: " + miartic.getDenominacion());
			System.out.println("Codigo art: " + miartic.getCodigo());
			System.out.println("Stock art: " + miartic.getCodigo());
			System.out.println("Ventas  del art�culo , hay: " + listaVentas.size());

			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Venta) listaVentas.get(i);
				System.out.println("N�mero de venta: " + ve.getNumventa() + ". Nombre cliente: " + ve.getNombrecliente()
						+ ", unidades: " + ve.getUnidades() + ", fecha: " + ve.getFecha());
			}

		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}

	/////////////////////////////////////////////////
	private static void insertarVenta(int numeventa, String nomcli, int uni, String fecha) {

		System.out.println("---------------------------- ");
		System.out.println("-------A�ADIR VENTA--------- ");
		System.out.println("---------------------------- ");
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("./ventasarticulos.xml"));

			VentasType miventa = (VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();

			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			// comprobar si existe el n�mero de venta, reccorriendo el arraylist
			int existe = 0; // si no existe, 1 si existe
			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Venta) listaVentas.get(i);
				if (ve.getNumventa().intValue() == numeventa) {
					existe = 1;
					break;
				}
			}

			if (existe == 0) {
				// Crear el objeto Ventas.Venta, y si no existe se a�ade a la
				// lista

				Ventas.Venta ve = new Ventas.Venta();
				ve.setNombrecliente(nomcli);
				ve.setFecha(fecha);
				ve.setUnidades(uni);
				BigInteger nume = BigInteger.valueOf(numeventa);
				ve.setNumventa(nume);

				// a�adimos la venta a la lista

				listaVentas.add(ve);

				// crear el Marshaller, volcar la lista al fichero XML
				

				System.out.println("Venta a�adida: " + numeventa);

			} else

				System.out.println("En n�mero de venta ya existe: " + numeventa);

		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}
	/////////////////////////////
private static boolean eliminar(BigInteger cod) throws JAXBException, FileNotFoundException {
			boolean sal=false;
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("./ventasarticulos.xml"));

			VentasType miventa = (VentasType) jaxbElement.getValue();
			Ventas vent = miventa.getVentas();
				
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();
			
			int existe=0;
			for(int i=0;i< listaVentas.size();i++) {
				Ventas.Venta ve = (Venta) listaVentas.get(i);
					if(ve.getNumventa()==cod) {
						existe=i;
						break;
					}
					if (existe!=0) {
					listaVentas.remove(existe);
					Marshaller m = jaxbContext.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.marshal(jaxbElement, new FileOutputStream("./ventasarticulos.xml"));
				System.out.println("Eliminado correctamente");
				sal=true;
					}else {System.out.println("Error");}
			}
			return sal;
			}

/////////////////////////////////////////
private static boolean a�adir(BigInteger cod, int sum) throws JAXBException, FileNotFoundException {
	boolean sal=false;
	JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
	Unmarshaller u = jaxbContext.createUnmarshaller();
	JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("./ventasarticulos.xml"));

	VentasType miventa = (VentasType) jaxbElement.getValue();
	Ventas vent = miventa.getVentas();
		
	List listaVentas = new ArrayList();
	listaVentas = vent.getVenta();
	
	int existe=0;
	for(int i=0;i< listaVentas.size();i++) {
		Ventas.Venta ve = (Venta) listaVentas.get(i);
			if(ve.getNumventa()==cod) {
				existe=i;
				break;
			}
			if (existe!=0) {
			int numven =((Venta) listaVentas.get(i)).getUnidades()+sum;
			((Venta) listaVentas.get(i)).setUnidades(numven);
			
			Marshaller m = jaxbContext.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(jaxbElement, new FileOutputStream("./ventasarticulos.xml"));
		System.out.println("Eliminado correctamente");
		sal=true;
			}else {System.out.println("Error");}
	}
	return sal;
	}
private static boolean mod(BigInteger cod, int uni, String fecha) throws JAXBException, FileNotFoundException {
	boolean sal=false;
	JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
	Unmarshaller u = jaxbContext.createUnmarshaller();
	JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("./ventasarticulos.xml"));

	VentasType miventa = (VentasType) jaxbElement.getValue();
	Ventas vent = miventa.getVentas();
		
	List listaVentas = new ArrayList();
	listaVentas = vent.getVenta();
	
	int existe=0;
	for(int i=0;i< listaVentas.size();i++) {
		Ventas.Venta ve = (Venta) listaVentas.get(i);
			if(ve.getNumventa()==cod) {
				existe=i;
				break;
			}
			if (existe!=0) {
			
			((Venta) listaVentas.get(i)).setUnidades(uni);
			((Venta) listaVentas.get(i)).setFecha(fecha);
			Marshaller m = jaxbContext.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(jaxbElement, new FileOutputStream("./ventasarticulos.xml"));
		System.out.println("Eliminado correctamente");
		sal=true;
			}else {System.out.println("Error");}
	}
	return sal;
	}


}
