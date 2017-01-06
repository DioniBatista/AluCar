import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ExibeFuncionario extends JInternalFrame{

	private String [] colunas = new String []{"Nome","Cargo"};	  
	private DefaultTableModel modelo = new DefaultTableModel(colunas,0);	  
	private JTable tabela = new JTable( modelo );
	private JScrollPane rolagem=new JScrollPane();
	
	public  ExibeFuncionario()
	{
		
		super("Funcionários",false,false,false,false);
		final JButton btVoltar = new JButton("Voltar");
		final JButton btAtualiza = new JButton("Atualizar");
		//rolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
		
		tabela.setBounds(10,10,304,300);
		rolagem.setBounds(170, 50, 304, 300);		
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
						Funcionarios c=new Funcionarios();
						ResultSet resultado=c.exibirFuncionario(conn);
						if(resultado.first())
						{	modelo.setNumRows(0);//zera a tabela
							tabela.setModel(modelo);
							
							do{
								String [] dados=new String[]{resultado.getString(2),resultado.getString(4)};		
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