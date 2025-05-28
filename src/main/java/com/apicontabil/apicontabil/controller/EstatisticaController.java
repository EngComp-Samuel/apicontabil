package com.apicontabil.apicontabil.controller;


import com.apicontabil.apicontabil.controlefinanceiro.dominio.modelo.Categoria;
import com.apicontabil.apicontabil.controlefinanceiro.dominio.repository.CategoriaRepository;
import com.apicontabil.apicontabil.relatorios.CategoriaReports;
import com.apicontabil.apicontabil.relatorios.CategoriaReportsPdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/estatistica")
public class EstatisticaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaReports categoriaReports;

    @Autowired
    private CategoriaReportsPdf categoriaReportsPdf;

    @GetMapping(value = "/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Categoria> consultarCategorias(){
        return categoriaRepository.findAll();
    }

    //modificacao para gerar o relatorio
    @GetMapping(value = "/categorias", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> consultarCategoriasPdf(){
        System.out.println("Fui chamado");
        //byte[] bytesPdf = categoriaReportsPdf.consultarCategorias();
        byte[] bytesPdf = categoriaReports.consultarCategorias();
        var headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=categorias.pdf");

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .headers(headers)
                .body(bytesPdf);
    }



}
