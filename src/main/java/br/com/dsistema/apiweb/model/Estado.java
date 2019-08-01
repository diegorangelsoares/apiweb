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
		private String UF;
		
		public Estado() {
			
		}
		
		public Estado(long id, String UF) {
			this.id = id;
			this.UF = UF;
		}
		
		public long getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getUFe() {
			return UF;
		}
		
		public void setUF(String UF) {
			this.UF = UF;
		}

}
