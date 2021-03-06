package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class ServletGestionUsuario
 */
@WebServlet("/ServletGestionUsuario")
public class ServletGestionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u,c,r,e;
		int d;
		boolean res;
		UsuarioDTO usdto;
		UsuarioDAO usdao;
		UsuarioDTO recdatos;
		
		if(request.getParameter("btnins")!=null) {
			d=Integer.parseInt(request.getParameter("doc"));
			u=request.getParameter("usu");
			c=request.getParameter("cla");
			r=request.getParameter("rol");
			e=request.getParameter("est");
			
			usdto=new UsuarioDTO(d, u, c, r, e);
			usdao=new UsuarioDAO();
			res=usdao.insertarusuario(usdto);
			
			if(res) {
				JOptionPane.showMessageDialog(null, "Usuario registrado");
				response.sendRedirect("Usuarios.jps");
			}
			else {
				JOptionPane.showMessageDialog(null, "Usuario no registrado");
				response.sendRedirect("Usuarios.jsp");
			}
		}
		
		if(request.getParameter("btncon")!= null) {
			//Accion para consultar
			int doc;
			d=Integer.parseInt(request.getParameter("doc"));
			usdto=new UsuarioDTO(d);
			usdao=new UsuarioDAO();
			recdatos=usdao.consultarusuario(usdto);
			doc=recdatos.getDocumento();
			u=recdatos.getNomusu();
			c=recdatos.getClave();
			r=recdatos.getRol();
			e=recdatos.getEstado();
				
			response.sendRedirect("Usuarios.jsp?do="+doc+"&&us="+u+"&&cl"+c+"&&ro"+r+"&&es"+e);
			
		}
		
		
		if(request.getParameter("btnact")!= null) {
			//Accion para consultar usuario
			boolean dat;
			d=Integer.parseInt(request.getParameter("doc"));
			u=request.getParameter("usu");
			c=request.getParameter("cla");
			r=request.getParameter("rol");
			e=request.getParameter("est");
			usdto=new UsuarioDTO(d, u, c, r, e);
			usdao=new UsuarioDAO();
			dat=usdao.actualizar(usdto);
			if(dat==true) {
				JOptionPane.showMessageDialog(null, "El usuario se actualizo");
				response.sendRedirect("Usuarios.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El usuario no se actualizo");
				response.sendRedirect("Usuarios.jsp");
			}
			
		}
		
		if(request.getParameter("btneli")!= null) {
			//Accion para eliminar
			int y;
			d=Integer.parseInt(request.getParameter("doc"));
			usdto=new UsuarioDTO(d);
			usdao=new UsuarioDAO();
			y=usdao.eliminar(usdto);
			if(y>0){
				JOptionPane.showMessageDialog(null, "El usuario fue eliminado");
				response.sendRedirect("Usuarios.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El usuario no fue eliminado");
				response.sendRedirect("Usuarios.jsp");
			}
		}
	}
	

}
