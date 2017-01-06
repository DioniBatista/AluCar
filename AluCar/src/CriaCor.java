import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.ResultSet;
public class CriaCor extends JInternalFrame
{
	String modelosel;
	String marcasel;
	public CriaCor()
	{
		super("Criar nova cor",false,false,false,false);
		setBounds(200,100,400,300);
		setVisible(true);
		setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca: ");
		final JComboBox comboMarca = new JComboBox();
		 comboMarca.addItem("Escolha a marca:");
		comboMarca.setEditable(false);
		comboMarca.setSelectedIndex(0);	
		
		JLabel lblModelo = new JLabel("Modelo: ");
		final JComboBox comboModelo = new JComboBox();
		comboModelo.addItem("Escolha o modelo:");
		comboModelo.setEditable(false);
		comboModelo.setSelectedIndex(0);
		
		JLabel lblCor = new JLabel("Nova Cor: ");
		final JTextField txtCor = new JTextField();
		
		final JButton btSalvar = new JButton("Salvar");
		final JButton btCancelar = new JButton("Cancelar");
		
		/*lblMarca.setBounds(50,50,50,20);
		add(lblMarca);
		comboMarca.setBounds(100,50,200,20);
		add(comboMarca);
		lblModelo.setBounds(50,90,50,20);
		add(lblModelo);
		comboModelo.setBounds(100,90,150,20);
		add(comboModelo);*/
		
		lblCor.setBounds(50,130,100,20);
		add(lblCor);
		txtCor.setBounds(120,130,100,20);
		add(txtCor);
		
		btSalvar.setBounds(100,190,100,30);
		add(btSalvar);
		btCancelar.setBounds(230,190,100,30);
		add(btCancelar);
		
		
		
		class Eventos implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == btCancelar)
				{
					txtCor.setText("");
					Plataforma.verificatela=0;
					dispose();
				}
				
				if(e.getSource() == comboMarca)
				{
					
					try{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						CaracteristicaVeiculo carac=new CaracteristicaVeiculo();
						
						String selecao=comboMarca.getSelectedItem().toString();
						ResultSet resultadomarca=carac.pesquisarMarca(conn, selecao);
						resultadomarca.first();
						marcasel=resultadomarca.getString(1);
						
						
						ResultSet resultadomodelo=carac.exibirModelo(conn,marcasel);
						
						
						if(resultadomodelo.first())
						{
							  comboModelo.removeAllItems();
							
							do{
							comboModelo.addItem(resultadomodelo.getString(3));
							
							}while(resultadomodelo.next());	
							
						}	
					}
					catch(Exception ex)
					{}
				}
				if(e.getSource() == comboModelo)
				{
					try{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						CaracteristicaVeiculo carac=new CaracteristicaVeiculo();
					String selecao=comboModelo.getSelectedItem().toString();
					ResultSet resultadomodelo=carac.pesquisarModelo(conn, selecao);
					resultadomodelo.first();
					modelosel=resultadomodelo.getString(1);
					}
					catch(Exception ex)
					{}
				}
				if(e.getSource() == btSalvar)
				{
					try
					{
						
						Conexao conecta=new Conexao();					
						Connection conn=conecta.obtemConexao();	
					//String marca = comboMarca.getSelectedItem().toString();
					Cor c=new Cor(txtCor.getText().toUpperCase());
					c.inserirCor(conn);
					JOptionPane.showMessageDialog(null, "Cor criada com Sucesso!");
					txtCor.setText("");	
					//comboModelo.removeAllItems();
					Plataforma.verificatela=0;
					dispose();
					}
					catch(Exception E)
					{
					
						JOptionPane.showMessageDialog(null, "Erro ao inserir");
					}
				}
				
			}//fim actionPermed
		}//fim actionListener
		class Atualizacombo implements FocusListener
		{
			public void focusGained(FocusEvent f)
			{
				if(f.getSource()==comboMarca)
				{
					try
					{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						Marca m = new Marca();
						ResultSet resultadomarca=m.exibirMarca(conn);
						if(resultadomarca.first())
						{
							comboMarca.removeAllItems();
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
		Eventos acao = new Eventos();
		Atualizacombo atualiza=new Atualizacombo();
		btCancelar.addActionListener(acao);
		btSalvar.addActionListener(acao);
		comboMarca.addActionListener(acao);
		comboModelo.addActionListener(acao);
		comboMarca.addFocusListener(atualiza);
	}

}
