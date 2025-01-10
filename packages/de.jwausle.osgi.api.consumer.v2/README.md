# de.jwausle.osgi.api.consumer.v1

* 2 static bundles `provider.v1(1.0.0) and this consumer.v2(2.0.0) and
* 1 variable bundle `provider.v2(2.0.0 | 3.0.0 | 1.0.0) to 
demonstrate different package wiring.

```
      +-------------+          +-------------+                           
      |p.v1         |          | c.v1        |                           
      |+ api=1.0.0  |          | - api=[1,2) |                           
      +-------------+          |             |                           
      +-------------+          +-------------+                           
      |p.v2         |          +-------------+                           
      +-------------+          | c.v2        |                           
  M   |+ api=2.0.0  |          | - api=[2,3) |                           
      +-------------+          |             |                           
  M1  |+ api=''     |          +-------------+                           
      +-------------+                                                    
  M2  |+ api=3.0.0  |                                                    
      +-------------+                                                   -
  M3  |+ api=1.0.1  |                                                    
      +-------------+                                                    
  M4  |+ api=1.0.1  |                                                    
      +-------------+      
```

> -manifest: provider.v2/META-INF/MANIFEST.MF (export 2.0)

## Provider provide package

> consumer.v2/bnd.bndrun

```
g! inspect cap osgi.wiring.package 5 # p.v1 -> c.v1
g! inspect cap osgi.wiring.package 7 # p.v2 -> c.v2
```

## Consumer require package

> consumer.v2/bnd.bndrun

```
g! inspect req osgi.wiring.package 4 # c.v1 -> p.v1
g! inspect req osgi.wiring.package 6 # c.v2 -> p.v2
```

## Bundle Version provider.v2 = ''

> -manifest: provider.v2/META-INF/MANIFEST1.MF

Consumer v1,v2 wire provider.v1.


## Bundle Version provider.v2 = 3.0.0

> -manifest: provider.v2/META-INF/MANIFEST2.MF

> consumer.v2/bnd.bndrun

```
g! inspect cap osgi.wiring.package 7
de.jwausle.osgi.api.provider.v2 [7] provides:
---------------------------------------------
osgi.wiring.package; de.jwausle.osgi.api.provider 3.0.0 required by:
   de.jwausle.osgi.api.consumer.v2 [6]
```

## Bundle Version provider.v2 package export  = 1.0.1

> -manifest: provider.v2/META-INF/MANIFEST3.MF

> consumer.v2/bnd.bndrun

```
g! inspect cap osgi.wiring.package 7
de.jwausle.osgi.api.provider.v2 [7] provides:
---------------------------------------------
osgi.wiring.package; de.jwausle.osgi.api.provider 1.0.1 required by:
   de.jwausle.osgi.api.consumer.v1 [4]
   de.jwausle.osgi.api.consumer.v2 [6]
```