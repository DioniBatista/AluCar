import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;



public class EditaCliente extends JInternalFrame
{
	public EditaCliente()
	{
		super("Editar Cliente",false,false,false,false);
		setBounds(0,0,800,600);
		setVisible(true);
		setLayout(null);
		
		JLabel lblbuscaCpf = new JLabel("CPF: ");
		
		final JFormattedTextField txtbuscaCpf = new JFormattedTextField();
		
		final JButton btBuscar = new JButton("Buscar");
		
		/*try
		{
			MaskFormatter cpf = new MaskFormatter("###.###.###-##");
			cpf.install(txtbuscaCpf);
		}
		catch(Exception e)
		{
			
		}*/
		
		lblbuscaCpf.setBounds(200,25,50,20);
		add(lblbuscaCpf);
		txtbuscaCpf.setBounds(250,25,150,20);
		add(txtbuscaCpf);
		
		btBuscar.setBounds(430,25,100,20);
		add(btBuscar);
		////////////////////////////////////
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
		final JLabel lblCodigo = new JLabel("Cod:");
		final JTextField txtCodigo = new JTextField();
		
		final JCheckBox chkLazer = new JCheckBox("Lazer");
		final JCheckBox chkTrabalho = new JCheckBox("Trabalho");
		final JCheckBox chkViajem = new JCheckBox("Viajem");
		
		final JButton btSalvar = new JButton("Salvar alterações");
		final JButton btCancelar = new JButton("Cancelar");
		final JButton btLimpar = new JButton("Limpar");
		
		//COLOCAR MASCARA
		try
		{
			MaskFormatter cpf = new MaskFormatter("###.###.###-##");
			MaskFormatter data = new MaskFormatter("##/##/####");
			MaskFormatter telefone = new MaskFormatter("(##) ####-####");
			MaskFormatter celular = new MaskFormatter("(##) ####-####");
			MaskFormatter cep = new MaskFormatter("#####-###");
			cpf.install(txtCpf);
			cpf.install(txtbuscaCpf);
			data.install(txtData);
			telefone.install(txtTelefone);
			celular.install(txtCelular);
			cep.install(txtCep);
		}
		catch(Exception e)
		{
			//nao precisa preeccher
		}
		
		lblNome.setBounds(50,70,50,20);
		add(lblNome);
		txtNome.setBounds(100,70,300,20);
		add(txtNome);
		
		lblSexo.setBounds(500,70,50,20);
		add(lblSexo);
		ButtonGroup grupo = new ButtonGroup();
		feminino.setBounds(560,70,90,20);
		add(feminino);
		masculino.setBounds(560,100,90,20);
		add(masculino);
		grupo.add(feminino);
		grupo.add(masculino);
		
		lblData.setBounds(50,100,150,20);
		add(lblData);
		txtData.setBounds(200,100,100,20);
		add(txtData);
		
		lblCpf.setBounds(50,130,50,20);
		add(lblCpf);
		txtCpf.setBounds(100,130,125,20);
		txtCpf.setEditable(false);
		add(txtCpf);
		
		
		lblRg.setBounds(245,130,50,20);
		add(lblRg);
		txtRg.setBounds(275,130,125,20);
		add(txtRg);
		
		lblUtilidade.setBounds(500,130,200,20);
		add(lblUtilidade);
		//checkbox
		chkLazer.setBounds(560,160,200,20);
		add(chkLazer);
		chkTrabalho.setBounds(560,190,200,20);
		add(chkTrabalho);
		chkViajem.setBounds(560,220,200,20);
		add(chkViajem);
		
		lblTelefone.setBounds(50,160,100,20);
		add(lblTelefone);
		txtTelefone.setBounds(140,160,100,20);
		add(txtTelefone);

		lblCelular.setBounds(250,160,50,20);
		add(lblCelular);
		txtCelular.setBounds(300,160,100,20);
		add(txtCelular);
		
		lblEstado.setBounds(50,190,50,20);
		add(lblEstado);
		txtEstado.setBounds(100,190,100,20);
		add(txtEstado);
		
		lblCidade.setBounds(210,190,50,20);
		add(lblCidade);
		txtCidade.setBounds(260,190,140,20);
		add(txtCidade);
		
		lblCep.setBounds(50,220,50,20);
		add(lblCep);
		txtCep.setBounds(100,220,100,20);
		add(txtCep);
		
		lblRua.setBounds(210,220,50,20);
		add(lblRua);
		txtRua.setBounds(260,220,140,20);
		add(txtRua);

		lblNumero.setBounds(50,250,70,20);
		add(lblNumero);
		txtNumero.setBounds(120,250,50,20);
		add(txtNumero);
		
		lblBairro.setBounds(190,250,70,20);
		add(lblBairro);
		txtBairro.setBounds(260,250,140,20);
		add(txtBairro);
		
		lblEmail.setBounds(50,280,50,20);
		add(lblEmail);
		txtEmail.setBounds(100,280,300,20);
		add(txtEmail);
		
		lblObservacoes.setBounds(50,340,100,20);
		add(lblObservacoes);
		txtObservacoes.setBounds(150,370,400,100);
		add(txtObservacoes);
		
		btSalvar.setBounds(350,480,170,30);
		add(btSalvar);
		btLimpar.setBounds(540,480,110,30);
		add(btLimpar);
		btCancelar.setBounds(680,480,100,30);
		add(btCancelar);
		
		class Acoes implements ActionListener
		{
			String sexo;
			String utilidades;
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == btLimpar)
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
					txtbuscaCpf.setText("");
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
					txtbuscaCpf.setText("");
					Plataforma.verificatela=0;
					dispose();
				}
				if(e.getSource() == btBuscar)
				{
					try
					{
						String masc;
						String femin;
						String util;
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						String cpf=txtbuscaCpf.getText();
						Cliente c=new Cliente();
						ResultSet resultado=c.pesquisarCliente(conn, cpf);
						if(resultado.first())
						{
							do{
								masc = resultado.getString(4);
								femin = resultado.getString(4);
								util = resultado.getString(16);
								if(masc.equals("masculino"))
								{
									masculino.setSelected(true);
								}
								if(femin.equals("feminino"))
								{
									feminino.isSelected();
								}
								if(util.contains("Lazer"))
								{
									chkLazer.setSelected(true);
								}
								if(util.contains("Trabalho"))
								{
									chkTrabalho.setSelected(true);
								}
								if(util.contains("Viajem"))
								{
									chkViajem.setSelected(true);
								}
								//txtCodigo.setText(resultado.getString(1));
								txtCpf.setText(resultado.getString(2));			
								txtNome.setText(resultado.getString(3));
								txtData.setText(resultado.getString(5));
								txtRg.setText(resultado.getString(6));
								txtTelefone.setText(resultado.getString(7));
								txtCelular.setText(resultado.getString(8));
								txtEstado.setText(resultado.getString(9));
								txtCidade.setText(resultado.getString(10));
								txtCep.setText(resultado.getString(11));
								txtRua.setText(resultado.getString(12));
								txtNumero.setText(resultado.getString(13));
								txtBairro.setText(resultado.getString(14));
								txtEmail.setText(resultado.getString(15));
								//txtUtilidades.setText(resultado.getString(16));
								txtObservacoes.setText(resultado.getString(17));
								
							}while(resultado.next());
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Dados não encontrados, procure outro nome");
						}
					}//fim try
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
						if(e.getSource() == btSalvar)
						{
								
							try
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
								if(chkViajem.isSelected())
								{
									utilidades += "Viajem--";
								}
								 if(chkTrabalho.isSelected())
								{
									utilidades += " Trabalho--";
								}
								
								
								
								
									Cliente cl=new Cliente();
								cl.editaCliente(txtNome.getText(),sexo, txtData.getText(),txtCpf.getText(),txtRg.getText(),txtTelefone.getText(),txtCelular.getText(),txtEstado.getText(),txtCidade.getText(),txtCep.getText(),txtRua.getText(),txtNumero.getText(),txtBairro.getText(),txtEmail.getText(),utilidades,txtObservacoes.getText());
									JOptionPane.showMessageDialog(null, "Cliente alterados com Sucesso");
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
									txtbuscaCpf.setText("");
									Plataforma.verificatela=0;
									dispose();
								
							}//fim try
								catch(Exception E)
								{
							
									JOptionPane.showMessageDialog(null, "Erro ao Editar");
								}
						}
				
			}//fim actionPerformed
		}//fim ActonListener
		Acoes acao = new Acoes();
		btCancelar.addActionListener(acao);
		btBuscar.addActionListener(acao);
		btSalvar.addActionListener(acao);
		btLimpar.addActionListener(acao);
		
		
	}//fim construtor
	
}
