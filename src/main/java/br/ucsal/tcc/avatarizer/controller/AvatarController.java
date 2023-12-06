package br.ucsal.tcc.avatarizer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.tcc.avatarizer.service.AvatarService;

@RestController
@RequestMapping(value = "/avatar")
public class AvatarController {

	private final AvatarService avatarService;

	public AvatarController(AvatarService avatarService) {
		this.avatarService = avatarService;
	}
// @RequestParam String latitude, @RequestParam String longitude
	@GetMapping("/dados/{codigo}")
	public ResponseEntity<?> obterDadosDaAPI(@PathVariable String codigo) {
		return ResponseEntity.ok().body(avatarService.filtro(codigo, "-12.9704", "-38.5124"));
	}
}
