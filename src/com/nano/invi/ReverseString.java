//package com.nano.invi;
//
//public class ReverseString {
//    public static void main(String[] args) {
//        String s = "tima234";
//        System.out.println(reverseOnlyAlphabets(s));
//    }
//
//    private static String reverseOnlyAlphabets(String s){
//        StringBuilder sb = new StringBuilder(s.length());
//        StringBuilder charString = new StringBuilder();
//        StringBuilder digitString = new StringBuilder();
//        for(char c : s.toCharArray()){
//            if(Character.isDigit(c))
//                digitString.append(c);
//            else
//                charString.append(c);
//        }
//        String str=charString.reverse().toString();
//        int j=0;
//        for(int i=0;i<s.length();i++){
//            if(Character.isDigit(s.charAt(i)))
//                sb.append(s.charAt(i));
//            else
//                sb.append(str.charAt(j++));
//        }
//        return sb.toString();
//    }
//
//    private static String reverseOnlyAlphabets1(String s){
//        StringBuilder sb = new StringBuilder(s.length());
//        StringBuilder charString = new StringBuilder();
//        StringBuilder digitString = new StringBuilder();
//        for(char c : s.toCharArray()){
//            if(Character.isDigit(c))
//                digitString.append(c);
//            else
//                charString.append(c);
//        }
//        String str=charString.reverse().toString();
//        int j=0;
//        for(int i=s.length()-1;i>=0;i--){
//            if(Character.isDigit(s.charAt(i)))
//                sb.append(s.charAt(i));
//            else
//                sb.append(str.charAt(j++));
//        }
//        return sb.toString();
//    }
//}
//
//
//@Controller
//class EmployeeController{
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @GetMapping("/employees")
//    public ResponseEntity<> getAllEmployees(){
//        ///
//        employeeService.getAllEmployees();
//    }
//}
//
//package pack
//procedure proc(int param1 IN, int param1 IN,int param3 OUT){
//            param3=param1+param2
//            return param3;
//        }