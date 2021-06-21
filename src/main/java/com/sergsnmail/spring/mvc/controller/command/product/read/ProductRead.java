package com.sergsnmail.spring.mvc.controller.command.product.read;

import com.sergsnmail.spring.mvc.controller.command.Command;

public class ProductRead extends Command<ProductReadParam> {

    private ProductRead(ProductReadParam createParam) {
        this.parameter = createParam;
    }

    public static ReadBuilder builder () {
        return new ReadBuilder();
    }

    public static class ReadBuilder {
        private long id;

        public ReadBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public ProductRead build(){
            ProductReadParam readParam = new ProductReadParam();
            readParam.setId(this.id);
            return new ProductRead(readParam);
        }
    }

}
