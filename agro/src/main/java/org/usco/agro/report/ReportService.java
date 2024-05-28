package org.usco.agro.report;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private DataSource dataSource;

    public byte[] generateReport() throws JRException, SQLException {
        // Ruta del archivo .jrxml
        String reportPath = "src/main/resources/reports/EspacioReport.jrxml";

        // Compilar el archivo jrxml a jasper
        JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);

        // Obtener la conexión JDBC
        Connection connection = dataSource.getConnection();

        // Llenar el reporte
        Map<String, Object> parameters = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

        // Exportar el reporte a PDF
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}