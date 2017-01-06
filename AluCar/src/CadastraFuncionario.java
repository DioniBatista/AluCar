import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class CadastraFuncionario extends JInternalFrame
{
	public CadastraFuncionario()
	{
		super("Cadastro de Usuário",false,false,false,false);
		setBounds(200,100,400,300);
		setVisible(true);
		setLayout(null);
		
		
		JLabel lblNome = new JLabel("Nome do usuário: ");
		JLabel lblSenha = new JLabel("Senha do usuário: ");
		JLabel lblCargo = new JLabel("Cargo: ");

		final JTextField txtNome = new JTextField();
		final JPasswordField txtSenha = new JPasswordField();
		final JComboBox comboCargo = new JComboBox();
		comboCargo.addItem("Selecione o cargo");
		comboCargo.addItem("Funcionário");
		comboCargo.addItem("Gerente");
		final JButton btSalvar = new JButton("Salvar");
		final JButton btCancelar = new JButton("Cancelar");
		
		comboCargo.setEditable(false);//nao permite editar as combobox
		comboCargo.setSelectedIndex(0);//mostrar a posicao zero da combo
		
		lblNome.setBounds(50,50,200,20);
		add(lblNome);
		txtNome.setBounds(165,50,200,20);
		add(txtNome);
		
		lblSenha.setBounds(50,80,200,20);
		add(lblSenha);
		txtSenha.setBounds(165,80,200,20);
		add(txtSenha);
		
		lblCargo.setBounds(50,110,50,20);
		add(lblCargo);
		comboCargo.setBounds(100,110,200,20);
		add(comboCargo);
		
		btSalvar.setBounds(100,200,100,30);
		add(btSalvar);
		
		btCancelar.setBounds(230,200,100,30);
		add(btCancelar);
		
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
					
					Funcionarios f=new Funcionarios(txtNome.getText(),new String(txtSenha.getPassword()),comboCargo.getSelectedItem().toString());
					f.inserirFuncionarios(conn);
					JOptionPane.showMessageDialog(null, "Funcionário cadastrado com Sucesso!!");
					txtNome.setText("");
					txtSenha.setText("");
					comboCargo.setSelectedIndex(0);					
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
					txtNome.setText("");
					txtSenha.setText("");
					comboCargo.setSelectedIndex(0);
					Plataforma.verificatela=0;
					dispose();
				}
			}//fim actionPerformed
		}//fim ActionListener
		
		Eventos acao= new Eventos();
		btCancelar.addActionListener(acao);
		btSalvar.addActionListener(acao);
		
	}//fim construtor

}
