import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
public class Plataforma
{
	String cargo;
	String nomelogin;
	
	public static int verificatela = 0;
	public Plataforma(String cargo, String nomelogin)
	{
		
		this.cargo = cargo;
		this.nomelogin = nomelogin;
		if(cargo.equals("Gerente"))
		{
		final JFrame plataforma = new JFrame("AluCar Veículos");
		plataforma.setSize(800,600);
		plataforma.setLayout(null);
		plataforma.setVisible(true);
		plataforma.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//desabilita o X
		//plataforma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fechar tudo temporario
		plataforma.setResizable(false);//proibe modificar o tamanho com o mouse
		plataforma.setLocationRelativeTo(null);//colocar no centro
		
		
		final JDesktopPane area = new JDesktopPane();
		area.setBounds(0,0,800,600);
		area.setLayout(null);
		plataforma.add(area);
		final JLabel recebelogo = new JLabel();
		
		//BEM VINDO
		JLabel bemvindo = new JLabel("Bem vindo, "+nomelogin);
		bemvindo.setBounds(50,50,500,20);
		area.add(bemvindo);
		
		
		//menu
		JMenuBar menu = new JMenuBar();
		JMenu menuCadastro = new JMenu("Cadastro");
		JMenu menuEditar = new JMenu("Editar");
		JMenu menuExcluir = new JMenu("Excluir");
		JMenu menuLocacoes = new JMenu("Locações");
		JMenu menuInovacoes = new JMenu("Inovações");
		JMenu menuRelatorios = new JMenu("Relatórios");
		final JMenu menuAbout = new JMenu("Sobre");
		final JMenu menuSair = new JMenu("Sair");
		
		final JMenuItem itemaddCliente = new JMenuItem("Cliente");
		final JMenuItem itemaddFuncionario = new JMenuItem("Funcionário");
		final JMenuItem itemaddVeiculo = new JMenuItem("Veículo");
		final JMenuItem itemeditCliente = new JMenuItem("Cliente");
		final JMenuItem itemeditFuncionario = new JMenuItem("Funcionário");
		final JMenuItem itemeditVeiculo = new JMenuItem("Veículo");
		final JMenuItem itemexcluirCliente = new JMenuItem("Cliente");
		final JMenuItem itemexcluirFuncionario = new JMenuItem("Funcionário");
		final JMenuItem itemexcluirVeiculo = new JMenuItem("Veículo");
		final JMenuItem itemAlugar = new JMenuItem("Alugar");
		final JMenuItem itemeditAlugar = new JMenuItem("Editar");
		final JMenuItem itemexcluirAlugar = new JMenuItem("Excluir");
		final JMenuItem itemaddMarca = new JMenuItem("Nova Marca");
		final JMenuItem itemaddModelo = new JMenuItem("Novo Modelo");
		final JMenuItem itemaddCor = new JMenuItem("Nova cor");		
		final JMenuItem itemlistaCliente = new JMenuItem("Clientes");
		final JMenuItem itemlistaFuncionario = new JMenuItem("Funcionários");
		final JMenuItem itemlistaVeiculo = new JMenuItem("Veículos");
		final JMenuItem itemlistaLocacoes = new JMenuItem("Locações");		
		final JMenuItem itemSair = new JMenuItem("Desconectar");
		final JMenuItem itemAbout = new JMenuItem("About");
		menuCadastro.add(itemaddCliente);
		menuCadastro.add(itemaddFuncionario);
		menuCadastro.add(itemaddVeiculo);
		
		menuEditar.add(itemeditCliente);
		menuEditar.add(itemeditFuncionario);
		menuEditar.add(itemeditVeiculo);
		
		menuExcluir.add(itemexcluirCliente);
		menuExcluir.add(itemexcluirFuncionario);
		menuExcluir.add(itemexcluirVeiculo);
		
		menuLocacoes.add(itemAlugar);
		menuLocacoes.add(itemeditAlugar);
		menuLocacoes.add(itemexcluirAlugar);
		
		menuInovacoes.add(itemaddMarca);
		menuInovacoes.add(itemaddModelo);
		menuInovacoes.add(itemaddCor);
		
		menuRelatorios.add(itemlistaCliente);
		menuRelatorios.add(itemlistaFuncionario);
		menuRelatorios.add(itemlistaVeiculo);
		menuRelatorios.add(itemlistaLocacoes);		
		
		menuAbout.add(itemAbout);
		
		menuSair.add(itemSair);
		
		menu.add(menuCadastro);
		menu.add(menuEditar);
		menu.add(menuExcluir);
		menu.add(menuLocacoes);
		menu.add(menuInovacoes);
		menu.add(menuRelatorios);
		menu.add(menuAbout);
		menu.add(menuSair);
		
		//adiciona menu na plataforma
		plataforma.setJMenuBar(menu);

		Icon teste = new ImageIcon("imagens/logoopaco.png");
		recebelogo.setIcon(teste);
		recebelogo.setBounds(70,200,640,321);
		area.add(recebelogo);
		
		final CadastraCliente cadastraCliente = new CadastraCliente();
		final CadastraFuncionario cadastraFuncionario = new CadastraFuncionario();
		final CadastraVeiculo cadastraVeiculo = new CadastraVeiculo();
		final EditaCliente editaCliente = new EditaCliente();
		final EditaFuncionario editaFuncionario = new EditaFuncionario();
		final EditaVeiculo editaVeiculo = new EditaVeiculo();
		final ExcluiCliente excluiCliente = new ExcluiCliente();
		final ExcluiFuncionario excluiFuncionario = new ExcluiFuncionario();
		final ExcluiVeiculo excluiVeiculo = new ExcluiVeiculo();
		final CriaLocacao criaLocacao = new CriaLocacao();
		final EditaLocacao editaLocacao = new EditaLocacao();
		final ExcluiLocacao excluiLocacao = new ExcluiLocacao();
		final CriaMarca criaMarca = new CriaMarca();
		final CriaModelo criaModelo = new CriaModelo();
		final CriaCor criaCor = new CriaCor();
		final ExibeCliente  exibeCliente = new ExibeCliente();
		final ExibeFuncionario exibeFuncionario=new ExibeFuncionario();
		final ExibeVeiculos exibeVeiculos = new ExibeVeiculos();
		final ExibeLocacao exibeLocacao = new ExibeLocacao();
		final About about = new About();
		
		

		class Eventos implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
				
				
				if(e.getSource() == itemaddCliente)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
						
					area.remove(cadastraCliente);
					area.add(cadastraCliente);	
					cadastraCliente.show();
					area.moveToFront(cadastraCliente);
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					criaCor.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemaddFuncionario)
				{	
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(cadastraFuncionario);
					area.add(cadastraFuncionario);
					cadastraFuncionario.show();
					area.moveToFront(cadastraFuncionario);
					cadastraCliente.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					criaCor.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemaddVeiculo)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(cadastraVeiculo);
					area.add(cadastraVeiculo);
					cadastraVeiculo.show();
					area.moveToFront(cadastraVeiculo);
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					criaCor.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemeditCliente)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(editaCliente);
					area.add(editaCliente);
					editaCliente.show();
					area.moveToFront(editaCliente);
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					criaCor.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemeditFuncionario)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(editaFuncionario);
					area.add(editaFuncionario);
					editaFuncionario.show();
					area.moveToFront(editaFuncionario);
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					criaCor.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemeditVeiculo)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(editaVeiculo);
					area.add(editaVeiculo);
					editaVeiculo.show();
					area.moveToFront(editaVeiculo);
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					criaCor.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemexcluirCliente)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(excluiCliente);
					area.add(excluiCliente);
					excluiCliente.show();
					area.moveToFront(excluiCliente);
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					criaCor.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemexcluirFuncionario)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(excluiFuncionario);
					area.add(excluiFuncionario);
					excluiFuncionario.show();
					area.moveToFront(excluiFuncionario);
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					criaCor.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemexcluirVeiculo)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(excluiVeiculo);
					area.add(excluiVeiculo);
					excluiVeiculo.show();
					area.moveToFront(excluiVeiculo);
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					criaCor.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemAlugar)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(criaLocacao);
					area.add(criaLocacao);
					criaLocacao.show();
					area.moveToFront(criaLocacao);
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					criaCor.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemeditAlugar)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(editaLocacao);
					area.add(editaLocacao);
					editaLocacao.show();	
					area.moveToFront(editaLocacao);
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					criaCor.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemexcluirAlugar)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(excluiLocacao);
					area.add(excluiLocacao);
					excluiLocacao.show();
					area.moveToFront(excluiLocacao);
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					criaCor.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemaddMarca)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(criaMarca);
					area.add(criaMarca);
					criaMarca.show();
					area.moveToFront(criaMarca);
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaModelo.dispose();
					criaCor.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource()== itemaddModelo)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(criaModelo);
					area.add(criaModelo);
					criaModelo.show();
					area.moveToFront(criaModelo);
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaCor.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemaddCor)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(criaCor);
					area.add(criaCor);
					criaCor.show();
					area.moveToFront(criaCor);
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					exibeCliente.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemlistaCliente)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(exibeCliente);
					area.add(exibeCliente);
					exibeCliente.show();
					area.moveToFront(exibeCliente);
					criaCor.dispose();
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					excluiLocacao.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemlistaFuncionario)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(exibeFuncionario);
					area.add(exibeFuncionario);
					exibeFuncionario.show();
					area.moveToFront(exibeFuncionario);
					criaCor.dispose();
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					excluiLocacao.dispose();
					exibeCliente.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemlistaVeiculo)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(exibeVeiculos);
					area.add(exibeVeiculos);
					exibeVeiculos.show();
					area.moveToFront(exibeVeiculos);
					criaCor.dispose();
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					excluiLocacao.dispose();
					exibeCliente.dispose();
					exibeFuncionario.dispose();
					exibeLocacao.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource() == itemlistaLocacoes)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(exibeLocacao);
					area.add(exibeLocacao);
					exibeLocacao.show();
					area.moveToFront(exibeLocacao);
					criaCor.dispose();
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					excluiLocacao.dispose();
					exibeCliente.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					about.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}
				if(e.getSource()==itemAbout)
				{
					if(verificatela == 0)
					{
						verificatela = 1;
					area.remove(about);
					area.add(about);
					about.show();
					area.moveToFront(about);
					criaCor.dispose();
					cadastraCliente.dispose();
					cadastraFuncionario.dispose();
					cadastraVeiculo.dispose();
					editaCliente.dispose();
					editaFuncionario.dispose();
					editaVeiculo.dispose();
					excluiCliente.dispose();
					excluiFuncionario.dispose();
					excluiVeiculo.dispose();
					criaLocacao.dispose();
					editaLocacao.dispose();
					criaMarca.dispose();
					criaModelo.dispose();
					excluiLocacao.dispose();
					exibeCliente.dispose();
					exibeFuncionario.dispose();
					exibeVeiculos.dispose();
					exibeLocacao.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
					}
				}								
				if(e.getSource() == itemSair)
				{
					int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION);
					
					if(sair == JOptionPane.YES_OPTION)
					{
						plataforma.dispose();
						plataforma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						new Login();
					}					
				}
				
			}//fim actionPerformed

		}//fim ActioListener
		
		Eventos acao = new Eventos();
		itemaddCliente.addActionListener(acao);
		itemaddFuncionario.addActionListener(acao);
		itemaddVeiculo.addActionListener(acao);
		itemeditCliente.addActionListener(acao);
		itemeditFuncionario.addActionListener(acao);
		itemeditVeiculo.addActionListener(acao);
		itemexcluirCliente.addActionListener(acao);
		itemexcluirFuncionario.addActionListener(acao);
		itemexcluirVeiculo.addActionListener(acao);
		itemAlugar.addActionListener(acao);
		itemeditAlugar.addActionListener(acao);
		itemexcluirAlugar.addActionListener(acao);
		itemaddMarca.addActionListener(acao);
		itemaddModelo.addActionListener(acao);
		itemaddCor.addActionListener(acao);
		itemlistaCliente.addActionListener(acao);
		itemlistaFuncionario.addActionListener(acao);
		itemlistaVeiculo.addActionListener(acao);
		itemlistaLocacoes.addActionListener(acao);
		itemSair.addActionListener(acao);
		itemAbout.addActionListener(acao);
		}//fim do IF
	/////////SE FOR FUNCIONARIO/////////////	
		if(cargo.equals("Funcionário"))
		{
			final JFrame plataforma = new JFrame("AluCar Veículos");
			plataforma.setSize(800,600);
			plataforma.setLayout(null);
			plataforma.setVisible(true);
			plataforma.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//desabilita o X
			//plataforma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fechar tudo temporario
			plataforma.setResizable(false);//proibe modificar o tamanho com o mouse
			plataforma.setLocationRelativeTo(null);//colocar no centro
			
			
			
			final JDesktopPane area = new JDesktopPane();
			area.setBounds(0,0,800,600);
			area.setLayout(null);
			plataforma.add(area);
			final JLabel recebelogo = new JLabel();
			
			//BEM VINDO
			JLabel bemvindo = new JLabel("Bem vindo, "+nomelogin);
			bemvindo.setBounds(50,50,500,20);
			area.add(bemvindo);
			
			
			//menu
			JMenuBar menu = new JMenuBar();
			JMenu menuCadastro = new JMenu("Cadastro");
			JMenu menuEditar = new JMenu("Editar");
			JMenu menuExcluir = new JMenu("Excluir");
			JMenu menuLocacoes = new JMenu("Locações");
			JMenu menuInovacoes = new JMenu("Inovações");
			JMenu menuRelatorios = new JMenu("Relatórios");
			final JMenu menuAbout = new JMenu("Sobre");
			final JMenu menuSair = new JMenu("Sair");
			
			final JMenuItem itemaddCliente = new JMenuItem("Cliente");
			final JMenuItem itemaddFuncionario = new JMenuItem("Funcionário");
			final JMenuItem itemaddVeiculo = new JMenuItem("Veículo");
			final JMenuItem itemeditCliente = new JMenuItem("Cliente");
			final JMenuItem itemeditFuncionario = new JMenuItem("Funcionário");
			final JMenuItem itemeditVeiculo = new JMenuItem("Veículo");
			final JMenuItem itemexcluirCliente = new JMenuItem("Cliente");
			final JMenuItem itemexcluirFuncionario = new JMenuItem("Funcionário");
			final JMenuItem itemexcluirVeiculo = new JMenuItem("Veículo");
			final JMenuItem itemAlugar = new JMenuItem("Alugar");
			final JMenuItem itemeditAlugar = new JMenuItem("Editar");
			final JMenuItem itemexcluirAlugar = new JMenuItem("Excluir");
			final JMenuItem itemaddMarca = new JMenuItem("Nova Marca");
			final JMenuItem itemaddModelo = new JMenuItem("Novo Modelo");
			final JMenuItem itemaddCor = new JMenuItem("Nova cor");		
			final JMenuItem itemlistaCliente = new JMenuItem("Clientes");
			final JMenuItem itemlistaFuncionario = new JMenuItem("Funcionários");
			final JMenuItem itemlistaVeiculo = new JMenuItem("Veículos");
			final JMenuItem itemlistaLocacoes = new JMenuItem("Locações");		
			final JMenuItem itemSair = new JMenuItem("Desconectar");
			final JMenuItem itemAbout = new JMenuItem("About");
			menuCadastro.add(itemaddCliente);
			menuCadastro.add(itemaddFuncionario);
			menuCadastro.add(itemaddVeiculo);
			
			menuEditar.add(itemeditCliente);
			menuEditar.add(itemeditFuncionario);
			menuEditar.add(itemeditVeiculo);
			
			menuExcluir.add(itemexcluirCliente);
			menuExcluir.add(itemexcluirFuncionario);
			menuExcluir.add(itemexcluirVeiculo);
			
			menuLocacoes.add(itemAlugar);
			menuLocacoes.add(itemeditAlugar);
			menuLocacoes.add(itemexcluirAlugar);
			
			menuInovacoes.add(itemaddMarca);
			menuInovacoes.add(itemaddModelo);
			menuInovacoes.add(itemaddCor);
			
			menuRelatorios.add(itemlistaCliente);
			menuRelatorios.add(itemlistaFuncionario);
			menuRelatorios.add(itemlistaVeiculo);
			menuRelatorios.add(itemlistaLocacoes);		
			
			menuAbout.add(itemAbout);
			
			menuSair.add(itemSair);
			
			menu.add(menuCadastro);
			menu.add(menuEditar);
			menu.add(menuExcluir);
			menu.add(menuLocacoes);
			menu.add(menuInovacoes);
			menu.add(menuRelatorios);
			menu.add(menuAbout);
			menu.add(menuSair);
			
			//adiciona menu na plataforma
			plataforma.setJMenuBar(menu);

			Icon teste = new ImageIcon("logoopaco.png");
			recebelogo.setIcon(teste);
			recebelogo.setBounds(70,200,640,321);
			area.add(recebelogo);
			
			final CadastraCliente cadastraCliente = new CadastraCliente();
			final CadastraFuncionario cadastraFuncionario = new CadastraFuncionario();
			final CadastraVeiculo cadastraVeiculo = new CadastraVeiculo();
			final EditaCliente editaCliente = new EditaCliente();
			final EditaFuncionario editaFuncionario = new EditaFuncionario();
			final EditaVeiculo editaVeiculo = new EditaVeiculo();
			final ExcluiCliente excluiCliente = new ExcluiCliente();
			final ExcluiFuncionario excluiFuncionario = new ExcluiFuncionario();
			final ExcluiVeiculo excluiVeiculo = new ExcluiVeiculo();
			final CriaLocacao criaLocacao = new CriaLocacao();
			final EditaLocacao editaLocacao = new EditaLocacao();
			final ExcluiLocacao excluiLocacao = new ExcluiLocacao();
			final CriaMarca criaMarca = new CriaMarca();
			final CriaModelo criaModelo = new CriaModelo();
			final CriaCor criaCor = new CriaCor();
			final ExibeCliente  exibeCliente = new ExibeCliente();
			final ExibeFuncionario exibeFuncionario=new ExibeFuncionario();
			final ExibeVeiculos exibeVeiculos = new ExibeVeiculos();
			final ExibeLocacao exibeLocacao = new ExibeLocacao();
			final About about = new About();
			
			class Eventos implements ActionListener
			{
				
				public void actionPerformed(ActionEvent e)
				{
					if(e.getSource() == itemaddCliente)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
							
						area.remove(cadastraCliente);
						area.add(cadastraCliente);	
						cadastraCliente.show();
						area.moveToFront(cadastraCliente);
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						criaCor.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemaddFuncionario)
					{	
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(cadastraFuncionario);
						area.add(cadastraFuncionario);
						cadastraFuncionario.show();
						area.moveToFront(cadastraFuncionario);
						cadastraCliente.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						criaCor.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemaddVeiculo)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(cadastraVeiculo);
						area.add(cadastraVeiculo);
						cadastraVeiculo.show();
						area.moveToFront(cadastraVeiculo);
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						criaCor.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemeditCliente)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(editaCliente);
						area.add(editaCliente);
						editaCliente.show();
						area.moveToFront(editaCliente);
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						criaCor.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemeditFuncionario)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(editaFuncionario);
						area.add(editaFuncionario);
						editaFuncionario.show();
						area.moveToFront(editaFuncionario);
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						criaCor.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemeditVeiculo)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(editaVeiculo);
						area.add(editaVeiculo);
						editaVeiculo.show();
						area.moveToFront(editaVeiculo);
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						criaCor.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemexcluirCliente)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(excluiCliente);
						area.add(excluiCliente);
						excluiCliente.show();
						area.moveToFront(excluiCliente);
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						criaCor.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemexcluirFuncionario)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(excluiFuncionario);
						area.add(excluiFuncionario);
						excluiFuncionario.show();
						area.moveToFront(excluiFuncionario);
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						criaCor.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemexcluirVeiculo)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(excluiVeiculo);
						area.add(excluiVeiculo);
						excluiVeiculo.show();
						area.moveToFront(excluiVeiculo);
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						criaCor.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemAlugar)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(criaLocacao);
						area.add(criaLocacao);
						criaLocacao.show();
						area.moveToFront(criaLocacao);
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						criaCor.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemeditAlugar)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(editaLocacao);
						area.add(editaLocacao);
						editaLocacao.show();	
						area.moveToFront(editaLocacao);
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						criaCor.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemexcluirAlugar)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(excluiLocacao);
						area.add(excluiLocacao);
						excluiLocacao.show();
						area.moveToFront(excluiLocacao);
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						criaCor.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemaddMarca)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(criaMarca);
						area.add(criaMarca);
						criaMarca.show();
						area.moveToFront(criaMarca);
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaModelo.dispose();
						criaCor.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource()== itemaddModelo)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(criaModelo);
						area.add(criaModelo);
						criaModelo.show();
						area.moveToFront(criaModelo);
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaCor.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemaddCor)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(criaCor);
						area.add(criaCor);
						criaCor.show();
						area.moveToFront(criaCor);
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						exibeCliente.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemlistaCliente)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(exibeCliente);
						area.add(exibeCliente);
						exibeCliente.show();
						area.moveToFront(exibeCliente);
						criaCor.dispose();
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						excluiLocacao.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemlistaFuncionario)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(exibeFuncionario);
						area.add(exibeFuncionario);
						exibeFuncionario.show();
						area.moveToFront(exibeFuncionario);
						criaCor.dispose();
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						excluiLocacao.dispose();
						exibeCliente.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemlistaVeiculo)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(exibeVeiculos);
						area.add(exibeVeiculos);
						exibeVeiculos.show();
						area.moveToFront(exibeVeiculos);
						criaCor.dispose();
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						excluiLocacao.dispose();
						exibeCliente.dispose();
						exibeFuncionario.dispose();
						exibeLocacao.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource() == itemlistaLocacoes)
					{
						if(verificatela == 0)
						{
							verificatela = 1;
						area.remove(exibeLocacao);
						area.add(exibeLocacao);
						exibeLocacao.show();
						area.moveToFront(exibeLocacao);
						criaCor.dispose();
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						excluiLocacao.dispose();
						exibeCliente.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						about.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Por favor feche a janela atual!");
						}
					}
					if(e.getSource()==itemAbout)
					{
						
						area.remove(about);
						area.add(about);
						about.show();
						area.moveToFront(about);
						criaCor.dispose();
						cadastraCliente.dispose();
						cadastraFuncionario.dispose();
						cadastraVeiculo.dispose();
						editaCliente.dispose();
						editaFuncionario.dispose();
						editaVeiculo.dispose();
						excluiCliente.dispose();
						excluiFuncionario.dispose();
						excluiVeiculo.dispose();
						criaLocacao.dispose();
						editaLocacao.dispose();
						criaMarca.dispose();
						criaModelo.dispose();
						excluiLocacao.dispose();
						exibeCliente.dispose();
						exibeFuncionario.dispose();
						exibeVeiculos.dispose();
						exibeLocacao.dispose();
						
					}								
					if(e.getSource() == itemSair)
					{
						int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION);
						
						if(sair == JOptionPane.YES_OPTION)
						{
							plataforma.dispose();
							plataforma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							new Login();
						}					
					}
					
				}//fim actionPerformed

			}//fim ActioListener
			
			Eventos acao = new Eventos();
			itemaddCliente.addActionListener(acao);
			itemaddFuncionario.addActionListener(acao);
			itemaddVeiculo.addActionListener(acao);
			itemeditCliente.addActionListener(acao);
			itemeditFuncionario.addActionListener(acao);
			itemeditVeiculo.addActionListener(acao);
			itemexcluirCliente.addActionListener(acao);
			itemexcluirFuncionario.addActionListener(acao);
			itemexcluirVeiculo.addActionListener(acao);
			itemAlugar.addActionListener(acao);
			itemeditAlugar.addActionListener(acao);
			itemexcluirAlugar.addActionListener(acao);
			itemaddMarca.addActionListener(acao);
			itemaddModelo.addActionListener(acao);
			itemaddCor.addActionListener(acao);
			itemlistaCliente.addActionListener(acao);
			itemlistaFuncionario.addActionListener(acao);
			itemlistaVeiculo.addActionListener(acao);
			itemlistaLocacoes.addActionListener(acao);
			itemSair.addActionListener(acao);
			itemAbout.addActionListener(acao);
			
			//RESTRIÇÕES PARA FUNCIONARIO
			itemaddFuncionario.setVisible(false);
			itemaddVeiculo.setVisible(false);
			itemeditFuncionario.setVisible(false);
			itemeditVeiculo.setVisible(false);
			itemexcluirFuncionario.setVisible(false);
			itemexcluirVeiculo.setVisible(false);
			menuInovacoes.setVisible(false);
		}
	}//fim construtor
	
	

}
