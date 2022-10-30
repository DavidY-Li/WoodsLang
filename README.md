# WoodsLang

WoodsLang, dynamically typed, garbage collected language with C family style syntax.

Example code snippet:

```java
var superRandomNo = 123;
var theInput = double(input("Guess a number: "));

while (superRandomNo != theInput)
{
    if (theInput < superRandomNo)
    {
        print "Your input is too low.";
    }
    if (theInput > superRandomNo)
    {
        print "Your input is too high.";
    }

    theInput = double(input("Guess a number: "));
}

print "YAY you got it!";
```
