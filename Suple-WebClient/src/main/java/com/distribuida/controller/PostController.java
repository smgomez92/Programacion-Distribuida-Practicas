package com.distribuida.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.distribuida.modelo.Coment;
import com.distribuida.modelo.ListaPost;
import com.distribuida.modelo.Post;
import com.distribuida.modelo.Usuario;


@Controller
public class PostController {
	@Autowired
	RestTemplate restTemplate;
	private List<Post> post = new ArrayList<Post>();
	@Value("${url.gateway}")
	String GATEWAY;

//	@RequestMapping(value = "/listar", method = RequestMethod.GET)
//	public String listar(ModelMap model) {
//
//		ResponseEntity<List<Post>> response = restTemplate.exchange(GATEWAY + "postservice", HttpMethod.GET, null,
//				new ParameterizedTypeReference<List<Post>>() {
//				});
//		post = response.getBody();
//		model.addAttribute("lista", post);
//		return "posts";
//	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listarPost(ModelMap model) {
		List<ListaPost> posts = new ArrayList<ListaPost>();

		ResponseEntity<List<Post>> response = restTemplate.exchange(GATEWAY + "/postservice", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Post>>() {
				});

		ResponseEntity<List<Coment>> responseComments = restTemplate.exchange(GATEWAY + "/commentservice",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Coment>>() {
				});

		ResponseEntity<List<Usuario>> usuarios = restTemplate.exchange(GATEWAY + "/usuarioservice/usuarios",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Usuario>>() {
				});
		int i = 0;
		for (Usuario u : usuarios.getBody()) {

			posts.add(new ListaPost(u, response.getBody().get(i), responseComments.getBody().get(i)));

		}

		model.addAttribute("lista", posts);
		return "posts";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		return "index";
	}
}
