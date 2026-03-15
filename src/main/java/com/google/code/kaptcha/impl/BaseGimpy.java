package com.google.code.kaptcha.impl;

import com.google.code.kaptcha.GimpyEngine;
import com.google.code.kaptcha.NoiseProducer;
import com.google.code.kaptcha.util.Configurable;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 * base to an image.
 */
public class BaseGimpy extends Configurable implements GimpyEngine {
    @Override
    public BufferedImage getDistortedImage(BufferedImage baseImage) {
        NoiseProducer noiseProducer = this.getConfig().getNoiseImpl();
        // 创建一个与原图尺寸相同的空白图像
        BufferedImage distortedImage = new BufferedImage(baseImage.getWidth(), baseImage.getHeight(), 2);
        Graphics2D graphics = (Graphics2D)distortedImage.getGraphics();
        // 将原始的、未扭曲的验证码图像绘制到新创建的图像上
        graphics.drawImage(baseImage, 0, 0, null, null);
        // 释放图形资源
        graphics.dispose();
        return distortedImage;
    }
}