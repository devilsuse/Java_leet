package com.nano.core;

public class OverrideSynchronisedMethod {
    SuperClass su = new SubClass();
    //SuperClass.show();
    //SubClass.show();
}

class SuperClass{
    protected void protectedMethod(){
        System.out.println("SuperClass: " + " protectedMethod" );
    }

    public synchronized void sync(){
        System.out.println("SuperClass: " + " synchronized void sync" );
    }

    public void unSync(){
        System.out.println("SuperClass: " + "unSync" );
    }
    public void publicMethod(){
    }

    Number getValue() { return 10; }
    static void show() {
        System.out.println("Parent static");
    }
}

class SubClass extends SuperClass{
    public void sync(){
    }

    public synchronized void unSync(){
    }

    //cannot reduce visibility of method being overriden
  //  private void publicMethod(){
  //  }

    // increasing visibility is fine
    public void protectedMethod(){
    }

    Integer getValue() { return 20; } // ✅ allowed (Integer is a subtype of Number)
    static void show() { // hides Parent.show()
        System.out.println("Child static");
}
