import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class CadastraCliente extends JInternalFrame
{
	public CadastraCliente() 
	{
		
		/*JInternalFrame cadastraCliente= new JInternalFrame("Cadastro de Cliente",false,false,false,false);
		cadastraCliente.setBounds(0,0,800,600);
		cadastraCliente.setLayout(null);
		cadastraCliente.setVisible(true);*/
		super("Cadastro de Cliente",false,false,false,false);
		setBounds(0,0,800,600);
		setLayout(null);
		setVisible(true); 
		
		JLabel lblNome = new JLabel("Nome: ");
		JLabel lblCpf = new JLabel("CPF: ");
		JLabel lblRg = new JLabel("RG: ");
		JLabel lblTelefone = new JLabel("Telefone fixo: ");
		JLabel lblCelular = new JLabel("Celular: ");
		JLabel lblSexo = new JLabel("Sexo: ");
		JLabel lblEmail = new JLabel("E-mail: ");
		JLabel lblObservacoes = new JLabel("Observações: ");
		JLabel lblData = new JLabel("Data de Nascimento: ");
		JLabel lblEstado = new JLabel("Estado: ");
		JLabel lblBairro = new JLabel("Bairro: ");
		JLabel lblRua = new JLabel("Rua: ");
		JLabel lblCidade = new JLabel("Cidade: ");
		JLabel lblNumero = new JLabel("Número: ");
		JLabel lblCep = new JLabel("CEP: ");
		JLabel lblUtilidade = new JLabel("Utilizará o veículo em: ");
		
		final JTextField txtNome = new JTextField();
		final JFormattedTextField txtCpf = new JFormattedTextField();
		final JTextField txtRg = new JTextField();
		final JFormattedTextField txtTelefone = new JFormattedTextField();
		final JFormattedTextField txtCelular = new JFormattedTextField();
		final JRadioButton feminino = new JRadioButton("Feminino");
		final JRadioButton masculino = new JRadioButton("Masculino");
		final JTextField txtEmail = new JTextField();
		final JTextArea txtObservacoes = new JTextArea();
		final JFormattedTextField txtData = new JFormattedTextField();
		final JTextField txtEstado = new JTextField();
		final JTextField txtBairro = new JTextField();
		final JTextField txtRua = new JTextField();
		final JTextField txtCidade = new JTextField();
		final JTextField txtNumero = new JTextField();
		final JFormattedTextField txtCep = new JFormattedTextField();
		
		final JCheckBox chkLazer = new JCheckBox("Lazer");
		final JCheckBox chkTrabalho = new JCheckBox("Trabalho");
		final JCheckBox chkViajem = new JCheckBox("Viajem");
		
		final JButton btSalvar = new JButton("Salvar");
		final JButton btCancelar = new JButton("Cancelar");
		
		//COLOCAR MASCARA
		try
		{
			MaskFormatter cpf = new MaskFormatter("###.###.###-##");
			MaskFormatter data = new MaskFormatter("##/##/####");
			MaskFormatter telefone = new MaskFormatter("(##) ####-####");
			MaskFormatter celular = new MaskFormatter("(##) ####-####");
			MaskFormatter cep = new MaskFormatter("#####-###");
			cpf.install(txtCpf);
			data.install(txtData);
			telefone.install(txtTelefone);
			celular.install(txtCelular);
			cep.install(txtCep);
		}
		catch(Exception e)
		{
			//nao precisa preeccher
		}
		
		lblNome.setBounds(50,20,50,20);
		add(lblNome);
		txtNome.setBounds(100,20,300,20);
		add(txtNome);
		
		lblSexo.setBounds(500,20,50,20);
		add(lblSexo);
		ButtonGroup grupo = new ButtonGroup();
		feminino.setBounds(560,20,90,20);
		add(feminino);
		masculino.setBounds(560,50,90,20);
		add(masculino);
		grupo.add(feminino);
		grupo.add(masculino);
		
		lblData.setBounds(50,50,150,20);
		add(lblData);
		txtData.setBounds(200,50,100,20);
		add(txtData);
		
		lblCpf.setBounds(50,80,50,20);
		add(lblCpf);
		txtCpf.setBounds(100,80,125,20);
		add(txtCpf);
		
		lblRg.setBounds(245,80,50,20);
		add(lblRg);
		txtRg.setBounds(275,80,125,20);
		add(txtRg);
		
		lblUtilidade.setBounds(500,80,200,20);
		add(lblUtilidade);
		//checkbox
		chkLazer.setBounds(560,110,200,20);
		add(chkLazer);
		chkTrabalho.setBounds(560,140,200,20);
		add(chkTrabalho);
		chkViajem.setBounds(560,170,200,20);
		add(chkViajem);
		
		lblTelefone.setBounds(50,110,100,20);
		add(lblTelefone);
		txtTelefone.setBounds(140,110,100,20);
		add(txtTelefone);

		lblCelular.setBounds(250,110,50,20);
		add(lblCelular);
		txtCelular.setBounds(300,110,100,20);
		add(txtCelular);
		
		lblEstado.setBounds(50,140,50,20);
		add(lblEstado);
		txtEstado.setBounds(100,140,100,20);
		add(txtEstado);
		
		lblCidade.setBounds(210,140,50,20);
		add(lblCidade);
		txtCidade.setBounds(260,140,140,20);
		add(txtCidade);
		
		lblCep.setBounds(50,170,50,20);
		add(lblCep);
		txtCep.setBounds(100,170,100,20);
		add(txtCep);
		
		lblRua.setBounds(210,170,50,20);
		add(lblRua);
		txtRua.setBounds(260,170,140,20);
		add(txtRua);

		lblNumero.setBounds(50,200,70,20);
		add(lblNumero);
		txtNumero.setBounds(120,200,50,20);
		add(txtNumero);
		
		lblBairro.setBounds(190,200,70,20);
		add(lblBairro);
		txtBairro.setBounds(260,200,140,20);
		add(txtBairro);
		
		lblEmail.setBounds(50,230,50,20);
		add(lblEmail);
		txtEmail.setBounds(100,230,300,20);
		add(txtEmail);
		
		lblObservacoes.setBounds(50,290,100,20);
		add(lblObservacoes);
		txtObservacoes.setBounds(150,320,400,100);
		add(txtObservacoes);
		
		btSalvar.setBounds(450,450,100,30);
		add(btSalvar);
		
		btCancelar.setBounds(570,450,100,30);
		add(btCancelar);
		
		class Acoes implements ActionListener
		{
			String sexo;
			String utilidades;
			public void actionPerformed(ActionEvent e)
			{
				if(feminino.isSelected())
				{
					sexo = "feminino";
				}
				if(masculino.isSelected())
				{
					sexo = "masculino";
				}
				if(chkLazer.isSelected())
				{
					utilidades = " Lazer--";
				}
				 if(chkTrabalho.isSelected())
				{
					utilidades += " Trabalho--";
				}
				if(chkViajem.isSelected())
				{
					utilidades += "Viajem--";
				}
				if(e.getSource() == btSalvar)
				{
						
					try
					{
						
						Conexao conecta=new Conexao();					
						Connection conn=conecta.obtemConexao();	
						if(txtNome.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Por favor digite o nome!");
						}
						else if(txtData.getText().contains(" "))
						{
							JOptionPane.showMessageDialog(null, "Data de nascimento inválida!");
						}
						
						else if(txtCpf.getText().contains(" "))
						{
							JOptionPane.showMessageDialog(null, "CPF inválido!");
						}
						else if(txtRg.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Por favor digite o RG!");
						}
						
						else
						{
							Cliente c=new Cliente(txtNome.getText(),sexo, txtData.getText(),txtCpf.getText(),txtRg.getText(),txtTelefone.getText(),txtCelular.getText(),txtEstado.getText(),txtCidade.getText(),txtCep.getText(),txtRua.getText(),txtNumero.getText(),txtBairro.getText(),txtEmail.getText(),utilidades,txtObservacoes.getText());
							//Cliente c = new Cliente("",sexo,"",Integer.parseInt(txtCpf.getText()),"","","","","","","","","","",utilidades,"");
							c.inserirCliente(conn);
							JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso!");
							txtNome.setText("");
							txtData.setText("");
							txtCpf.setText("");
							txtRg.setText("");							
							txtTelefone.setText("");
							txtCelular.setText("");
							txtEstado.setText("");
							txtCidade.setText("");
							txtCep.setText("");
							txtRua.setText("");
							txtNumero.setText("");
							txtBairro.setText("");
							txtEmail.setText("");
							txtObservacoes.setText("");
							Plataforma.verificatela=0;
							dispose();
						}
					}
						catch(Exception E)
						{
					
							JOptionPane.showMessageDialog(null, "Erro ao inserir");
						}
					}
				
				
				if(e.getSource() == btCancelar)
				{
					txtNome.setText("");
					txtData.setText("");
					txtCpf.setText("");
					txtRg.setText("");
					txtTelefone.setText("");
					txtCelular.setText("");
					txtEstado.setText("");
					txtCidade.setText("");
					txtCep.setText("");
					txtRua.setText("");
					txtNumero.setText("");
					txtBairro.setText("");
					txtEmail.setText("");
					txtObservacoes.setText("");
					Plataforma.verificatela=0;				
					dispose();
				}
			}//fim actionPerformed
		}//fim ActonListener
		Acoes acao = new Acoes();
		btCancelar.addActionListener(acao);
		btSalvar.addActionListener(acao);
		feminino.addActionListener(acao);
		masculino.addActionListener(acao);
		chkLazer.addActionListener(acao);
		chkTrabalho.addActionListener(acao);
		chkViajem.addActionListener(acao);
	}//fim construtor
	
	
}
