package modeloBD;
// Generated 27-jun-2018 13:23:48 by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Productos generated by hbm2java
 */
@Entity
@Table(name = "productos", catalog = "bilnow_db")
public class Productos implements java.io.Serializable {

	private String idProducto;
	private String nomProducto;
	private Date fechaCaducidad;
	private String fabricantePro;
	private int priceProducto;

	public Productos() {
	}

	public Productos(String idProducto, String nomProducto, Date fechaCaducidad, String fabricantePro,
			int priceProducto) {
		this.idProducto = idProducto;
		this.nomProducto = nomProducto;
		this.fechaCaducidad = fechaCaducidad;
		this.fabricantePro = fabricantePro;
		this.priceProducto = priceProducto;
	}

	@Id

	@Column(name = "id_Producto", unique = true, nullable = false, length = 9)
	public String getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	@Column(name = "nom_Producto", nullable = false, length = 20)
	public String getNomProducto() {
		return this.nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_Caducidad", nullable = false, length = 10)
	public Date getFechaCaducidad() {
		return this.fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	@Column(name = "fabricante_Pro", nullable = false, length = 15)
	public String getFabricantePro() {
		return this.fabricantePro;
	}

	public void setFabricantePro(String fabricantePro) {
		this.fabricantePro = fabricantePro;
	}

	@Column(name = "price_Producto", nullable = false)
	public int getPriceProducto() {
		return this.priceProducto;
	}

	public void setPriceProducto(int priceProducto) {
		this.priceProducto = priceProducto;
	}

}
