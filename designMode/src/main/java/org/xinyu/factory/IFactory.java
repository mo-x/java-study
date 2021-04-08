package org.xinyu.factory;

/**
 * Created by zzqno on 2017-2-26.
 */
public interface IFactory {

     IProduct createProduct();
}

class Factory implements IFactory{

    @Override
    public IProduct createProduct() {
        return new Product();
    }


    public static void main(String[] args) {
        IFactory factory = new Factory();
        IProduct product = factory.createProduct();
        product.productMethod();
    }

}
