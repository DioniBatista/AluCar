import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class ExcluiLocacao extends JInternalFrame
{
	String cpf;
	String codigo;
	
	public ExcluiLocacao()
	{
		super("Excluir locação");
		setBounds(0,0,800,600);
		setVisible(true);
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do cliente: ");
		JLabel lblbuscaCpf = new JLabel("CPF: ");
		final JFormattedTextField txtbuscaCpf = new JFormattedTextField();
		final JTextField txtNome = new JTextField();
		final JButton btBuscar = new JButton("Buscar");
		//JLabel lblVeiculos = new JLabel("Veículo: ");
		//final JTextField txtVeiculos = new JTextField();
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
		final JButton btExcluir = new JButton("Excluir");
		final JButton btCancelar = new JButton("Cancelar");
		final JComboBox comboVeiculos = new JComboBox();
		comboVeiculos.addItem("");
		comboVeiculos.setEditable(false);//nao permite editar as combobox
		comboVeiculos.setSelectedIndex(0);//mostrar a posicao zero da combo
		
		
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
		
		comboVeiculos.setBounds(320,50,150,20);
		add(comboVeiculos);
		
		//lblVeiculos.setBounds(50,130,150,20);
		//add(lblVeiculos);
		//txtVeiculos.setBounds(200,130,200,20);
		//txtVeiculos.setEditable(false);
		//add(txtVeiculos);
		
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
		txtData.setEditable(false);
		add(txtData);
		
		lblDias.setBounds(200,220,150,20);
		add(lblDias);
		txtDias.setBounds(315,220,50,20);
		txtDias.setEditable(false);
		add(txtDias);
		lblvalorTotal.setBounds(395,220,150,20);
		add(lblvalorTotal);
		txtvalorTotal.setBounds(470,220,80,20);
		txtvalorTotal.setEditable(false);
		add(txtvalorTotal);
		
		lblObservacao.setBounds(50,290,100,20);
		add(lblObservacao);
		txtObservacao.setBounds(85,320,550,100);
		txtObservacao.setEditable(false);
		add(txtObservacao);
		
		btExcluir.setBounds(300,470,100,30);
		add(btExcluir);
		btCancelar.setBounds(430,470,100,30);
		add(btCancelar);
		
		class Eventos implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == btBuscar)
				{
					comboVeiculos.removeAllItems();
					try
					{
					Conexao conecta=new Conexao();
					Connection conn=conecta.obtemConexao();
					
					Locacao l=new Locacao();
					cpf = txtbuscaCpf.getText();
					ResultSet resultado = l.pesquisarLocacao(conn, cpf);
					if(resultado.first())
					{
						
						do
						{
							comboVeiculos.addItem(resultado.getString(5));
							//codigo = resultado.getString(1);
							
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
					
					try
					{
					Conexao conecta=new Conexao();
					Connection conn=conecta.obtemConexao();
					String carroselect = comboVeiculos.getSelectedItem().toString();
					Locacao l=new Locacao();
					
					
					ResultSet resultado = l.pesquisarveiculoLocacao(conn, cpf,carroselect);
					if(resultado.first())
					{
						
						do
						{
							txtNome.setText(resultado.getString(3));
							txtMarca.setText(resultado.getString(4));
							txtModelo.setText(resultado.getString(5));
							txtCor.setText(resultado.getString(6));
							txtPlaca.setText(resultado.getString(7));
							txtAno.setText(resultado.getString(8));
							txtvalorLocacao.setText(resultado.getString(9));
							txtData.setText(resultado.getString(10));
							txtDias.setText(resultado.getString(11));
							txtvalorTotal.setText(resultado.getString(12));
							txtObservacao.setText(resultado.getString(13));
							
						}while(resultado.next());
					}
				
					}
					catch(Exception ex)
					{
						
					}
				}
				if(e.getSource() == btExcluir)
				{
					String carroselect = comboVeiculos.getSelectedItem().toString();
					Locacao l = new Locacao();
					l.excluiLocacao(cpf,carroselect,txtModelo.getText(),txtCor.getText());
					JOptionPane.showMessageDialog(null, "Locacao Excluída com Sucesso!");
					txtbuscaCpf.setText("");
					txtNome.setText("");
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
					comboVeiculos.removeAllItems();
					Plataforma.verificatela=0;
					dispose();
				}
				if(e.getSource() == btCancelar)
				{
					comboVeiculos.removeAllItems();
					txtbuscaCpf.setText("");
					txtNome.setText("");
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
					dispose();
				}
			}//fim actionPerformed
		}//fim ActionListener
		Eventos acao = new Eventos();
		btCancelar.addActionListener(acao);
		btBuscar.addActionListener(acao);
		btExcluir.addActionListener(acao);
		comboVeiculos.addActionListener(acao);
		
	}//fim construtor

}
