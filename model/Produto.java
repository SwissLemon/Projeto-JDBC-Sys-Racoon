package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Produto {
	private int id;
	private String codigo;
	private String nome;
	private String descricao;
	private String deposito;
	private Image imagem;
	private Double custo;
	private Double valor;
	private ImageIcon imagemIcon;
	private String dataCriacaoFormatada;
	private String dataAtualizacaoFormatada;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDeposito() {
		return deposito;
	}
	public void setDeposito(String deposito) {
		this.deposito = deposito;
	}
	public Image getImagem() {
		return imagem;
	}
	public void setImagem(Image foto) {
		this.imagem = foto;
	}
	public Double getCusto() {
		return custo;
	}
	public void setCusto(Double custo) {
		this.custo = custo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public ImageIcon getImagemIcon() {
		return imagemIcon;
	}
	public void setImagemIcon(ImageIcon imagemIcon) {
		this.imagemIcon = imagemIcon;
	}
	public String getDataCriacaoFormatada() {
		return dataCriacaoFormatada;
	}
	public void setDataCriacaoFormatada(String dataCriacaoFormatada) {
		this.dataCriacaoFormatada = dataCriacaoFormatada;
	}
	public String getDataAtualizacaoFormatada() {
		return dataAtualizacaoFormatada;
	}
	public void setDataAtualizacaoFormatada(String dataAtualizacaoFormatada) {
		this.dataAtualizacaoFormatada = dataAtualizacaoFormatada;
	}
	
}
