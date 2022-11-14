package modelo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class AbstractJasperReport {

	private static JasperReport report;
	private static JasperPrint reportfilled;

	public static void createReport(ResultSet info, String path) {
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		try {
			report = (JasperReport) JRLoader.loadObjectFromFile(path);
			reportfilled = JasperFillManager.fillReport(report, parametros, new JRResultSetDataSource(info));
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	public static void exportToPDF(String destination) {
		try {
			JasperExportManager.exportReportToPdfFile(reportfilled, destination);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	public static void openPDF(String destination) {
		try {
			File path = new File(destination);
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
