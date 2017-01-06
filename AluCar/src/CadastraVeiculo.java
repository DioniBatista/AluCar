import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
public class CadastraVeiculo extends JInternalFrame
{
	String teste="";
	public CadastraVeiculo()
	{
		super("Cadastro de Veículo",false,false,false,false);
		setBounds(0,0,800,600);
		setVisible(true);
		setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo: ");
		JLabel lblMarca = new JLabel("Marca: ");
		JLabel lblCor = new JLabel("Cor: ");
		JLabel lblPlaca = new JLabel("Placa: ");
		JLabel lblAno = new JLabel("Ano de Fabricação: ");
		JLabel lblvalorLocacao = new JLabel("Valor da Locação: ");
		
		final JComboBox comboModelo = new JComboBox();
		comboModelo.addItem("");
		comboModelo.setEditable(false);//nao permite editar as combobox
		comboModelo.setSelectedIndex(0);//mostrar a posicao zero da combo
		
		final JComboBox comboMarca = new JComboBox();
		comboMarca.addItem("");
		comboMarca.setEditable(false);
		comboMarca.setSelectedIndex(0);
		
		final JComboBox comboCor = new JComboBox();
		comboCor.addItem("");
		comboCor.setEditable(false);
		comboCor.setSelectedIndex(0);		
		
		final JTextField txtvalorLocacao = new JTextField();
		final JFormattedTextField txtPlaca = new JFormattedTextField();
		final JFormattedTextField txtAno = new JFormattedTextField();
		//final JFormattedTextField txtvalorLocacao = new JFormattedTextField();
		
		final JButton btSalvar = new JButton("Salvar");
		final JButton btCancelar = new JButton("Cancelar");
		
		//mascara
		try
		{
			MaskFormatter placa = new MaskFormatter("***-####");
			MaskFormatter ano = new MaskFormatter("####");
			//MaskFormatter valor = new MaskFormatter("R$########");
			
			placa.install(txtPlaca);
			ano.install(txtAno);	
			//valor.install(txtvalorLocacao);
		}
		catch(Exception e)
		{
			
		}		
		
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
		add(txtPlaca);
		
		lblAno.setBounds(230,190,200,20);
		add(lblAno);
		txtAno.setBounds(350,190,100,20);
		add(txtAno);
		
		lblvalorLocacao.setBounds(480,190,200,20);
		add(lblvalorLocacao);
		txtvalorLocacao.setBounds(590,190,100,20);
		add(txtvalorLocacao);
		
		btSalvar.setBounds(300,250,100,30);
		add(btSalvar);
		btCancelar.setBounds(430,250,100,30);
		add(btCancelar);
		
		//CARREGA AS COMBOBOX 
		 
		/*try
		{
			Conexao conecta=new Conexao();
			Connection conn=conecta.obtemConexao();
			CaracteristicaVeiculo carac=new CaracteristicaVeiculo();
			ResultSet resultadomarca=carac.exibirMarca(conn);
			//String teste="";
			//ResultSet resultadomodelo=carac.exibirModelo(conn,teste);
			//ResultSet resultadocor=carac.exibirCor(conn,teste);
			if(resultadomarca.first())
			{
				do{
				comboMarca.addItem(resultadomarca.getString(2));
				
				}while(resultadomarca.next());	
				
			}
			
			
		}
		catch(Exception e)
		{
			
		}*/
		
		
	
		class Eventos implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == btSalvar)
				{
					
					try
					{
						Conexao conecta=new Conexao();					
						Connection conn=conecta.obtemConexao();	
					String marca = comboMarca.getSelectedItem().toString();
					String modelo = comboModelo.getSelectedItem().toString();
					String cor = comboCor.getSelectedItem().toString();
					String placa = txtPlaca.getText();
					String ano = txtAno.getText();
					int valor = Integer.parseInt(txtvalorLocacao.getText());
					
					Veiculos v=new Veiculos(marca,modelo,cor,placa,ano,valor);
					v.inserirVeiculos(conn);
					JOptionPane.showMessageDialog(null, "Veiculo cadastrado com Sucesso");
					
					comboMarca.setSelectedIndex(0);		
					comboModelo.setSelectedIndex(0);	
					comboCor.setSelectedIndex(0);	
					txtAno.setText("");
					txtPlaca.setText("");
					txtvalorLocacao.setText("");
					Plataforma.verificatela=0;
					dispose();
				}
				catch(Exception E)
				{
					
					JOptionPane.showMessageDialog(null, "Erro ao inserir");
				}		 
				}
				if(e.getSource() == btCancelar)
				{
					comboMarca.setSelectedIndex(0);
					comboModelo.setSelectedIndex(0);
					comboCor.setSelectedIndex(0);
					txtAno.setText("");
					txtPlaca.setText("");
					txtvalorLocacao.setText("");
					Plataforma.verificatela=0;
					dispose();
				}
				if(e.getSource() == comboMarca)
				{
					//JOptionPane.showMessageDialog(null, "combo marca select");
				
					try
					{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						CaracteristicaVeiculo carac=new CaracteristicaVeiculo();
						
						String selecao=comboMarca.getSelectedItem().toString();
						ResultSet resultadomarca=carac.pesquisarMarca(conn, selecao);
						resultadomarca.first();
						teste=resultadomarca.getString(1);
						
						
						ResultSet resultadomodelo=carac.exibirModelo(conn,teste);
						//ResultSet resultadocor=carac.exibirCor(conn,teste);
						ResultSet resultadocor=carac.exibirCor(conn);
						if(resultadomodelo.first())
						{
							  comboModelo.removeAllItems();
							
							do{
							comboModelo.addItem(resultadomodelo.getString(3));
							
							}while(resultadomodelo.next());	
							
							//JOptionPane.showMessageDialog(null, teste);
						}					
						
					}
					catch(Exception ex)
					{
						
					}
				}
				if(e.getSource() == comboModelo)
				{
					//JOptionPane.showMessageDialog(null, "combo modelo select");
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
							
							//JOptionPane.showMessageDialog(null, teste);
						}					
						
					}
					catch(Exception ex)
					{
						
					}
				}
				
			}//fim actionPermed
		}//fim actionListener
		class Carrega implements FocusListener
		{
			public void focusGained(FocusEvent f)
			{
				if(f.getSource() == comboMarca )
				{
					try
					{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						CaracteristicaVeiculo carac=new CaracteristicaVeiculo();
						ResultSet resultadomarca=carac.exibirMarca(conn);
						//String teste="";
						//ResultSet resultadomodelo=carac.exibirModelo(conn,teste);
						//ResultSet resultadocor=carac.exibirCor(conn,teste);
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
				}
				
			}
			
			public void focusLost(FocusEvent f)
			{
				
				
			}
			
		}//fim
		Carrega carrega = new Carrega();
		Eventos acao = new Eventos();
		btSalvar.addActionListener(acao);
		btCancelar.addActionListener(acao);	
		comboMarca.addActionListener(acao);
		comboModelo.addActionListener(acao);
		comboMarca.addFocusListener(carrega);
	}//fim construto
	
}
