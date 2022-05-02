package com.xkx.bookmanager.util;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.util.StringUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class barCodeUtil {

    public static void getBarCode(String msg, String path) {
        try {
            File file = new File(path);
            OutputStream ous = new FileOutputStream(file);
            if (StringUtils.isEmpty(msg) || ous == null)
                return;
            //选择条形码类型(好多类型可供选择)
            Code128Bean bean = new Code128Bean();
            //设置长宽
            final double moduleWidth = 0.20;
            final int resolution = 150;
            bean.setModuleWidth(moduleWidth);
            bean.doQuietZone(false);
            String format = "image/png";
            // 输出流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous, format,
                    resolution, BufferedImage.TYPE_BYTE_BINARY, false, 0);
            //生成条码
            bean.generateBarcode(canvas, msg);
            canvas.finish();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
