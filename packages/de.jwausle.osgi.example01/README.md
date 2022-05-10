# Example 01

## Optional vs Dynamic Import

> Class not found

```
g! dyn
gogo: ClassNotFoundException: de.jwausle.osgi.dynamicPackage.DynamicClass not found by de.jwausle.osgi.example01 [7]
g! opt
gogo: ClassNotFoundException: de.jwausle.osgi.optionalPackage.OptionalClass not found by de.jwausle.osgi.example01 [7]
g! 
```

## Manual install optionalPackage

```
g! install file:/Users/winter/Git/jwausle/01/de.jwausle.osgi.optionalPackage/target/de.jwausle.osgi.optionalPackage.jar
g! lb 
...
   ID|State      |Level|Name
    8|Installed  |    1|de.jwausle.osgi.optionalPackage (1.0.0.202205011144)|1.0.0.202205011144
g! start 8
g! opt
gogo: ClassNotFoundException: de.jwausle.osgi.optionalPackage.OptionalClass not found by de.jwausle.osgi.example01 [7]
```

## Manual install dynamicPackage

```
g! install file:/Users/winter/Git/jwausle/01/de.jwausle.osgi.dynamicPackage/target/de.jwausle.osgi.dynamicPackage.jar
Bundle ID: 9
g! lb
   ID|State      |Level|Name
    ...
    9|Installed  |    1|de.jwausle.osgi.dynamicPackage (1.0.0.202205011156)|1.0.0.202205011156

g! dyn
Load and instantiate - DynamicClass.String
g! lb
   ID|State      |Level|Name
    ...
    9|Resolved   |    1|de.jwausle.osgi.dynamicPackage (1.0.0.202205011156)|1.0.0.202205011156
g! 
```

## http://localhost:8888/system/console

> https://felix.apache.org/documentation/subprojects/apache-felix-web-console.html
