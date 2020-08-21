package examenBBDD;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class Exportar_importar extends JPanel {
	JRadioButton rdbtnVehiculo;
	JRadioButton rdbtnUsuario;
	JTextField textDirectorio;
	JCheckBox chckbxVehculo;
	JCheckBox chckbxUsuario;
	JButton btnExportar;
	JLabel Aviso ;
	JLabel lblDirectorio;
	JButton btnImportar;
	ButtonGroup grupo;
	public Exportar_importar() {
		setLayout(null);
		Aviso = new JLabel("Aviso");
		Aviso.setVerticalAlignment(SwingConstants.TOP);
		Aviso.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		Aviso.setForeground(Color.RED);
		Aviso.setBounds(47, 293, 588, 130);
		add(Aviso);
		
		rdbtnUsuario = new JRadioButton("Usuario");
		rdbtnUsuario.setSelected(true);
		rdbtnUsuario.setBounds(299, 179, 98, 27);
		add(rdbtnUsuario);
	
		 rdbtnVehiculo = new JRadioButton("Vehiculo");
		rdbtnVehiculo.setBounds(299, 214, 95, 27);
		add(rdbtnVehiculo);
	
		grupo=new ButtonGroup();
		grupo.add(rdbtnUsuario);
		grupo.add(rdbtnVehiculo);
		

		chckbxVehculo = new JCheckBox("Veh\u00EDculo");
		chckbxVehculo.setSelected(true);
		chckbxVehculo.setBounds(29, 214, 98, 27);
		add(chckbxVehculo);
		
		chckbxUsuario = new JCheckBox("Usuario");
		chckbxUsuario.setSelected(true);
		chckbxUsuario.setBounds(29, 179, 98, 27);
		add(chckbxUsuario);
		
		btnExportar = new JButton("Exportar");
		btnExportar.setBounds(135, 179, 119, 62);
		add(btnExportar);

		btnExportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(directoriovacio(textDirectorio.getText())) {
					TextodeAviso.Directoriovacio(Aviso);
				}
				else {
				// TODO Auto-generated method stub
				BBDD base=new BBDD();
				operacionfichero exportar=new operacionfichero(textDirectorio, chckbxVehculo, chckbxUsuario,
						Aviso, base.getTabla(), base.getResultado(), rdbtnVehiculo, rdbtnUsuario, grupo);
				exportar.generar();
				base.cerrar();
				
				}
			}
		});
		
		textDirectorio = new JTextField();
		textDirectorio.setBounds(142, 68, 381, 27);
		add(textDirectorio);
		textDirectorio.setColumns(10);
		
		lblDirectorio = new JLabel("Directorio :");
		lblDirectorio.setBounds(29, 72, 98, 18);
		add(lblDirectorio);
		
		btnImportar = new JButton("Importar");
		btnImportar.setBounds(404, 179, 119, 62);
		add(btnImportar);
		
		btnImportar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(directoriovacio(textDirectorio.getText())) {
					TextodeAviso.Directoriovacio(Aviso);
				}
				else {
				BBDD base=new BBDD();
				operacionfichero importar=new operacionfichero(textDirectorio, chckbxVehculo,
						chckbxUsuario, Aviso, base.getTabla(), base.getResultado(),rdbtnVehiculo, rdbtnUsuario,  grupo);
				importar.setBBDD();
				base.cerrar();
				}
			}
		});
		
	
	}
	public boolean directoriovacio(String directorio) {
		
		if(directorio.equals("")) {
			return true;
		}
		else return false;
	}
}
