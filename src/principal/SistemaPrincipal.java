package principal;

import java.util.Scanner;
import objetos.Funcoes;

public class SistemaPrincipal {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Funcoes funcoes = new Funcoes();
		
		Boolean menu = true;
		Boolean menuInt = true;
		
		while(menu)
		{
			menuInt = true;
			System.out.println("opções: \n"
					+ "[1] quartos \n"
					+ "[2] reservas \n"
					+ "[3] sair \n"
					+ "sua escolha: ");
			int esc = scan.nextInt();
			
			switch(esc)
			{
				case 1:
					while(menuInt)
					{
						System.out.println("opções de quartos: \n"
								+ "[1] cadastrar quarto \n"
								+ "[2] exibir lista de quartos \n"
								+ "[3] exibir relatorio de quartos reservados \n"
								+ "[4] exibir relatorio de quartos indisponiveis \n"
								+ "[5] alterar disponibilidade de quarto \n"
								+ "[6] sair \n"
								+ "sua escolha: ");
						int escInt = scan.nextInt();
						
						if(escInt==1)
						{
							funcoes.cadastrarQuarto();
						}
						else if(escInt==2)
						{
							funcoes.exibirListaQuartos();
						}
						else if(escInt==3)
						{
							funcoes.exibirRelatorioQuartosReservados();
						}
						else if(escInt==4)
						{
							funcoes.exibirQuartosIndisponiveis();
						}
						else if(escInt==5)
						{
							funcoes.alterarDisponibilidadeQuarto();
						}
						else if(escInt==6)
						{
							menuInt = false;
						}
						else
						{
							System.out.println("opção invalida!");
						}
					}
					break;	
					
				case 2:
					while(menuInt)
					{
						System.out.println("opções de reservas: \n"
								+ "[1] cadastrar reserva \n"
								+ "[2] exibir lista de reservas \n"
								+ "[3] sair \n"
								+ "sua escolha: ");
						int escInt = scan.nextInt();
						
						if(escInt==1)
						{
							funcoes.cadastrarReserva();
						}
						else if(escInt==2)
						{
							funcoes.exibirListaReservas();
						}
						else if(escInt==3)
						{
							menuInt = false;
						}
						else
						{
							System.out.println("opção invalida!");
						}
					}
					break;
					
				case 3:
					menu = false;
					break;
					
				default:
					System.out.println("opção invalida!");
			}
		}

	}

}
