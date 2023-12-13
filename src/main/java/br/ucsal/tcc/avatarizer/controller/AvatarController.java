package br.ucsal.tcc.avatarizer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ucsal.tcc.avatarizer.service.AvatarService;

@RestController
@RequestMapping(value = "/avatar")
public class AvatarController {

	private final AvatarService avatarService;

	public AvatarController(AvatarService avatarService) {
		this.avatarService = avatarService;
	}
// @RequestParam String latitude, @RequestParam String longitude
	@CrossOrigin(origins = "*")
	@GetMapping("/dados/{codigo}")
	public ResponseEntity<?> obterDadosDaAPI(@PathVariable String codigo, @RequestParam String latitude, @RequestParam String longitude) {
		return ResponseEntity.ok().body(avatarService.filtro(codigo, latitude, longitude));
	}
}
