import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
public class ExcluiFuncionario extends JInternalFrame
{
	public ExcluiFuncionario() 
	{
		super("Excluir Funcionário",false,false,false,false);
		setBounds(100,50,600,300);
		setVisible(true);
		setLayout(null);
		
		JLabel lblbuscaNome = new JLabel("Nome: ");
		JLabel lblNome = new JLabel("Nome: ");
		JLabel lblCargo = new JLabel("Cargo: ");
		final JTextField txtbuscaNome = new JTextField();
		final JTextField txtNome = new JTextField();
		final JTextField txtCargo = new JTextField();
		final JButton btBuscar = new JButton("Buscar");
		final JButton btExcluir = new JButton("Excluir");
		final JButton btCancelar = new JButton("Cancelar");
		
		lblbuscaNome.setBounds(100,50,50,20);
		add(lblbuscaNome);
		txtbuscaNome.setBounds(150,50,150,20);
		add(txtbuscaNome);
		btBuscar.setBounds(320,50,100,20);
		add(btBuscar);
		
		txtbuscaNome.requestFocus(true);
		
		lblNome.setBounds(50,100,50,20);
		add(lblNome);
		txtNome.setBounds(100,100,150,20);
		add(txtNome);	
		lblCargo.setBounds(280,100,50,20);
		add(lblCargo);
		txtCargo.setBounds(340,100,150,20);
		add(txtCargo);
		
		txtNome.setEditable(false);
		txtCargo.setEditable(false);
		
		btExcluir.setBounds(300,200,100,30);
		add(btExcluir);
		btCancelar.setBounds(420,200,100,30);
		add(btCancelar);
		
		class Eventos implements ActionListener
		{
			String nome;
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == btBuscar)
				{
					try
					{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						 nome=txtbuscaNome.getText();
						Funcionarios f=new Funcionarios();
						ResultSet resultado=f.pesquisarFuncionario(conn,nome);
						if(resultado.first())
						{
							do{
								txtNome.setText(resultado.getString(2));
								txtCargo.setText(resultado.getString(4));
							}
							while(resultado.next());
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Dados não encontrados, procure outro Nome");
						}
					}
					catch(Exception ex)
					{
						
					}
				}
				if(e.getSource() == btCancelar)
				{
					txtNome.setText("");
					txtCargo.setText("");
					txtbuscaNome.setText("");
					Plataforma.verificatela=0;
					dispose();
				}
				if(e.getSource()==btExcluir)
				{
					Funcionarios f = new Funcionarios();
					f.excluiFuncionario(nome);
					JOptionPane.showMessageDialog(null, "Funcionário Excluídos com Sucesso!");
					txtNome.setText("");
					txtCargo.setText("");
					txtbuscaNome.setText("");
					Plataforma.verificatela=0;
					dispose();
					
				}
				
			}//fim actionPrformed
		}//fim ActionListenr
		
		Eventos acao = new Eventos();
		btCancelar.addActionListener(acao);
		btBuscar.addActionListener(acao);
		btExcluir.addActionListener(acao);
	}

}
