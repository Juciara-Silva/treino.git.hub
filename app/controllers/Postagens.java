package controllers;

import java.util.List;

import models.Postagem;
import play.mvc.Controller;

public class Postagens extends Controller {
	
	
	 public static void form() {
	        render();
	    }
	 
	 public static void salvar(Postagem p) {
		 String mensagem = "Cadastrado com sucesso!";
		p.save();
		flash.success(mensagem);
		listar("");
	 }
	 
	 
	 
	 public static void listar(String termo) {
			List<Postagem> postagens = null;
			if (termo == null) {
				postagens = Postagem.findAll();
			} else {
				postagens = Postagem.find("lower(titulo) like ?1 or conteudo like ?1 or autor like ?1 or data like ?1",
						"%" + termo.toLowerCase() + "%").fetch();
			 }
			render(postagens, termo);
		}
	  
	 public static void remover(long id) {
		 Postagem p = Postagem.findById(id);
			p.delete();
			flash.success("Removido com sucesso!");
			listar(null);
	    }

}