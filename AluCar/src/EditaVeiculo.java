import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class EditaVeiculo extends JInternalFrame
{
	String teste= "";
	public EditaVeiculo()
	{
		super("Editar veículo",false,false,false,false);
		setBounds(0,0,800,600);
		setVisible(true);
		setLayout(null);
		
		JLabel lblbuscaPlaca = new JLabel("Placa: ");
		final JFormattedTextField txtbuscaPlaca = new JFormattedTextField();
		final JButton btBuscar = new JButton("Buscar");
		
		try
		{
			MaskFormatter placa = new MaskFormatter("***-####");
			placa.install(txtbuscaPlaca);
		}
		catch(Exception e)
		{
			
		}
		
		lblbuscaPlaca.setBounds(200,25,50,20);
		add(lblbuscaPlaca);
		
		txtbuscaPlaca.setBounds(250,25,100,20);
		add(txtbuscaPlaca);
		
		btBuscar.setBounds(360,25,100,20);
		add(btBuscar);
		
		/////////////////////////////////////////////
		JLabel lblModelo = new JLabel("Modelo: ");
		JLabel lblMarca = new JLabel("Marca: ");
		JLabel lblCor = new JLabel("Cor: ");
		JLabel lblPlaca = new JLabel("Placa: ");
		JLabel lblAno = new JLabel("Ano de Fabricação: ");
		JLabel lblvalorLocacao = new JLabel("Valor da Locação: ");
		
		final JTextField txtMarcasel = new JTextField();
		final JTextField txtModelosel = new JTextField();
		final JTextField txtCorsel = new JTextField();
		
		
		final JComboBox comboModelo = new JComboBox();
		comboModelo.addItem("Novo modelo:");
		comboModelo.setEditable(false);//nao permite editar as combobox
		comboModelo.setSelectedIndex(0);//mostrar a posicao zero da combo
				
		final JComboBox comboMarca = new JComboBox();
		comboMarca.addItem("Nova marca:");
		comboMarca.setEditable(false);
		comboMarca.setSelectedIndex(0);
		
		final JComboBox comboCor = new JComboBox();
		comboCor.addItem("Nova cor:");
		comboCor.setEditable(false);
		comboCor.setSelectedIndex(0);		
		
		final JFormattedTextField txtPlaca = new JFormattedTextField();
		final JFormattedTextField txtAno = new JFormattedTextField();
		final JFormattedTextField txtvalorLocacao = new JFormattedTextField();
		
		final JButton btSalvar = new JButton("Salvar alterações");
		final JButton btCancelar = new JButton("Cancelar");
		final JButton btLimpar = new JButton("Limpar");
		
		//mascara
		try
		{
			MaskFormatter placa = new MaskFormatter("***-####");
			MaskFormatter ano = new MaskFormatter("####");
			
			
			placa.install(txtPlaca);
			ano.install(txtAno);
			
		}
		catch(Exception e)
		{
			
		}		
		//caixas para serem preenchidas pelo banco

		txtMarcasel.setBounds(100,100,200,20);
		txtMarcasel.setEditable(false);
		add(txtMarcasel);
		
		txtModelosel.setBounds(360,100,200,20);
		txtModelosel.setEditable(false);
		add(txtModelosel);
		
		txtCorsel.setBounds(600,100,100,20);
		txtCorsel.setEditable(false);
		add(txtCorsel);
		// fim de preenchimento 
		
		lblMarca.setBounds(50,130,50,20);
		add(lblMarca);
		comboMarca.setBounds(100,130,200,20);
		add(comboMarca);
		
		lblModelo.setBounds(310,130,50,20);
		add(lblModelo);
		comboModelo.setBounds(360,130,200,20);
		add(comboModelo);
		
		lblCor.setBounds(570,130,50,20);
		add(lblCor);
		comboCor.setBounds(600,130,150,20);
		add(comboCor);
		
		lblPlaca.setBounds(50,190,50,20);
		add(lblPlaca);
		txtPlaca.setBounds(100,190,100,20);
		txtPlaca.setEditable(false);
		add(txtPlaca);
		
		lblAno.setBounds(230,190,200,20);
		add(lblAno);
		txtAno.setBounds(350,190,100,20);
		add(txtAno);
		
		lblvalorLocacao.setBounds(480,190,200,20);
		add(lblvalorLocacao);
		txtvalorLocacao.setBounds(590,190,100,20);
		add(txtvalorLocacao);
		
		btSalvar.setBounds(200,250,150,30);
		add(btSalvar);
		btLimpar.setBounds(380,250,80,30);
		add(btLimpar);
		btCancelar.setBounds(480,250,100,30);
		add(btCancelar);
		
		//CARREGA COMBOMARCA
		 
				try
				{
					Conexao conecta=new Conexao();
					Connection conn=conecta.obtemConexao();
					CaracteristicaVeiculo carac=new CaracteristicaVeiculo();
					ResultSet resultadomarca=carac.exibirMarca(conn);
					
					if(resultadomarca.first())
					{
						do{
						comboMarca.addItem(resultadomarca.getString(2));
						
						}while(resultadomarca.next());						
					}	
				}
				catch(Exception e)
				{
					
				}
				
		
		class Eventos implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				
				if(e.getSource() == btBuscar)
				{
					try
					{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						String placa = txtbuscaPlaca.getText();
						Veiculos v=new Veiculos();
						ResultSet resultado=v.pesquisarVeiculos(conn, placa);
						if(resultado.first())
						{
							do{
								txtPlaca.setText(resultado.getString(1));
								txtMarcasel.setText(resultado.getString(2));
								txtModelosel.setText(resultado.getString(3));
								txtCorsel.setText(resultado.getString(4));
								txtAno.setText(resultado.getString(5));
								txtvalorLocacao.setText(resultado.getString(6));
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
				if(e.getSource() == comboMarca)
				{
					comboModelo.removeAllItems();
					  comboCor.removeAllItems();
					try
					{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						CaracteristicaVeiculo c=new CaracteristicaVeiculo();
						
						String selecao=comboMarca.getSelectedItem().toString();
						ResultSet resultadomarca=c.pesquisarMarca(conn, selecao);
						resultadomarca.first();
						teste=resultadomarca.getString(1);						
						
						ResultSet resultadomodelo=c.exibirModelo(conn,teste);
						//ResultSet resultadocor=c.exibirCor(conn,teste);
						ResultSet resultadocor=c.exibirCor(conn);
						if(resultadomodelo.first())
						{
							  comboModelo.removeAllItems();
							  comboCor.removeAllItems();
							
							do{
							comboModelo.addItem(resultadomodelo.getString(3));
							
							}while(resultadomodelo.next());	
						}					
						
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "erro combo modelo"+ex);
					}
				}
				if(e.getSource() == comboModelo)
				{
					
					try
					{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						CaracteristicaVeiculo carac=new CaracteristicaVeiculo();
						
						String selecao=comboModelo.getSelectedItem().toString();
						ResultSet resultadomodelo=carac.pesquisarModelo(conn, selecao);
						resultadomodelo.first();
						teste=resultadomodelo.getString(1);
						
						//ResultSet resultadocor=carac.exibirCor(conn,teste);
						ResultSet resultadocor=carac.exibirCor(conn);
						if(resultadocor.first())
						{
							  comboCor.removeAllItems();
							
							do{
							comboCor.addItem(resultadocor.getString(2));
							
							}while(resultadocor.next());
						}					
						
					}
					catch(Exception ex)
					{
						
					}
				}
				if(e.getSource() == btLimpar)
				{
					txtbuscaPlaca.setText("");
					txtMarcasel.setText("");
					txtModelosel.setText("");
					txtCorsel.setText("");
					comboMarca.setSelectedItem(0);
					comboModelo.setSelectedItem(0);
					comboCor.setSelectedItem(0);
					txtPlaca.setText("");
					txtvalorLocacao.setText("");
					txtAno.setText("");
					
				}
				if(e.getSource() == btCancelar)
				{
					txtbuscaPlaca.setText("");
					txtMarcasel.setText("");
					txtModelosel.setText("");
					txtCorsel.setText("");
					comboMarca.setSelectedItem(0);
					comboModelo.setSelectedItem(0);
					comboCor.setSelectedItem(0);
					txtPlaca.setText("");
					txtvalorLocacao.setText("");
					txtAno.setText("");
					Plataforma.verificatela=0;
					dispose();
				}
				if(e.getSource() == btSalvar)
				{
					/*if(comboCor.getSelectedItem().equals("Nova cor:")||comboCor.getSelectedItem().equals(" "))
					{
						JOptionPane.showMessageDialog(null, "Por favor, preencha a Cor!");
					}*/
					
						Veiculos v = new Veiculos();
						v.editaVeiculos(txtPlaca.getText(),comboMarca.getSelectedItem().toString(),comboModelo.getSelectedItem().toString(),comboCor.getSelectedItem().toString(),Integer.parseInt(txtvalorLocacao.getText()),Integer.parseInt(txtAno.getText()));
						JOptionPane.showMessageDialog(null, "Veiculo alterado com Sucesso!!");
						txtbuscaPlaca.setText("");
						txtMarcasel.setText("");
						txtModelosel.setText("");
						txtCorsel.setText("");
						comboMarca.setSelectedItem(0);
						comboModelo.setSelectedItem(0);
						comboCor.setSelectedItem(0);
						txtPlaca.setText("");
						txtvalorLocacao.setText("");
						txtAno.setText("");
						Plataforma.verificatela=0;
						dispose();
						
				}
			}//fim actionPermed
		}//fim actionListener
		Eventos acao = new Eventos();
		btSalvar.addActionListener(acao);
		btCancelar.addActionListener(acao);	
		btBuscar.addActionListener(acao);
		btLimpar.addActionListener(acao);
		comboMarca.addActionListener(acao);
		comboModelo.addActionListener(acao);
		comboCor.addActionListener(acao);
		}//fim construtor

}
