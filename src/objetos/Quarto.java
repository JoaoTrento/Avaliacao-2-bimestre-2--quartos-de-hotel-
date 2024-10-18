package objetos;

public class Quarto {
	
	private Integer numero;
	private String tipo;
	private Double preco;
	private Boolean disponivel;
	
	public Quarto(Integer numero, String tipo, Double preco, Boolean disponivel) {
		super();
		this.numero = numero;
		this.tipo = tipo;
		this.preco = preco;
		this.disponivel = disponivel;
	}
	public Quarto() {
		super();
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Boolean getDisponivel() {
		return disponivel;
	}
	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	@Override
	public String toString() {
		return "Quarto [numero=" + numero + ", tipo=" + tipo + ", preco=" + preco + ", disponivel=" + disponivel + "]";
	}
	
	

}
