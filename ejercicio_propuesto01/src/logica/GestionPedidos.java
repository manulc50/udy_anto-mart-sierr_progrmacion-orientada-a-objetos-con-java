package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Pedido;

public class GestionPedidos {
	private final static String RUTA = "pedidos.txt";
	private final static String FORMATO_FECHA = "yyyy-MM-dd";
	public final static SimpleDateFormat SDF = new SimpleDateFormat(FORMATO_FECHA);
	
	public GestionPedidos() {
		File archivo = new File(RUTA);
		if(!archivo.exists()) {
			try {
				archivo.createNewFile();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void agregar(String producto, double precio, int unidades, Date fecha) {
		try(FileOutputStream fos = new FileOutputStream(RUTA, true);
				PrintStream salida = new PrintStream(fos)) {
			salida.println(producto + "|" + precio + "|" + unidades + "|" + SDF.format(fecha));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Pedido obtenerMayorUnidades() {
		Pedido pedido = null;
		try(BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
			String linea;
			while((linea = br.readLine()) != null) {
				String[] datos = linea.split("\\|");
				double precio = Double.parseDouble(datos[1]);
				int unidades = Integer.parseInt(datos[2]);
				try {
					Date fecha = SDF.parse(datos[3]);
					if(pedido == null)
						pedido = new Pedido(datos[0], precio, unidades, fecha);
					else if(unidades > pedido.getUnidades()) {
						pedido.setProducto(datos[0]);
						pedido.setPrecioUnitario(precio);
						pedido.setUnidades(unidades);
						pedido.setFecha(fecha);
					}
				}
				catch(ParseException e) {
					e.printStackTrace();
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return pedido;
	}
	
	public double calcularTotalFacturado() {
		double total = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
			String linea;
			while((linea = br.readLine()) != null) {
				String[] datos = linea.split("\\|");
				double precio = Double.parseDouble(datos[1]);
				int unidades = Integer.parseInt(datos[2]);
				total += precio * unidades;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public Pedido[] obtenerPedidos(Date fecha1, Date fecha2) {
		List<Pedido> pedidos = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
			String linea;
			while((linea = br.readLine()) != null) {
				String[] datos = linea.split("\\|");
				try {
					Date fecha = SDF.parse(datos[3]);
					if(fecha1.getTime() <= fecha.getTime() && fecha.getTime() <= fecha2.getTime()) {
						double precio = Double.parseDouble(datos[1]);
						int unidades = Integer.parseInt(datos[2]);
						pedidos.add(new Pedido(datos[0], precio, unidades, fecha));
					}
				}
				catch(ParseException e) {
					e.printStackTrace();
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return pedidos.toArray(new Pedido[0]);
	}
}
