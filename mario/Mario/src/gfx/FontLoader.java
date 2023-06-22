package gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {
	public static Font loadFont(String path, float size){   

		try {
			InputStream is = FontLoader.class.getResourceAsStream(path);
			return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN,size);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
}
