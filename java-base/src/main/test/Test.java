import org.goskyer.base.lambda.BestFinder;

public class Test {

  @org.junit.Test
  public void findPrices() {
    BestFinder bestFinder = new BestFinder();
    long st = System.currentTimeMillis();
    System.out.println(bestFinder.findPrices("iPhonX"));
    System.out.println("done : " + (System.currentTimeMillis() - st) + "msecs");
  }

  @org.junit.Test
  public void findPricesParallel() {
    BestFinder bestFinder = new BestFinder();
    long st = System.currentTimeMillis();
    System.out.println(bestFinder.findPricesParallel("iPhonX"));
    System.out.println("done : " + (System.currentTimeMillis() - st) + "msecs");
  }

  @org.junit.Test
  public void findPricesAsync() {
    BestFinder bestFinder = new BestFinder();
    long st = System.currentTimeMillis();
    System.out.println(bestFinder.findPricesAsync("iPhonX"));
    System.out.println("done : " + (System.currentTimeMillis() - st) + "msecs");
  }

  public static void main(String[] args) {
    //
    Test test = new Test();
    test.findPrices();
    test.findPricesAsync();
    test.findPricesParallel();
  }
}
