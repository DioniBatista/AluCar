import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class ExcluiCliente extends JInternalFrame
{
	public ExcluiCliente()
	{
		super("Exluir Cliente",false,false,false,false);
		setBounds(100,50,600,300);
		setVisible(true);
		setLayout(null);
		
		JLabel lblbuscaCpf = new JLabel("CPF: ");
		final JFormattedTextField txtbuscaCpf = new JFormattedTextField();
		final JButton btBuscar = new JButton("Buscar");
		
		JLabel lblNome = new JLabel("Nome: ");
		JLabel lblTelefone = new JLabel("Telefone: ");
		final JTextField txtNome = new JTextField();
		final JFormattedTextField txtTelefone = new JFormattedTextField();
		
		final JButton btExcluir = new JButton("Excluir");
		final JButton btCancelar = new JButton("Cancelar");
		
		try
		{
			MaskFormatter cpf = new MaskFormatter("###.###.###-##");
			MaskFormatter tel = new MaskFormatter("(##) ####-####");
			cpf.install(txtbuscaCpf);
			tel.install(txtTelefone);
		}
		catch(Exception e)
		{
			
		}
		
		lblbuscaCpf.setBounds(100,50,50,20);
		add(lblbuscaCpf);
		txtbuscaCpf.setBounds(150,50,150,20);
		add(txtbuscaCpf);
		btBuscar.setBounds(320,50,100,20);
		add(btBuscar);
		
		lblNome.setBounds(50,100,50,20);
		add(lblNome);
		txtNome.setBounds(100,100,150,20);
		add(txtNome);	
		lblTelefone.setBounds(280,100,100,20);
		add(lblTelefone);
		txtTelefone.setBounds(340,100,150,20);
		add(txtTelefone);
		
		txtTelefone.setEditable(false);//nao permite editar
		txtNome.setEditable(false);
		
		btExcluir.setBounds(300,200,100,30);
		add(btExcluir);
		btCancelar.setBounds(420,200,100,30);
		add(btCancelar);
		
		class Eventos implements ActionListener
		{
			String cpf;
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == btBuscar)
				{
					try
					{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						 cpf=txtbuscaCpf.getText();
						Cliente c=new Cliente();
						ResultSet resultado=c.pesquisarCliente(conn,cpf);
						if(resultado.first())
						{
							do{
								txtNome.setText(resultado.getString(3));
								txtTelefone.setText(resultado.getString(7));
							}
							while(resultado.next());
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Dados não encontrados, procure outro cpf");
						}
					}
					catch(Exception ex)
					{
						
					}
				}
				if(e.getSource() == btCancelar)
				{
					txtNome.setText("");
					txtTelefone.setText("");
					txtbuscaCpf.setText("");
					Plataforma.verificatela=0;
					dispose();
					
				}
				if(e.getSource()==btExcluir)
				{
					Cliente c=new Cliente();
					c.excluiCliente(cpf);
					JOptionPane.showMessageDialog(null, "Cliente Excluído com Sucesso!");
					txtNome.setText("");
					txtTelefone.setText("");
					txtbuscaCpf.setText("");
					Plataforma.verificatela=0;
					dispose();
					
				}
				
			}//fim actionPrformed
		}//fim ActionListenr
		
		Eventos acao = new Eventos();
		btCancelar.addActionListener(acao);
		btBuscar.addActionListener(acao);
		btExcluir.addActionListener(acao);
		
	}// fim construtor

}
