package com.qhzk.imge.service.impl;

import com.qhzk.imge.service.ImageMagikService;
import com.qhzk.imge.utils.Composite;
import com.qhzk.imge.utils.Convert;
import com.qhzk.imge.utils.IMOperation;

/**
 * @description: ImageMagik具体逻辑类
 * @author: Mr.Muxl
 * @create: 2021-07-06 11:00
 **/
public class ImageMagikServiceImpl implements ImageMagikService {
    /**
     * 命令
     */
    private String magick = IMOperation.MAGICK;
    private String blank = IMOperation.BLANK;
    private String convert = IMOperation.CONVERT;
    private String composite = IMOperation.COMPOSITE;
    private String quotes = IMOperation.QUOTES;
    private String doublequotes = IMOperation.DOUBLEQUOTES;
    private String X = IMOperation.X;
    private String percent = IMOperation.PERCENT;
    private String add = IMOperation.ADD;
    private String sub = IMOperation.SUB;
    private String dot = IMOperation.DOT;

    private String resize = Convert.RESIZE;
    private String border = Convert.BORDER;
    private String bordercolor = Convert.BORDERCOLOR;
    private String rose = Convert.ROSE;
    private String blur = Convert.BLUR;
    private String crop = Convert.CROP;
    private String flip = Convert.FLIP;
    private String flop = Convert.FLOP;
    private String rotate = Convert.ROTATE;
    private String quality = Convert.QUALITY;
    private String negate = Convert.NEGATE;
    private String monochrome = Convert.MONOCHROME;
    private String paint = Convert.PAINT;
    private String charcoal = Convert.CHARCOAL;
    private String swirl = Convert.SWIRL;
    private String raise = Convert.RAISE;
    private String background = Convert.BACKGROUND;
    private String flatten = Convert.FLATTEN;
    private String trim = Convert.TRIM;
    private String modulate = Convert.MODULATE;
    private String sharpen = Convert.SHARPEN;
    private String spread = Convert.SPREAD;
    private String geometry = Convert.GEOMETRY;
    private String ccomposite = Convert.COMPOSITE;
    private String vtdp = Convert.VTDP;
    private String sepiatone = Convert.SEPIATONE;

    private String gravity = Composite.GRAVITY;
    private String southwest = Composite.SOUTHWEST;
    private String southeast = Composite.SOUTHEAST;
    private String northwest = Composite.NORTHWEST;
    private String northeast = Composite.NORTHEAST;
    private String south = Composite.SOUTH;
    private String west = Composite.WEST;
    private String north = Composite.NORTH;
    private String east = Composite.EAST;
    private String center = Composite.CENTER;
    private String composeplus = Composite.COMPOSEPLUS;

    @Override
    public String convertFormat(String sourcepath, String tagetpath) {
        if(null == sourcepath||"".equals(sourcepath)||null == tagetpath||"".equals(tagetpath)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
               .append(convert).append(blank)
               .append(sourcepath).append(blank)
               .append(tagetpath);
        return commond.toString();
    }

    @Override
    public String resizeImage(String sourcepath, String tagetpath,String size1,String size2,boolean ispercent) {
        if(null == sourcepath||"".equals(sourcepath)||null == tagetpath||"".equals(tagetpath)
                ||null == size1||"".equals(size1)||null == size2||"".equals(size2)){
            return "";
        }
        String precent = "";
        if(ispercent){
            precent = percent;
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(resize).append(blank)
                .append(size1).append(precent)
                .append(X)
                .append(size2).append(precent).append(blank)
                .append(sourcepath).append(blank)
                .append(tagetpath);
        return commond.toString();
    }

    @Override
    public String addborder(String sourcepath, String tagetpath, String size1, String size2,String color) {
        if(null == sourcepath||"".equals(sourcepath)||null == tagetpath||"".equals(tagetpath)
                ||null == size1||"".equals(size1)||null == size2||"".equals(size2)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(bordercolor).append(blank)
                .append(doublequotes).append(color).append(doublequotes).append(blank)
                .append(border).append(blank)
                .append(size1).append(X).append(size2).append(blank)
                .append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String sharpenImage(String sourcepath, String tagetpath, String level) {
        if(null == sourcepath||"".equals(sourcepath)||null == tagetpath||"".equals(tagetpath)
                ||null == level||"".equals(level)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(sourcepath).append(blank)
                .append(sharpen).append(blank)
                .append(level).append(blank)
                .append(tagetpath);
        return commond.toString();
    }

    @Override
    public String fuzzyImage(String sourcepath, String tagetpath, String foglevel) {
        if(null == sourcepath||"".equals(sourcepath)||null == tagetpath||"".equals(tagetpath)
                ||null == foglevel||"".equals(foglevel)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(blur).append(blank)
                .append(foglevel).append(blank)
                .append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String cropImage(String sourcepath,String tagetpath, String width, String height, String left, String top) {
        if(null == sourcepath||"".equals(sourcepath)||null == left||"".equals(left)
                ||null == top||"".equals(top)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(sourcepath).append(blank)
                .append(crop).append(blank)
                .append(width).append(X).append(height).append(add).append(left).append(add).append(top).append(blank)
                .append(tagetpath);
        return commond.toString();
    }

    @Override
    public String autocropImage(String sourcepath, String tagetpath) {
        if(null == sourcepath||"".equals(sourcepath)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(sourcepath).append(blank)
                .append(trim).append(blank)
                .append(tagetpath);
        return commond.toString();
    }

    @Override
    public String flipImage(String sourcepath, String tagetpath, boolean isflop) {
        if(null == sourcepath||"".equals(sourcepath)){
            return "";
        }
        String flips = flip;
        if(isflop){
            flips = flop;
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(flips).append(blank)
                .append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String rotateImage(String sourcepath, String tagetpath, String degree) {
        if(null == sourcepath||"".equals(sourcepath)||null == degree||"".equals(degree)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(rotate).append(blank)
                .append(degree).append(blank)
                .append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String qualityImage(String sourcepath, String tagetpath, String degree) {
        if(null == sourcepath||"".equals(sourcepath)||null == degree||"".equals(degree)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(quality).append(blank)
                .append(degree).append(blank)
                .append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String inverseImage(String sourcepath, String tagetpath, boolean isinverse) {
        if(null == sourcepath||"".equals(sourcepath)){
            return "";
        }
        String degree =add;
        if(isinverse){
            degree = sub;
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(degree)
                .append(negate).append(blank)
                .append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String monochromeImage(String sourcepath, String tagetpath) {
        if(null == sourcepath||"".equals(sourcepath)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(monochrome).append(blank)
                .append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String paintImage(String sourcepath, String tagetpath, String degree) {
        if(null == sourcepath||"".equals(sourcepath)||null == degree||"".equals(degree)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(paint).append(blank)
                .append(degree).append(blank)
                .append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String charcoalImage(String sourcepath, String tagetpath, String degree) {
        if(null == sourcepath||"".equals(sourcepath)||null == degree||"".equals(degree)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(charcoal).append(blank)
                .append(degree).append(blank)
                .append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String swirlImage(String sourcepath, String tagetpath, String degree) {
        if(null == sourcepath||"".equals(sourcepath)||null == degree||"".equals(degree)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(swirl).append(blank)
                .append(degree).append(blank)
                .append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String raiseImage(String sourcepath, String tagetpath, String cross, String vertical, boolean isonraise) {
        if(null == sourcepath||"".equals(sourcepath)||null == tagetpath||"".equals(tagetpath)
                ||null == cross||"".equals(cross)||null == vertical||"".equals(vertical)){
            return "";
        }
        String raiseflag = sub;
        if(isonraise){
            raiseflag= add;
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(raiseflag)
                .append(raise).append(blank)
                .append(cross).append(X).append(vertical).append(blank)
                .append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String addwatermark(String sourcepath, String tagetpath, String watermarkpath, String location) {
        if(null == sourcepath||"".equals(sourcepath)||null == tagetpath||"".equals(tagetpath)
                ||null == watermarkpath||"".equals(watermarkpath)||null == location||"".equals(location)){
            return "";
        }
        String locationflag = center;

        if("c".equals(location)){//居中
            locationflag= center;
        }
        if("sw".equals(location)){//左下
            locationflag= southwest;
        }
        if("se".equals(location)){//右下
            locationflag= southeast;
        }
        if("nw".equals(location)){//左上
            locationflag= northwest;
        }
        if("ne".equals(location)){//右上
            locationflag= northeast;
        }
        if("s".equals(location)){//底部居中
            locationflag= south;
        }
        if("w".equals(location)){//左侧居中
            locationflag= west;
        }
        if("n".equals(location)){//顶部居中
            locationflag= north;
        }
        if("e".equals(location)){//右侧居中
            locationflag= east;
        }

        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(composite).append(blank)
                .append(gravity).append(blank)
                .append(locationflag).append(blank)
                .append(composeplus).append(blank)
                .append(watermarkpath).append(blank).append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String setBackground(String sourcepath, String tagetpath, String rgb) {
        if(null == sourcepath||"".equals(sourcepath)||null == tagetpath||"".equals(tagetpath)){
            return "";
        }
        String rgbcolor = rgb;
        if("".equals(rgbcolor)){
            rgbcolor= "none";
        }

        String comma = "";
        if (System.getProperty("os.name").toUpperCase().contains("WIN")) {
            comma =doublequotes;
        } else {
            comma =quotes;
        }

        if("none".equals(rgbcolor)){
            comma = "";
        }

        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(sourcepath).append(blank)
                .append(background).append(blank)
                .append(comma).append(rgbcolor).append(comma).append(blank)
                .append(flatten).append(blank)
                .append(tagetpath);
        return commond.toString();
    }

    @Override
    public String setBrightnessSaturationHue(String sourcepath, String tagetpath, String brightness, String saturation, String hue) {
        if(null == sourcepath||"".equals(sourcepath)||null == tagetpath||"".equals(tagetpath)
                ||null == brightness||"".equals(brightness)||null == saturation||"".equals(saturation)||null == hue||"".equals(hue)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(sourcepath).append(blank)
                .append(modulate).append(blank)
                .append(brightness).append(dot)
                .append(saturation).append(dot)
                .append(hue).append(blank)
                .append(tagetpath);
        return commond.toString();
    }

    @Override
    public String spreadImage(String sourcepath, String tagetpath, String level) {
        if(null == sourcepath||"".equals(sourcepath)||null == tagetpath||"".equals(tagetpath)||null == level||"".equals(level)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(spread).append(blank)
                .append(level).append(blank)
                .append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String fotoMix(String sourcepath1, String sourcepath2, String tagetpath, String left, String top) {
        if(null == sourcepath1||"".equals(sourcepath1)||null == sourcepath2||"".equals(sourcepath2)
                ||null == tagetpath||"".equals(tagetpath)||null == left||"".equals(left)||null == top||"".equals(top)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(sourcepath1).append(blank)
                .append(sourcepath2).append(blank)
                .append(geometry).append(blank)
                .append(add).append(left).append(add).append(top).append(blank)
                .append(ccomposite).append(blank)
                .append(tagetpath);
        return commond.toString();
    }

    @Override
    public String imagePerspective(String sourcepath, String tagetpath, String bitmap) {
        if(null == sourcepath||"".equals(sourcepath)||null == tagetpath||"".equals(tagetpath)||null == bitmap||"".equals(bitmap)){
            return "";
        }
        String comma = "";
        if (System.getProperty("os.name").toUpperCase().contains("WIN")) {
            comma =doublequotes;
        } else {
            comma =quotes;
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(vtdp).append(blank)
                .append(comma).append(bitmap).append(comma).append(blank)
                .append(sourcepath).append(blank).append(tagetpath);
        return commond.toString();
    }

    @Override
    public String imageRetroStyle(String sourcepath, String tagetpath, String level) {
        if(null == sourcepath||"".equals(sourcepath)||null == tagetpath||"".equals(tagetpath)||null == level||"".equals(level)){
            return "";
        }
        StringBuffer commond = new StringBuffer();
        commond.append(magick).append(blank)
                .append(convert).append(blank)
                .append(sourcepath).append(blank)
                .append(sepiatone).append(blank)
                .append(level).append(percent).append(blank)
                .append(tagetpath);
        return commond.toString();
    }
}
