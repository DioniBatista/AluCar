import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
public class EditaFuncionario extends JInternalFrame
{
	public EditaFuncionario()
	{
		super("Editar Funcionário",false,false,false,false);
		setBounds(0,0,800,600);
		setVisible(true);
		setLayout(null);
		
		JLabel lblbuscaNome = new JLabel("Nome: ");
		
		final JTextField txtbuscaNome = new JTextField();
		
		final JButton btBuscar = new JButton("Buscar");
		
		lblbuscaNome.setBounds(200,25,50,20);
		add(lblbuscaNome);
		txtbuscaNome.setBounds(250,25,200,20);
		add(txtbuscaNome);
		
		btBuscar.setBounds(480,25,100,20);
		add(btBuscar);
		
		////////
		JLabel lblNome = new JLabel("Nome do usuário: ");
		JLabel lblSenha = new JLabel("Senha do usuário: ");
		JLabel lblCargo = new JLabel("Novo Cargo: ");
		JLabel lblCargosel = new JLabel("Cargo: ");
		final JTextField txtNome = new JTextField();
		final JPasswordField txtSenha = new JPasswordField();
		final JTextField txtCargosel = new JTextField();
		final JComboBox comboCargo = new JComboBox();
		comboCargo.addItem("Funcionário");
		comboCargo.addItem("Gerente");
		final JButton btSalvar = new JButton("Salvar alterações");
		final JButton btLimpar = new JButton("Limpar");
		final JButton btCancelar = new JButton("Cancelar");
		
		comboCargo.setEditable(false);//nao permite editar as combobox
		comboCargo.setSelectedIndex(0);//mostrar a posicao zero da combo
		
		lblNome.setBounds(100,100,200,20);
		add(lblNome);
		txtNome.setBounds(215,100,200,20);
		add(txtNome);
		
		lblSenha.setBounds(100,130,200,20);
		add(lblSenha);
		txtSenha.setBounds(215,130,200,20);
		add(txtSenha);
		
		lblCargosel.setBounds(100,160,50,20);
		add(lblCargosel);
		txtCargosel.setBounds(160,160,100,20);
		txtCargosel.setEnabled(false);
		add(txtCargosel);
		
		lblCargo.setBounds(100,190,100,20);
		add(lblCargo);
		comboCargo.setBounds(180,190,200,20);
		add(comboCargo);
		
		
		
		btSalvar.setBounds(150,250,150,30);
		add(btSalvar);
		
		btLimpar.setBounds(320,250,100,30);
		add(btLimpar);
		
		btCancelar.setBounds(440,250,100,30);
		add(btCancelar);
		
		class Eventos implements ActionListener
		{
			String codigo;
			public void actionPerformed(ActionEvent e)
			{
				
				if(e.getSource() == btBuscar)
				{
					try
					{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						String nome=txtbuscaNome.getText();
					
						Funcionarios f=new Funcionarios();
						ResultSet resultado=f.pesquisarFuncionario(conn, nome);
						if(resultado.first())
						{
							do{
								
								codigo = resultado.getString(1);
								txtNome.setText(resultado.getString(2));
								txtSenha.setText(resultado.getString(3));
								txtCargosel.setText(resultado.getString(4));
							}
							while(resultado.next());
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Dados não encontrados, procure outro nome");
						}
					}
					catch(Exception ex)
					{
						
					}
				}
				if(e.getSource() == btSalvar)
				{
					Funcionarios f = new Funcionarios();
					f.editaFuncionarios(codigo,txtNome.getText(),txtSenha.getText(),comboCargo.getSelectedItem().toString());
						JOptionPane.showMessageDialog(null, "Funcionario alterado com Sucesso");
						txtbuscaNome.setText("");
						txtNome.setText("");
						txtSenha.setText("");
						txtCargosel.setText("");
						comboCargo.setSelectedIndex(0);
						Plataforma.verificatela=0;
						dispose();
				}
				if(e.getSource() == btCancelar)
				{
					txtbuscaNome.setText("");
					txtNome.setText("");
					txtSenha.setText("");
					txtCargosel.setText("");
					comboCargo.setSelectedIndex(0);
					Plataforma.verificatela=0;
					dispose();
				}
				if(e.getSource() == btLimpar)
				{
					txtbuscaNome.setText("");
					txtNome.setText("");
					txtSenha.setText("");
					txtCargosel.setText("");
					comboCargo.setSelectedIndex(0);
				}
			}//fim actionPerformed
		}//fim ActionListener
		
		Eventos acao= new Eventos();
		btCancelar.addActionListener(acao);
		btSalvar.addActionListener(acao);
		btLimpar.addActionListener(acao);
		btBuscar.addActionListener(acao);
	}

}
