package objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcoes {
	
	public static Scanner scan = new Scanner(System.in);
	
	ArrayList<Quarto> listaDeQuartos = new ArrayList<>();
	ArrayList<Reserva> listaDeReservas = new ArrayList<>();
	
	Integer numeroID = 0;
	
	public void cadastrarQuarto() {
		
		numeroID++; // numero do quarto é definido automaticamente, assim evita o cadastro de mais de um quarto com o mesmo numero
		
		System.out.println("quarto numero " + numeroID + ": ");
		
		System.out.println("Insira o tipo do quarto (solteiro, casal, suite): ");
		String tipo = scan.next();
		
		System.out.println("Insira o preço da diaria do quarto: ");
		Double preco = scan.nextDouble();
		
		Boolean disponivel = null;
		
		Boolean menu = true;
		while(menu)
		{
			System.out.println("O quarto esta disponivel? \n[1] sim \n[2] não \nSua escolha: ");
			int esc = scan.nextInt();
			
			if(esc==1)
			{
				disponivel = true;
				menu = false;
			}
			else if(esc==2)
			{
				disponivel = false;
				menu = false;
			}
			else
			{
				System.out.println("Opção Invalida");
			}
			
			Quarto quarto = new Quarto(numeroID, tipo, preco, disponivel);
			listaDeQuartos.add(quarto);
		}
		
	}
	
	public void cadastrarReserva() {
		
		Boolean quartoDisponivel = false;
		
		for (Quarto quarto : listaDeQuartos) 
		{
			if(quarto.getDisponivel()) // testa para saber se tem algum quarto disponivel
			{
				quartoDisponivel = true;
				break;
			}
		}
		
		if(quartoDisponivel) // se tiver um quarto disponivel a reserva segue normalmente
		{
			System.out.println("Insira o nome do hospede: ");
			String nome = scan.next();
			
			Quarto quartoReserva = null;
			
			Boolean menu = true;
			while(menu)
			{
				System.out.println("Quartos cadastrados: ");
				exibirListaQuartosDisponiveis();
				System.out.println("Insira o numero do quarto: ");
				Integer numero = scan.nextInt();
				scan.nextLine();
				
				for (Quarto quarto : listaDeQuartos) 
				{
					if(quarto.getNumero()==numero)
					{
						if(quarto.getDisponivel())
						{
							quarto.setDisponivel(false); // apos a reserva ser feita o quarto fica ocupado
							quartoReserva=quarto;
							menu = false;
							break;
						}
					}
				}
			}
			
			
			System.out.println("Insira a data do checkin (dd/mm/aaaa): ");
			String checkin = scan.next();
			
			System.out.println("Insira a data do checkout (dd/mm/aaaa): ");
			String checkout = scan.next();
			
			Reserva reserva = new Reserva(nome, checkin, checkout, quartoReserva);
			listaDeReservas.add(reserva);
		}
		else // se não tiver quarto disponivel a reserva não pode ser realizada
		{
			System.out.println("Nenhum quarto disponivel.");
		}
	}
	
	public void exibirListaQuartos() {
		
		for (Quarto quarto : listaDeQuartos) 
		{
			System.out.println(quarto);
		}
	}
	
	public void exibirListaQuartosDisponiveis() { // não é usada no sistema principal
		
		for (Quarto quarto : listaDeQuartos) 
		{
			if(quarto.getDisponivel())
			{
				System.out.println(quarto);				
			}
		}
	}
	
	public void exibirListaReservas() {
		
		for (Reserva reserva : listaDeReservas) 
		{
			System.out.println(reserva);
		}
	}
	
	public void exibirQuartosIndisponiveis() { // quartos indisponiveis são todos os quartos com "disponivel" = false (quarto indisponivel != quarto reservado)
		
		int numeroQuartosIndisponiveis = 0;
		
		for (Quarto quarto : listaDeQuartos) 
		{
			if(!quarto.getDisponivel())
			{
				System.out.println(quarto);
				numeroQuartosIndisponiveis++;
			}
		}
		
		System.out.println("Tem " + numeroQuartosIndisponiveis + " quartos indisponiveis: ");
		
	}
	
	public void exibirRelatorioQuartosReservados() { // quartos que estão indisponiveis por causa de uma reserva (quarto indisponivel != quarto reservado)
		
		int numeroQuartosReservados = 0;
		
		for (Reserva reserva : listaDeReservas) 
		{
			if(!reserva.getQuarto().getDisponivel())
			{
				numeroQuartosReservados++;
			}
			
			System.out.println("Numero: " + reserva.getQuarto().getNumero() + "; "
						    + "Tipo: " + reserva.getQuarto().getTipo() + "; "
							+ "checkin: " + reserva.getCheckin() + "; "
							+ "checkout: " + reserva.getCheckout());
		}
		System.out.println("Tem " + numeroQuartosReservados + " quartos reservados: ");
		
	}
	
	public void alterarDisponibilidadeQuarto() {
		
		exibirListaQuartos();
		Boolean menu = true;
		while(menu)
		{
			System.out.println("Deseja alterar a disponibilidade de algum quarto? \n"
					+ "[1] sim \n"
					+ "[2] não \n"
					+ "sua escolha: ");
			
			int esc = scan.nextInt();
			
			if(esc==1)
			{
				Boolean menuInt = true;
				Boolean quartoEncontrado = false;
				while(menuInt)
				{
					System.out.println("Qual o numero do quarto que deseja alterar a disponibilidade? ");
					int numeroQuarto = scan.nextInt();
					
					for (Quarto quarto : listaDeQuartos)
					{
						if(quarto.getNumero()==numeroQuarto)
						{
							quarto.setDisponivel(!quarto.getDisponivel());
							quartoEncontrado=true;
							menuInt = false;
							break;
						}
					}
					
					if(!quartoEncontrado)
					{
						System.out.println("Quarto numero " + numeroQuarto + " não escontrado.");
					}
				}
				menu = false;
			}
			else if(esc==2)
			{
				menu = false;
			}
			else
			{
				System.out.println("escolha invalida!");
			}
		}
	}

}
