package com.sergsnmail.spring.mvc.controller.command.product.delete;

import com.sergsnmail.spring.mvc.controller.command.Command;

public class ProductDelete extends Command<ProductDeleteParam> {

    private ProductDelete(ProductDeleteParam deleteParam) {
        this.parameter = deleteParam;
    }

    public static DeleteBuilder builder () {
        return new DeleteBuilder();
    }

    public static class DeleteBuilder {
        private long id;

        public DeleteBuilder setId(long id) {
            this.id = id;
            return this;
        }


        public ProductDelete build(){
            ProductDeleteParam deleteParam = new ProductDeleteParam();
            deleteParam.setId(this.id);
            return new ProductDelete(deleteParam);
        }
    }
}
