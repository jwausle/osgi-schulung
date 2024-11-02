# Declarative Service

Handwritten OSGI-INF/HelloWorld.xml

## Without waring every 5 seconds

> Run: bnd.bndrun

```
g! scr:list 
io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld in bundle 15 (SimpleBundle-DS0:1.2.0) enabled, 1 instance.
    Id: 0, State:ACTIVE
    
g! scr:info io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld
Component Description: io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld
===============================================================================
Class:         io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld
Bundle:        15 (SimpleBundle-DS0:1.2.0)
Enabled:       true
Immediate:     true
Services:      <<none>>
Config PID(s): [io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld], Policy: optional
Base Props:    (1 entry)
  osgi.ds.satisfying.condition.target<String> = (osgi.condition.id=true)

Component Configuration Id: 0
-----------------------------
State:        ACTIVE
Config Props: (3 entries)
  component.id<Long> = 0
  component.name<String> = io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld
  osgi.ds.satisfying.condition.target<String> = (osgi.condition.id=true)
References:   (total 2)
  - LogService: org.osgi.service.log.LogService SATISFIED 1..1 static
    target=(*) scope=bundle (1 binding):
    * Bound to [6] from bundle 1 (org.apache.felix.log:1.2.6)
  - osgi.ds.satisfying.condition: org.osgi.service.condition.Condition SATISFIED 1..1 dynamic
    target=(osgi.condition.id=true) scope=bundle (1 binding):
    * Bound to [4] from bundle 0 (org.apache.felix.framework:7.0.3)
    
g! scr:disable io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld
true
g! scr:list 
io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld in bundle 15 (SimpleBundle-DS0:1.2.0) enabled, 0 instances.
g! scr:info io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld
Component Description: io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld
===============================================================================
Class:         io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld
Bundle:        15 (SimpleBundle-DS0:1.2.0)
Enabled:       true
Immediate:     true
Services:      <<none>>
Config PID(s): [io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld], Policy: optional
Base Props:    (1 entry)
  osgi.ds.satisfying.condition.target<String> = (osgi.condition.id=true)

g! scr:enable io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld
true
g! Hello World!
scr:list
io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld in bundle 15 (SimpleBundle-DS0:1.2.0) enabled, 1 instance.
    Id: 1, State:ACTIVE
```

## With waring every 5 seconds

> Run: bnd-with-logging.bndrun

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