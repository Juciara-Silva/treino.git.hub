package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;
@Entity
public class Postagem extends Model{

	public String titulo;
	public String conteudo;
	public String autor;
	public Date data;
}