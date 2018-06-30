package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.*;

import javax.imageio.IIOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorMainWin;

import java.awt.Font;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

	public JPanel contentPane;
	public JTextField campo_Usuario;
	public JTextField campo_Password;
	public JButton btnAcceder;

	public MainWindow() {
		
		addWindowListener(new ControladorMainWin(this));
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.setBounds(112, 395, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBackground(Color.WHITE);
		lblFondo.setBounds(0, 11, 326, 256);
		lblFondo.setIcon(new ImageIcon("iconos/logo.gif"));
		contentPane.add(lblFondo);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblUsuario.setBounds(43, 298, 60, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblContrasea.setBounds(43, 342, 85, 14);
		contentPane.add(lblContrasea);
		
		campo_Usuario = new JTextField();
		campo_Usuario.setToolTipText("");
		campo_Usuario.setBounds(147, 297, 86, 20);
		contentPane.add(campo_Usuario);
		campo_Usuario.setColumns(10);
		
		campo_Password = new JTextField();
		campo_Password.setBounds(147, 341, 86, 20);
		contentPane.add(campo_Password);
		campo_Password.setColumns(10);
		this.setLocationRelativeTo(null);
		
		btnAcceder = new JButton("Acceder");
		btnAcceder.setBounds(449, 124, 192, 44);
		contentPane.getRootPane().add(btnAcceder);
	}
}
