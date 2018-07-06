package controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import modelo.AccesoBD;
import modelo.Carrito;
import modelo.Producto;
import modelo.Usuario;
import vista.Aniadirproducto;
import vista.Reserva;

public class ControlReserva extends WindowAdapter implements WindowListener{
	
	public Reserva winReserva;
	public Usuario cliente;
	public static Producto[] carrito=null;
	public static Producto[] productos_Tienda=null;
	public Carrito carro_compra=null;
	public int pos_Objeto=0;

	public ControlReserva(Usuario cli, Reserva admin_Productos) {
		// TODO Auto-generated constructor stub
		
		this.cliente=cli;
		this.winReserva=admin_Productos;
		carro_compra=new Carrito(cli);
		winReserva.frame.addWindowListener(this);

	}
	
	public void windowOpened(WindowEvent e) {
		
		Producto gestionar=new Producto();
		
		carrito=new Producto[carro_compra.getTamanio()];

		productos_Tienda=new Producto[gestionar.getNumProductos()];

		productos_Tienda= gestionar.getProductos();
		
		this.winReserva.btnQuitarProducto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {

				carro_compra.eliminar_Producto(pos_Objeto);
				
				pintar_Carrito();
				
			}
		});
		
		this.winReserva.btnRealizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Date fecha_Reserva=new Date();
				
				modelo.Reserva nueva=new modelo.Reserva(cliente.getDni_usuario(), new java.sql.Date(fecha_Reserva.getTime()), carro_compra);
				
				winReserva.frame.setVisible(false);
				
			}
		});

		if(winReserva.aniadir_Prod!=null) {
			
			winReserva.aniadir_Prod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Aniadirproducto addProd=new Aniadirproducto();
								ControlAddProd cAddProd=new ControlAddProd(addProd);
								addProd.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
								addProd.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			winReserva.aniadir_Prod.setBounds(487, 557, 53, 39);
			winReserva.frame.getContentPane().add(winReserva.aniadir_Prod);
		}
		
		JPanel panelObj = new JPanel();
		winReserva.scrollPane.setViewportView(panelObj);
		panelObj.setLayout(null);
		
		if(productos_Tienda.length%3==0) {
			panelObj.setPreferredSize(new Dimension(600, 200*(productos_Tienda.length/3)));
		}
		else {
			panelObj.setPreferredSize(new Dimension(600, 200*(productos_Tienda.length/3)+200));
		}
		
		int x=0;
		int y=0;
		int cont=0;
		for(int i=0;i<productos_Tienda.length;i++) {

			cont++;
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(x, y, 200, 200);
			panel_2.setLayout(null);

			JLabel lblNomprod = new JLabel(productos_Tienda[i].getId_Prod());
			lblNomprod.setBounds(30, 21, 139, 32);
			panel_2.add(lblNomprod);

			JLabel lblFabricante = new JLabel("Fabricante");
			lblFabricante.setBounds(30, 64, 80, 14);
			panel_2.add(lblFabricante);

			JLabel lblPrecio = new JLabel("precio");
			lblPrecio.setBounds(30, 101, 46, 14);
			panel_2.add(lblPrecio);		

			
			if(winReserva.btnEliminar!=null) {
				
				JButton btnElim_1=new JButton("-");
				btnElim_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						AccesoBD consulta=new AccesoBD();
						consulta.eliminarProductoBD(lblNomprod.getText());	
						winReserva.frame.repaint();
						
					}
				});
				btnElim_1.setBounds(30, 166, 65, 23);
				panel_2.add(btnElim_1);
				
			}
			
			JButton btnAdd = new JButton("ADD");
			btnAdd.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					String id=lblNomprod.getText();

					Producto seleccionado = gestionar.obtener_Producto(id); 

					carro_compra.aniadir_Producto(seleccionado);

					int total=carro_compra.obtener_Total();

					pintar_Carrito();
					
					actualizar_Precio();
	
				}

				
			});

			btnAdd.setBounds(125, 166, 65, 23);
			panel_2.add(btnAdd);

			panelObj.add(panel_2);
			
			x=x+200;
			if(cont%3==0){
				x=0;
				y=y+200;
			}
			
		}
		System.out.println(productos_Tienda[0].getId_Prod());
	}

	private void actualizar_Precio() {
		// TODO Auto-generated method stub
		
		JLabel lblPreciototal = new JLabel("Precio_Total");
		lblPreciototal.setBounds(880, 548, 300, 20);
		winReserva.frame.getContentPane().add(lblPreciototal);

		lblPreciototal.setText(String.valueOf(carro_compra.obtener_Total()));
		
	}
	
	public void pintar_Carrito() {
		// TODO Auto-generated method stub
		
		winReserva.panel = new JPanel();
	
		winReserva.scrollPane_1.setViewportView(winReserva.panel);
		winReserva.panel.setLayout(null);
		winReserva.panel.setBackground(Color.WHITE);

		winReserva.panel.setPreferredSize(new Dimension(359, 68*carro_compra.getTamanio()));
		
		int pos=0;

		for(int i=0;i<carro_compra.getTamanio();i++) {

			Producto actual=carro_compra.getProd(i);

			JPanel panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);

			panel_3.setBounds(0, pos, 359, 68);
			winReserva.panel.add(panel_3);
			panel_3.setLayout(null);

			panel_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {

					int pos=panel_3.getY();

					if(pos!=0) {
						pos_Objeto=pos/68;
					}
					else {
						pos_Objeto=0;
					}

				}
			});

			JLabel lblNomprod_1 = new JLabel(actual.getId_Prod());
			lblNomprod_1.setBounds(36, 23, 68, 14);
			panel_3.add(lblNomprod_1);

			JLabel lblPrecio_1 = new JLabel("Precio");
			lblPrecio_1.setBounds(246, 23, 46, 14);
			panel_3.add(lblPrecio_1);

			JLabel lblUnidades = new JLabel("unidades");
			lblUnidades.setBounds(153, 23, 46, 14);
			panel_3.add(lblUnidades);

			pos=pos+68;
		}
	}
	
}

