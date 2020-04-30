package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SalvarFesta")
public class SalvarFesta extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String cliente = request.getParameter("cliente");
		String aniversariante = request.getParameter("aniversariante");
		String tema = request.getParameter("tema");
		String data = request.getParameter("data");
		String inicio = request.getParameter("inicio");
		String fim = request.getParameter("fim");
		
		int horaInic = 0;
		int horaFin = 0;
		
		String[] vetorInicio = inicio.split(":");
		String[] vetorFim = fim.split(":");
		
		horaInic += Integer.parseInt(vetorInicio[0])*60;
		horaInic += Integer.parseInt(vetorInicio[1]);
				
		horaFin += Integer.parseInt(vetorFim[0])*60;
		horaFin += Integer.parseInt(vetorFim[1]);
		
		
		if(horaInic < horaFin){	
			
			PrintWriter saida= response.getWriter();
			
			saida.println("<!DOCTYPE html>");
			saida.println("<html lang='pt-br'>");
			saida.println("<head>");
			saida.println("<meta charset='UTF-8'>");
			saida.println("<title>Formulario</title>");
			saida.println("</head>");
			saida.println("<body>");
			
			saida.println("<h1>Festa cadastrada com Sucesso</h1>");
			saida.println("<p>Confira seus dados:</p>");
			saida.println("<p>Cliente: "+cliente+"</p>");
			saida.println("<p>Aniversariante: "+aniversariante+"</p>");
			saida.println("<p>Tema: "+tema+"</p>");
			saida.println("<p>Hora Inicial: "+inicio+"</p>");
			saida.println("<p>Hora Final: "+fim+"</p>");
			saida.println("<h2>Agradecemos por nos escolher!</h2>");
			
						
		} else{
			PrintWriter saida= response.getWriter();
			
			saida.println("<!DOCTYPE html>");
			saida.println("<html lang='pt-br'>");
			saida.println("<head>");
			saida.println("<meta charset='UTF-8'>");
			saida.println("<title>Formulario</title>");
			saida.println("</head>");
			saida.println("<body>");
			
			saida.println("<h1>Cadastro de Festas</h1>");
			saida.println("<form action='SalvarFesta' method='post' style='width: 450px'>");
			saida.println("<fieldset>");
			saida.println("<legend>Dados da festa a ser cadastrada</legend>");
			
			saida.println("<p><label for='cliente'>Cliente:</label>");
			saida.println("<input type='text' value='"+cliente+"' name='cliente' id='cliente' size='40' /></p>");
			
			saida.println("<p><label for='aniversariante'>Aniversariante:</label> ");
			saida.println("<input type='text' value='"+aniversariante+"' name='aniversariante' id='aniversariante' size='40' /></p>");
			
			saida.println("<p><label for='tema'>Tema:</label>");
			saida.println("<select id='tema' name='tema'>");
			saida.println("<option>"+tema+"</option>");
			saida.println("<option> Homem de Ferro </option>");
			saida.println("<option> X-men </option>");
			saida.println("<option> Cinderela </option>");
			saida.println("</select></p>");
			
			saida.println("<p><label for='data'>Data:</label>");
			saida.println("<input type='date' value='"+data+"' name='data' id='data'/></p>");
			
			saida.println("<p style='background: red; color: white'><strong>A hora de termino nao pode ser menor que a hora de inicio!</strong></p>");
			
			saida.println("<p><label for='horaInicio'>Hora Inicio:</label> ");
			saida.println("<input type='time' value='"+inicio+"' name='inicio' id='inicio'/></p>");
			
			saida.println("<p><label for='horaTermino'>Hora Termino:</label>");
			saida.println("<input type='time' value='"+fim+"' name='fim' id='fim'/></p> ");
			
			saida.println("<input type='submit' value='Cadastrar Festa' />");
			
			saida.println("</fieldset>");
			saida.println("</form>");
			saida.println("</body>");
			saida.println("</html>");
			
		}
	}
}
