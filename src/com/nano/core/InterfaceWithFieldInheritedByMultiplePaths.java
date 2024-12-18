package com.nano.core;
/*
https://docs.oracle.com/javase/specs/jls/se8/html/jls-9.html
The rules for annotation modifiers on an interface field declaration are specified in §9.7.4 and §9.7.5.

Every field declaration in the body of an interface is implicitly public, static, and final. It is permitted to redundantly specify any or all of these modifiers for such fields.

It is a compile-time error if the same keyword appears more than once as a modifier for a field declaration.

If two or more (distinct) field modifiers appear in a field declaration, it is customary, though not required, that they appear in the order consistent with that shown above in the production for ConstantModifier.

The declared type of a field is denoted by UnannType if no bracket pairs appear in UnannType and VariableDeclaratorId, and is specified by §10.2 otherwise.

The scope and shadowing of an interface field declaration is specified in §6.3 and §6.4.

It is a compile-time error for the body of an interface declaration to declare two fields with the same name.

If the interface declares a field with a certain name, then the declaration of that field is said to hide any and all accessible declarations of fields with the same name in superinterfaces of the interface.

It is possible for an interface to inherit more than one field with the same name. Such a situation does not in itself cause a compile-time error. However, any attempt within the body of the interface to refer to any such field by its simple name will result in a compile-time error, because such a reference is ambiguous.

There might be several paths by which the same field declaration might be inherited from an interface. In such a situation, the field is considered to be inherited only once, and it may be referred to by its simple name without ambiguity.

Example 9.3-1. Ambiguous Inherited Fields

If two fields with the same name are inherited by an interface because, for example, two of its direct superinterfaces declare fields with that name, then a single ambiguous member results. Any use of this ambiguous member will result in a compile-time error. In the program:

interface BaseColors {
    int RED = 1, GREEN = 2, BLUE = 4;
}
interface RainbowColors extends BaseColors {
    int YELLOW = 3, ORANGE = 5, INDIGO = 6, VIOLET = 7;
}
interface PrintColors extends BaseColors {
    int YELLOW = 8, CYAN = 16, MAGENTA = 32;
}
interface LotsOfColors extends RainbowColors, PrintColors {
    int FUCHSIA = 17, VERMILION = 43, CHARTREUSE = RED+90;
}
the interface LotsOfColors inherits two fields named YELLOW. This is all right as long as the interface does not contain any reference by simple name to the field YELLOW. (Such a reference could occur within a variable initializer for a field.)

Even if interface PrintColors were to give the value 3 to YELLOW rather than the value 8, a reference to field YELLOW within interface LotsOfColors would still be considered ambiguous.


Example 9.3-2. Multiply Inherited Fields

If a single field is inherited multiple times from the same interface because, for example, both this interface and one of this interface's direct superinterfaces extend the interface that declares the field, then only a single member results. This situation does not in itself cause a compile-time error.

In the previous example, the fields RED, GREEN, and BLUE are inherited by interface LotsOfColors in more than one way, through interface RainbowColors and also through interface PrintColors, but the reference to field RED in interface LotsOfColors is not considered ambiguous because only one actual declaration of the field RED is involved.
*
 */
public class InterfaceWithFieldInheritedByMultiplePaths {
    public static void main(String[] args) {
        System.out.println(LotsOfColors.RED);
        //System.out.println(LotsOfColors.YELLOW); //This results into compile-time error as ref to YELLOW is ambiguous.
    }
}
interface BaseColors {
    int RED = 1, GREEN = 2, BLUE = 4;
}
interface RainbowColors extends BaseColors {
    int YELLOW = 3, ORANGE = 5, INDIGO = 6, VIOLET = 7;
}
interface PrintColors extends BaseColors {
    int YELLOW = 8, CYAN = 16, MAGENTA = 32;
}
interface LotsOfColors extends RainbowColors, PrintColors {
    int FUCHSIA = 17, VERMILION = 43, CHARTREUSE = RED+90;
}