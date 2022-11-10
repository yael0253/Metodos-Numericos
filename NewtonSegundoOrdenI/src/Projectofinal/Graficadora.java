
package Projectofinal;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graficadora {

    public static final int EXIT_ON_CLOSE = 0;
    JFreeChart grafica;
    XYSeriesCollection datos = new XYSeriesCollection();
    String titulo;
    String EtiquetaX;
    String EtiquetaY;

    public Graficadora(Double[][] Puntos) {
        titulo = "Puntos";
        EtiquetaX = "X";
        EtiquetaY = "Y";
        XYSeriesCollection Puntos1 = new XYSeriesCollection();
        XYSeries s = new XYSeries("puntos");
        for (int i = 0; i < Puntos.length; i++) {
            s.add(Puntos[i][0], Puntos[i][1]);
        }
        Puntos1.addSeries(s);
        grafica = ChartFactory.createScatterPlot("puntos", EtiquetaX, EtiquetaY, Puntos1);

    }

    public Graficadora(String t, String EX, String EY) {

        titulo = t;
        EtiquetaX = EX;
        EtiquetaY = EY;
        grafica = ChartFactory.createXYLineChart(titulo, EtiquetaX, EtiquetaY, datos, PlotOrientation.VERTICAL, true,
                true, true);
    }

    public Graficadora() {

        this("sin titulo", "x", "y");

    }

    public void agregarGrafica(String id, double[] x, double[] y) {
        XYSeries s = new XYSeries(id);
        int n = x.length;
        for (int i = 0; i < n; i++) {

            s.add(x[i], y[i]);

        }
        datos.addSeries(s);

    }

    public void crearGrafica(String id, double[] x, double[] y) {
        datos.removeAllSeries();
        agregarGrafica(id, x, y);

    }

    public JPanel obtieneGrafica() {
        return new ChartPanel(grafica);

    }

}
