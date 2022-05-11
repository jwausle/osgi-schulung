# de.jwausle.osgi.api.consumer.v1


## Provider provide package

```
g! inspect cap osgi.wiring.package 5
g! inspect cap osgi.wiring.package 7
```

## Consumer require package

```
g! inspect req osgi.wiring.package 4
g! inspect req osgi.wiring.package 6
```

## Bundle Version provider.v2 = 3.0.0

> -manifest: ./META-INF/MANIFEST2.MF

```
g! inspect cap osgi.wiring.package 7
de.jwausle.osgi.api.provider.v2 [7] provides:
---------------------------------------------
osgi.wiring.package; de.jwausle.osgi.api.provider 1.0.1 required by:
   de.jwausle.osgi.api.consumer.v2 [6]
```

## Bundle Version provider.v2 package export  = 1.0.1

> > -manifest: ./META-INF/MANIFEST3.MF

```
g! inspect cap osgi.wiring.package 7
de.jwausle.osgi.api.provider.v2 [7] provides:
---------------------------------------------
osgi.wiring.package; de.jwausle.osgi.api.provider 1.0.1 required by:
   de.jwausle.osgi.api.consumer.v1 [4]
   de.jwausle.osgi.api.consumer.v2 [6]
```