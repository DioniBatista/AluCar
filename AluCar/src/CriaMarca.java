import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class CriaMarca extends JInternalFrame
{
	public CriaMarca()
	{
		super("Criar nova marca",false,false,false,false);
		setBounds(200,100,400,300);
		setVisible(true);
		setLayout(null);
		
		JLabel lblMarca = new JLabel("Nova marca: ");
		final JTextField txtMarca = new JTextField();
		final JButton btSalvar = new JButton("Salvar");
		final JButton btCancelar = new JButton("Cancelar");
		
		lblMarca.setBounds(70,70,100,20);
		add(lblMarca);
		txtMarca.setBounds(170,70,150,20);
		add(txtMarca);
		
		btSalvar.setBounds(100,150,100,30);
		add(btSalvar);
		btCancelar.setBounds(230,150,100,30);
		add(btCancelar);
		
		class Eventos implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == btCancelar)
				{
					Plataforma.verificatela=0;
					dispose();
				}
				if(e.getSource() == btSalvar)
				{
					try
					{
						Conexao conecta=new Conexao();					
						Connection conn=conecta.obtemConexao();	
					Marca m=new Marca(txtMarca.getText().toUpperCase());
					m.inserirMarca(conn);
					JOptionPane.showMessageDialog(null, "Marca criada com sucesso!");
					txtMarca.setText("");
					Plataforma.verificatela=0;
					dispose();
					//conn.close(); comentei dia 04-07
				}
				catch(Exception E)
				{
					
					JOptionPane.showMessageDialog(null, "Erro ao inserir");
				}		 
				}
			}//fim actionPermed
		}//fim actionListener
		Eventos acao = new Eventos();
		btCancelar.addActionListener(acao);
		btSalvar.addActionListener(acao);
	}

}
