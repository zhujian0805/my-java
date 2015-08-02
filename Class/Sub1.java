 class Sub{
   Sub(){
    System.out.println("默认类:");
  }
   public void PublicTest(){
      System.out.println("public方法可以跨包访问");
    }
    protected void ProtectedTest(){
      System.out.println("protected方法可以被包内其他类访问，可以被包外子类访问");
    }
    void FriendlyTest(){
      System.out.println("默认方法只能包内访问");
    }      
    private void PrivateTest(){
    System.out.println("默认类独享的private方法");
  }
}
public class Sub1 {
     public Sub1(){
    System.out.println("public类:");
  }
public void PublicTest(){
  System.out.println("public方法可以跨包访问");
}
protected void ProtectedTest(){
  System.out.println("protected方法可以被包内其他类访问，可以被包外子类访问");
}
void FriendlyTest(){
  System.out.println("默认方法只能包内访问");
}
private void PrivateTest(){
  System.out.println("本类独享的private方法");
}public static void main(String[] args) {
  System.out.println("类内部private方法测试：");
  Sub1 s1=new Sub1();
  s1.PrivateTest();
  Sub s=new Sub();
  /* s.PrivateTest(); */
}
}
