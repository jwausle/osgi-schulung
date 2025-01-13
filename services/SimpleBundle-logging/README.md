# Registered services

> Run: bndrun-resolved.bndrun

```
g! lb 
	...
    7|Resolved   |    3|SimpleBundle-logging (1.1.0)|1.1.0
    	
g! bundle 7
...
RegisteredServices   null
ServicesInUse        null

g! allservicereferences null null

000002   0 PackageAdmin
..
000004   0 Condition

g! inspect cap service 

g! bundlelevel -s 2 7
g! bundle 7
...
RegisteredServices   [HelloWorld]
ServicesInUse        [LogService | LoggerFactory]

g! inspect cap service 7
g! each (servicereferences io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld null) { $it properties }
```


# service reference

> Run: bndrun-active.bndrun

```
g! lb
	...
    7|Active     |    3|SimpleBundle-logging (1.1.0)|1.1.0
    	
g! servicereferences io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld null
000020   7 HelloWorld  

g! stop 1
g! bundle 7
...
RegisteredServices   null
ServicesInUse        null


g! start 1

g! each (bundles) { $it registeredservices }
[Resolver, PackageAdmin, StartLevel, Condition, Object | Launcher]
[LogService | LoggerFactory, LogReaderService, LoggerAdmin]
[Basic, Inspect, Files]
[ThreadIO, CommandProcessor]
[Converter, Builtin, Procedural, Posix, Telnet, Shell]
null
null
[HelloWorld]
```

## What do the HelloWorld service

```

```

# service properties 

> Run: bndrun-active.bndrun

```
g! lb
	...
    7|Active     |    3|SimpleBundle-logging (1.1.0)|1.1.0

g! each (servicereferences io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld null) { $it properties }
[service.id=20, objectClass=[Ljava.lang.String;@4d7d6dde, service.scope=singleton, service.bundleid=7
```

# service reference LogService

> Run: bndrun-active.bndrun

```
g! servicereferences org.osgi.service.log.LogService null
000006   1 LogService | LoggerFactory

g! each (servicereferences org.osgi.service.log.LogService null) { $it properties }
[service.id=20, objectClass=[Ljava.lang.String;@4d7d6dde, service.scope=singleton, service.bundleid=7
```