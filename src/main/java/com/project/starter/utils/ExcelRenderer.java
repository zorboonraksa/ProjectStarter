package com.project.starter.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;

public class ExcelRenderer {
    public Sheet sheet;
    public Workbook workbook;
    public CellStyle csHeader;
    public CellStyle csHeaderBold;
    public CellStyle csHeaderLeft;
    public CellStyle csHeaderColumn;
    public CellStyle csHeaderColumnNumber;
    public CellStyle csHeaderColumnLeft;
    public CellStyle csBodyColumn;
    public CellStyle csBodyColumnVirticalBorder;
    public CellStyle csBodyColumnVirticalBorderNumber;
    public CellStyle csBodyColumnVirticalBorderLeft;
    public CellStyle csBodyColumnVirticalBorderRight;
    public CellStyle csBodyColumnVirticalBorderRightAlignLeft;
    public CellStyle csBodyColumnLeft;
    public CellStyle csBodyColumnRight;
    public CellStyle csBodyColumnNumber;
    public CellStyle csBodyColumnNumberBold;
    public CellStyle csBodyColumnNumberLeft;
    public CellStyle csBodyColumnNumberRight;
    public CellStyle csBodyColumnNumberRightBold;
    public CellStyle csBodyColumnDoubleLeft;
    public CellStyle csBodyColumnDoubleRight;
    public CellStyle csBodyColumnDoubleRightBold;
    public CellStyle csFooter;
    public CellStyle csFooterBold;
    public CellStyle csNormal;
    public CellStyle csNormalRight;
    public CellStyle csNormalLeft;
    public CellStyle csNormalBold;
    public CellStyle csNormalBoldRight;
    public XSSFFont font;
    public XSSFFont fontBold;
    public XSSFFont font14;

    public ExcelRenderer(Sheet sheet) {
        super();
        this.workbook = sheet.getWorkbook();
        this.sheet = sheet;

        DataFormat datFmt = workbook.createDataFormat();

        this.font = (XSSFFont) workbook.createFont();
        font.setFontName("TH SarabunPSK");
        font.setFontHeight(16);

        this.fontBold = (XSSFFont) workbook.createFont();
        fontBold.setFontName("TH SarabunPSK");
        fontBold.setBold(true);
        fontBold.setFontHeight(16);

        this.font14 = (XSSFFont) workbook.createFont();
        font14.setFontName("TH SarabunPSK");
        font14.setFontHeight(14);

        csHeader = workbook.createCellStyle();
        csHeader.setWrapText(true);
        csHeader.setAlignment(HorizontalAlignment.CENTER);
        csHeader.setVerticalAlignment(VerticalAlignment.CENTER);
        csHeader.setFont(font);

        csHeaderBold = workbook.createCellStyle();
        csHeaderBold.setWrapText(true);
        csHeaderBold.setAlignment(HorizontalAlignment.CENTER);
        csHeaderBold.setVerticalAlignment(VerticalAlignment.CENTER);
        csHeaderBold.setFont(fontBold);

        csHeaderLeft = workbook.createCellStyle();
        csHeaderLeft.setWrapText(true);
        csHeaderLeft.setAlignment(HorizontalAlignment.LEFT);
        csHeaderLeft.setVerticalAlignment(VerticalAlignment.CENTER);
        csHeaderLeft.setFont(font);
        csHeaderLeft.setFont(fontBold);

        csHeaderColumn = workbook.createCellStyle();
        csHeaderColumn.setWrapText(true);
        csHeaderColumn.setAlignment(HorizontalAlignment.CENTER);
        csHeaderColumn.setBorderLeft(BorderStyle.MEDIUM);
        csHeaderColumn.setBorderRight(BorderStyle.MEDIUM);
        csHeaderColumn.setBorderTop(BorderStyle.MEDIUM);
        csHeaderColumn.setBorderBottom(BorderStyle.MEDIUM);
        csHeaderColumn.setAlignment(HorizontalAlignment.CENTER);
        csHeaderColumn.setVerticalAlignment(VerticalAlignment.CENTER);
        csHeaderColumn.setFont(fontBold);

        csHeaderColumnLeft = workbook.createCellStyle();
        csHeaderColumnLeft.setWrapText(true);
        csHeaderColumnLeft.setAlignment(HorizontalAlignment.CENTER);
        csHeaderColumnLeft.setBorderLeft(BorderStyle.MEDIUM);
        csHeaderColumnLeft.setBorderRight(BorderStyle.MEDIUM);
        csHeaderColumnLeft.setBorderTop(BorderStyle.MEDIUM);
        csHeaderColumnLeft.setBorderBottom(BorderStyle.MEDIUM);
        csHeaderColumnLeft.setAlignment(HorizontalAlignment.LEFT);
        csHeaderColumnLeft.setVerticalAlignment(VerticalAlignment.CENTER);
        csHeaderColumnLeft.setFont(fontBold);

        csHeaderColumnNumber = workbook.createCellStyle();
        csHeaderColumnNumber.setWrapText(true);
        csHeaderColumnNumber.setDataFormat(datFmt.getFormat("#,##0"));
        csHeaderColumnNumber.setAlignment(HorizontalAlignment.CENTER);
        csHeaderColumnNumber.setBorderLeft(BorderStyle.MEDIUM);
        csHeaderColumnNumber.setBorderRight(BorderStyle.MEDIUM);
        csHeaderColumnNumber.setBorderTop(BorderStyle.MEDIUM);
        csHeaderColumnNumber.setBorderBottom(BorderStyle.MEDIUM);
        csHeaderColumnNumber.setAlignment(HorizontalAlignment.CENTER);
        csHeaderColumnNumber.setVerticalAlignment(VerticalAlignment.CENTER);
        csHeaderColumnNumber.setFont(fontBold);

        csBodyColumn = workbook.createCellStyle();
        csBodyColumn.setWrapText(true);
        csBodyColumn.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumn.setBorderRight(BorderStyle.MEDIUM);
        csBodyColumn.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumn.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumn.setAlignment(HorizontalAlignment.CENTER);
        csBodyColumn.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumn.setFont(font);

        csBodyColumnVirticalBorder = workbook.createCellStyle();
        csBodyColumnVirticalBorder.setWrapText(true);
        csBodyColumnVirticalBorder.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorder.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorder.setAlignment(HorizontalAlignment.CENTER);
        csBodyColumnVirticalBorder.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnVirticalBorder.setFont(font);

        csBodyColumnVirticalBorderNumber = workbook.createCellStyle();
        csBodyColumnVirticalBorderNumber.setWrapText(true);
        csBodyColumnVirticalBorderNumber.setDataFormat(datFmt.getFormat("#,##0"));
        csBodyColumnVirticalBorderNumber.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorderNumber.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorderNumber.setAlignment(HorizontalAlignment.CENTER);
        csBodyColumnVirticalBorderNumber.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnVirticalBorderNumber.setFont(font);

        csBodyColumnVirticalBorderLeft = workbook.createCellStyle();
        csBodyColumnVirticalBorderLeft.setWrapText(true);
        csBodyColumnVirticalBorderLeft.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorderLeft.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorderLeft.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorderLeft.setAlignment(HorizontalAlignment.LEFT);
        csBodyColumnVirticalBorderLeft.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnVirticalBorderLeft.setFont(font);

        csBodyColumnVirticalBorderRight = workbook.createCellStyle();
        csBodyColumnVirticalBorderRight.setWrapText(true);
        csBodyColumnVirticalBorderRight.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorderRight.setBorderRight(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorderRight.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorderRight.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorderRight.setAlignment(HorizontalAlignment.RIGHT);
        csBodyColumnVirticalBorderRight.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnVirticalBorderRight.setFont(font);

        csBodyColumnVirticalBorderRightAlignLeft = workbook.createCellStyle();
        csBodyColumnVirticalBorderRightAlignLeft.setWrapText(true);
        csBodyColumnVirticalBorderRight.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorderRightAlignLeft.setBorderRight(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorderRightAlignLeft.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorderRightAlignLeft.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnVirticalBorderRightAlignLeft.setAlignment(HorizontalAlignment.RIGHT);
        csBodyColumnVirticalBorderRightAlignLeft.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnVirticalBorderRightAlignLeft.setFont(font);

        csBodyColumnLeft = workbook.createCellStyle();
        csBodyColumnLeft.setWrapText(true);
        csBodyColumnLeft.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumnLeft.setBorderRight(BorderStyle.MEDIUM);
        csBodyColumnLeft.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnLeft.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnLeft.setAlignment(HorizontalAlignment.LEFT);
        csBodyColumnLeft.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnLeft.setFont(font);

        csBodyColumnRight = workbook.createCellStyle();
        csBodyColumnRight.setWrapText(true);
        csBodyColumnRight.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumnRight.setBorderRight(BorderStyle.MEDIUM);
        csBodyColumnRight.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnRight.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnRight.setAlignment(HorizontalAlignment.RIGHT);
        csBodyColumnRight.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnRight.setFont(font);

        csBodyColumnNumber = workbook.createCellStyle();
        csBodyColumnNumber.setWrapText(true);
        csBodyColumnNumber.setDataFormat(datFmt.getFormat("#,##0"));
        csBodyColumnNumber.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumnNumber.setBorderRight(BorderStyle.MEDIUM);
        csBodyColumnNumber.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnNumber.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnNumber.setAlignment(HorizontalAlignment.CENTER);
        csBodyColumnNumber.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnNumber.setFont(font);

        csBodyColumnNumberBold = workbook.createCellStyle();
        csBodyColumnNumberBold.setWrapText(true);
        csBodyColumnNumberBold.setDataFormat(datFmt.getFormat("#,##0"));
        csBodyColumnNumberBold.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumnNumberBold.setBorderRight(BorderStyle.MEDIUM);
        csBodyColumnNumberBold.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnNumberBold.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnNumberBold.setAlignment(HorizontalAlignment.CENTER);
        csBodyColumnNumberBold.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnNumberBold.setFont(fontBold);

        csBodyColumnNumberLeft = workbook.createCellStyle();
        csBodyColumnNumberLeft.setWrapText(true);
        csBodyColumnNumberLeft.setDataFormat(datFmt.getFormat("#,##0"));
        csBodyColumnNumberLeft.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumnNumberLeft.setBorderRight(BorderStyle.MEDIUM);
        csBodyColumnNumberLeft.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnNumberLeft.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnNumberLeft.setAlignment(HorizontalAlignment.LEFT);
        csBodyColumnNumberLeft.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnNumberLeft.setFont(font);

        csBodyColumnNumberRight = workbook.createCellStyle();
        csBodyColumnNumberRight.setWrapText(true);
        csBodyColumnNumberRight.setDataFormat(datFmt.getFormat("#,##0"));
        csBodyColumnNumberRight.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumnNumberRight.setBorderRight(BorderStyle.MEDIUM);
        csBodyColumnNumberRight.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnNumberRight.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnNumberRight.setAlignment(HorizontalAlignment.RIGHT);
        csBodyColumnNumberRight.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnNumberRight.setFont(font);

        csBodyColumnNumberRightBold = workbook.createCellStyle();
        csBodyColumnNumberRightBold.setWrapText(true);
        csBodyColumnNumberRightBold.setDataFormat(datFmt.getFormat("#,##0"));
        csBodyColumnNumberRightBold.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumnNumberRightBold.setBorderRight(BorderStyle.MEDIUM);
        csBodyColumnNumberRightBold.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnNumberRightBold.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnNumberRightBold.setAlignment(HorizontalAlignment.RIGHT);
        csBodyColumnNumberRightBold.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnNumberRightBold.setFont(fontBold);

        csBodyColumnDoubleLeft = workbook.createCellStyle();
        csBodyColumnDoubleLeft.setWrapText(true);
        csBodyColumnDoubleLeft.setDataFormat(datFmt.getFormat("#,##0.00"));
        csBodyColumnDoubleLeft.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumnDoubleLeft.setBorderRight(BorderStyle.MEDIUM);
        csBodyColumnDoubleLeft.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnDoubleLeft.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnDoubleLeft.setAlignment(HorizontalAlignment.LEFT);
        csBodyColumnDoubleLeft.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnDoubleLeft.setFont(font);

        csBodyColumnDoubleRight = workbook.createCellStyle();
        csBodyColumnDoubleRight.setWrapText(true);
        csBodyColumnDoubleRight.setDataFormat(datFmt.getFormat("#,##0.00"));
        csBodyColumnDoubleRight.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumnDoubleRight.setBorderRight(BorderStyle.MEDIUM);
        csBodyColumnDoubleRight.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnDoubleRight.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnDoubleRight.setAlignment(HorizontalAlignment.RIGHT);
        csBodyColumnDoubleRight.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnDoubleRight.setFont(font);

        csBodyColumnDoubleRightBold = workbook.createCellStyle();
        csBodyColumnDoubleRightBold.setWrapText(true);
        csBodyColumnDoubleRightBold.setDataFormat(datFmt.getFormat("#,##0.00"));
        csBodyColumnDoubleRightBold.setBorderLeft(BorderStyle.MEDIUM);
        csBodyColumnDoubleRightBold.setBorderRight(BorderStyle.MEDIUM);
        csBodyColumnDoubleRightBold.setBorderTop(BorderStyle.MEDIUM);
        csBodyColumnDoubleRightBold.setBorderBottom(BorderStyle.MEDIUM);
        csBodyColumnDoubleRightBold.setAlignment(HorizontalAlignment.RIGHT);
        csBodyColumnDoubleRightBold.setVerticalAlignment(VerticalAlignment.CENTER);
        csBodyColumnDoubleRightBold.setFont(fontBold);

        csFooter = workbook.createCellStyle();
        csFooter.setWrapText(true);
        csFooter.setBorderLeft(BorderStyle.MEDIUM);
        csFooter.setBorderRight(BorderStyle.MEDIUM);
        csFooter.setBorderTop(BorderStyle.MEDIUM);
        csFooter.setBorderBottom(BorderStyle.MEDIUM);
        csFooter.setAlignment(HorizontalAlignment.CENTER);
        csFooter.setVerticalAlignment(VerticalAlignment.CENTER);
        csFooter.setFont(font);

        csFooterBold = workbook.createCellStyle();
        csFooterBold.setWrapText(true);
        csFooterBold.setBorderLeft(BorderStyle.MEDIUM);
        csFooterBold.setBorderRight(BorderStyle.MEDIUM);
        csFooterBold.setBorderTop(BorderStyle.MEDIUM);
        csFooterBold.setBorderBottom(BorderStyle.MEDIUM);
        csFooterBold.setAlignment(HorizontalAlignment.CENTER);
        csFooterBold.setVerticalAlignment(VerticalAlignment.CENTER);
        csFooterBold.setFont(fontBold);

        csNormal = workbook.createCellStyle();
        csNormal.setWrapText(true);
        csNormal.setFont(font);

        csNormalRight = workbook.createCellStyle();
        csNormalRight.setAlignment(HorizontalAlignment.RIGHT);
        csNormalRight.setWrapText(true);
        csNormalRight.setFont(font);

        csNormalLeft = workbook.createCellStyle();
        csNormalLeft.setAlignment(HorizontalAlignment.LEFT);
        csNormalLeft.setWrapText(true);
        csNormalLeft.setFont(font);

        csNormalBold = workbook.createCellStyle();
        csNormalBold.setWrapText(true);
        csNormalBold.setFont(fontBold);

        csNormalBoldRight = workbook.createCellStyle();
        csNormalBoldRight.setAlignment(HorizontalAlignment.RIGHT);
        csNormalBoldRight.setWrapText(true);
        csNormalBoldRight.setFont(fontBold);
    }

    public CellStyle csHeader() {
        return csHeader;
    }


    public String doubleToString(Double num) {
        if (num % 1.0 != 0) {
            return String.format("%1$,.2f", num);
        } else {
            return String.format("%1$,.0f", num);
        }
    }

    public String integerToString(Integer num) {
        return String.format("%,d", num);
    }
}
