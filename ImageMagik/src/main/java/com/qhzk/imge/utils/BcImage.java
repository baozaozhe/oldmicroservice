package com.qhzk.imge.utils;

/**
 * @description: 更改图像的亮度和/或对比度
 * @author: Mr.Muxl
 * @create: 2021-07-09 09:41
 *
 * Separates the RBG image into HSB channels and saves the Saturation channel
 * Convert the slope (1.121) and intercept (-.166) into break points (0,0 14,0 100,95)
 * Convert the break points into a LUT image
 * Applies the LUT image to each RGB channel
 * Separates the new RBG image into HSB channels
 * Applies a gamma of 1.409 to the new Saturation channel.
 * Merges the Hue, Saturation and Brightness channels back as an RBG image.
 *          This is equivalent to the following IM commands:
 * convert lena_poor.jpg -colorspace RGB tmp0.jpg
 * convert tmp0.jpg tmplut.jpg -clut tmp0p.jpg
 * convert tmp0p.jpg -colorspace $colormodel -channel R -separate tmp1.jpg
 * convert tmp0p.jpg -colorspace $colormodel -channel G -separate tmp2.jpg
 * convert tmp0p.jpg -colorspace $colormodel -channel B -separate tmp3.jpg
 * convert tmp2.jpg -gamma 1.409 tmp2p.jpg
 * convert tmp0.jpg -colorspace HSB tmp1.jpg -compose CopyRed -composite \
 * tmp2p.jpg -compose CopyGreen -composite tmp3.jpg -compose CopyBlue -composite \
 * -colorspace RGB lena_b-10_c10_s30.jpg
 **/
public class BcImage {
}
