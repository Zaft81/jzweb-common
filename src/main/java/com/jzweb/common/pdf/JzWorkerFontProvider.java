package com.jzweb.common.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.jzweb.common.utils.SystemPath;

/**
 * @author Ryan
 * @version 1.0
 * @date 12/29/2019
 */
public class JzWorkerFontProvider extends XMLWorkerFontProvider {
    //记得将宋体字体复制到服务器指定路径下
    private static final String WIN_FONT_SIMSUN = "C:/Windows/Fonts/SimSun.ttc";
    private static final String LINUX_FONT_SIMSUN = "";

    /**
     * 自定义字体，注意服务器和本地的字体文件路径
     */
    @Override
    public Font getFont(final String fontname, final String encoding, final boolean embedded, final float size,
                        final int style, final BaseColor color) {
        if(SystemPath.isWindowOS()) {
            registerFamily("SimSun", encoding, WIN_FONT_SIMSUN);
        }else {
            registerFamily("SimSun", encoding, LINUX_FONT_SIMSUN);
        }

        return super.getFont("SimSun", encoding, size, style);
    }
}
