import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
public class ExcluiVeiculo extends JInternalFrame
{
	public ExcluiVeiculo()
	{
		super("Exluir Veículo",false,false,false,false);
		setBounds(100,50,600,300);
		setVisible(true);
		setLayout(null);
		
		JLabel lblbuscaPlaca = new JLabel("Placa: ");
		final JFormattedTextField txtbuscaPlaca = new JFormattedTextField();
		
		final JButton btBuscar = new JButton("Buscar");
		final JButton btExcluir = new JButton("Excluir");
		final JButton btCancelar = new JButton("Cancelar");
		
		lblbuscaPlaca.setBounds(100,50,50,20);
		add(lblbuscaPlaca);
		txtbuscaPlaca.setBounds(150,50,150,20);
		add(txtbuscaPlaca);
		btBuscar.setBounds(320,50,100,20);
		add(btBuscar);
	
		JLabel lblModelo = new JLabel("Modelo: ");
		JLabel lblMarca = new JLabel("Marca: ");
		JLabel lblPlaca = new JLabel("Placa: ");
		JLabel lblAno = new JLabel("Ano de Fabricação: ");
		
		final JTextField txtMarca = new JTextField();
		final JTextField txtModelo = new JTextField();
		final JFormattedTextField txtPlaca = new JFormattedTextField();
		final JFormattedTextField txtAno = new JFormattedTextField();
			
		//mascara
		try
		{
			MaskFormatter placa = new MaskFormatter("***-####");
			MaskFormatter ano = new MaskFormatter("####");
			
			placa.install(txtbuscaPlaca);
			ano.install(txtAno);		
		}
		catch(Exception e)
		{
			
		}		
		
		lblMarca.setBounds(50,100,50,20);
		add(lblMarca);
		txtMarca.setBounds(100,100,200,20);
		txtMarca.setEditable(false);
		add(txtMarca);
		
		
		lblModelo.setBounds(310,100,50,20);
		add(lblModelo);
		txtModelo.setBounds(360,100,200,20);
		txtModelo.setEditable(false);
		add(txtModelo);

		
		lblPlaca.setBounds(50,160,50,20);
		add(lblPlaca);
		txtPlaca.setBounds(100,160,100,20);
		txtPlaca.setEditable(false);
		add(txtPlaca);
		
		lblAno.setBounds(230,160,200,20);
		add(lblAno);
		txtAno.setBounds(350,160,100,20);
		txtAno.setEditable(false);
		add(txtAno);
		
		btExcluir.setBounds(300,220,100,30);
		add(btExcluir);
		btCancelar.setBounds(430,220,100,30);
		add(btCancelar);
		
		class Eventos implements ActionListener
		{
			String placa;
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == btBuscar)
				{
					try
					{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						 placa=txtbuscaPlaca.getText();
						Veiculos v=new Veiculos();
						ResultSet resultado=v.pesquisarVeiculos(conn,placa);
						if(resultado.first())
						{
							do{
								txtMarca.setText(resultado.getString(2));
								txtModelo.setText(resultado.getString(3));
								txtPlaca.setText(resultado.getString(1));
								txtAno.setText(resultado.getString(5));
							}
							while(resultado.next());
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Dados não encontrados, procure outra placa");
						}
					}
					catch(Exception ex)
					{
						
					}
				}
				if(e.getSource() == btExcluir)
				{
					Veiculos v = new Veiculos();
					v.excluiVeiculos(placa);
					JOptionPane.showMessageDialog(null, "Veiculo excluído com sucesso!");
					txtbuscaPlaca.setText("");
					txtMarca.setText("");
					txtModelo.setText("");
					txtAno.setText("");
					txtPlaca.setText("");
					Plataforma.verificatela=0;
					dispose();
				}
				if(e.getSource() == btCancelar)
				{
					txtbuscaPlaca.setText("");
					txtMarca.setText("");
					txtModelo.setText("");
					txtAno.setText("");
					txtPlaca.setText("");
					Plataforma.verificatela=0;
					dispose();
				}
			}//fim actionPermed
		}//fim actionListener
		Eventos acao = new Eventos();
		btCancelar.addActionListener(acao);	
		btBuscar.addActionListener(acao);
		btExcluir.addActionListener(acao);
		
	}

	
}
