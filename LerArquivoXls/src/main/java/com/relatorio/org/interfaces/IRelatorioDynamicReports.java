package com.relatorio.org.interfaces;

import com.relatorio.org.objectFake.OperadorLogado;
import java.util.Map;
import javax.persistence.EntityManager;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.jasperreports.engine.JRDataSource;

public interface IRelatorioDynamicReports extends IRelatorio{

    public Object setEm(EntityManager em);

    public JasperReportBuilder geraRelatorioCom(Object... obj);

    public JRDataSource createDataSource(Object obj);

    public JasperReportBuilder parametro(Map<String, String[]> parametro, OperadorLogado operadorLogado);
}