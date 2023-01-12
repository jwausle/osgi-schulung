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

g! start 7
g! bundle 7
...
RegisteredServices   [HelloWorld]
ServicesInUse        [LogService | LoggerFactory]
```

# service reference

> Run: bndrun-active.bndrun

```
g! lb
	...
    7|Active     |    3|SimpleBundle-logging (1.1.0)|1.1.0
    	
g! servicereferences io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld null
000020   7 HelloWorld  

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