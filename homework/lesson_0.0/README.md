Напишите класс `BitwiseCalc` и реализуйте следующие методы:

```java
public static String and(String binaryLeft, String binaryRight)
public static String or(String binaryLeft, String binaryRight)
public static String xor(String binaryLeft, String binaryRight)
public static String not(String binary)
```
---
Напишите класс `ArraysCopier` с конструктором, который принимает массив целых чисел в качестве параметра. Добавьте и реализуйте следующие методы:

```java
public int[] copyOf(int newLength) // возвращает новый массив указанной длины.
public int[] copyOfRange(int from, int to) // возвращает новый массив начиная с элемента from до элемента to
public int[] fill(int value) // возвращает новый массив заполненный значением параметра value
```

В случае неверных значений параметров, возвращайте `null`
