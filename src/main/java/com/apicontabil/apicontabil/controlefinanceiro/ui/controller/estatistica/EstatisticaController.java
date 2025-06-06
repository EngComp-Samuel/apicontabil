package com.apicontabil.apicontabil.controlefinanceiro.ui.controller.estatistica;


import com.apicontabil.apicontabil.controlefinanceiro.domain.modelo.CategoriaEntity;
import com.apicontabil.apicontabil.controlefinanceiro.domain.repository.CategoriaJpaRepository;
import com.apicontabil.apicontabil.controlefinanceiro.infra.relatorios.CategoriaReports;
import com.apicontabil.apicontabil.controlefinanceiro.infra.relatorios.CategoriaReportsPdf;
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
    private CategoriaJpaRepository categoriaJpaRepository;

    @Autowired
    private CategoriaReports categoriaReports;

    @Autowired
    private CategoriaReportsPdf categoriaReportsPdf;

    @GetMapping(value = "/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoriaEntity> consultarCategorias(){
        return categoriaJpaRepository.findAll();
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
