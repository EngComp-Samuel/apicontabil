package com.apicontabil.apicontabil.relatorios;

import com.apicontabil.apicontabil.controlefinanceiro.dominio.modelo.Categoria;
import com.apicontabil.apicontabil.controlefinanceiro.dominio.repository.CategoriaRepository;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Service
public class CategoriaReportsPdf implements CategoriaReports{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public byte[] consultarCategorias(){
        try {
            var inputStream = this.getClass().getResourceAsStream("/relatorios/Categoria.jasper");
            List<Categoria> categorias = categoriaRepository.findAll();
            var dataSource = new JRBeanCollectionDataSource(categorias);
            //passar os parametros caso queira
            // 1 - passar os parametros do cabeçalho, logo, essas coisas deixa o relatorio mais dinamico.
            // 2 -
            // 3 -

            var parametros = new HashMap<String, Object>();
            parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
            //ESSAS INFORMAÇÕES PODEM SER MAIS DINÂMICAS, POR EXEMPLO, VIR DO BANCO DE DADOS.
            parametros.put("nomeEmpresa", "Samuel Farias");
            parametros.put("ramoDaEmpresa", "Consultoria de Contabilidade e Sistemas");
            parametros.put("nomeDoSistema", "API Contábil");
            parametros.put("moduloDoSistema", "Controle Financeiro");
            parametros.put("nomeRelatorio", "Categorias");

            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros, dataSource);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            throw new ReportsException("Não foi possivel gerar o relatório", e);
        }
    }
}
