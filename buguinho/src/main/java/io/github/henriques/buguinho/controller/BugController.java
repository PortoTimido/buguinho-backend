package io.github.henriques.buguinho.controller;

import io.github.henriques.buguinho.entity.Bug;
import io.github.henriques.buguinho.service.BugService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.net.URI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/bugs")
public class BugController {

	private final BugService bugService;

	public BugController(BugService bugService) {
		this.bugService = bugService;
	}

	@GetMapping
	public List<Bug> getAllBugs() {
		return bugService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Bug> getBugById(@PathVariable String id) {
		return bugService.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Bug> createBug(@RequestBody Bug bug) {
		Bug novoBug = bugService.create(bug);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(novoBug.getId())
				.toUri();
		return ResponseEntity.created(location).body(novoBug);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Bug> patchBug(@PathVariable String id, @RequestBody Map<String, Object> updates) {
		return bugService.patch(id, updates)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBug(@PathVariable String id) {
		boolean removido = bugService.deleteById(id);
		if (removido) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

    
    
}
