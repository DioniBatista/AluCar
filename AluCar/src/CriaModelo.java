import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.ResultSet;
public class CriaModelo extends JInternalFrame
{
	String marcasel;
	public CriaModelo()
	{
		super("Criar novo modelo",false,false,false,false);
		setBounds(200,100,400,300);
		setVisible(true);
		setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca: ");
		final JComboBox comboMarca = new JComboBox();
		comboMarca.addItem("Escolha a marca:");
		comboMarca.setEditable(false);
		comboMarca.setSelectedIndex(0);	
		
		JLabel lblModelo = new JLabel("Novo modelo: ");
		final JTextField txtModelo = new JTextField();
		final JButton btSalvar = new JButton("Salvar");
		final JButton btCancelar = new JButton("Cancelar");
		
		lblMarca.setBounds(50,70,50,20);
		add(lblMarca);
		comboMarca.setBounds(100,70,200,20);
		add(comboMarca);
		lblModelo.setBounds(50,120,100,20);
		add(lblModelo);
		txtModelo.setBounds(150,120,150,20);
		add(txtModelo);
		
		btSalvar.setBounds(100,190,100,30);
		add(btSalvar);
		btCancelar.setBounds(230,190,100,30);
		add(btCancelar);
		
		
		//CARREGAR A COMBO MARCA
		/*try
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
			
		}*/
		
		class Eventos implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
				
				if(e.getSource() == btCancelar)
				{
					Plataforma.verificatela=0;
					dispose();
				}
				if(e.getSource() == comboMarca)
				{
					
					//JOptionPane.showMessageDialog(null,marcasel);
					try{
					Conexao conecta=new Conexao();
					Connection conn=conecta.obtemConexao();
					CaracteristicaVeiculo carac = new CaracteristicaVeiculo();
					String selecao=comboMarca.getSelectedItem().toString();
					ResultSet resultadomarca=carac.pesquisarMarca(conn, selecao);
					resultadomarca.first();
					marcasel=resultadomarca.getString(1);
							
					//.showMessageDialog(null,marcasel);
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
					Modelo m=new Modelo(txtModelo.getText().toUpperCase(),marcasel.toUpperCase());
					m.inserirModelo(conn);
					JOptionPane.showMessageDialog(null, "Modelo criado com sucesso!");
					txtModelo.setText("");	
					comboMarca.removeAllItems();
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
		Atualizacombo atualiza = new Atualizacombo();
		btCancelar.addActionListener(acao);
		btSalvar.addActionListener(acao);
		comboMarca.addActionListener(acao);
		comboMarca.addFocusListener(atualiza);
	}

}
