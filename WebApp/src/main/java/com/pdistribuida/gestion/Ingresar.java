package com.pdistribuida.gestion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@SessionScoped
@ManagedBean(name = "ingreso")
public class Ingresar {

	private boolean isLogin = false;
	private String message = "";
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Ingresar() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public void verifyLogin() {
		if (!this.isLogin) {
			doRedirect("login.xhtml");
		}
	}

	public void login() {
		if (this.username.equalsIgnoreCase("programacion")
				&& this.password.equalsIgnoreCase("distribuida")) {
			this.isLogin = true;
			this.message = "";
			doRedirect("welcome.xhtml");
		} else {
			this.message = "Account's Invalid";
			doRedirect("login.xhtml");
		}
	}

	public void logout() {
		this.isLogin = false;
		doRedirect("login.xhtml");
	}

	private void doRedirect(String url) {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.getExternalContext().redirect(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
