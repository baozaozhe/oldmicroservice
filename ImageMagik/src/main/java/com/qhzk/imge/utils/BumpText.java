package com.qhzk.imge.utils;

/**
 * @description: 凹凸文本
 * @author: Mr.Muxl
 * @create: 2021-07-09 09:23
 *
 *     Uses either label or caption to create white text on a
 *     black background and determines the width and height of
 *     the textbox from that image
 *     Uses -shade to give a 3D effect to the text and makes the
 *     background of the text transparent
 *     Uses -colorize to adjust the blending color of the image
 *     Overlays the text image onto the colorized images at the desired location
 *     This is equivalent to the following IM commands for the label case.
 *
 * convert $infile -alpha off +repage -fill $color -colorize ${blendval}% $tmp1
 * ww=`echo "${size}x" | cut -dx -f1`
 * hh=`echo "${size}x" | cut -dx -f2`
 * convert -background black -fill white \
 *             -font $font -gravity center \
 *             -size ${ww}x ${mode}:"$text" -shade "$angles" $tmp2
 *             hh=`convert $tmp2 -ping -format "%h" info:`
 * grayval=`convert $tmp2[1x1+0+0] -format "%[fx:100*u.r]" info:`
 * convert $tmp1 \( $tmp2 -trim +repage -transparent "gray($grayval%)" \) \
 *             -gravity "$gravity" -geometry "$offsets" -compose modulate \
 *             -set option:compose:args $intensity -composite $outfile
 **/
public class BumpText {



}
