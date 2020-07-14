package com.example.security.configurations.validations.image;

import com.example.security.configurations.validations.ValidationCode;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @program: security
 * @description:
 * @author: yetin
 * @create: 2020-07-09 13:04
 **/
@Getter
@Setter
public class ImageCode extends ValidationCode {
    private BufferedImage image;


    public ImageCode(BufferedImage image, String code, int expireIn){
        super(code,expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireAt){
        super(code,expireAt);
        this.image = image;
    }

}
