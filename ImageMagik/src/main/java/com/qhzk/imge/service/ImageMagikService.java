package com.qhzk.imge.service;

/**
 * @description: ImageMagik方法类
 * @author: Mr.Muxl
 * @create: 2021-07-06 10:17
 **/
public interface ImageMagikService {
    /**
     * 转换图像格式
     */
    public String convertFormat(String sourcepath,String tagetpath);
    /**
     * 图像尺寸操作
     */
    public  String resizeImage(String sourcepath,String tagetpath,String size1,String size2,boolean ispercent);
    /**
     * 加边框
     */
    public  String addborder(String sourcepath,String tagetpath,String size1,String size2,String color);
    /**
     * 锐化
     */
    public String sharpenImage(String sourcepath,String tagetpath,String level);
    /**
     * 模糊
     */
    public String fuzzyImage(String sourcepath,String tagetpath,String foglevel);
    /**
     * 裁剪
     */
    public  String cropImage(String sourcepath,String tagetpath,String width,String height,String left,String top);

    /**
     * 自动裁剪
     */
    public  String autocropImage(String sourcepath,String tagetpath);
    /**
     * 翻转
     */
    public  String flipImage(String sourcepath,String tagetpath,boolean isflop);
    /**
     * 旋转
     */
    public String rotateImage(String sourcepath,String tagetpath,String degree);
    /**
     * 图片质量
     */
    public  String qualityImage(String sourcepath,String tagetpath,String degree);

    /**
     * 图片反色
     */
    public  String inverseImage(String sourcepath,String tagetpath,boolean isinverse);
    /**
     * 单色  黑白
     */
    public  String monochromeImage(String sourcepath,String tagetpath);

    /**
     * 图像转油画
     */
    public  String paintImage(String sourcepath,String tagetpath,String degree);
    /**
     * 碳笔效果
     */
    public  String charcoalImage(String sourcepath,String tagetpath,String degree);

    /**
     * 漩涡效果
     */
    public  String swirlImage(String sourcepath,String tagetpath,String degree);
    /**
     * 凸起效果
     */
    public  String raiseImage(String sourcepath,String tagetpath,String cross,String vertical,boolean isonraise);
    /**
     * 加水印
     */
    public  String addwatermark(String sourcepath,String tagetpath,String watermarkpath,String location);
    /**
     * 设置背景颜色
     */
    public  String setBackground(String sourcepath,String tagetpath,String rgb);

    /**
     * 亮度、饱和度和色相
     */
    public  String setBrightnessSaturationHue(String sourcepath,String tagetpath,String brightness,String saturation,String hue);
    /**
     * 散射毛玻璃效果
     */
    public  String spreadImage(String sourcepath,String tagetpath,String level);
    /**
     * 图片合成
     */
    public  String fotoMix(String bgpath,String tpath,String tagetpath,String left,String top);
    /**
     * 透视
     */
    public  String imagePerspective(String sourcepath,String tagetpath,String bitmap);
    /**
     * 复古
     */
    public  String imageRetroStyle(String sourcepath,String tagetpath,String level);

}
