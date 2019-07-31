package br.com.dsistema.apiweb.model;

	
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;


	@Entity
	@Table(name="TAB_ESTADO")
	public class Estado {
		
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		private String nome;
		
		public Estado() {
			
		}
		
		public Estado(long id, String nome) {
			this.id = id;
			this.nome = nome;
		}
		
		public long getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}

}