package kr.co.sist;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

public class FontSingleton {
    static private FontSingleton fontSingleton;
    public Font bonGodic;

    private FontSingleton() {
        try {
            bonGodic = Font.createFont(Font.TRUETYPE_FONT, new File("./NotoSansKR-Regular.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(bonGodic);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            // 예외 처리
        }
        UIDefaults defaults = UIManager.getDefaults();
        for (Object key : defaults.keySet()) {
            if (defaults.get(key) instanceof Font) {
                Font defaultFont = (Font) defaults.get(key);
                defaults.put(key, bonGodic.deriveFont(defaultFont.getStyle(), defaultFont.getSize()));
            }
        }
    }

    static public FontSingleton getInstance() {
        if (fontSingleton == null) {
            fontSingleton = new FontSingleton();
        }

        return fontSingleton;
    }
}
