package font;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ArcFont {
    public ArcFont() {
    }

    /**
     * Arcaea中常用的字体（包括曲名，ptt等）
     * @param fontSize 字体大小
     * @return Font类型
     */
    public java.awt.Font getArcaeaFont(int fontSize){
        Font font = null;
        File file = new File("assets/font/Exo-Regular.ttf");
        try{
            font = Font.createFont(Font.TRUETYPE_FONT, file);
            font = font.deriveFont(Font.PLAIN, fontSize);
        } catch (FontFormatException | IOException e){
            return null;
        }
        return font;
    }

    /**
     * Arcaea中需翻译的字体（ui语言之类的）
     *
     * @param fontSize 字体大小
     * @return Font类型
     */
    public java.awt.Font getUIFont(int fontSize) {
        Font font = null;
        File file = new File("assets/font/NotoSansCJKsc-Regular.otf");

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, file);
            font = font.deriveFont(Font.PLAIN, fontSize);
        } catch (FontFormatException | IOException e) {
            return null;
        }
        return font;
    }
}