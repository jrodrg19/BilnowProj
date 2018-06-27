package modeloBD;
// Generated 27-jun-2018 10:59:07 by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "bilnow_db")
public class Usuario implements java.io.Serializable {

	private String idUsuario;
	private String nomUsuario;
	private String apUsuario;
	private String tlfUsuario;
	private String dirUsuario;
	private boolean rolUsuario;
	private String pswdUsuario;
	private String emailUsuario;

	public Usuario() {
	}

	public Usuario(String idUsuario, String nomUsuario, String apUsuario, String tlfUsuario, String dirUsuario,
			boolean rolUsuario, String pswdUsuario, String emailUsuario) {
		this.idUsuario = idUsuario;
		this.nomUsuario = nomUsuario;
		this.apUsuario = apUsuario;
		this.tlfUsuario = tlfUsuario;
		this.dirUsuario = dirUsuario;
		this.rolUsuario = rolUsuario;
		this.pswdUsuario = pswdUsuario;
		this.emailUsuario = emailUsuario;
	}

	@Id

	@Column(name = "id_Usuario", unique = true, nullable = false, length = 9)
	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "nom_Usuario", nullable = false, length = 9)
	public String getNomUsuario() {
		return this.nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	@Column(name = "ap_Usuario", nullable = false, length = 9)
	public String getApUsuario() {
		return this.apUsuario;
	}

	public void setApUsuario(String apUsuario) {
		this.apUsuario = apUsuario;
	}

	@Column(name = "tlf_Usuario", nullable = false, length = 9)
	public String getTlfUsuario() {
		return this.tlfUsuario;
	}

	public void setTlfUsuario(String tlfUsuario) {
		this.tlfUsuario = tlfUsuario;
	}

	@Column(name = "dir_Usuario", nullable = false, length = 20)
	public String getDirUsuario() {
		return this.dirUsuario;
	}

	public void setDirUsuario(String dirUsuario) {
		this.dirUsuario = dirUsuario;
	}

	@Column(name = "rol_Usuario", nullable = false)
	public boolean isRolUsuario() {
		return this.rolUsuario;
	}

	public void setRolUsuario(boolean rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	@Column(name = "pswd_Usuario", nullable = false, length = 8)
	public String getPswdUsuario() {
		return this.pswdUsuario;
	}

	public void setPswdUsuario(String pswdUsuario) {
		this.pswdUsuario = pswdUsuario;
	}

	@Column(name = "email_Usuario", nullable = false, length = 15)
	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

}
