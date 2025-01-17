package com.uniamerica.unijobsbackend.controllers;

import com.uniamerica.unijobsbackend.dto.ServicoDTO;
import com.uniamerica.unijobsbackend.dto.TipoServicoDTO;
import com.uniamerica.unijobsbackend.models.TipoServico;
import com.uniamerica.unijobsbackend.services.TipoServicoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@OpenAPIDefinition
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/tiposServicos")
public class TipoServicoController {

    @Autowired
    private TipoServicoService tipoServicoService;

    @GetMapping
    public ResponseEntity<List<TipoServicoDTO>> listar(){
        return ResponseEntity.ok(tipoServicoService.listarTiposServicos());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TipoServicoDTO> cadastrar(@Valid @RequestBody TipoServico tipoServico){
        return ResponseEntity.ok(tipoServicoService.novoTipoServico(tipoServico));
    }

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TipoServicoDTO> atualizar(@Valid @RequestBody TipoServico novoTipoServico, @PathVariable("id") Integer id){
        return ResponseEntity.ok(tipoServicoService.atualizarTipoServico( id, novoTipoServico));
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletar(@PathVariable("id") Integer id){
        return tipoServicoService.deletarTipoServico(id);
    }

    @GetMapping(path = "{id}/servicos")
    public ResponseEntity<List<ServicoDTO>> servicosByTipoServicos(@PathVariable("id") Integer id){
        return ResponseEntity.ok(tipoServicoService.servicosByTipoServicos(id));
    }
}
