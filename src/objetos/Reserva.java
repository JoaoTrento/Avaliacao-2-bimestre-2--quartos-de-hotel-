package objetos;

public class Reserva {
	
	private String nome;
	private String checkin;
	private String checkout;
	private Quarto quarto;
	
	public Reserva(String nome, String checkin, String checkout, Quarto quarto) {
		super();
		this.nome = nome;
		this.checkin = checkin;
		this.checkout = checkout;
		this.quarto = quarto;
	}
	public Reserva() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	
	@Override
	public String toString() {
		return "Reserva [nome=" + nome + ", checkin=" + checkin + ", checkout=" + checkout + ", numero do quarto=" + quarto.getNumero() + ", tipo do quarto=" + quarto.getTipo()+ "]";
	}

}
