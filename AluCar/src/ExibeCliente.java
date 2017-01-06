import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ExibeCliente extends JInternalFrame{

	private String [] colunas = new String []{"Nome","Cpf","Sexo","Data Nascimento","RG","Telefone","Celular","Estado","Cidade","Cep","Rua","Numero","Bairro","Email"};	  
	private DefaultTableModel modelo = new DefaultTableModel(colunas,0);	  
	private JTable tabela = new JTable( modelo );
	private JScrollPane rolagem=new JScrollPane();
	
	public  ExibeCliente()
	{
		
		super("Clientes",false,false,false,false);
		final JButton btVoltar = new JButton("Voltar");
		final JButton btAtualiza = new JButton("Atualizar");
		rolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(8).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(9).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(10).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(11).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(12).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(13).setPreferredWidth(200);
		
		
		tabela.setBounds(10,10,1000,500);
		rolagem.setBounds(30,70, 700, 400);		
		rolagem.setViewportView(tabela);
		add(rolagem);
		
		btAtualiza.setBounds(600,10,120,20);
		add(btAtualiza);
		btVoltar.setBounds(600,480,120,20);
		add(btVoltar);		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBounds(0,0,800,600);
		setVisible(true);
		setResizable(false);
		
		class Acoes implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()== btAtualiza)
				{
					try
					{
						Conexao conecta=new Conexao();
						Connection conn=conecta.obtemConexao();
						Cliente c=new Cliente();
						ResultSet resultado=c.exibirCliente(conn);
						if(resultado.first())
						{	modelo.setNumRows(0);//zera a tabela
						
							tabela.setModel(modelo);
							
							do{
								String [] dados=new String[]{resultado.getString(3),resultado.getString(2),resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7),resultado.getString(8),resultado.getString(9),resultado.getString(10),resultado.getString(11),resultado.getString(12),resultado.getString(13),resultado.getString(14)};		
								modelo.addRow(dados);
								
							}while(resultado.next());
						}//fim if
						else
						{				
							JOptionPane.showMessageDialog(null, "Não existem registros");				
						}	
					}//fim try
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,"Erro no acesso e listagem dos dados do B.D.");//impressão do erro do banco de dados
					}
				}
				if(e.getSource() == btVoltar)
				{
					Plataforma.verificatela=0;
					dispose();
				}
			}//fim performed
		}//fim action Listener
		Acoes acao = new Acoes();
		btAtualiza.addActionListener(acao);
		btVoltar.addActionListener(acao);
	}
	
	
}
