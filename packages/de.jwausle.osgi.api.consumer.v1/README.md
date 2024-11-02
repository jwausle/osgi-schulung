# de.jwausle.osgi.api.consumer.v1

Control bundle start order with framework and bundle level.

## Bundle start level (Default)

> bnd-sl-default.bndrun

* `frameworklevel` --> 1
* `bundlelevel 0` --> 0
* `bundlelevel 1` --> 1

## Bundle start level

> bnd-sl-default-3.bndrun

```
g! lb
START LEVEL 2
   ID|State      |Level|Name
    0|Active     |    0|System Bundle (6.0.3)|6.0.3
    1|Active     |    2|Apache Felix Gogo Command (1.1.0)|1.1.0
    2|Active     |    2|Apache Felix Gogo Runtime (1.1.2)|1.1.2
    3|Active     |    2|Apache Felix Gogo Shell (1.1.2)|1.1.2
    4|Resolved   |    3|de.jwausle.osgi.api.consumer.v1 (1.0.0.202301112210)|1.0.0.202301112210
    5|Resolved   |    3|de.jwausle.osgi.api.provider.v1 (1.0.0.202301101110)|1.0.0.202301101110

g! frameworklevel
2

g! bundlelevel 4
3

g! bundlelevel -s 2 4
g! lb
START LEVEL 2
   ID|State      |Level|Name
	...
    4|Active     |    2|de.jwausle.osgi.api.consumer.v1 (1.0.0.202301112210)|1.0.0.202301112210
    5|Resolved   |    3|de.jwausle.osgi.api.provider.v1 (1.0.0.202301101110)|1.0.0.202301101110
```

## Framework start level

> bnd-sl-default-4.bndrun

```
g! lb
START LEVEL 2
   ID|State      |Level|Name
    0|Active     |    0|System Bundle (6.0.3)|6.0.3
    1|Active     |    2|Apache Felix Gogo Command (1.1.0)|1.1.0
    2|Active     |    2|Apache Felix Gogo Runtime (1.1.2)|1.1.2
    3|Active     |    2|Apache Felix Gogo Shell (1.1.2)|1.1.2
    4|Resolved   |    3|de.jwausle.osgi.api.consumer.v1 (1.0.0.202301112210)|1.0.0.202301112210
    5|Resolved   |    4|de.jwausle.osgi.api.provider.v1 (1.0.0.202301101110)|1.0.0.202301101110

g! frameworklevel 3
g! lb
START LEVEL 3
   ID|State      |Level|Name
	...
    4|Active     |    3|de.jwausle.osgi.api.consumer.v1 (1.0.0.202301112210)|1.0.0.202301112210
    5|Resolved   |    4|de.jwausle.osgi.api.provider.v1 (1.0.0.202301101110)|1.0.0.202301101110
```
