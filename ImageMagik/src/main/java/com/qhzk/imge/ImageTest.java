package com.qhzk.imge;

import com.qhzk.imge.service.ImageMagikService;
import com.qhzk.imge.service.impl.ImageMagikServiceImpl;
import com.qhzk.imge.utils.ProcessUtil;

/**
 * @description:
 * @author: Mr.Muxl
 * @create: 2021-07-06 14:03
 **/
public class ImageTest {
    /**
     * 命令执行工具
     */
    private static ProcessUtil processutil = new ProcessUtil();
    public static void main(String[] args) {

        ImageMagikService service = new ImageMagikServiceImpl();
        //转换图像格式
        //String commond = service.convertFormat("C:\\Users\\qhzk\\Pictures\\dx.png","C:\\Users\\qhzk\\Pictures\\dxj.jpg");

        //String commond = service.convertFormat("C:\\Users\\qhzk\\Pictures\\dx.png","C:\\Users\\qhzk\\Pictures\\dxj.jpg");

        /**
         * 加边框
         */
        //String commond = service.addborder("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmborder.png","6","6","#FF0000");
        /**
         * 模糊
         */
        //String commond = service.fuzzyImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmfruzzy.png","100");
        /**
         * 裁剪
         */
        //String commond = service.cropImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmcrop.png","32","32","16","16");
        /**
         * 翻转
         */
        //String commond = service.flipImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmflip.png",true);
        //String commond = service.flipImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmflip.png",false);
        /**
         * 旋转
         */
        //String commond = service.rotateImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmrotate.png","-60");
        /**
         * 图片质量
         */
        //String commond = service.qualityImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmquality.png","80");
        /**
         * 取反色
         */
        //String commond = service.inverseImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xminverse.png",true);
        /**
         * 灰度相反
         */
        //String commond = service.inverseImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xminverse1.png",false);
        /**
         * 单色  黑白
         */
        //String commond = service.monochromeImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmmonochrome.png");
        /**
         * 图像转油画
         */
        //String commond = service.paintImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmpaint.png","4");
        /**
         * 碳笔效果
         */
        //String commond = service.charcoalImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmcharcoal.png","4");
        /**
         * 漩涡效果
         */
        //String commond = service.swirlImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmswirl.png","100");
        /**
         * 凸起效果
         */
        //String commond = service.raiseImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmraise.png","40","40",true);
        /**
         * 加水印
         */
        //String commond = service.addwatermark("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmwatermark.png","C:\\Users\\qhzk\\Pictures\\watermark.png","ne");
        /**
         * 设置背景颜色
         */
        //String commond = service.setBackground("C:\\Users\\qhzk\\Pictures\\fh.png","C:\\Users\\qhzk\\Pictures\\fhBackground.jpg","#FF00CC");
        /**
         * 自动裁剪
         */
        //String commond = service.autocropImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\lalaautocrop.png");

        /**
         * 亮度、饱和度和色相
         */
        //String commond = service.setBrightnessSaturationHue("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmBrightnessSaturationHue.png","150","100","100");
        /**
         * 锐化
         */
        //String commond = service.sharpenImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmsharpen.png","30");
        /**
         * 散射毛玻璃效果
         */
        //String commond = service.spreadImage("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmspread.png","30");
        /**
         * 合成
         */
        //String commond = service.fotoMix("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\watermark.png","C:\\Users\\qhzk\\Pictures\\xmfotoMix.png","150","210");
        /**
         * 透视  至少需要4组坐标（8个点，16个数字）
         */
        //String commond = service.imagePerspective("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmimagePerspective.png","0,0,0,8 0,390,132,323 558,390,558,265 558,0,400,0");
        /**
         * 复古
         */
        String commond = service.imageRetroStyle("C:\\Users\\qhzk\\Pictures\\xm.png","C:\\Users\\qhzk\\Pictures\\xmRetroStyle.png","60");
        try{
            int execute = processutil.execute(commond);
            if(execute == 0){
                System.out.println("成功");
            }else{
                System.out.println("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
