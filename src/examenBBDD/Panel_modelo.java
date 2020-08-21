package examenBBDD;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Panel_modelo extends JPanel {
	public JTextField textDNI;
	public JTextField textNombre;
	public JTextField textTelefono;
	public JTextField textEdad;
	
	public JTextField textFechaYHora;
	
	public JButton btnconsultar;
	public  JLabel Aviso;
	
	public JTextField textUsuario;
	public JTextField textVehiculo;
	JButton btnborrar;
	JTextField textMatricula;
	JTextField textPeso;
	JTextField textMarca;
	JRadioButton sexoH;
	JRadioButton sexoM ;
	ButtonGroup gruposexo;
	ButtonGroup grupocategria;
	JRadioButton rdbtnL ;
	JRadioButton rdbM  ;
	JRadioButton rdbtnN ;
	JButton btnInsertat;	
	JButton btnmodificar;
	 
	JButton btnVaciar ;
	 public JRadioButton rdbtnUsuario;
		public JRadioButton rdbtnVechiculo;
		ButtonGroup grupousuariovehiculo;
	/**
	 * Create the panel.
	 */
	public Panel_modelo() {
		setLayout(null);

	
		textDNI = new JTextField();
		textDNI.setBounds(100, 283, 136, 24);
		add(textDNI);
		textDNI.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(32, 286, 40, 18);
		add(lblDni);
		
		 btnconsultar = new JButton("Consultar");
		btnconsultar.setBounds(60, 157, 130, 46);
		add(btnconsultar);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(97, 231, 89, 39);
		add(lblNewLabel);
		
		JLabel lblVehculo = new JLabel("Veh\u00EDculo");
		lblVehculo.setForeground(Color.ORANGE);
		lblVehculo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblVehculo.setBounds(310, 231, 89, 39);
		add(lblVehculo);
		
		textNombre = new JTextField();
		textNombre.setBounds(100, 320, 131, 24);
		add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 323, 72, 18);
		add(lblNombre);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(100, 357, 131, 24);
		add(textTelefono);
		
		JLabel lblTelefono = new JLabel("T\u00E9lefono:");
		lblTelefono.setBounds(22, 360, 72, 18);
		add(lblTelefono);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setBounds(22, 400, 72, 18);
		add(lblEdad);
		
		JLabel lblSexo = new JLabel("Sexo :");
		lblSexo.setBounds(22, 431, 72, 18);
		add(lblSexo);
		
		textEdad = new JTextField();
		textEdad.setBounds(100, 394, 86, 24);
		add(textEdad);
		textEdad.setColumns(10);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora de registro:");
		lblFechaYHora.setBounds(22, 465, 209, 24);
		add(lblFechaYHora);
		
		textFechaYHora = new JTextField();
		textFechaYHora.setBounds(32, 498, 179, 24);
		add(textFechaYHora);
		textFechaYHora.setColumns(10);
		textFechaYHora.setEditable(false);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula :");
		lblMatricula.setBounds(320, 286, 89, 18);
		add(lblMatricula);
		
	
		
		JLabel lblPeso = new JLabel("Peso :");
		lblPeso.setBounds(327, 337, 72, 18);
		add(lblPeso);
		
		
		
		JLabel lblMarca = new JLabel("Marca :");
		lblMarca.setBounds(327, 378, 72, 18);
		add(lblMarca);
		
	
		
		JLabel lblCategoria = new JLabel("Categor\u00EDa :");
		lblCategoria.setBounds(306, 431, 93, 18);
		add(lblCategoria);
		
	
		
		Aviso = new JLabel("Aviso :");
		Aviso.setFont(new Font("Arial", Font.PLAIN, 20));
		Aviso.setVerticalAlignment(SwingConstants.TOP);
		Aviso.setForeground(Color.RED);
		Aviso.setBounds(310, 20, 307, 126);
		add(Aviso);
		
	
		
		
		
		textUsuario = new JTextField();
		textUsuario.setBounds(121, 45, 136, 24);
		add(textUsuario);
		textUsuario.setColumns(10);
		
		textVehiculo = new JTextField();
		textVehiculo.setBounds(121, 92, 136, 24);
		add(textVehiculo);
		textVehiculo.setColumns(10);
		
		JLabel lblDni_1 = new JLabel("DNI:");
		lblDni_1.setBounds(121, 25, 40, 18);
		add(lblDni_1);
		
		JLabel lblMatricula_1 = new JLabel("Matricula:");
		lblMatricula_1.setBounds(121, 72, 80, 18);
		add(lblMatricula_1);
		
		
		btnborrar = new JButton("Borrar");
		btnborrar.setBounds(204, 157, 136, 46);
		add(btnborrar);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(420, 283, 136, 24);
		add(textMatricula);
		textMatricula.setColumns(10);
		
		textPeso = new JTextField();
		textPeso.setBounds(420, 334, 86, 24);
		add(textPeso);
		textPeso.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setBounds(420, 375, 86, 24);
		add(textMarca);
		textMarca.setColumns(10);
		
		
		
		
		sexoH = new JRadioButton("H");
		sexoH .setBounds(100, 427, 40, 27);
		add(sexoH );
		
		 sexoM = new JRadioButton("M");
		sexoM .setBounds(145, 427, 40, 27);
		add(sexoM );
		
		 rdbtnL = new JRadioButton("L");
		rdbtnL.setBounds(409, 427, 40, 27);
		add(rdbtnL);
		
		rdbM = new JRadioButton("M");
		rdbM.setBounds(455, 427, 54, 27);
		add(rdbM);
		
		rdbtnN = new JRadioButton("N");
		rdbtnN.setBounds(512, 427, 54, 27);
		add(rdbtnN);
		
		btnInsertat = new JButton("Insertar");
		btnInsertat.setBounds(365, 157, 136, 46);
		add(btnInsertat);
		
		btnmodificar = new JButton("Modificar");
		btnmodificar.setEnabled(false);
		btnmodificar.setBounds(522, 157, 121, 46);
		add(btnmodificar);
		
		
		
		rdbtnUsuario = new JRadioButton("Usuario");
		rdbtnUsuario.setBounds(5, 45, 89, 27);
		add(rdbtnUsuario);
		rdbtnVechiculo = new JRadioButton("Veh\u00EDculo");
		rdbtnVechiculo.setBounds(5, 91, 101, 27);
		add(rdbtnVechiculo);
		rdbtnUsuario.setSelected(true);	
		textVehiculo.setEnabled(false);
		
		grupousuariovehiculo = new ButtonGroup();
		grupousuariovehiculo.add(rdbtnVechiculo);
		grupousuariovehiculo.add(rdbtnUsuario);
		
		
		
		
		
		gruposexo=new ButtonGroup();
		gruposexo.add(sexoH);
		gruposexo.add(sexoM);
		
		
		grupocategria=new ButtonGroup();
		grupocategria.add(rdbM);	
		grupocategria.add(rdbtnL);
		grupocategria.add(rdbtnN);
		
		textDNI.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("<html><body>Para hacer modificaci\u00F3n ,<br>"
												+ "	primero hay que hacer <br>"
												+ "una consulta.</html></body>");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(532, 216, 210, 54);
		add(lblNewLabel_1);
		
	 btnVaciar = new JButton("Vaciar");
		btnVaciar.setBounds(394, 476, 130, 46);
		add(btnVaciar);
		
	}
	

	 public void vaciar() {
		
		textNombre.setText("");
		textFechaYHora.setText("");
		textEdad.setText("");
		textTelefono.setText("");
		textMatricula.setText("");
		textPeso.setText("");
		textMarca.setText("");
		
	}
}
