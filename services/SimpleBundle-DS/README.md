# Declarative Service

## With waring every 5 seconds

> Run: bnd.bndrun

```
g! lb
	...
   15|Active     |    1|SimpleBundle-DS0 (1.2.0)|1.2.0	
g! scr:list
io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld in bundle 15 (SimpleBundle-DS0:1.2.0) enabled, 1 instance.
    Id: 1, State:ACTIVE

g! stop 15
g! scr:list
No component descriptions found

g! start 15

g! scr:disable io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld
true
g! scr:list
io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld in bundle 15 (SimpleBundle-DS0:1.2.0) enabled, 1 instance.

g! scr:enable io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld
true

g! scr:list
io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld in bundle 15 (SimpleBundle-DS0:1.2.0) enabled, 1 instance.
```

## Links

* https://felix.apache.org/documentation/subprojects/apache-felix-log.html
* enhance gogo: https://web.archive.org/web/20220113102917/https://rotty3000.doublebite.com/Introspect-Configuration-Admin-from-Gogo-Shell/