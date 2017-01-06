import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CriaLocacao extends JInternalFrame
{
	String veiculo;
	String cor;
	public CriaLocacao()
	{
		super("Locar veículos");
		setBounds(0,0,800,600);
		setVisible(true);
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do cliente: ");
		JLabel lblbuscaCpf = new JLabel("CPF: ");
		final JFormattedTextField txtbuscaCpf = new JFormattedTextField();
		final JTextField txtNome = new JTextField();
		final JButton btBuscar = new JButton("Buscar");
		final JComboBox comboVeiculos = new JComboBox();
		comboVeiculos.addItem("Escolha o veículo:");
		comboVeiculos.setEditable(false);//nao permite editar as combobox
		comboVeiculos.setSelectedIndex(0);//mostrar a posicao zero da combo
		final JComboBox comboCor = new JComboBox();
		comboCor.addItem("");
		comboCor.setEditable(false);//nao permite editar as combobox
		comboCor.setSelectedIndex(0);//mostrar a posicao zero da combo
		
		JLabel lblMarca = new JLabel("Marca: ");
		final JTextField txtMarca = new JTextField();
		JLabel lblModelo = new JLabel("Modelo: ");
		final JTextField txtModelo = new JTextField();
		JLabel lblCor = new JLabel("Cor: ");
		final JTextField txtCor = new JTextField();
		JLabel lblPlaca = new JLabel("Placa: ");
		final JTextField txtPlaca = new JTextField();
		JLabel lblAno = new JLabel("Ano de Fabricação: ");
		final JTextField txtAno = new JTextField();
		JLabel lblvalorLocacao = new JLabel("Valor da locação: ");
		final JTextField txtvalorLocacao = new JTextField();
		JLabel lblData = new JLabel("Data: ");
		final JFormattedTextField txtData = new JFormattedTextField();
		JLabel lblDias = new JLabel("Quantidade de dias: ");
		final JTextField txtDias = new JTextField();
		JLabel lblvalorTotal = new JLabel("Valor total: ");
		final JTextField txtvalorTotal = new JTextField();
		JLabel lblObservacao = new JLabel("Observação: ");
		final JTextArea txtObservacao = new JTextArea();
		final JButton btAlugar = new JButton("Alugar");
		final JButton btCancelar = new JButton("Cancelar");
		
		
		try
		{
			MaskFormatter cpf = new MaskFormatter("###.###.###-##");
			MaskFormatter data = new MaskFormatter("##/##/####");
			cpf.install(txtbuscaCpf);			
			data.install(txtData);
		}
		catch(Exception e)
		{
			//nao precisa preeccher
		}
		
		lblbuscaCpf.setBounds(50,50,50,20);
		add(lblbuscaCpf);
		txtbuscaCpf.setBounds(100,50,100,20);
		add(txtbuscaCpf);
		
		lblNome.setBounds(50,80,150,20);
		add(lblNome);
		txtNome.setBounds(170,80,250,20);
		txtNome.setEditable(false);
		add(txtNome);
		
		btBuscar.setBounds(210,50,90,20);
		add(btBuscar);
		
		comboVeiculos.setBounds(50,130,200,20);
		add(comboVeiculos);
		
		comboCor.setBounds(270,130,150,20);
		comboCor.setVisible(false);
		add(comboCor);
		
		lblMarca.setBounds(50,160,50,20);
		add(lblMarca);
		txtMarca.setBounds(100,160,100,20);
		txtMarca.setEditable(false);
		add(txtMarca);
		
		lblModelo.setBounds(230,160,50,20);
		add(lblModelo);
		txtModelo.setBounds(280,160,100,20);
		txtModelo.setEditable(false);
		add(txtModelo);
		
		lblCor.setBounds(410,160,50,20);
		add(lblCor);
		txtCor.setBounds(460,160,100,20);
		txtCor.setEditable(false);
		add(txtCor);
		
		lblPlaca.setBounds(50,190,50,20);
		add(lblPlaca);
		txtPlaca.setBounds(100,190,100,20);
		txtPlaca.setEditable(false);
		add(txtPlaca);
		
		lblAno.setBounds(230,190,150,20);
		add(lblAno);
		txtAno.setBounds(350,190,100,20);
		txtAno.setEditable(false);
		add(txtAno);
		
		lblvalorLocacao.setBounds(480,190,130,20);
		add(lblvalorLocacao);
		txtvalorLocacao.setBounds(590,190,100,20);
		txtvalorLocacao.setEditable(false);
		add(txtvalorLocacao);
		
		lblData.setBounds(50,220,50,20);
		add(lblData);
		txtData.setBounds(100,220,80,20);
		add(txtData);
		
		lblDias.setBounds(200,220,150,20);
		add(lblDias);
		txtDias.setBounds(315,220,50,20);
		add(txtDias);
		lblvalorTotal.setBounds(395,220,150,20);
		add(lblvalorTotal);
		txtvalorTotal.setBounds(470,220,80,20);
		txtvalorTotal.setEditable(false);
		add(txtvalorTotal);
		
		lblObservacao.setBounds(50,290,100,20);
		add(lblObservacao);
		txtObservacao.setBounds(85,320,550,100);
		add(txtObservacao);
		
		btAlugar.setBounds(300,470,100,30);
		add(btAlugar);
		btCancelar.setBounds(430,470,100,30);
		add(btCancelar);
		
		
		
		
		class Eventos implements ActionListener
		{
			String cpf;
			
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == btBuscar)
				{
					//COLOCA DATA
					txtData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
					try
					{
					Conexao conecta=new Conexao();
					Connection conn=conecta.obtemConexao();
					
					Cliente c=new Cliente();
					cpf = txtbuscaCpf.getText();
					ResultSet resultado = c.pesquisarCliente(conn, cpf);
					if(resultado.first())
					{
						do
						{
							txtNome.setText(resultado.getString(3));
							
						}while(resultado.next());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Dados não encontrados, procure outro Cpf");
					}
					}
					catch(Exception ex)
					{
						
					}
				}
				
				if(e.getSource() == comboVeiculos)
				{
					comboCor.setVisible(true);
					try
					{
						String modelo = comboVeiculos.getSelectedItem().toString();
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						Locacao l=new Locacao();
						ResultSet resultado=l.mostraCor(conn,modelo);
						
						if(resultado.first())
						{
							comboCor.removeAllItems();
							do{				
								
								comboCor.addItem(resultado.getString(4));			
							
							}while(resultado.next());						
						}	
					}
					catch(Exception ex)
					{
					}
				}
				if(e.getSource()==comboCor)
				{
					
					try
					{
						//codveiculo = "aaa-0987";
						veiculo =comboVeiculos.getSelectedItem().toString(); 
						cor = comboCor.getSelectedItem().toString();
						//JOptionPane.showMessageDialog(null, veiculo+cor);
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						Locacao l=new Locacao();
						ResultSet resultado=l.dadosVeiculos(conn,veiculo,cor);
					
						if(resultado.first())
						{
							do{
								
							txtMarca.setText(resultado.getString(2));
							txtModelo.setText(resultado.getString(3));
							txtCor.setText(resultado.getString(4));
							txtPlaca.setText(resultado.getString(1));
							txtAno.setText(resultado.getString(5));
							txtvalorLocacao.setText(resultado.getString(6));
							}
							while(resultado.next());
					   }
					}
					catch(Exception ex)
					{
					
					}
				}
				if(e.getSource() == btAlugar)
				{
					try
					{
						
						Conexao conecta=new Conexao();					
						Connection conn=conecta.obtemConexao();	
				
					Locacao l=new Locacao(txtbuscaCpf.getText(),txtNome.getText(),txtMarca.getText(),txtModelo.getText(),txtCor.getText(),txtPlaca.getText(),txtAno.getText(),txtvalorLocacao.getText(),txtData.getText(),txtDias.getText(),txtvalorTotal.getText(),txtObservacao.getText());
					l.inserirLocacao(conn);
					l.colocaStatus(txtModelo.getText(), txtCor.getText());
					JOptionPane.showMessageDialog(null, "Locacao concluida!");
					//carrega pdf
					new Mostrapdf(txtNome.getText(),txtbuscaCpf.getText(),txtMarca.getText(),txtModelo.getText(),txtCor.getText(),txtPlaca.getText(),txtvalorLocacao.getText(),txtObservacao.getText(),txtvalorTotal.getText(),txtData.getText());
					txtNome.setText("");
					txtbuscaCpf.setText("");
					txtMarca.setText("");
					txtModelo.setText("");
					txtCor.setText("");
					txtPlaca.setText("");
					txtAno.setText("");
					txtvalorLocacao.setText("");
					txtData.setText("");
					txtDias.setText("");
					txtvalorTotal.setText("");
					txtObservacao.setText("");
					comboVeiculos.setSelectedIndex(0);
					comboCor.setSelectedIndex(0);
					Plataforma.verificatela=0;
					dispose();
				}
				catch(Exception E)
				{
					
					JOptionPane.showMessageDialog(null, "Erro ao alugar..Exibir pdf");
				}		 
				}
				
				if(e.getSource() == btCancelar)
				{
					txtNome.setText("");
					txtbuscaCpf.setText("");
					txtMarca.setText("");
					txtModelo.setText("");
					txtCor.setText("");
					txtPlaca.setText("");
					txtAno.setText("");
					txtvalorLocacao.setText("");
					txtData.setText("");
					txtDias.setText("");
					txtvalorTotal.setText("");
					txtObservacao.setText("");
					comboVeiculos.setSelectedItem(0);
					Plataforma.verificatela=0;
					dispose();
				}
			}//fim actionPerformed
		}//fim ActionListener
		
		class Somar implements FocusListener
		{
			public void focusGained(FocusEvent f)
			{
				if(f.getSource() == comboVeiculos)
				{
					try
					{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						Veiculos v=new Veiculos();
						ResultSet resultado=v.exibirVeiculos(conn);
						
						if(resultado.first())
						{
							comboVeiculos.removeAllItems();
							do{
								
								comboVeiculos.addItem(resultado.getString(3));
							
							
							}while(resultado.next());						
						}	
					}
					catch(Exception e)
					{
						
					}
				}
				
			}
			
			public void focusLost(FocusEvent f)
			{
				if(f.getSource()==txtDias)
				{
					int valorlocacao = Integer.parseInt(txtvalorLocacao.getText());
					int dias = Integer.parseInt(txtDias.getText());
					int total = valorlocacao*dias;	
					String aux = String.valueOf(total);
					txtvalorTotal.setText(aux);
				}
				
			}
			
		}//fim
		Eventos acao = new Eventos();
		Somar soma = new Somar();
		btCancelar.addActionListener(acao);
		btBuscar.addActionListener(acao);
		btAlugar.addActionListener(acao);
		comboVeiculos.addActionListener(acao);
		comboCor.addActionListener(acao);
		txtDias.addFocusListener(soma);
		comboVeiculos.addFocusListener(soma);
	}//fim construtor

}
