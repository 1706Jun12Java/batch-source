����   4 �  calculator/ScannerTest  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lcalculator/ScannerTest; main ([Ljava/lang/String;)V	    java/lang/System   out Ljava/io/PrintStream;  'Enter your numeric type and two numbers
    java/io/PrintStream   println (Ljava/lang/String;)V  java/util/Scanner	  ! " # in Ljava/io/InputStream;
  %  & (Ljava/io/InputStream;)V
  ( ) * next ()Ljava/lang/String;
  , - . convert 9(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
  0 1  close args [Ljava/lang/String; s Ljava/util/Scanner;
 7 9 8 java/lang/String : ; hashCode ()I = double
 7 ? @ A equals (Ljava/lang/Object;)Z C int E byte G long I float K short
 M O N java/lang/Byte P Q 	parseByte (Ljava/lang/String;)B
  S  T (I)V
 V X W java/lang/Short Y Z 
parseShort (Ljava/lang/String;)S
 \ ^ ] java/lang/Integer _ ` parseInt (Ljava/lang/String;)I
 b d c java/lang/Long e f 	parseLong (Ljava/lang/String;)J
  h  i (J)V
 k m l java/lang/Float n o 
parseFloat (Ljava/lang/String;)F
  q  r (F)V
 t v u java/lang/Double w x parseDouble (Ljava/lang/String;)D
  z  { (D)V a1 Ljava/lang/String; a2 a3 b2 B b3 s2 S s3 i2 I i3 l2 J l3 f2 F f3 d2 D d3 StackMapTable 
SourceFile ScannerTest.java !               /     *� �    
                    	       k     '� � � Y�  � $L+� '+� '+� '� ++� /�    
           	 " 
 &         ' 2 3     4 5  	 - .    T    "*YN� 6�      ��{�   : ��   F .a   R 2�|   ^�"\   j��|   v-<� >� ħ �-B� >� j� �-D� >� *� �-F� >� l� �-H� >� z� �-J� >�  � �+� L6,� L6� `� R� �+� U6,� U6� `� R� h+� [6,� [6	� 	`� R� N+� a7
,� a7� 
a� g� 4+� j8,� j8� b� p� +� s9,� s9� c� y�    
   f     �  �  �  �  �  �  �  �  �  �  �  �   � " � # � $ � % � ' � ( � ) *
 , - .! 3    �   " | }    " ~ }   "  }  �  � �  �  � �  �  � �  �  � �  �  � �  �  � � 	 �  � � 
 �  � �  �  � �  �  � �   � �   � �  �    � @ 7�   �    �