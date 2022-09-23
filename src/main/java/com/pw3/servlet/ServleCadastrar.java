package com.pw3.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pw3.model.Pessoa;

@WebServlet(name = "servletCadastrar", value = "/cadastrar")
public class ServleCadastrar extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        
        String op = req.getParameter("op");
        Pessoa pessoa = new Pessoa();
        String local = ".";
        Integer id;
        ArrayList<Pessoa> lista = (ArrayList<Pessoa>)session.getAttribute("lista");

        

        if (op != null) {
            id = Integer.parseInt(req.getParameter("id"));


            if (op.equals("excluir")) {
                for (Pessoa p : lista) {
                    if (p.getId() == id) {
                        pessoa = p;
                        break;
                    }
                }
                lista.remove(pessoa);

                session.setAttribute("lista", lista);

            } else if (op.equals("alterar")) {
                for (Pessoa p : lista) {
                    if (p.getId() == id) {
                        pessoa = p;
                        break;
                    }
                }

                session.setAttribute("pessoa", pessoa);
                session.setAttribute("op", "alterar");
                local = "cadastro.jsp";
            }

        }

        resp.sendRedirect(local);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ArrayList<Pessoa> lista = (ArrayList<Pessoa>)session.getAttribute("lista");
        Integer id;
        id = Integer.parseInt(req.getParameter("id"));

        if (lista == null) {
            lista = new ArrayList<Pessoa>();
        }

        if (id == -1) {
            
            lista.add(new Pessoa(req.getParameter("name"), req.getParameter("email"), req.getParameter("phone")));
        } else {
            
            for (Pessoa pessoa : lista) {
                if (pessoa.getId() == id) {
                    pessoa.setName(req.getParameter("name"));
                    pessoa.setEmail(req.getParameter("email"));
                    pessoa.setPhone(req.getParameter("phone"));
                }
            }
        }

    
        session.setAttribute("lista", lista);

        resp.sendRedirect(".");
    }
}
