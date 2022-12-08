package apoio;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import modelos.Usuario;

@ManagedBean
public class UsuarioBean {
  private Usuario usuario = new Usuario();

  public String doEfetuarLogin() {
    if("admin".equals(usuario.getLogin())
            && "admin".equals(usuario.getSenha())) {
      return "layout";
    } else {
      /* Cria uma mensagem. */
      FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
      FacesContext.getCurrentInstance().addMessage("erro", msg);
      return null;
    }
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}