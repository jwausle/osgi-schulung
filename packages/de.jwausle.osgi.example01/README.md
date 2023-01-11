# Example 01

## Optional vs Dynamic Import > Class not found

> Run: bndrun-default.bndrun

```
g! dyn
gogo: ClassNotFoundException: de.jwausle.osgi.dynamicPackage.DynamicClass not found by de.jwausle.osgi.example01 [7]
g! opt
gogo: ClassNotFoundException: de.jwausle.osgi.optionalPackage.OptionalClass not found by de.jwausle.osgi.example01 [7]
g! 
```

## Manual install optionalPackage

> Run: bndrun-default.bndrun

```
g! install file:./../de.jwausle.osgi.optionalPackage/target/de.jwausle.osgi.optionalPackage.jar
g! lb 
...
   ID|State      |Level|Name
    14|Installed  |    1|de.jwausle.osgi.optionalPackage (1.0.0.202205011144)|1.0.0.202205011144
g! start 14
g! opt
gogo: ClassNotFoundException: de.jwausle.osgi.optionalPackage.OptionalClass not found by de.jwausle.osgi.example01 [7]

g! refresh 13
g! opt
Load and instantiate - OptionalClass.toString

g! inspect req osgi.wiring.package 13
de.jwausle.osgi.example01 [13] requires:
----------------------------------------
osgi.wiring.package; (osgi.wiring.package=de.jwausle.osgi.optionalPackage) resolved by:
   osgi.wiring.package; de.jwausle.osgi.optionalPackage 1.0.0 from de.jwausle.osgi.optionalPackage [14]
osgi.wiring.package; (osgi.wiring.package=de.jwausle.osgi.dynamicPackage) [UNRESOLVED]

g! inspect cap osgi.wiring.package 14
de.jwausle.osgi.optionalPackage [14] provides:
----------------------------------------------
osgi.wiring.package; de.jwausle.osgi.optionalPackage 1.0.0 required by:
   de.jwausle.osgi.example01 [13]
```

> Run: bndrun-opt.bndrun


## Manual install dynamicPackage

> Run: bndrun-default.bndrun

```
g! dyn
gogo: ClassNotFoundException: de.jwausle.osgi.dynamicPackage.DynamicClass not found by de.jwausle.osgi.example01 [13]

g! install file:../de.jwausle.osgi.dynamicPackage/target/de.jwausle.osgi.dynamicPackage.jar
Bundle ID: 14
g! lb
   ID|State      |Level|Name
    ...
    14|Installed  |    1|de.jwausle.osgi.dynamicPackage (1.0.0.202205011156)|1.0.0.202205011156

g! start 14    

g! dyn
Load and instantiate - DynamicClass.String
g! lb
   ID|State      |Level|Name
    ...
    14|Resolved   |    1|de.jwausle.osgi.dynamicPackage (1.0.0.202205011156)|1.0.0.202205011156

g! inspect req osgi.wiring.package 13
de.jwausle.osgi.example01 [13] requires:
----------------------------------------
osgi.wiring.package; (osgi.wiring.package=de.jwausle.osgi.dynamicPackage) [UNRESOLVED]

g! inspect cap osgi.wiring.package 14
de.jwausle.osgi.dynamicPackage [14] provides:
---------------------------------------------
osgi.wiring.package; de.jwausle.osgi.dynamicPackage 1.0.0 [UNUSED]
```

> Run: bndrun-dyn.bndrun

## Uninstall is not working as expected

> Run: bndrun-opt-dyn.bndrun

```
g! lb
START LEVEL 1
   ID|State      |Level|Name
   ...
   13|Active     |    1|de.jwausle.osgi.example01 (1.0.0.202301112055)|1.0.0.202301112055
   14|Active     |    1|de.jwausle.osgi.optionalPackage (1.0.0.202301112043)|1.0.0.202301112043
   15|Active     |    1|de.jwausle.osgi.dynamicPackage (1.0.0.202301112046)|1.0.0.202301112046

g! opt
Load and instantiate - OptionalClass.toString
Call - 29

g! dyn
Load and instantiate - DynamicClass.String
Call - 29

g! uninstall 14
g! uninstall 15

g! lb
START LEVEL 1
   ID|State      |Level|Name
   ...
   13|Active     |    1|de.jwausle.osgi.example01 (1.0.0.202301112055)|1.0.0.202301112055

g! opt 
?
g! dyn
?    
```

> Surprise - but it's not promised (depends on the container runtime)

## http://localhost:8888/system/console

> https://felix.apache.org/documentation/subprojects/apache-felix-web-console.html

User: admin, Password: admin
