# Registered services

ServiceTracker example to show when log service gone and come back.

> Run: bndrun-resolved.bndrun

```
g! lb
	...
    7|Resolved   |    3|SimpleBundle-logging2 (1.1.0)|1.1.0

g! bundlelevel -s 2 7

g! bundle 7
...
RegisteredServices   [HelloWorld]
ServicesInUse        [LogService | LoggerFactory]
...

g! each (servicereferences io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld null) { $it properties }
```

# service reference

> Run: bndrun-active.bndrun

```
servicereferences io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld null
000020   7 HelloWorld  
```

# service properties 

> Run: bndrun-active.bndrun

```
g! each (servicereferences io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld null) { $it properties }
[service.id=20, objectClass=[Ljava.lang.String;@4d7d6dde, service.scope=singleton, service.bundleid=7
```