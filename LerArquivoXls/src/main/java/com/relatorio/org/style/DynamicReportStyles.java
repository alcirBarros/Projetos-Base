package com.relatorio.org.style;

import java.awt.Color;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;

public class DynamicReportStyles {

    public static final StyleBuilder fonte10 = stl.style().setFontSize(10);
    public static final StyleBuilder fonte10_right = stl.style(fonte10).setAlignment(HorizontalAlignment.RIGHT, VerticalAlignment.MIDDLE);
    public static final StyleBuilder title1StyleBold = stl.style().setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE).setFontSize(11).bold();
    public static final StyleBuilder title2Style = stl.style().setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE).setFontSize(9);
    public static final StyleBuilder columnPedding = stl.style().setBorder(stl.pen1Point()).setPadding(3);
    public static final StyleBuilder align_right = stl.style().setAlignment(HorizontalAlignment.RIGHT, VerticalAlignment.MIDDLE);
    public static final StyleBuilder columnNumberStyle = stl.style(align_right).setBorder(stl.pen1Point()).setPadding(3);
    public static final StyleBuilder styleProduto = stl.style().bold().setFontSize(18);
    public static final StyleBuilder boldStyle = stl.style().bold();
    public static final StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
    public static final StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle).setBorder(stl.pen1Point()).setBackgroundColor(Color.LIGHT_GRAY);
}
